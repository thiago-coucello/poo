public class Horista extends Empregado{

	private int horasTrabalhadas;

	private double salarioHora;

	public Horista(){ // constructor SEM parâmetros
		super();
		this.salarioHora=0; this.horasTrabalhadas=0; 
	}

	public Horista(String nome, String nd, int horasTrabalhadas, double salarioHora) {
		super(nome,nd);
		this.horasTrabalhadas = horasTrabalhadas;
		this.salarioHora = salarioHora;
	}
	// metodo OBRIGATORIO devido a heranca da superClasse abstrata Empregado

	public double calculaSalario() {
		if (this.horasTrabalhadas <= 40)
			return(horasTrabalhadas * salarioHora);
		else {
			int hsExtras = horasTrabalhadas - 40;
			return((salarioHora * 40) + (hsExtras * (salarioHora * 1.5)));
		}
	}
	
	public void setSalarioHora(double salario) {
		this.salarioHora = salario;
	}
	
	public double getSalarioHora() {
		return (this.salarioHora);
	}
	
	public int getHorasTrabalhadas() {
		return(this.horasTrabalhadas);
	}
	
	public String toString() {
		String temp = "\nHorista "+super.toString()+ String.format(
				"Hs Trabalhadas=%d Salario Hora=$%,.2f Salario final=$%,.2f",
				this.getHorasTrabalhadas(),this.getSalarioHora(),this.calculaSalario());
		
		return (temp);
	}
}// fecha classe Horista 