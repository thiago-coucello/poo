import java.util.Scanner;

public class Exercicio8 {
	public int[] leitura(int tamanho) {
		int indice;
		int[] a = new int[tamanho];
		
		Scanner input = new Scanner(System.in);
		
		System.out.printf("Digite os numeros:\n");
		
		for(indice = 0; indice < tamanho; indice++) {
			a[indice] = input.nextInt();
		}
		input.close();
		
		return a;
	}
}
