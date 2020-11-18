
public class Exercicio5 {
	public int repeticoes(int[] a, int x) {
		int contador = 0, indice;
		
		for(indice = 0; indice < a.length; indice++) {
			if(a[indice] == x) {
				contador++;
			}
		}
		
		return contador;
	}
}
