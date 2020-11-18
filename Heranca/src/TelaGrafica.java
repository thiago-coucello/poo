import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class TelaGrafica extends JFrame implements ActionListener, ItemListener{
	
	private JRadioButton 		rbPessoa, rbEstudante;
	private ButtonGroup 		grupo;
	private JButton 			btnInsere, btnExibe;
	private JLabel 				labelNome, labelAno, labelRA, labelN1, labelN2, labelAviso;
	private JTextField 			txtNome, txtAno, txtRA, txtN1, txtN2;
	private JPanel 				pnlPessoa, pnlEstudante, pnlBotoes, pnlRadioButtons, pnlCentro;
	private boolean				check_pessoa, check_estudante;
	
	private LinkedList<Pessoa> lista = new LinkedList<Pessoa>();
	
	public TelaGrafica() {
		super("Herança: pessoa e estudante");
		setLayout(new BorderLayout());
		
		// ============== Parte Norte do layout ================ //
		
		// ===== Iniciando os Componentes ===== //
		
		rbPessoa 		= new JRadioButton("Pessoa", true);
		check_pessoa 	= true;
		rbEstudante 	= new JRadioButton("Estudante", false);
		pnlRadioButtons	= new JPanel(new FlowLayout());
		grupo			= new ButtonGroup();
		
		// ===== Adicionando os ItemListeners ===== //
		
		rbPessoa		.addItemListener(this);
		rbEstudante		.addItemListener(this);
		
		// ===== Adicionando os RadioButtons ao grupo ===== //
		
		grupo			.add(rbPessoa);
		grupo			.add(rbEstudante);
		
		// ====== Adicionando os RadioButtons ao painel ===== //
		
		pnlRadioButtons	.add(rbPessoa);
		pnlRadioButtons	.add(rbEstudante);
		
		// ====== Adicionando o painel ao layout ======= //
		
		add(pnlRadioButtons, BorderLayout.NORTH);
		
		//======================= Parte central do layout  ========================== //
		
		// ===== Iniciando os componentes ===== //
		
		// ======= Labels ======== //
		labelNome 		= new JLabel("Nome: ", SwingConstants.CENTER);
		labelAno 		= new JLabel("Ano: ", SwingConstants.CENTER);
		labelRA 		= new JLabel("RA: ", SwingConstants.CENTER);
		labelN1 		= new JLabel("Nota 1: ", SwingConstants.CENTER);
		labelN2			= new JLabel("Nota 2: ", SwingConstants.CENTER);

		// ======= TextFields ========== //
		
		txtNome			= new JTextField();
		txtAno			= new JTextField();
		txtRA			= new JTextField();
		txtN1			= new JTextField();
		txtN2			= new JTextField();
		
		// ======= Panels ========//
		
		pnlPessoa 		= new JPanel(new GridLayout(2,2));
		pnlEstudante 	= new JPanel(new GridLayout(3,2));
		pnlCentro 		= new JPanel(new GridLayout(3,1));
		labelAviso		= new JLabel("",SwingConstants.CENTER);
		
		// ======= Adicionando componentes aos paineis ====== //
		
		pnlPessoa		.add(labelNome);
		pnlPessoa		.add(txtNome);
		pnlPessoa		.add(labelAno);
		pnlPessoa		.add(txtAno);
		
		pnlEstudante	.add(labelRA);
		pnlEstudante	.add(txtRA);
		pnlEstudante	.add(labelN1);
		pnlEstudante	.add(txtN1);
		pnlEstudante	.add(labelN2);
		pnlEstudante	.add(txtN2);
		
		pnlEstudante	.setVisible(false);
		
		pnlCentro		.add(pnlPessoa);
		pnlCentro		.add(pnlEstudante);
		pnlCentro		.add(labelAviso);
		
		// ====== Adicionando painel ao layout ===== //
		
		add(pnlCentro, BorderLayout.CENTER);
		
		// ================= Parte sul do layout ================== //
		
		// ======= Iniciando componentes ====== //
		
		btnInsere 		= new JButton("Insere");
		btnExibe		= new JButton("Exibe");
		pnlBotoes 		= new JPanel(new FlowLayout());
		
		// ====== Adicionando ActionListeners ======//
		
		btnInsere		.addActionListener(this);
		btnExibe		.addActionListener(this);
		
		// ===== Adicionando ao painel ====== //
		
		pnlBotoes		.add(btnInsere);
		pnlBotoes		.add(btnExibe);
		
		// ===== Adicionando painel ao layout ===== //
		
		add(pnlBotoes, BorderLayout.SOUTH);
	}
	
	@Override
	public void itemStateChanged(ItemEvent ievent) {
		
		if(ievent.getSource() == rbPessoa) {
			pnlEstudante.setVisible(false);
			check_pessoa = true;
			check_estudante = false;
		}
		else {
			pnlEstudante.setVisible(true);
			check_estudante = true;
			check_pessoa = false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == btnInsere) {
			insere();
		}
		else {
			exibe();
		}
		
	}
	

	private void exibe() {
		String saida = "----- Lista de Pessoas e Estudantes ------\n\n";
		int i = 1;
		
		for(Pessoa p : lista) {
			saida += "Posicao: "+ i + "\n" + p.toString() + "\n\n";
			i++;
		}
		JTextArea area = new JTextArea(saida,11,10);
		JOptionPane.showMessageDialog(null, area, "Listagem", JOptionPane.INFORMATION_MESSAGE);
	}

	private void insere() {
		String nome, ra;
		Double n1, n2;
		int ano;
		Pessoa p = new Pessoa();
		Estudante e = new Estudante();
		
		if(check_pessoa) {
			nome = txtNome.getText().toString();
			ano = Integer.valueOf(txtAno.getText().toString());
			
			p.setNome(nome);
			p.setAnoNasc(ano);
			
			lista.add(p);
		}
		
		if(check_estudante) {
			nome = txtNome.getText().toString();
			ano = Integer.valueOf(txtAno.getText().toString());
			ra = txtRA.getText().toString();
			n1 = Double.valueOf(txtN1.getText().toString());
			n2 = Double.valueOf(txtN2.getText().toString());
		
			e.setNome(nome);
			e.setAnoNasc(ano);
			e.setN1(n1);
			e.setN2(n2);
			e.setRa(ra);
			
			lista.add(e);
		}
		
		clear();
		
		labelAviso		.setText("----- Inseriu com sucesso -----");

        Timer timer = new Timer(1000, event -> {
            labelAviso.setText("");
        });
        timer.setRepeats(false);
        timer.start();
	}
	
	public void clear() {
		txtNome.setText("");
		txtAno.setText("");
		txtRA.setText("");
		txtN1.setText("");
		txtN2.setText("");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TelaGrafica tela = new TelaGrafica();
		//tela.removeAll();
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setSize(250,250);
		tela.setLocationRelativeTo(null);
		tela.setVisible(true);
		
	}

}
