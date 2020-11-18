import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class Calculadora extends JFrame implements ActionListener {

	JButton btnSoma, btnDiferenca, btnMulti, btnDivide, btnClear;
	JLabel texto1, texto2, texto3;
	JTextField valor1, valor2, txtResul;
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Calculadora() {
		setLayout(new BorderLayout());
		btnSoma = new JButton("+");
		btnDiferenca = new JButton("-");
		btnMulti = new JButton("x");
		btnDivide = new JButton("/");
		btnClear = new JButton("Clear");
		
		JPanel leste = new JPanel(new GridLayout(5,1));

		leste.add(btnSoma);
		leste.add(btnDiferenca);
		leste.add(btnMulti);
		leste.add(btnDivide);
		leste.add(btnClear);
		
		add(leste, BorderLayout.EAST);
		
		JPanel centro = new JPanel(new GridLayout(3,2));
		
		valor1 = new JTextField(10);
		valor2 = new JTextField(10);
		txtResul = new JTextField(10);
		
		valor1.setHorizontalAlignment(JTextField.CENTER);
		valor2.setHorizontalAlignment(JTextField.CENTER);
		txtResul.setEditable(false);
		txtResul.setHorizontalAlignment(JTextField.CENTER);
		txtResul.setForeground(Color.MAGENTA);
		
		texto1 = new JLabel("Entre com o valor 1: ",SwingConstants.CENTER);
		texto2 = new JLabel("Entre com o valor 2: ",SwingConstants.CENTER);
		texto3 = new JLabel("Resultado: ",SwingConstants.CENTER);
		
		centro.add(texto1);
		centro.add(valor1);
		centro.add(texto2);
		centro.add(valor2);
		centro.add(texto3);
		centro.add(txtResul);
		
		add(centro, BorderLayout.CENTER);
		
		btnSoma.addActionListener(this);
		btnDiferenca.addActionListener(this);
		btnMulti.addActionListener(this);
		btnDivide.addActionListener(this);
		btnClear.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent b) {
		
		float num1, num2, resul;
		
		try {
			num1 = Float.parseFloat(valor1.getText());
			num2 = Float.parseFloat(valor2.getText());
			
		}catch(NumberFormatException e) {
			num1 = 0;
			num2 = 0;
			
		}
		
		if(b.getSource()==btnSoma) {
			resul = num1 + num2;
			txtResul.setText(String.format("%5.2f", resul));
		}
		
		else if(b.getSource() == btnDiferenca) {
			resul = num1 - num2;
			txtResul.setText(String.format("%5.2f", resul));
		}
		
		else if(b.getSource() == btnMulti) {
			resul = num1 * num2;
			System.out.println(resul);
			txtResul.setText(String.format("%5.2f", resul));
		}
		
		else if(b.getSource() == btnDivide) {
			if(num2 == 0) {
				txtResul.setForeground(Color.red);
				txtResul.setText(" puts kkkkk Não existe divisão por 0");
			}
			else {
				resul = num1 / num2;
				txtResul.setText(String.format("%5.2f", resul));
				
			}
		}
		
		else {
			valor1.setText("");
			valor2.setText("");
			txtResul.setText("");
			txtResul.setForeground(Color.MAGENTA);
		}
		
	}
	
	public static void main(String[] args) {
		Calculadora tela = new Calculadora();
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setSize(350,230);
		tela.setLocation(700,400);
		tela.setVisible(true);
		
	}

}
