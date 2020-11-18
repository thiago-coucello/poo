package Truco;

public class Carta {
	private String nome;
	private String naipe;

	public Carta() {
		
	}
	
	public Carta(String nome, String naipe) {
		setNome(nome);
		setNaipe(naipe);
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getNaipe() {
		return this.naipe;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setNaipe(String naipe) {
		this.naipe = naipe;
	}

	public String toString() {	
		return String.format("%s de %s", this.nome, this.naipe);
	}
}
