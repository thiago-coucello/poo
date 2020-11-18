
public class Exercicio7 {
	public int maiorValor(int[] a) {
		int maior, posicao = 0, indice;
		
		maior = a[0];
		
		for(indice = 1; indice < a.length; indice++) {
			if(a[indice] > maior) {
				maior = a[indice];
			}
		}
		
		for(indice = 0; indice < a.length; indice++) {
			if(a[indice] == maior) {
				posicao = indice;
			}
		}
		
		return posicao;
	}
}
