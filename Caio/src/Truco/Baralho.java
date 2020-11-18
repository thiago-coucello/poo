package Truco;

import java.util.Random;

public class Baralho {
	Carta[] baralho = new Carta[56];
	int topo;
	
	public Baralho() {
		int i, j, indice = 0;;
		String naipe = "";
		String nome = "";
		Carta c;
		
		topo = 55;
		
		//Adicionando cartas normais
		
		for(i=0; i < 4; i++) {
			switch(i) {
				case 0:
					naipe = "espadas";
					break;
		
				case 1:
					naipe = "ouro";
					break;
					
				case 2:
					naipe = "copas";
					break;
				
				case 3:
					naipe = "paus";
					break;
			}
			
			for(j=1;j <= 13; j++) {
				switch(j) {
				case 1:
					nome = "Ás";
					break;
					
				case 11:
					nome = "Valete";
					break;
				
				case 12:
					nome = "Rainha";
					break;
				
				case 13:
					nome = "Rei";
					break;
				
				default:
					nome = String.valueOf(j);
					break;
				}
				
				c = new Carta(nome,naipe);
				baralho[indice] = c;
				indice++;
			}
		}
		
		// Adicionar coringas
		
		for(i = 0; i < 4; i++, indice++) {
			c = new Carta("coringa","coringa");
			baralho[indice] = c;
		}
		
	}
	
	public void embaralha() {
		int i, posicao1, posicao2;
		Random rand = new Random();
		Carta auxiliar;
		
		for(i = 0; i < 100; i++) {
			posicao1 = rand.nextInt(56);
			posicao2 = rand.nextInt(56);
			
			auxiliar = baralho[posicao1];
			baralho[posicao1] = baralho[posicao2];
			baralho[posicao2] = auxiliar;
		}
	}
	
	public Carta daCarta() {
		Carta c = baralho[topo];
		topo--;
		
		return c;
	}
	
	public boolean temCarta() {
		if(topo < 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void imprimeBaralho() {
		int i;
		System.out.printf("Baralho:\n");
		for(i=0;i < baralho.length; i++) {
			System.out.printf("%s\n", baralho[i].toString());
		}
		System.out.printf("\n");
	}
}
