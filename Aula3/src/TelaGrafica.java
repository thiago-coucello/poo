import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.List;
import java.util.ArrayList;

public class TelaGrafica extends JFrame implements ActionListener {

	JButton btnInsere, btnExibe;
	JTextField txtNome, txtDia, txtMes, txtAno;
	JLabel entraNome;
	
	List<Pessoa> lista = new ArrayList<Pessoa>();
	
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnInsere) {
			String nome = txtNome.getText();
			int dia,mes,ano;
			
			if(nome == "")
				nome = "Vazio da Silva Pinto Melado";
			
			try {
				dia = Integer.parseInt(txtDia.getText());
				mes = Integer.parseInt(txtMes.getText());
				ano = Integer.parseInt(txtAno.getText());
				
			}catch(NumberFormatException b) {
				dia = 0;
				mes = 0;
				ano = 0;
			
			}
			
			Pessoa p = new Pessoa(nome,dia,mes,ano);
			p.verificaSigno();
			
			lista.add(p);
		
			JOptionPane.showMessageDialog(null, ".... Cadastrado com sucesso ....");
			txtNome.setText("");
			txtDia.setText("");
			txtMes.setText("");
			txtAno.setText("");
		}
		
		else if(e.getSource() == btnExibe) {
			String saida = "";
			for(int i = 0; i < lista.size(); i++) 
				saida += lista.get(i).toString();
			JOptionPane.showMessageDialog(null,saida);
		}
		
	}
	
	public TelaGrafica() {
		super("Lista de Pessoas");
		setLayout(new BorderLayout());
		
		btnInsere = new JButton("Insere");
		btnExibe = new JButton("Exibe");
		entraNome = new JLabel("Entra nome: ", SwingConstants.CENTER);
		txtNome = new JTextField(20);
		txtDia = new JTextField(3);
		txtMes = new JTextField(3);
		txtAno = new JTextField(4);
		
		JPanel norte = new JPanel(new FlowLayout());
		norte.add(entraNome);
		norte.add(txtNome);
		
		JPanel centro = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		centro.add(txtDia);
		centro.add(txtMes);
		centro.add(txtAno);
		Border b1 = BorderFactory.createEtchedBorder();
		Border b2 = BorderFactory.createTitledBorder(b1,"Data de Nascimento");
		centro.setBorder(b2);
	
		JPanel sul = new JPanel(new FlowLayout(FlowLayout.CENTER,50,10));
		sul.add(btnInsere);
		sul.add(btnExibe);
		
		add(centro,BorderLayout.CENTER);
		add(sul,BorderLayout.SOUTH);
		add(norte,BorderLayout.NORTH);
		
		btnInsere.addActionListener(this);
		btnExibe.addActionListener(this);
	}
	
	public static void main(String[] args) {
		TelaGrafica tela = new TelaGrafica();
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setSize(360,180);
		tela.setLocation(750,450);
		tela.setVisible(true);
	}

}
