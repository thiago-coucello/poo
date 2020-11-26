public abstract class Contribuinte {
    private double rendaBrutaAnual;
    private String nome;

    public Contribuinte() {
        this.setNome("");
        this.setRendaBrutaAnual(0.00);
    }

    public Contribuinte(double rendaBrutaAnual, String nome) {
        this.setNome(nome);
        this.setRendaBrutaAnual(rendaBrutaAnual);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRendaBrutaAnual(double rendaBrutaAnual) {
        this.rendaBrutaAnual = rendaBrutaAnual;
    }

    public String getNome() {
        return this.nome;
    }

    public double getRendaBrutaAnual() {
        return this.rendaBrutaAnual;
    }

    public String toString() {
        String saida = "";
        saida = String.format("Nome: %s, Renda Bruta Anual: R$ %.2f", this.getNome(), this.getRendaBrutaAnual());

        return saida;
    }
}
