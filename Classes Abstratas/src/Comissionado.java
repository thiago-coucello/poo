public class Comissionado extends Empregado
{
	private double brutoVendas;
	private double taxaComissao;
	private double bonus;
	
	public Comissionado(){
		super();
		this.brutoVendas=0;
		this.taxaComissao=0; 
		this.bonus=0;
	}
	public Comissionado(String nome, String nd, double brutoVendas, double taxaComissao,double bonus){
		super(nome,nd);
		this.brutoVendas = brutoVendas;
		this.taxaComissao = taxaComissao;
		this.bonus = bonus;
	}
	// metodo OBRIGATORIO devido a heranca da superClasse abstrata Empregado

	public double calculaSalario() {
		return (brutoVendas * taxaComissao) + this.bonus;
	}

	public void setBrutoVendas(double bruto) {
		brutoVendas = bruto;
	}

	public void setTaxaComissao( double taxa) {
		this.taxaComissao = taxa;
	}

	public void setBonus (double bonus) {
		this.bonus = bonus;
	}

	public double getBrutoVendas() {
		return (this.brutoVendas);
	}

	public double getTaxa() {
		return(this.taxaComissao);
	}

	public double getBonus() {
		return (this.bonus);
	}

	public String toString() {
		String temp = "\nComissionado "+super.toString()+String.format(
				"Bruto Vendas=$%,.2f Taxa Comissao=$%.2f Bonus=$%,.2f Salario Final=$%,2f",
				this.getBrutoVendas(),this.getTaxa(),this.getBonus(),this.calculaSalario());
		return (temp);
	}

}// fecha classe Comissionado