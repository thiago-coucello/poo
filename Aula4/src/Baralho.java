import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Baralho {
	
	private List<Carta> baralho = new ArrayList<>();
	
	public Baralho() {
		int numcarta, i;
		char naipe = '0';
		String nome;
		Carta c;
		
		for(i=1;i<=4;i++) {
			switch(i) {
			case 1:
				naipe = 'o';
				break;
		
			case 2:
				naipe = 'e';
				break;
			
			case 3:
				naipe = 'c';
				break;
			
			case 4:
				naipe = 'o';
				break;
			}
		
			for(numcarta = 1; numcarta < 14; numcarta++) {
				nome = String.format("%d-%c.png", numcarta, naipe);
				c = new Carta(nome,numcarta,naipe);
				baralho.add(c);
			}
			
		}
	}
	
	public void setBaralho(List<Carta> x) {
		this.baralho = x;
	}
	
	public List<Carta> getBaralho(){
		return this.baralho;
	}
	
	public void zeraBaralho() {
		baralho.clear();
	}
	
	public void adiciona(Carta c) {
		baralho.add(c);
	}
	
	public int qntdade() {
		return baralho.size();
	}
	
	public void embaralha() {
		Collections.shuffle(baralho);
	}
	
	public Carta getCarta(int pos) {
		Carta c = baralho.get(pos);
		baralho.remove(0);
		
		return c;
	}
	
	public String toString() {
		String frase = "---------- Baralho-----------\n\n";
		for(Carta c: baralho) {
			frase += c.toString() + "\n";
		}
		
		
		return frase;
	}
	
}
