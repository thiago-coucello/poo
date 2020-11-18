import java.util.List;

public class Pedido {
	private List<ItemPedido> itens;

    private String idPedido;
    private int    vendedor;
    private String filial;
    private String docCliente;
    private String codCliente;
    private String nomeCliente;
    private String total;
    private int    metodoPagamento;
    private int    contadorPedido;

    //Construtor

    public Pedido(){

    }

    //Getters and Setters
    public String getIdPedido() {
        return idPedido;
    }

    public void   setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public int getVendedor() {
        return vendedor;
    }

    public void   setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }

    public String getDocCliente() {
        return docCliente;
    }

    public void setDocCliente(String docCliente) {
        this.docCliente = docCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void   setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTotal() {
        return total;
    }

    public void   setTotal(String total) {
        this.total = total;
    }

    public int getMetodoPagamento() {
        return metodoPagamento;
    }

    public void   setMetodoPagamento(int metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public int getContadorPedido() {
        return contadorPedido;
    }

    public void   setContadorPedido(int contadorPedido) {
        this.contadorPedido = contadorPedido;
    }

    public String getFilial() {
        return filial;
    }

    public void   setFilial(String filial) {
        this.filial = filial;
    }

    public void   setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setCodCliente(String codCliente){ this.codCliente = codCliente; }

    public String getCodCliente(){ return this.codCliente; }
    
    public String toString() {
    	String saida = "";
    	saida = String.format("%s, %d, %s, %s, %s",this.getIdPedido(), this.getMetodoPagamento(), this.getCodCliente(), this.getVendedor(), this.getTotal());
    	
    	return saida;
    }
    
    public String toString(String vendedor) {
    	String saida = "";
    	saida = String.format("%s, %d, %s, %s, %s",this.getIdPedido(), this.getMetodoPagamento(), this.getCodCliente(), vendedor, this.getTotal());
    	
    	return saida;
    }
}
