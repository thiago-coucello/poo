import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Jogo extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	Baralho bar;
	List<Carta> morto = new ArrayList<>();
	Carta c;
	JButton btnFechado, btnAberto, btnCriaBaralho, btnEmbaralha, btnZeraTudo, btnExibe;
	ImageIcon fechado, aberto, vazio;
	
	public Jogo() {
		super("Baralho de Cartas");
		setLayout(new BorderLayout());
		
		fechado = new ImageIcon(getClass().getResource("fechado.png"));
		vazio = new ImageIcon(getClass().getResource("fechado2.png"));
		
		btnFechado = new JButton(fechado);
		btnAberto = new JButton(vazio);
		btnCriaBaralho = new JButton("Cria Baralho");
		btnEmbaralha = new JButton("Embaralha");
		btnZeraTudo = new JButton("Zera Tudo");
		btnExibe = new JButton("Exibe");
		
		bar=  new Baralho();
		morto.clear();
		
		JPanel centro = new JPanel(new FlowLayout());
		centro.add(btnFechado);
		centro.add(btnAberto);
		
		JPanel sul = new JPanel(new FlowLayout());
		
		sul.add(btnCriaBaralho);
		sul.add(btnEmbaralha);
		sul.add(btnZeraTudo);
		sul.add(btnExibe);
		
		add(centro,BorderLayout.NORTH);
		add(sul,BorderLayout.CENTER);
		
		btnFechado.addActionListener(this);
		btnCriaBaralho.addActionListener(this);
		btnEmbaralha.addActionListener(this);
		btnZeraTudo.addActionListener(this);
		btnExibe.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent a) {
		
		if(a.getSource() == btnCriaBaralho) {
			bar.zeraBaralho();
			bar = new Baralho();
			btnFechado.setIcon(fechado);
			btnAberto.setIcon(vazio);
		}
		
		else if(a.getSource() == btnExibe) {
			String saida = bar.toString();
			JOptionPane.showMessageDialog(null, saida);
		}
		
		else if(a.getSource() == btnEmbaralha) {
			bar.embaralha();
		}
		
		else if(a.getSource() == btnZeraTudo) {
			bar.zeraBaralho();
			btnFechado.setIcon(vazio);
			btnAberto.setIcon(vazio);
		}
		
		else{
			if(bar.getBaralho().isEmpty()) {
				fechado = new ImageIcon("fechado2.png");
				btnFechado.setIcon(vazio);
				btnFechado.disable();
			}
			else {
				c = bar.getCarta(0);
				morto.add(c);
				
				aberto = new ImageIcon(getClass().getResource(c.getImagem()));
				btnAberto.setIcon(aberto);
			}
			
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Jogo tela = new Jogo();
		tela.setCursor(Cursor.HAND_CURSOR);
		tela.setTitle("Joguin");
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setVisible(true);
		tela.pack();
		tela.setLocation(750,450);
	}
	
}
