public class AssalariadoComissionado extends Comissionado
{
	private double salarioBase;
	
	public AssalariadoComissionado(){
		super(); // chama constructor de Comissionado
		this.salarioBase=0;
	}
	
	public AssalariadoComissionado(String nome,String nd, double brutoVendas, double taxaComissao,double bonus, double salarioBase){
		super(nome,nd,brutoVendas,taxaComissao,bonus); // constructor Comissionado
		this.salarioBase = salarioBase;
	}
	
	// metodo OBRIGATORIO devido a herança
	
	public double calculaSalario() {
		return (salarioBase+ super.calculaSalario());
	}
	
	public void setSalarioBase(double salario) {
		this.salarioBase = salario;
	}
	
	public double getSalarioBase() {
		return (this.salarioBase);
	}
	
	public String toString() {
		String temp = "\nAssalariado Comissionado "+super.toString()+
				String.format("Salario Base=$%,.2f Sal.Final=$%,2f",
						this.getSalarioBase(), this.calculaSalario());
		return (temp);
	}

}// fecha classe assalariadoComissionado