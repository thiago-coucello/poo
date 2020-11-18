
public class Exercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Arrays / Vetores
		int[] arrayA = new int[10]; // 10 9 8 7 6 5 4 3 2 1
		int[] arrayB = new int[11]; // 0 1 4 9 16 25 36 49 64 81 100
		int[] arrayC = new int[10]; // 1 2 3 4 5 10 20 30 40 50
		int[] arrayD = new int[10]; // 3 4 7 12 19 28 39 52 67 84
		
		//Indice
		int indice; //Indice do array
		
		//valores
		int valor; //Valor a ser adicionado no array
		int acrescimo; //Acrescimo no valor a ser adicionado no array
		
		//usando o for
		System.out.printf("a) ");
		
		//Indice começa em 0
		//Valor começa em 10
		//condição de parada chegar no final do array (arrays começam em 0)
		//A cada laço, soma um ao indice, subtrai um do valor
		for(indice = 0, valor = 10;indice < 10 /*(array.length)*/; indice++,valor--) {
			arrayA[indice] = valor;
			System.out.printf("%d ",arrayA[indice]);
		}
		
		System.out.printf("\n");
		System.out.printf("b) ");
		
		for(indice = 0, valor = 0, acrescimo = 1; indice < 11; indice++) {
			arrayB[indice] = valor;
			valor = valor + acrescimo;
			acrescimo = acrescimo + 2;
			System.out.printf("%d ",arrayB[indice]);
			
		}
		
		System.out.printf("\n");
		System.out.printf("c) ");
		
		for(indice = 0, valor = 1; indice < 10; indice++) {
			arrayC[indice] = valor;
			
			if(valor == 5) {
				valor = valor + 5;
			}
			else if(valor > 5) {
				valor = valor + 10;
			}
			else {
				valor = valor + 1;
			}
			System.out.printf("%d ", arrayC[indice]);
		}
		
		System.out.printf("\n");
		System.out.printf("d) ");
		
		for(indice = 0, valor = 3, acrescimo = 1; indice < 10; indice++) {
			arrayD[indice] = valor;
			valor = valor + acrescimo;
			acrescimo = acrescimo + 2;
			System.out.printf("%d ",arrayD[indice]);
			
		}
	}

}
