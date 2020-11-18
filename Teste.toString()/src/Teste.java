import java.util.ArrayList;
import java.util.List;

public class Teste {

	public static void main(String[] args) {
		List <Integer> teste = new ArrayList<Integer>();
		String saida = "";
		
		for(int i = 0;i < 10;i++) {
			teste.add(i);
		}
		
		for(int i = 0; i < teste.size(); i++) {
			saida += String.format("%d\n", teste.get(i));
		}
		
		System.out.println(saida);
		System.out.println(teste.toString());

	}

}
