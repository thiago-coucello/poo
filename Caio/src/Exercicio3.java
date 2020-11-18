import java.util.Locale;
import java.util.Scanner;

public class Exercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Scanner
		Scanner input = new Scanner(System.in);
		
		//Separação de decimais por ponto (0.1 ao inves de 0,1)
		input.useLocale(Locale.US);
		
		//Array
		double[] d = new double[10];
		
		//indice
		int indice;
		
		for(indice = 0; indice < d.length; indice++) {
			System.out.printf("Entre com um valor double:\n");
			d[indice] = input.nextDouble();
		}
		
		System.out.printf("\n");
		System.out.printf("d: ");
		for(indice = 0; indice < d.length; indice++) {
			System.out.printf(Locale.US,"%.2f ", d[indice]);
		}
		
		input.close();
	}

}
