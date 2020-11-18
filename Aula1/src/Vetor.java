import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import javax.swing.JOptionPane;

public class Vetor {
	Random rd = new Random();
	List <Integer> vetor;
	boolean ordenado;
	int ponteiro;
	
	public Vetor() {
		ordenado = false;
		vetor = new ArrayList<Integer>();
		ponteiro = -1;
	}
	
	public int get(int num) {
		return vetor.get(num);
	}
	
	public void gerar() {
		int i,n;
		for(i=0;i<100;i++) {
			n = rd.nextInt(999);
			vetor.add(n);
		}
	}
	
	public int buscaExaustiva(int num) {
		ponteiro = 0;
		
		while(ponteiro < vetor.size() && num != vetor.get(ponteiro)) {
			ponteiro++;
		}
		
		if(ponteiro < vetor.size() && num == vetor.get(ponteiro)) {			
			return ponteiro;
		}
		
		return -1;
	}
	
	public int buscaSequencial(int num) {
		int i=0;
		
		if(!ordenado) return -2;
		
		while(num > vetor.get(i) && i < vetor.size())
			i++;
		
		if(i < vetor.size() && num == vetor.get(i))
			return i;
		
		return -1;
	}
	
	public int buscaBinaria(int num) {
		int inicio = 0, fim = vetor.size() - 1;
		int meio = (inicio + fim)/2;
		
		if(!ordenado) return -2;
		
		while(inicio < fim && vetor.get(meio) != num) {
			if(vetor.get(meio) > num) 
				fim = meio - 1;
			else
				inicio = meio + 1;
			
			meio = (inicio + fim)/2;
		}
		
		if(num <= vetor.get(meio)) {
			System.out.println("Achou ou menor");
			return meio;
		}
		
		return (meio + 1);
	}
	
	public int startBBR(int num) {
		return buscaBinariaRecursiva(num, 0, (vetor.size()-1));
	}
	
	public int buscaBinariaRecursiva(int num, int inicio, int fim) {
		int meio = (inicio + fim)/2;
		
		System.out.print(inicio + " " + fim + "\n");
		
		if(!ordenado) 
			return -2;
		
		if(inicio > fim) {
			if(num <= vetor.get(meio))
				return meio;
			
			else
				return (meio + 1);
		}
		
		if(num < vetor.get(meio)) return buscaBinariaRecursiva(num, inicio, meio - 1);
		
		if(num > vetor.get(meio)) return buscaBinariaRecursiva(num, meio + 1, fim);
		
		return meio;
	}
	
	public String toString() { 
		String saida = "";
		for(int i=0;i<vetor.size()/2;i++) {
			saida += String.format("[%d]=%3d     [%d]=%3d\n",i,vetor.get(i),i+50,vetor.get(i+50));
		}
		
		
		return saida;
	}
	
	public void BubbleSort() {
		int i, fim, aux;
		
		for(fim = vetor.size()-1; fim > 0; fim--) {
			for(i = 0; i < fim; i++) {
				if(vetor.get(i)>vetor.get(i+1)) {
					aux = vetor.get(i);
					vetor.set(i, vetor.get(i+1));
					vetor.set(i+1, aux);
				}
			}
		}
	}
	
	public void Ordena() {
		//Collections.sort(vetor);
		String opcao = JOptionPane.showInputDialog(
				"(1) Bubble Sort\n"+
				"(2) Selection Sort\n"+
				"(3) Sequential Insertion Sort\n"+
				"(4) Binary Insertion Sort\n"+
				"(5) Quick Sort\n"
				);
		
		if(opcao.equals("1") || opcao.equals("um")) {
			BubbleSort();
		}
		
		ordenado = true;
	}
	
	public static void main(String[] args) {
		Vetor v = new Vetor();
		
		while(true) {
			String opcao = JOptionPane.showInputDialog(null,".........Classe Vetor............\n\n"+
					"(1) Gerar um vetor\n"+
					"(2) Exibe um vetor\n"+
					"(3) Busca Exaustiva\n"+
					"(4) Ordena o vetor\n" +
					"(5) Busca Sequencial\n"+
					"(6) Busca Binaria\n"+
					"(7) Busca Binaria Recursiva\n"+
					"(0) Sair\n\n");
			
			if(opcao == null) break;
			
			opcao = opcao.toLowerCase();
			
			if(opcao.equals("1")||opcao.equals("um")) {
				v.gerar();
			}
			
			else if(opcao.equals("2")||opcao.equals("dois")){
				String saida = v.toString();
				JOptionPane.showMessageDialog(null, saida);
			}
			
			else if(opcao.equals("3")||opcao.equals("tres")) {
				String valor = JOptionPane.showInputDialog(null,"Qual número deseja buscar?\n\n");
				int numero = Integer.parseInt(valor);
				int posicao = v.buscaExaustiva(numero);
				
				if(posicao == -1) {
					JOptionPane.showMessageDialog(null, "Número não encontrado\n\n");
				}
				else {
					JOptionPane.showMessageDialog(null, "Número econtrado na posição: " + posicao + "\n");
				}
			}
			
			else if(opcao.equals("4")||opcao.equals("quatro")) {
				v.Ordena();
				JOptionPane.showMessageDialog(null, "......Vetor Ordenado.......\n");
			}
			
			else if(opcao.equals("5")||opcao.equals("cinco")) {
				String valor = JOptionPane.showInputDialog(null,"Qual número deseja buscar?\n\n");
				int numero = Integer.parseInt(valor);
				int posicao = v.buscaSequencial(numero);
				
				if(posicao == -2) {
					JOptionPane.showMessageDialog(null, "......Vetor não ordenado......");
				}
				
				else {
					if(v.get(posicao) != numero) {
						JOptionPane.showMessageDialog(null, "Número não encontrado, posição ideal: " + posicao + "\n\n");
					
					}
					else {
						JOptionPane.showMessageDialog(null, "Número econtrado na posição: " + posicao + "\n");
					
					}
				}
			}
			
			else if(opcao.equals("6")||opcao.equals("seis")) {
				String valor = JOptionPane.showInputDialog(null,"Qual número deseja buscar?\n\n");
				int numero = Integer.parseInt(valor);
				int posicao = v.buscaBinaria(numero);
				
				if(posicao == -2) {
					JOptionPane.showMessageDialog(null, "......Vetor não ordenado......");
				}
				
				else {
					if(v.get(posicao) != numero) {
						JOptionPane.showMessageDialog(null, "Número não encontrado, posição ideal: " + posicao + "\n\n");
					
					}
					else {
						JOptionPane.showMessageDialog(null, "Número econtrado na posição: " + posicao + "\n");
					
					}
				}
			}

			else if(opcao.equals("7")||opcao.equals("sete")) {
				String valor = JOptionPane.showInputDialog(null,"Qual número deseja buscar?\n\n");
				int numero = Integer.parseInt(valor);
				int posicao = v.startBBR(numero);
				
				if(posicao == -2) {
					JOptionPane.showMessageDialog(null, "......Vetor não ordenado......");
				}
				
				else if(posicao == -3) {
					JOptionPane.showMessageDialog(null, "......Deu pau......");
				}
				
				else {
					if(v.get(posicao) != numero) {
						JOptionPane.showMessageDialog(null, "Número não encontrado, posição ideal: " + posicao + "\n\n");
					
					}
					else {
						JOptionPane.showMessageDialog(null, "Número econtrado na posição: " + posicao + "\n");
					
					}
				}
			}
			
			else if(opcao.equals("0")||opcao.equals("zero")) {
				break;
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Opção Inválida\n");
			}
			
			/*
			 * 			Jeito da Professora
			 * 
			char n = opcao.toUpperCase().charAt(0);
			
			switch(n) {
			
			case '1':	//Opção 1
			case 'U':
				v.gerar();
				break;
			
			case '2':	// Opção 2
			case 'D':
				String saida = v.toString();
				JOptionPane.showMessageDialog(null, saida);
				break;
				
			case '3':	// Opção 3
			case 'T':
				String valor = JOptionPane.showInputDialog(null,"Qual número deseja buscar?\n\n");
				int numero = Integer.parseInt(valor);
				int posicao = v.buscaExaustiva(numero);
				
				if(posicao == -1) {
					JOptionPane.showMessageDialog(null, "Número não encontrado\n\n");
				}
				else {
					JOptionPane.showMessageDialog(null, "Número econtrado na posição: " + posicao + "\n");
				}
				break;
				
			case '4':	//Opção 4
			case 'Q':
				v.Ordena();
				JOptionPane.showMessageDialog(null, "......Vetor Ordenado.......\n");
				break;
				
			case '0':	//Opção 0
			case 'Z':
				break;
			
			default:
				JOptionPane.showMessageDialog(null, "Opção inserida inválida\n");
				break;
			}
			
			if(n == '0' || n == 'Z') {
				break;
			} // */
			
		}
		
		 JOptionPane.showMessageDialog(null, "......Obrigado e até logo.......\n");
	}
	
}
