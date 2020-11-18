import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class Formulario extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnTam;
	private JButton btnMaiusc;
	private JButton btnMinusc;
	private JButton btnLimpar;
	JLabel txt1,txt2,tamanho;
	JTextField frase;
	
	public Formulario() {
		
		btnTam = new JButton("Tamanho");
		btnMaiusc = new JButton("Maiusculo");
		btnMinusc = new JButton("Minusculo");
		btnLimpar = new JButton("Limpar");
		txt1= new JLabel("digite um texto",SwingConstants.CENTER);
		txt2= new JLabel("tamanho",SwingConstants.CENTER);
		tamanho= new JLabel("XX",SwingConstants.CENTER);
		frase= new JTextField(20);
		
		setLayout(new BorderLayout());
		 
		JPanel south = new JPanel(new GridLayout(2,2));
		
		south.add(btnTam);
		south.add(btnMaiusc);
		south.add(btnMinusc);
		south.add(btnLimpar);
		
		add(south, BorderLayout.SOUTH);
		
		JPanel north = new JPanel(new GridLayout (2,2));
		
		north.add(txt1);
		north.add(frase);
		north.add(txt2);
		north.add(tamanho);
		
		add(north, BorderLayout.CENTER);
		
		btnTam.addActionListener(this);
		btnMaiusc.addActionListener(this);
		btnMinusc.addActionListener(this);
		btnLimpar.addActionListener(this);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String texto = frase.getText();
		String aux;
		int tam;
		
		if(texto.isEmpty()) {
			frase.setText("Digite um texto");
		}
		else {
			if(e.getSource() == btnTam) {
				tam = texto.length();
				tamanho.setText(String.format("%d", tam));
			}
			else if(e.getSource()==btnMaiusc) {
				aux = texto.toUpperCase();
				frase.setText(aux);
			}
			else if(e.getSource() == btnMinusc) {
				aux = texto.toLowerCase();
				frase.setText(aux);
			}
			else {
				frase.setText("");
				tamanho.setText("XX");
			}
		}
		
	}
	
	public static void main(String[] args) {
		Formulario tela = new Formulario();
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setSize(500,300);
		tela.setLocation(700,400);
		tela.setVisible(true);
		

	}

}
