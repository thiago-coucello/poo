public class Assalariado extends Empregado{
	private double salarioMensal;
 	private double descontos;
 	public Assalariado() {
 		super();
 		this.salarioMensal=0;
 		this.descontos=0;
 	}
 	public Assalariado(String nome, String nd, double salario, double descontos){
 		super(nome,nd);
 		this.salarioMensal = salario;
 		this.descontos = descontos;
 	}
	@Override
	public double calculaSalario() {
		 return (this.salarioMensal-this.descontos);
	}
	
	public void setSalarioMensal(double salario) {
		 this.salarioMensal = salario;
	}

	public void setDescontos( double descontos) {
		 this.descontos = descontos;
	 }
		 
	public double getSalarioMensal() {
		 return (this.salarioMensal);
	 }
	
	public double getDescontos() {
		 return (this.descontos);
	 }

	public String toString() {
		 String temp = "\nAssalariado "+super.toString()+ String.format(
				 "Salario Mensal=$%,.2f Desc=$%,.2f Salario Final=$%,.2f",
				 this.getSalarioMensal(),this.getDescontos(), this.calculaSalario());
		 
		 return (temp);
	 }
}// fecha classe assalariado