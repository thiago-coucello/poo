import java.awt.Color;
import java.awt.GridLayout;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;

public class Engenheiro extends Funcionario {
	
	// Atributos
	
	int qntdVistorias;
	double valorVistoria;
	
	// Variaveis de layout
	
	static JTextField txtQntdVistorias, txtValorVistoria;
	static JLabel labelQntdVistorias, labelValorVistoria;
	static JPanel painel;
	
	// Construtores
	
	public Engenheiro() {
		super();
		this.setQntdVistorias(0);
		this.setValorVistoria(0.00);
	}
	
	public Engenheiro(String nome, String departamento, int qntd, double valor) {
		super(nome, departamento);
		this.setQntdVistorias(qntd);
		this.setValorVistoria(valor);
	}
	
	// Métoods de classe
	
	public static JPanel criarPainel() {
		painel = new JPanel(new GridLayout(4,1));
		Border borda = BorderFactory.createLineBorder(Color.black);
		borda = BorderFactory.createTitledBorder(borda, "Engenheiro");
		
		painel.setBorder(borda);
		
		labelQntdVistorias = new JLabel("Quantidade de Vistorias:", SwingConstants.LEFT);
		labelValorVistoria = new JLabel("Valor da Vistoria:", SwingConstants.LEFT);
		
		txtQntdVistorias = new JTextField(10);
		txtValorVistoria = new JTextField(10);
		
		painel.add(labelQntdVistorias);
		painel.add(txtQntdVistorias);
		painel.add(labelValorVistoria);
		painel.add(txtValorVistoria);
		
		return painel;
	}
	
	public static int getTxtQntdVistorias() {
		try {
			return Integer.valueOf(txtQntdVistorias.getText().toString());
		}
		catch(NumberFormatException e) {
			txtQntdVistorias.setBackground(Color.red);
			Timer timer = new Timer(1000, event -> {
	            txtQntdVistorias.setBackground(Color.white);
	        });
	        timer.setRepeats(false);
	        timer.start();
			return -1;
		}
	}
	
	public static double getTxtValorVistoria() {
		try {
			return Double.valueOf(txtValorVistoria.getText().toString());
		}
		catch(NumberFormatException e) {
			txtValorVistoria.setBackground(Color.red);
			
			Timer timer = new Timer(1000, event -> {
	            txtValorVistoria.setBackground(Color.white);
	        });
	        timer.setRepeats(false);
	        timer.start();
	        
			return -1;
		}
	}
	
	// Método abstrato
	
	public double getBonificacao() {
		return (this.getQntdVistorias() * this.getValorVistoria());
	}

	// Getters e Setters
	
	public void setQntdVistorias(int qntd) {
		this.qntdVistorias = qntd;
	}
	
	public void setValorVistoria(double valor) {
		this.valorVistoria = valor;
	}
	
	public int getQntdVistorias() {
		return this.qntdVistorias;
	}
	
	public double getValorVistoria() {
		return this.valorVistoria;
	}
	
	public String toString() {
		String saida = "";
		
		saida = "Engenheiro: " + super.toString() + String.format(Locale.US,", Vistorias: %d, Valor por vistoria: %.2f \nBonificacao: %.2f", this.getQntdVistorias(), this.getValorVistoria(), this.getBonificacao()); 
		
		return saida;
	}
	
}
