
public class Exercicio6 {
	public boolean[] positivos(int[] a) {
		int indice;
		boolean[] b = new boolean[a.length];
		
		for(indice = 0; indice < a.length; indice++) {
			if(a[indice] > 0) {
				b[indice] = true;
			}
			else{
				b[indice] = false;
			}
		}
		
		return b;
	}
}
