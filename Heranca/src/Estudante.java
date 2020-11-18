
public class Estudante extends Pessoa {
	private String ra;
	private double n1,n2, media;
	
	public Estudante() {
		super();
		this.ra = "";
		this.n1 = 0.0;
		this.n2 = 0.0;
		this.media = 0.0;
	}
	
	public Estudante(String nome, int anoNasc, String ra, double n1, double n2) {
		super(nome,anoNasc);
		this.ra = ra;
		this.n1 = n1;
		this.n2 = n2;
		this.media = (this.n1 + this.n2) / 2;
	}
	
	public void setRa(String ra) {
		this.ra = ra;
	}
	
	public void setN1(double n1) {
		this.n1 = n1;
	}
	
	public void setN2(double n2) {
		this.n2 = n2;
	}
	
	public void setMedia(double n1, double n2) {
		this.media = (n1 + n2) / 2;
	}
	
	public String getRa() {
		return this.ra;
	}
	
	public Double getN1() {
		return this.n2;
	}
	
	public Double getN2() {
		return this.n1;
	}
	
	public Double getMedia() {
		return (this.n1 + this.n2)/2;
	}
	
	public String situacao() {
		this.media = (this.n1 + this.n2) / 2;
		
		if(this.media >= 6) {
			return "aprovado";
		}
		
		return "reprovado";
	}
	
	public String toString() {
		return String.format("Nome: %s  Idade: %d\nRegistro Acadêmico: %s  Nota 1: %.2f  Nota 2: %.2f  Media: %.2f\nSituação: %s\n", this.getNome(), this.getIdade(), this.getRa(), this.getN1(), this.getN2(), this.getMedia(), this.situacao());
	}
	
}
