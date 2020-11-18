
public class Exercicio9 {
	public int[] paridade(int[] a) {
		int indice;
		
		for(indice = 0; indice < a.length; indice++) {
			if(a[indice] % 2 == 0) { // Se o valor for par
				a[indice] = 1;
			}
			else {
				a[indice] = -1;
			}
		}
		
		return a;
	}
}
