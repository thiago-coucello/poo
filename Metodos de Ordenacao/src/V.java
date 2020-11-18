import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import javax.swing.JOptionPane;

public class V {
	Random rd = new Random();
	List <Integer> vetor;
	boolean ordenado;
	int ponteiro;
	
	public V() {
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
	
	public int buscaSequencial(int limite,int num) {
		int i=0;
		
		while(num > vetor.get(i) && i < limite)
			i++;
		
		return i;
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
		
		for(fim = vetor.size(); fim > 0; fim--) {
			for(i = 0; i < fim; i++) {
				if(vetor.get(i)>vetor.get(i+1)) {
					aux = vetor.get(i);
					vetor.set(i, vetor.get(i+1));
					vetor.set(i+1, aux);
				}
			}
		}
	}
	
	public void SelectionSort() {
		int i, j, menor, posmenor;
		
		for(i=0; i < vetor.size()-1; i++) {
			menor = vetor.get(i);
			posmenor = i;
			
			for(j=i+1; j < vetor.size(); j++) {
				if(vetor.get(j) < menor) {
					menor = vetor.get(j);
					posmenor = j;
				}
			}
			vetor.set(posmenor, vetor.get(i));
			vetor.set(i, menor);
		}
	}
	
	public void SequentialInsertionSort() {
		int aux, i, n, pos;
		
		if(vetor.get(0) > vetor.get(1)) {
			aux = vetor.get(0);
			vetor.set(0, vetor.get(1));
			vetor.set(1, aux);
		}
		
		for(n=2; n < (vetor.size()); n++) {
			aux = vetor.get(n);
			pos = buscaSequencial(n,aux);
			
			for(i = n; i > pos; i--) {
				vetor.set(i, vetor.get(i-1));
			}
			vetor.set(pos, aux);
		}
		
	}
	
	public void BinaryInsertionSort() {
		int aux, i, n, pos;
		
		if(vetor.get(0) > vetor.get(1)) {
			aux = vetor.get(0);
			vetor.set(0, vetor.get(1));
			vetor.set(1, aux);
		}
		
		for(n=2; n < vetor.size(); n++) {
			aux = vetor.get(n);
			pos = buscaBinariaRecursiva(aux,0,n);
			
			for(i = n; i > pos; i--) {
				vetor.set(i, vetor.get(i-1));
			}
			vetor.set(pos, aux);
		}
		
	}
	
	public void QuickSort(int inicio, int fim) {
		int aux,i,j,pivo;
		i = inicio;
		j = fim;
		pivo = vetor.get((inicio+fim)/2);
		do{
			while(vetor.get(i) < pivo)i++;
			while(vetor.get(j) > pivo)j--;
			if(i<=j){
				aux = vetor.get(i);
				vetor.set(i, vetor.get(j));
				vetor.set(j, aux);
				i++;
				j--;
			}
		}while(i<=j);
		if(j>inicio){
			QuickSort(inicio,j);
		}
		if(i<fim){
			QuickSort(i,fim);
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
		
		else if(opcao.equals("2") || opcao.equals("dois")) {
			SelectionSort();
		}
		
		else if(opcao.equals("3") || opcao.equals("tres")) {
			SequentialInsertionSort();
		}
		
		else if(opcao.equals("4") || opcao.equals("quatro")) {
			BinaryInsertionSort();
		}
		
		else if(opcao.equals("5") || opcao.equals("cinco")) {
			QuickSort(0,vetor.size()-1);
		}
		
		ordenado = true;
	}
}