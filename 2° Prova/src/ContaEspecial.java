import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class ContaEspecial extends ContaSimples {
	
	// Atributos
	
	private double limite;
	
	// Variáveis de classe
	
	private static JPanel painel;
	private static JLabel lLimite;
	private static JTextField txtLimite;
	
	// Construtores

	public ContaEspecial() {
		super();
		this.setLimite(0);
	}

	public ContaEspecial(Cliente cliente, int nroConta, double saldo, double limite) {
		super(cliente, nroConta, saldo);
		this.setLimite(limite);
	}
	
	// Getter e Setters

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	// toString
	
	public String toString() {
		return String.format("Numero da conta: %d, Saldo: R$ %.2f, Limite: R$ %.2f\n%s", 
				this.getNroConta(), this.getSaldo(), this.getLimite(), this.getCliente().saida());
	}
	
	public static JPanel criarPainel() {
		painel = ContaSimples.criarPainel();
		painel.setBorder(Borda.criaBorda("Dados Conta Especial", Color.black));
		
		lLimite = new JLabel("Limite: ", SwingConstants.CENTER);
		
		txtLimite = new JTextField(20);
		
		painel.add(lLimite);
		painel.add(txtLimite);
		
		return painel;
	}
	
	public static void limpar() {
		ContaSimples.limpar();
		txtLimite.setText("");
	}
	
	public static double getTxtLimite() {
		String texto = txtLimite.getText().toString();
		
		if(texto.isBlank()) {
			txtLimite.setBackground(Color.red);
			JOptionPane.showMessageDialog(null, "Insira o limite!", "ERRO", JOptionPane.ERROR_MESSAGE);
			
			Timer timer = new Timer(1000, event ->{
				txtLimite.setBackground(Color.white);
			});
			timer.setRepeats(false);
			timer.start();
		}
		else {
			try {
				double limite = Double.valueOf(texto);
				return limite;
			} catch (NumberFormatException e) {
				txtLimite.setBackground(Color.red);
				JOptionPane.showMessageDialog(null, "Valor invalido!", "ERRO", JOptionPane.ERROR_MESSAGE);
				
				Timer timer = new Timer(1000, event ->{
					txtLimite.setBackground(Color.white);
				});
				timer.setRepeats(false);
				timer.start();
			}
		}
		
		return -1;
	}
}
