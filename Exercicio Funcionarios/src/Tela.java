import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
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
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class Tela extends JFrame implements ActionListener, ItemListener{

	// Atributos de Layout

	private JRadioButton rbEngenheiro, rbDiretor, rbCaixa;
	private JLabel labelNome, labelDepartamento;
	private JTextField txtNome, txtDepartamento;
	private JButton btnExibeBonificacoes, btnInserir;
	private ButtonGroup grupo;
	private JPanel panelRadioButtons, panelDados, panelFuncionario, panelBotoes;
	private Border bordaRadioButtons;

	// Atributos auxiliares

	private Engenheiro objEngenheiro;
	private Diretor objDiretor;
	private Caixa objCaixa;
	private boolean eng, dir, cx;

	// Lista de funcionários

	private List<Funcionario> lista = new ArrayList<Funcionario>();

	public Tela() {
		super("Cadastro de funcionários");
		setLayout(new BorderLayout());

		// Inicialização de variáveis

		rbEngenheiro 			= new JRadioButton("Engenheiro", true);
		rbDiretor 				= new JRadioButton("Diretor",false);
		rbCaixa 				= new JRadioButton("Caixa", false);

		eng = true;
		dir = false;
		cx = false;

		labelNome 				= new JLabel("Nome:", SwingConstants.LEFT);
		txtNome 				= new JTextField();

		labelDepartamento		= new JLabel("Departamento:", SwingConstants.LEFT);
		txtDepartamento			= new JTextField();

		btnExibeBonificacoes 	= new JButton("Exibe todas as bonificacoes");
		btnInserir 				= new JButton("Adicionar");

		panelRadioButtons 		= new JPanel(new FlowLayout());

		bordaRadioButtons		= BorderFactory.createLineBorder(Color.gray);
		bordaRadioButtons		= BorderFactory.createTitledBorder(bordaRadioButtons, "Cargo");

		panelDados				= new JPanel(new GridLayout(4,1));

		panelBotoes				= new JPanel(new FlowLayout());

		grupo = new ButtonGroup();

		// Montando layout

		// Carregando paineis

		panelFuncionario = recuperarPainel();

		panelRadioButtons.setBorder(bordaRadioButtons);
		panelRadioButtons.add(rbEngenheiro);
		panelRadioButtons.add(rbCaixa);
		panelRadioButtons.add(rbDiretor);

		panelDados.add(labelNome);
		panelDados.add(txtNome);
		panelDados.add(labelDepartamento);
		panelDados.add(txtDepartamento);
		panelDados.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.black),
				"Dados do funcionário"
				));

		panelBotoes.add(btnExibeBonificacoes);
		panelBotoes.add(btnInserir);
		panelBotoes.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));

		grupo.add(rbEngenheiro);
		grupo.add(rbDiretor);
		grupo.add(rbCaixa);

		// Adicionando paineis ao layout

		this.add(panelRadioButtons, BorderLayout.NORTH);
		this.add(panelDados, BorderLayout.CENTER);
		this.add(panelFuncionario, BorderLayout.WEST);
		this.add(panelBotoes, BorderLayout.SOUTH);

		// Adicionando Listeners

		rbEngenheiro.addItemListener(this);
		rbDiretor.addItemListener(this);
		rbCaixa.addItemListener(this);

		btnExibeBonificacoes.addActionListener(this);
		btnInserir.addActionListener(this);
	}

	public JPanel recuperarPainel() {

		if(eng) {
			return Engenheiro.criarPainel();
		}
		else if(dir) {
			return Diretor.criarPainel();
		}
		else if(cx) {
			return Caixa.criarPainel();
		}

		return new JPanel();
	}

	public void limparPainel() {
		this.getContentPane().remove(panelFuncionario);
		recuperarPainel();
		this.add(panelFuncionario, BorderLayout.WEST);
		txtNome.setText("");
		txtDepartamento.setText("");
		this.revalidate();
		this.pack();
	}

	public void inserir() {
		Timer timer;
		String nome = txtNome.getText().toString();
		String departamento = txtDepartamento.getText().toString();


		if(nome.equals("")) {
			txtNome.setBackground(Color.red);

			timer = new Timer(1000, event -> {
				txtNome.setBackground(Color.white);
			});
			timer.setRepeats(false);
			timer.start();
		}

		if(departamento.equals("")) {
			txtDepartamento.setBackground(Color.red);

			timer = new Timer(1000, event -> {
				txtDepartamento.setBackground(Color.white);
			});
			timer.setRepeats(false);
			timer.start();
		}

		if(!nome.equals("") && !departamento.equals("")) {
			if(rbEngenheiro.isSelected()) {
				int quantidade = Engenheiro.getTxtQntdVistorias();
				double valor = Engenheiro.getTxtValorVistoria();

				if(quantidade != -1 && valor != -1) {
					objEngenheiro = new Engenheiro(nome, departamento, quantidade, valor);
					lista.add(objEngenheiro);
					limparPainel();
				}
			}
			else if(rbDiretor.isSelected()) {
				double salario = Diretor.getTxtSalario();
				double gratificacoes = Diretor.getTxtGratificacoes();
				int rendimento = Diretor.getTxtRendimento();

				if(salario != -1 && gratificacoes != -1 && rendimento != -1) {
					objDiretor = new Diretor(nome, departamento, salario, gratificacoes, rendimento);
					lista.add(objDiretor);
					limparPainel();
				}
			}
			else if(rbCaixa.isSelected()) {
				double salario = Caixa.getTxtSalario();
				double bonus = Caixa.getTxtBonus();

				if(salario != -1 && bonus != -1) {
					objCaixa = new Caixa(nome,departamento, salario, bonus);
					lista.add(objCaixa);
					limparPainel();
				}
			}
		}
	}

	public void exibe() {
		String saida = "----- Lista de Pessoas e Estudantes ------\n\n";
		int i = 1;

		for(Funcionario p : lista) {
			saida += "Posicao: "+ i + "\n" + p.toString() + "\n\n";
			i++;
		}
		JTextArea area = new JTextArea(saida,11,10);
		JOptionPane.showMessageDialog(null, area, "Listagem", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		if(a.getSource() == btnExibeBonificacoes) {
			exibe();
		}

		else if(a.getSource() == btnInserir){
			inserir();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent l) {
		if(l.getItem() == rbEngenheiro) {
			if(l.getStateChange() == ItemEvent.SELECTED) {
				this.getContentPane().remove(panelFuncionario);
				panelFuncionario = Engenheiro.criarPainel();
				this.add(panelFuncionario, BorderLayout.WEST);

				eng = true;
				dir = false;
				cx = false;
			}
		}
		else if(l.getItem() == rbDiretor) {
			if(l.getStateChange() == ItemEvent.SELECTED) {
				this.getContentPane().remove(panelFuncionario);
				panelFuncionario = Diretor.criarPainel();
				this.add(panelFuncionario, BorderLayout.WEST);

				eng = false;
				dir = true;
				cx = false;
			}
		}
		else if(l.getItem() == rbCaixa) {
			if(l.getStateChange() == ItemEvent.SELECTED) {
				this.getContentPane().remove(panelFuncionario);
				panelFuncionario = Caixa.criarPainel();
				this.add(panelFuncionario, BorderLayout.WEST);
				eng = false;
				dir = false;
				cx = true;
			}
		}

		this.revalidate();
		this.pack();
	}

	public static void main(String [] args) {
		Tela tela = new Tela();

		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.pack();
		tela.setLocationRelativeTo(null);
		tela.setVisible(true);
	}

}
