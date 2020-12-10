import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Caixa implements Autenticavel {

	// Atributos
	
	String nome, senha;
	double salario;
	
	// Variáveis de classe
	
	private static JPanel painel;
	private static JLabel lNome, lSalario, lSenha;
	private static JTextField txtNome, txtSalario, txtSenha;
	
	// Construtores
	
	public Caixa() {
		this.setNome("");
		this.setSenha("");
		this.setSalario(0);
	}

	public Caixa(String nome, String senha, double salario) {
		this.setNome(nome);
		this.setSalario(salario);
		this.setSenha(senha);
	}
	
	// Getters e Setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	// toString
	
	public String toString() {
		return String.format("Nome: %s, Salario: R$ %.2f", this.getNome(), this.getSalario());
	}

	// Método da Interface
	@Override
	public boolean autentica(String usuario, String senha) {
		// TODO Auto-generated method stub
		return false;
	}

	
	// Métodos de classe
	
	public static JPanel criarPainel() {
		painel = new JPanel(new GridLayout(3,2));
		painel.setBorder(Borda.criaBorda("Dados do caixa", Color.black));
		
		lNome = new JLabel("Nome: ", SwingConstants.CENTER);
		lSalario = new JLabel("Salario: ", SwingConstants.CENTER);
		lSenha = new JLabel("Senha: ", SwingConstants.CENTER);
		
		txtNome = new JTextField(100);
		txtSalario = new JTextField(20);
		txtSenha = new JTextField(100);
		
		painel.add(lNome);
		painel.add(txtNome);
		painel.add(lSalario);
		painel.add(txtSalario);
		painel.add(lSenha);
		painel.add(txtSenha);
		
		return painel;
	}
	
	public static void limpar() {
		txtNome.setText("");
		txtSalario.setText("");
		txtSenha.setText("");
	}
	
	public static String getTxtNome() {
		String texto = txtNome.getText().toString();
		
		if(texto.isBlank()) {
			txtNome.setBackground(Color.red);
			JOptionPane.showMessageDialog(null, "Insira o nome!", "ERRO", JOptionPane.ERROR_MESSAGE);
			
			Timer timer = new Timer(1000, event ->{
				txtNome.setBackground(Color.white);
			});
			timer.setRepeats(false);
			timer.start();
		}
		else {
			return texto;
		}
		
		return "";
	}
	
	public static String getTxtSenha() {
		String texto = txtSenha.getText().toString();
		
		if(texto.isBlank()) {
			txtSenha.setBackground(Color.red);
			JOptionPane.showMessageDialog(null, "Insira a senha!", "ERRO", JOptionPane.ERROR_MESSAGE);
			
			Timer timer = new Timer(1000, event ->{
				txtSenha.setBackground(Color.white);
			});
			timer.setRepeats(false);
			timer.start();
		}
		else {
			return texto;
		}
		
		return "";
	}
	
	public static double getTxtSalario() {
		String texto = txtSalario.getText().toString();
		
		if(texto.isBlank()) {
			txtSalario.setBackground(Color.red);
			JOptionPane.showMessageDialog(null, "Insira o salario!", "ERRO", JOptionPane.ERROR_MESSAGE);
			
			Timer timer = new Timer(1000, event ->{
				txtSalario.setBackground(Color.white);
			});
			timer.setRepeats(false);
			timer.start();
		}
		else {
			try {
				double salario = Double.valueOf(texto);
				return salario;
			} catch (NumberFormatException e) {
				txtSalario.setBackground(Color.red);
				JOptionPane.showMessageDialog(null, "Valor invalido!", "ERRO", JOptionPane.ERROR_MESSAGE);
				
				Timer timer = new Timer(1000, event ->{
					txtSalario.setBackground(Color.white);
				});
				timer.setRepeats(false);
				timer.start();
			}
		}
		
		return -1;
	}
	
}
