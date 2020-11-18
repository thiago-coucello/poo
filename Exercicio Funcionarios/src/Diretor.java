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

public class Diretor extends Funcionario {
	
	// Atributos
	double salarioFixo, gratificacoes;
	double taxaRendimento;
	
	// Variaveis do painel
	
	static JTextField txtSalario, txtGratificacoes, txtRendimento;
	static JLabel labelSalario, labelGratificacoes, labelRendimento;
	static JPanel painel;
	
	// Construtores
	
	public Diretor() {
		this.setSalarioFixo(0);
		this.setGratificacoes(0);
		this.setTaxaRendimento(0);
	}
	
	public Diretor(String nome, String departamento, double salario, double gratificacoes, int taxaRendimento) {
		super(nome, departamento);
		this.setSalarioFixo(salario);
		this.setGratificacoes(gratificacoes);
		this.setTaxaRendimento(taxaRendimento);
	}
	
	// Métodos da classe
	
	public static JPanel criarPainel() {
		painel = new JPanel(new GridLayout(6,1));
		Border borda = BorderFactory.createLineBorder(Color.black);
		borda = BorderFactory.createTitledBorder(borda, "Diretor");
		
		painel.setBorder(borda);
		
		txtSalario = new JTextField(10);
		txtGratificacoes = new JTextField(10);
		txtRendimento = new JTextField(10);
		
		labelSalario = new JLabel("Salario:", SwingConstants.LEFT);
		labelGratificacoes = new JLabel("Gratificacoes:", SwingConstants.LEFT);
		labelRendimento = new JLabel("Taxa de Rendimentos:", SwingConstants.LEFT);
		
		painel.add(labelSalario);
		painel.add(txtSalario);
		painel.add(labelRendimento);
		painel.add(txtRendimento);
		painel.add(labelGratificacoes);
		painel.add(txtGratificacoes);
		
		return painel;
	}
	
	public static double getTxtSalario() {
		double saida;
		
		try {
			saida = Double.valueOf(txtSalario.getText().toString());
			return saida;
		}
		catch(NumberFormatException e) {
			txtSalario.setBackground(Color.red);
			
			Timer timer = new Timer(1000, event -> {
	            txtSalario.setBackground(Color.white);
	        });
	        timer.setRepeats(false);
	        timer.start();
			
			return -1;
		}

	}
	
	public static double getTxtGratificacoes() {
		double saida;
		try {
			saida = Double.valueOf(txtGratificacoes.getText().toString());
			return saida;
		}
		catch(NumberFormatException e) {
			txtSalario.setBackground(Color.red);
			
			Timer timer = new Timer(1000, event -> {
	            txtGratificacoes.setBackground(Color.white);
	        });
	        timer.setRepeats(false);
	        timer.start();
	        
			return -1;
		}
	}

	public static int getTxtRendimento() {
		int saida;
		try {
			saida = Integer.valueOf(txtRendimento.getText().toString());
			return saida;
		}
		catch(NumberFormatException e) {
			txtSalario.setBackground(Color.red);
			Timer timer = new Timer(1000, event -> {
	            txtRendimento.setBackground(Color.white);
	        });
	        timer.setRepeats(false);
	        timer.start();
			return -1;
		}
	}
	
	// Métodos abstratos
	
	public double getBonificacao() {
		return this.getSalarioFixo() + this.getTaxaRendimento() * this.getGratificacoes();
	}
	
	// Getters e Setters
	
	public void setSalarioFixo(double salario) {
		this.salarioFixo = salario;
	}
	
	public void setGratificacoes(double gratificacoes) {
		this.gratificacoes = gratificacoes;
	}
	
	public void setTaxaRendimento(int taxaRendimento) {
		this.taxaRendimento = (double) taxaRendimento/100;
	}
	
	public double getSalarioFixo() {
		return this.salarioFixo;
	}
	
	public double getGratificacoes() {
		return this.gratificacoes;
	}
	
	public double getTaxaRendimento() {
		return this.taxaRendimento;
	}

	public String toString() {
		String saida = "";
		
		saida = "Diretor: " + super.toString() + String.format(Locale.US,", Salario: %.2f, Gratificacoes: %.2f, Rendimento: %.2f\nBonificacao: %.2f", this.getSalarioFixo(), this.getGratificacoes(), this.getTaxaRendimento(),this.getBonificacao()); 
		
		return saida;
	}
	
}
