import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;

public class Caixa extends Funcionario {
	
	// Atributos
	
	double salario, bonus;

	// Variáveis de classe
	
	static JTextField txtSalario, txtBonus;
	static JLabel labelSalario, labelBonus;
	static JPanel painel;
	
	// Construtores
	
	public Caixa() {
		this.setSalario(0.0);
		this.setBonus(0.0);
	}
	
	public Caixa(String nome, String departamento, double salario, double bonus) {
		super(nome, departamento);
		this.setSalario(salario);
		this.setBonus(bonus);
	}
	
	// Método de classe
	
	public static JPanel criarPainel() {
		painel = new JPanel(new GridLayout(4,1));
		Border borda = BorderFactory.createLineBorder(Color.black);
		borda = BorderFactory.createTitledBorder(borda, "Caixa");
		
		painel.setBorder(borda);
		
		labelSalario = new JLabel("Salario:", SwingConstants.LEFT);
		labelBonus = new JLabel("Bonus:", SwingConstants.LEFT);
		
		txtSalario = new JTextField(10);
		txtBonus = new JTextField(10);
		
		painel.add(labelSalario);
		painel.add(txtSalario);
		painel.add(labelBonus);
		painel.add(txtBonus);
		
		return painel;
	}
	
	public static double getTxtSalario() {
		try {
			return Double.valueOf(txtSalario.getText().toString());
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
	
	public static double getTxtBonus() {
		try {
			return Double.valueOf(txtBonus.getText().toString());
		}
		catch(NumberFormatException e) {
			txtBonus.setBackground(Color.red);
			
			Timer timer = new Timer(1000, event -> {
	            txtBonus.setBackground(Color.white);
	        });
	        timer.setRepeats(false);
	        timer.start();
			
			return -1;
		}
	}
	
	// Método abstrato
	
	@Override
	public double getBonificacao() {
		return (this.getSalario() + this.getBonus());
	}
	
	// Getters e Setters
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public double getSalario() {
		return this.salario;
	}
	
	public double getBonus() {
		return this.bonus;
	}

}
