import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static ItemPedido itemPedido;
	private static Produto produtoRecuperado;
	private static List<ItemPedido> lista = new ArrayList<ItemPedido>();
	private static Pedido p;

	public static void main(String args[]) {
		recuperarPedido();
		inserirProduto("14465", 5, 0);
		confirmarPedido();
	}

	public static void recuperarProduto(String idproduto) {
		Statement stmt;
		ResultSet rs;
		produtoRecuperado = new Produto();

		Connection c = conectarBanco();

		try {
			if(c != null) {
				stmt = c.createStatement();
				rs = stmt.executeQuery(String.format("select * from mlineapp.produtos where codigo = %s",idproduto));
				if(rs.next()) {
					produtoRecuperado.setDISCRIM(rs.getString("discrim"));
					produtoRecuperado.setCODIGO(rs.getString("codigo"));
					produtoRecuperado.setVLR_URV(rs.getString("vlr_urv"));
					
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void recuperarPedido() {
		Statement stmt;
		ResultSet rs;
		int idpedido = 0;
		p = new Pedido();
		String vendedor;

		Connection c = conectarBanco();

		try {

			if(c != null) {
				stmt = c.createStatement();
				rs = stmt.executeQuery("select * from mlineapp.pedidos where confirmado = 0;");

				if(rs.next()) {
					p.setIdPedido(rs.getString("idpedido"));
					p.setMetodoPagamento(rs.getInt("metodoPagamento"));
					p.setCodCliente(rs.getString("codCliente"));
					p.setVendedor(rs.getInt("codVendedor"));
					p.setTotal(rs.getString("total"));

					System.out.println("Pedido: " + p.toString());
				}
				else {
					rs = stmt.executeQuery("select * from mlineapp.pedidos;");

					if(!rs.isLast()) {
						while(rs.next()) {
							if(rs.isLast()) {
								idpedido = rs.getInt("idpedido") + 1;
							}
						}
					}
					else {
						idpedido = 0;
					}

					int sucesso = stmt.executeUpdate(String.format("insert into mlineapp.pedidos(idpedido,codvendedor, confirmado) values (%d,'%07d',%d)",idpedido,Integer.parseInt("0020001"),0));

					if(sucesso > 0) {
						System.out.println("Criou pedido novo");
						p.setIdPedido(String.valueOf(idpedido));
						p.setMetodoPagamento(0);
						p.setCodCliente("0000000");
						p.setVendedor(Integer.valueOf("0020001"));
						p.setTotal("0.00");
					}
					else {
						System.out.println("Erro");
					}
				}
			}		  
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		vendedor = recuperarVendedor(String.valueOf(p.getVendedor()));
		
		System.out.println(p.toString(vendedor));
	}

	public static String recuperarVendedor(String codigo) {
		Statement stmt;
		ResultSet rs;
		Connection c;
		String vendedor = "";

		try {
			c = conectarBanco();
			stmt = c.createStatement();

			rs = stmt.executeQuery(String.format("select * from mlineapp.vendedores where idvendedor = '%07d';", Integer.valueOf(codigo)));

			if(rs.next()) {
				vendedor = rs.getString("nome_vendedor");
			}
			else {
				System.out.println("------------ Vendedor não encontrado -----------");
			}
		}
		catch(Exception e) {
			System.out.println("Erro ao realizar conexão");
			e.printStackTrace();
		}

		return vendedor;
	}

	public static void inserirProduto(String codigo, int quantidade, int desconto) {
		Connection c;
		Statement stmt;
		int status;
		itemPedido = new ItemPedido();
		
		lista.clear();
		
		if(p.getItens() != null) {
			lista = p.getItens();
		}
		
		recuperarProduto(codigo);
		
		System.out.println("DISCRIM: " + produtoRecuperado.getDISCRIM());
		System.out.println("CODIGO: " + produtoRecuperado.getCODIGO());
		System.out.println("VLR_URV: " + produtoRecuperado.getVLR_URV());
		
		double precoFinal = produtoRecuperado.getVLR_URV() - produtoRecuperado.getVLR_URV() * desconto;

		itemPedido.setIdProduto(codigo);
		itemPedido.setQuantidade(quantidade);
		itemPedido.setDesconto(desconto);
		itemPedido.setPrecoReal(produtoRecuperado.getVLR_URV());
		itemPedido.setPrecoFinal(String.format("%.2f",precoFinal));

		lista.add(itemPedido);
		p.setItens(lista);
		
		try {
			c = conectarBanco();
			
			if(c != null) {
				stmt = c.createStatement();
				status = stmt.executeUpdate(String.format("insert into mlineapp.itens (desconto, codproduto, precofinal, precoreal, quantidade, pedidoref) values (%.2f, %s, %s, %.2f, %d, %s);",itemPedido.getDesconto(), itemPedido.getIdProduto(), itemPedido.getPrecoFinal(), itemPedido.getPrecoReal(), itemPedido.getQuantidade(), p.getIdPedido()));
				if(status > 0) {
					System.out.println("Sucesso ao inserir produto!");
				}
			}
		}
		catch(SQLException e) {
			System.out.println("Erro ao inserir produto!");
			e.printStackTrace();
		}
		
	}
	
	public static String recuperarCliente(String cpf_cnpj) {
		
		Connection c;
		Statement stmt;
		ResultSet rs;
		
		try {
			c = conectarBanco();
			stmt = c.createStatement();
			
			rs = stmt.executeQuery(String.format("select * from mlineapp.clientes where cpf_cnpj = '%s';",cpf_cnpj));
			
			if(rs.next()) {
				String codCliente = rs.getString("idcliente");
				return codCliente;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return "Sem cliente";
	}

	public static void confirmarPedido() {
		Connection c;
		Statement stmt;
		
		try {
			c = conectarBanco();
			stmt = c.createStatement();
			
			String codCliente = recuperarCliente("40951090259");
			
			p.setCodCliente(codCliente);
			
			int status = stmt.executeUpdate(String.format("update mlineapp.pedidos set codcliente = %s, metodopagamento = %d, total = %s, confirmado = 1 where idpedido = %s;",p.getCodCliente(), p.getMetodoPagamento(), p.getTotal(), p.getIdPedido()));
			
			if(status > 0) {
				System.out.println("Pedido confirmado ");
			}
		}
		catch(Exception e) {
			
		}
	}
	
	public static Connection conectarBanco() {
		Connection c = null;

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://191.223.32.116:5432/MicroLineDB","postgres", "%Mline775435%");
			//		   c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TesteDB","postgres", "root");  

		}
		catch(Exception e) {
			//	    	  System.out.println("Erro ao conectar ao database");
			e.printStackTrace();
		}

		if(c != null) {
			return c;
		}
		return null;
	}

}