import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Autenticacao extends JFrame{

	private JPanel painelDados, painelBotoes;
	private JLabel lCpf, lSenha;
	private JTextField txtCpf, txtSenha;
	private JButton btnLogin, btnCancela, btnCadastro;

	private static List<Cliente> listaCliente = new ArrayList<Cliente>();
	private static List<Cliente> listaAutenticacao = new ArrayList<Cliente>();

	private boolean login = false;

	public Autenticacao() {
		super("LOGIN");
		setLayout(new GridLayout(2,1));

		painelDados = new JPanel(new GridLayout(2,2));
		painelBotoes = new JPanel(new FlowLayout());

		lCpf = new JLabel("CPF: ", SwingConstants.CENTER);
		lSenha = new JLabel("Senha: ", SwingConstants.CENTER);

		txtCpf = new JTextField(100);
		txtSenha = new JTextField(100);

		btnLogin = new JButton("Entrar");
		btnCancela = new JButton("Cancela");
		btnCadastro = new JButton("Cadastrar Cliente");

		painelDados.add(lCpf);
		painelDados.add(txtCpf);
		painelDados.add(lSenha);
		painelDados.add(txtSenha);

		painelBotoes.add(btnLogin);
		painelBotoes.add(btnCadastro);
		painelBotoes.add(btnCancela);

		add(painelDados);
		add(painelBotoes);

		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String cpf = txtCpf.getText().toString();
				String senha = txtSenha.getText().toString();

				if(!(cpf.isBlank() || senha.isBlank())) {
					for(Cliente c : listaCliente) {
						if(c.autentica(cpf, senha)) {
							login = true;
							listaAutenticacao.add(c);
							menu();
						}
					}
					if(!login) {
						JOptionPane.showMessageDialog(null, "Cliente não cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Verifique se não existe campo em branco", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}

		});

		btnCadastro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame telaCadastro = new JFrame("Cadastrar Cliente");
				telaCadastro.setLayout(new GridLayout(2,1));

				JPanel painelCliente = Cliente.criarPainel();
				JPanel painelBotao = new JPanel(new FlowLayout());

				JButton btnCadastra = new JButton("Cadastrar");
				JButton btnCancelaCadastro = new JButton("Fechar");

				painelBotao.add(btnCadastra);
				painelBotao.add(btnCancelaCadastro);

				telaCadastro.add(painelCliente);
				telaCadastro.add(painelBotao);

				telaCadastro.setVisible(true);
				telaCadastro.setSize(600,300);
				telaCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				telaCadastro.setLocationRelativeTo(null);


				btnCadastra.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						String cpf = Cliente.getTxtCpf();
						String nome = Cliente.getTxtNome();
						String senha = Cliente.getTxtSenha();

						if(!(cpf.isBlank() || nome.isBlank() || senha.isBlank())) {
							Cliente cliente = new Cliente(cpf, nome, senha);
							listaCliente.add(cliente);
							ContaSimples.addCliente(cliente);
							Cliente.limpar();
							JOptionPane.showMessageDialog(null, "Cliente inserido!", "SUCESSO", JOptionPane.PLAIN_MESSAGE);
							telaCadastro.dispose();
						}
					}

				});

				btnCancelaCadastro.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						telaCadastro.dispose();

					}

				});

			}

		});
		
		btnCancela.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				fechar();
				
			}
			
		});
	}
	
	public void fechar() {
		this.dispose();
	}
	
	public static String relatorioAutenticacao() {
		String saida = "\t\tRelatorio de Autenticacoes\n\n";
		
		if(listaAutenticacao.size() == 0) {
			saida += "Sem logins efetuados";
			return saida;
		}
		else {
			for(Cliente c : listaAutenticacao) {
				saida += c.saida() + "\n\n";
			}
			
			return saida;
		}
	}

	public void menu(){
		Menu menu = new Menu();
		menu.setVisible(true);
		menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		menu.setSize(400,400);
		menu.setLocationRelativeTo(null);
		this.dispose();
	}

	public void login() {
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600,300);
		this.setLocationRelativeTo(null);

		if(listaCliente.size() < 0) {
			btnLogin.setEnabled(false);
			btnLogin.setBackground(Color.DARK_GRAY);
		}
		else {
			btnLogin.setEnabled(true);
			btnLogin.setBackground(null);
		}
	}

	public static void main(String[] args) {
		Autenticacao a = new Autenticacao();
		a.login();
	}

}
