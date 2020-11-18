import java.util.List;
import java.util.LinkedList;
import java.util.Vector;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;

public class Baralho {
	
	//Baralhos criados com cada lista pedida
	private List<Carta> baralho = new ArrayList<>();
	private LinkedList<Carta> baralho_lista = new LinkedList<>();
	private Vector<Carta> baralho_vector = new Vector<>();
	private Stack<Carta> baralho_stack = new Stack<>();
	
	//Variável para guardar o tipo de baralho desejado
	char t;
	
	//Tipo do baralho passado por parâmetro para o construtor
	public Baralho(char t) {
		this.t = t;
		
		//Dependendo do tipo do baralho chama o método responsável para iniciar ele
		switch(this.t) {
		case 'A':
		case 'a':
			ArrayList();
			break;
		
		case 'L':
		case 'l':
			LinkedList();
			break;
		
		case 'V':
		case 'v':
			Vector();
			break;
			
		case 'S':
		case 's':
			Stack();
			break;
		}
	}
	
	//Método para iniciar o baralho de ArrayList (Array)
	private void ArrayList() {
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
	
	//Método para iniciar o baralho de Vector (Vetor Sincronizado)
	private void Vector() {
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
				baralho_vector.add(c);
			}
			
		}
	}
	
	//Método para iniciar o baralho de Stack(Pilha)
	private void Stack() {
		int numcarta, i;
		char naipe = '0';
		String nome;
		Carta c;
		
		for(i=4;i>=1;i--) {
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
		
			for(numcarta = 13; numcarta > 0; numcarta--) {
				nome = String.format("%d-%c.png", numcarta, naipe);
				c = new Carta(nome,numcarta,naipe);
				baralho_stack.push(c);
			}
			
		}
	}
	
	//Método para iniciar o baralho de LinkedList (Lista Encadeada)
	private void LinkedList() {
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
				baralho_lista.add(c);
			}
			
		}
	
	}
	
	
	//Getter e Setters para todos os atributos
	public void setTipo(char t) {
		this.t = t;
	}
	
	public char getTipo() {
		return this.t;
	}
	
	public void setBaralho(List<Carta> x) {
		this.baralho = x;
	}
	
	public void setBaralhoLista(LinkedList<Carta> x) {
		this.baralho_lista = x;
	}
	
	public void setBaralhoVector(Vector<Carta> x) {
		this.baralho_vector = x;
	}
	
	public void setBaralhoStack(Stack<Carta> x) {
		this.baralho_stack = x;
	}
	
	public LinkedList<Carta> getBaralhoLista() {
		return this.baralho_lista;
	}
	
	public Vector<Carta> getBaralhoVector() {
		return this.baralho_vector;
	}
	
	public Stack<Carta> getBaralhoStack() {
		return this.baralho_stack;
	}
	
	public List<Carta> getBaralhoArray(){
		return this.baralho;
	}
	
	
	//Método para zerarBaralho
	public void zeraBaralho() {
		baralho.clear();
		baralho_lista.clear();
		baralho_vector.clear();
		baralho_stack.clear();
	}
	
	//Método para adicionar carta, baralho depende do tipo definido
	public void adiciona(Carta c) {
		switch(this.t) {
		case 'A':
		case 'a':
			baralho.add(c);
			
			break;
		
		case 'L':
		case 'l':
			baralho_lista.add(c);
			
			break;
		
		case 'V':
		case 'v':
			baralho_vector.add(c);
			
			break;
			
		case 'S':
		case 's':
			baralho_stack.push(c);
			
			break;
		}
	}
	
	
	//Método para embaralhar, baralho depende do tipo definido
	public void embaralha() {
		switch(this.t) {
		case 'A':
		case 'a':
			Collections.shuffle(baralho);
			
			break;
		
		case 'L':
		case 'l':
			Collections.shuffle(baralho_lista);
			
			break;
		
		case 'V':
		case 'v':
			Collections.shuffle(baralho_vector);
			
			break;
			
		case 'S':
		case 's':
			Collections.shuffle(baralho_stack);
			
			break;
		}
	}
	
	//Método para retirar uma carta do baralho, baralho depende do tipo definido
	public Carta getCarta(int pos) {
		Carta c = new Carta();
		
		switch(this.t) {
		case 'A':
		case 'a':
			c = baralho.get(pos);
			baralho.remove(pos);
			
			break;
		
		case 'L':
		case 'l':
			c = baralho_lista.get(pos);
			baralho_lista.remove(pos);
			
			break;
		
		case 'V':
		case 'v':
			c = baralho_vector.get(pos);
			baralho_vector.remove(pos);
			
			break;
			
		case 'S':
		case 's':
			c = baralho_stack.pop();
			
			break;
		}
		
		return c;
	}
	
	//Método para transformar o baralho em string para exibição, age apenas no tipo de baralho definido
	public String toString() {
		String frase = "";
		
		switch(this.t) {
		case 'A':
		case 'a':
			
			frase += "---------- Baralho - Array-----------\n\n";
			
			for(Carta c: baralho) {
				frase += c.toString() + "\n";
			}
			
			break;
		
		case 'L':
		case 'l':

			frase += "---------- Baralho - Lista -----------\n\n";
			
			for(Carta c: baralho_lista) {
				frase += c.toString() + "\n";
			}
			
			break;
		
		case 'V':
		case 'v':
			
			frase += "---------- Baralho - Vector -----------\n\n";
			
			for(Carta c: baralho_vector) {
				frase += c.toString() + "\n";
			}
			
			break;
			
		case 'S':
		case 's':
			
			frase += "---------- Baralho - Stack -----------\n\n";
			
			for(Carta c: baralho_stack) {
				frase += c.toString() + "\n";
			}
			
			break;
		}
		
		return frase;
	}
	
}
