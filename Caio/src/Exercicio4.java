
public class Exercicio4 {
	public static void main(String[] args) {
		int[] array = {1, -5, 3, -7, 10, 15, 20, -50};
		
		System.out.printf("Numero de negativos: %d\n",quantidadeDeNegativos(array));
	}
	
	public static int quantidadeDeNegativos(int[] array) {
		int numeroDeNegativos = 0;
		int indice;
		
		for(indice = 0; indice < array.length; indice++) {
			if(array[indice] < 0) {
				numeroDeNegativos = numeroDeNegativos + 1;
			}
		}
		
		return numeroDeNegativos;
	}
}
