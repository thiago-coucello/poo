import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class ContaSimples {
	
	// Atributos
	
	private Cliente cliente;
	private int nroConta;
	private double saldo;
	
	
	// Variáveis de classe
	
	private static JPanel painel;
	private static JLabel lCliente, lNumero, lSaldo;
	private static JTextField txtNumero, txtSaldo;
	private static JComboBox<Cliente> cCliente = new JComboBox<Cliente>();
	
	// Construtores
	
	public ContaSimples() {
		this.setCliente(null);
		this.setNroConta(0);
		this.setSaldo(0);
	}

	public ContaSimples(Cliente cliente, int nroConta, double saldo) {
		this.setCliente(cliente);
		this.setNroConta(nroConta);
		this.setSaldo(saldo);
	}
	
	public boolean equals(ContaSimples conta) {
		if(this.getNroConta() == conta.getNroConta()) return true;
		
		return false;
	}
	
	// Getters e Setter
		
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getNroConta() {
		return nroConta;
	}

	public void setNroConta(int nroConta) {
		this.nroConta = nroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	// toString
	
	public String toString() {
		return String.format("Numero da conta: %d, Saldo: R$ %.2f\n%s", 
				this.getNroConta(), this.getSaldo(), this.getCliente().saida());
	}
	
	// Métodos de classe
	
	public static JPanel criarPainel() {
		painel = new JPanel(new GridLayout(4,2));
		painel.setBorder(Borda.criaBorda("Dados do Conta Simples", Color.black));
		
		lNumero = new JLabel("Numero da conta: ", SwingConstants.CENTER);
		lSaldo = new JLabel("Saldo: ", SwingConstants.CENTER);
		lCliente = new JLabel("Selecione o cliente: ", SwingConstants.CENTER);
		
		txtNumero = new JTextField(100);
		txtSaldo = new JTextField(20);
		
		painel.add(lNumero);
		painel.add(txtNumero);
		painel.add(lSaldo);
		painel.add(txtSaldo);
		painel.add(lCliente);
		painel.add(cCliente);
		
		return painel;
	}
	
	public static int getTxtNumero() { 
		String texto = txtNumero.getText().toString();
		
		if(texto.isBlank()) {
			txtNumero.setBackground(Color.red);
			JOptionPane.showMessageDialog(null, "Insira o numero da conta!", "ERRO", JOptionPane.ERROR_MESSAGE);
			
			Timer timer = new Timer(1000, event ->{
				txtNumero.setBackground(Color.white);
			});
			timer.setRepeats(false);
			timer.start();
		}
		else {
			try {
				int numero = Integer.valueOf(texto);
				return numero;
			} catch (NumberFormatException e) {
				txtNumero.setBackground(Color.red);
				JOptionPane.showMessageDialog(null, "Valor invalido!", "ERRO", JOptionPane.ERROR_MESSAGE);
				
				Timer timer = new Timer(1000, event ->{
					txtNumero.setBackground(Color.white);
				});
				timer.setRepeats(false);
				timer.start();
			}
		}
		
		return -1;
	}
	
	public static double getTxtSaldo() {
		String texto = txtSaldo.getText().toString();
		
		if(texto.isBlank()) {
			txtSaldo.setBackground(Color.red);
			JOptionPane.showMessageDialog(null, "Insira o saldo!", "ERRO", JOptionPane.ERROR_MESSAGE);
			
			Timer timer = new Timer(1000, event ->{
				txtSaldo.setBackground(Color.white);
			});
			timer.setRepeats(false);
			timer.start();
		}
		else {
			try {
				double saldo = Double.valueOf(texto);
				return saldo;
			} catch (NumberFormatException e) {
				txtSaldo.setBackground(Color.red);
				JOptionPane.showMessageDialog(null, "Valor invalido!", "ERRO", JOptionPane.ERROR_MESSAGE);
				
				Timer timer = new Timer(1000, event ->{
					txtSaldo.setBackground(Color.white);
				});
				timer.setRepeats(false);
				timer.start();
			}
		}
		
		return -1;
	}
	
	public static void addCliente(Cliente cliente) {
		cCliente.addItem(cliente);
	}
	
	public static Cliente getClienteSelecionado() {
		Cliente cliente = (Cliente) cCliente.getSelectedItem();
		
		if(cliente == null) {
			if(cCliente.getItemCount() == 0) {
				cCliente.setBackground(Color.red);
				JOptionPane.showMessageDialog(null, "Cadastre clientes!", "ERRO", JOptionPane.ERROR_MESSAGE);
				
				Timer timer = new Timer(1000, event->{
					cCliente.setBackground(Color.white);
				});
				timer.setRepeats(false);
				timer.start();
			}
			else {
				cCliente.setBackground(Color.red);
				JOptionPane.showMessageDialog(null, "Selecione um cliente!", "ERRO", JOptionPane.ERROR_MESSAGE);
				
				Timer timer = new Timer(1000, event->{
					cCliente.setBackground(Color.white);
				});
				timer.setRepeats(false);
				timer.start();
			}
		}
		
		return cliente;
	}

	public static void limpar() {
		txtNumero.setText("");
		txtSaldo.setText("");
	}
}
