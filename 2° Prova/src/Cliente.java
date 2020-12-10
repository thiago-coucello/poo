import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Cliente implements Autenticavel {
	
	// Atributos
	
	String cpf, nome, senha;
	
	// Variáveis de classe
	
	private static JPanel painel;
	private static JLabel lCpf, lNome, lSenha;
	private static JTextField txtCpf, txtNome, txtSenha;
	
	// Construtores
	
	public Cliente() {
		this.setCpf("");
		this.setNome("");
		this.setSenha("");
	}

	public Cliente(String cpf, String nome, String senha) {
		this.setCpf(cpf);
		this.setNome(nome);
		this.setSenha(senha);
	}
	
	// Getters e Setters

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

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
	
	// o que vai ser Exibido no JComboBox
	
	public String toString() {
		return String.format("%s", this.getNome());
	}
	
	// toString
	
	public String saida() {
		return String.format("Nome: %s, CPF: %s", this.getNome(), this.getCpf());
	}

	// Método da Interface
	
	@Override
	public boolean autentica(String usuario, String senha) {
		return (this.getCpf().equals(usuario) && this.getSenha().equals(senha));
	}
	
	// Métodos de Classe
	
	public static JPanel criarPainel() {
		painel = new JPanel(new GridLayout(3,2));
		painel.setBorder(Borda.criaBorda("Dados do cliente", Color.black));
		
		lNome = new JLabel("Nome: ", SwingConstants.CENTER);
		lCpf = new JLabel("CPF: ", SwingConstants.CENTER);
		lSenha = new JLabel("Senha: ", SwingConstants.CENTER);
		
		txtNome = new JTextField(100);
		txtCpf = new JTextField(20);
		txtSenha = new JTextField(100);
		
		painel.add(lNome);
		painel.add(txtNome);
		painel.add(lCpf);
		painel.add(txtCpf);
		painel.add(lSenha);
		painel.add(txtSenha);
		
		return painel;
	}
	
	public static void limpar() {
		txtNome.setText("");
		txtCpf.setText("");
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
	
	public static String getTxtCpf() {
		String texto = txtCpf.getText().toString();
		
		if(texto.isBlank()) {
			txtCpf.setBackground(Color.red);
			JOptionPane.showMessageDialog(null, "Insira a senha!", "ERRO", JOptionPane.ERROR_MESSAGE);
			
			Timer timer = new Timer(1000, event ->{
				txtCpf.setBackground(Color.white);
			});
			timer.setRepeats(false);
			timer.start();
		}
		else {
			return texto;
		}
		
		return "";
	}
}
