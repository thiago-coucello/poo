import java.util.Calendar;

public class Pessoa {
	private String nome;
	private int anoNasc;
	

	public Pessoa() {
	
	}

	public Pessoa(String nome, int anoNasc) {
		setNome(nome);
		setAnoNasc(anoNasc);
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setAnoNasc(int anoNasc) {
		this.anoNasc = anoNasc;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getAnoNasc() {
		return this.anoNasc;
	}
	
	public int getIdade() {
		Calendar data = Calendar.getInstance();
		int idade = 0;
		int anohoje = data.get(Calendar.YEAR);
		
		System.out.println(anohoje);
		
		idade = anohoje - this.anoNasc;
		
		return idade;
	}
	
	public String toString() {
		return String.format("Nome: %s  Idade: %d\n", this.nome, this.getIdade());
	}
	
}
