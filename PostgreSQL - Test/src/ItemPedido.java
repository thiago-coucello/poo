public class ItemPedido {

    private String idProduto;
    private String nomeProduto;
    private int    quantidade;
    private double    desconto;
    private String precoFinal;
    private Double precoReal;
    private double estoqueAtualizado;
    private double estoqueOriginal;

    public ItemPedido() {
        this.setPrecoFinal("0.00");
        this.setQuantidade(0);
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void   setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void   setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int    getQuantidade() {
        return quantidade;
    }

    public void   setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getPrecoFinal() {
        return precoFinal;
    }

    public void   setPrecoFinal(String precoFinal) {
        this.precoFinal = precoFinal;
    }

    public Double getPrecoReal() {
        return precoReal;
    }

    public void   setPrecoReal(Double precoReal) {
        this.precoReal = precoReal;
    }

    public double    getDesconto() {
        return desconto;
    }

    public void   setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getEstoqueAtualizado(){ return this.estoqueAtualizado; }

    public void setEstoqueAtualizado(double estoque){this.estoqueAtualizado = estoque;}

    public double getEstoqueOriginal() { return estoqueOriginal; }

    public void setEstoqueOriginal(double estoqueOriginal){ this.estoqueOriginal = estoqueOriginal; }
}
