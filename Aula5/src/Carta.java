
public class Carta {
	private String imagem;
	private int numero;
	private char naipe;
	
	public Carta() {
		this.imagem = "fechado.png";
		this.numero = 0;
		this.naipe = '0';
	}
	
	public Carta(String imagem, int numero, char naipe) {
		this.imagem = imagem;
		this.naipe = naipe;
		this.numero = numero;
	}
	
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void setNaipe(char naipe) {
		this.naipe = naipe;
	}
	
	public String getImagem() {
		return this.imagem;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public char getNaipe() {
		return this.naipe;
	}
	
	public String toString() {
		String frase = "";
	
		switch(this.numero) {
		case 1:
			frase += "As ";
			break;
		case 11:
			frase += "Valete ";
			break;
		case 12:
			frase += "Rainha ";
			break;
		case 13:
			frase += "Rei ";
			break;
		default:
			frase += "Nro: " + String.format("%d", this.numero)+" ";
		}
		
		switch(this.naipe) {
		case 'o':
			frase += "Ouro";
			break;
		case 'e':
			frase += "Espada";
			break;
		case 'c':
			frase += "Copas";
			break;
		case 'p':
			frase += "Paus";
			break;
		default:
			frase += "Nulo";
			break;
		}
		
		return frase;
	}
	
}
