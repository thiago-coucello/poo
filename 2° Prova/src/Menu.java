import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class Menu extends JFrame{
	private JMenuBar barraPrincipal;
	private JMenu Cadastro, Movimento, Relatorio, Sair;
	private JMenuItem cadastrarSimples, cadastrarEspecial, saque, deposito, fecharT, fecharP;
	private JMenuItem relatorioAutenticacao, relatorioClientes;
	private JDesktopPane janela;
	private JPanel painelPrincipal, painelBotoes, painelBase;
	private JButton btnCadastrarSimples, btnCadastrarEspecial, btnCancelar, btnSacar, btnDepositar;
	private JComboBox<ContaSimples> cConta = new JComboBox<ContaSimples>();
	private List<ContaSimples> listaContaS = new ArrayList<ContaSimples>();

	public Menu() {
		super("Segunda Prova");
		setLayout(new BorderLayout());
		janela = new JDesktopPane();
		janela.setLayout(new BorderLayout());

		barraPrincipal = new JMenuBar();

		Cadastro = new JMenu("Cadastro");
		Relatorio = new JMenu("Relatorio");
		Movimento = new JMenu("Movimento");
		Sair = new JMenu("Sair");

		cadastrarSimples = new JMenuItem("Cadastrar Conta Simples");
		cadastrarEspecial = new JMenuItem("Cadastrar Conta Especial");
		saque = new JMenuItem("Saque");
		deposito = new JMenuItem("Deposito");
		relatorioAutenticacao = new JMenuItem("Relatorio Autenticacao");
		relatorioClientes = new JMenuItem("Relatorio Contas");
		fecharT = new JMenuItem("Voltar");
		fecharP = new JMenuItem("Encerrar");

		Cadastro.add(cadastrarSimples);
		Cadastro.add(cadastrarEspecial);

		Movimento.add(saque);
		Movimento.add(deposito);

		Relatorio.add(relatorioAutenticacao);
		Relatorio.add(relatorioClientes);

		Sair.add(fecharT);
		Sair.add(fecharP);

		barraPrincipal.add(Cadastro);
		barraPrincipal.add(Movimento);
		barraPrincipal.add(Relatorio);
		barraPrincipal.add(Sair);

		btnCadastrarSimples = new JButton("Cadastrar");
		btnCadastrarEspecial = new JButton("Cadastrar");
		btnCancelar = new JButton("Cancelar");
		btnSacar = new JButton("Sacar");
		btnDepositar = new JButton("Depositar");

		setJMenuBar(barraPrincipal);

		fecharT.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Autenticacao a = new Autenticacao();
				a.login();
				fechar();
			}

		});

		fecharP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				fechar();
			}

		});

		cadastrarSimples.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				painelPrincipal = new JPanel(new BorderLayout());
				painelBase = ContaSimples.criarPainel();
				painelBotoes = new JPanel(new FlowLayout());

				painelBotoes.add(btnCadastrarSimples);
				painelPrincipal.add(painelBase, BorderLayout.CENTER);
				painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

				btnCadastrarSimples.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						int numero = ContaSimples.getTxtNumero();
						double saldo = ContaSimples.getTxtSaldo();
						Cliente cliente = ContaSimples.getClienteSelecionado();

						if(!(numero == -1 || saldo == -1 || cliente == null)) {
							ContaSimples conta = new ContaSimples(cliente, numero, saldo);
							listaContaS.add(conta);
							ContaSimples.limpar();
							JOptionPane.showMessageDialog(null, "Conta criada com sucesso!", "SUCESSO", JOptionPane.PLAIN_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "Erro ao criar Conta!", "ERRO", JOptionPane.ERROR_MESSAGE);
						}
					}

				});

				getContentPane().add(painelPrincipal);
				revalidate();
				repaint();
			}

		});

		cadastrarEspecial.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				painelPrincipal = new JPanel(new BorderLayout());
				painelBase = ContaEspecial.criarPainel();
				painelBotoes = new JPanel(new FlowLayout());

				painelBotoes.add(btnCadastrarEspecial);
				painelPrincipal.add(painelBase, BorderLayout.CENTER);
				painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

				btnCadastrarEspecial.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						int numero = ContaEspecial.getTxtNumero();
						double saldo = ContaEspecial.getTxtSaldo();
						Cliente cliente = ContaEspecial.getClienteSelecionado();
						double limite = ContaEspecial.getTxtLimite();

						if(!(numero == -1 || saldo == -1 || cliente == null || limite == -1)) {
							ContaEspecial conta = new ContaEspecial(cliente, numero, saldo, limite);
							listaContaS.add(conta);
							ContaEspecial.limpar();
							JOptionPane.showMessageDialog(null, "Conta criada com sucesso!", "SUCESSO", JOptionPane.PLAIN_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "Erro ao criar Conta!", "ERRO", JOptionPane.ERROR_MESSAGE);
						}
					}

				});

				getContentPane().add(painelPrincipal);
				revalidate();
				repaint();
			}

		});

		saque.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JTextField txtValor = new JTextField();

				JPanel painelSaque = new JPanel(new GridLayout(2,2));
				painelSaque.add(new JLabel("Selecione a conta: ", SwingConstants.CENTER));
				painelSaque.add(cConta);
				painelSaque.add(new JLabel("Quantia: ", SwingConstants.CENTER));
				painelSaque.add(txtValor);

				for(ContaSimples c : listaContaS) {
					cConta.addItem(c);
				}

				int resultado = JOptionPane.showConfirmDialog(null, painelSaque, "Saque", JOptionPane.OK_CANCEL_OPTION);

				if(resultado == JOptionPane.OK_OPTION) {
					try {
						double valor = Double.valueOf(txtValor.getText().toString());

						if(valor >= 0) {
							int index = cConta.getSelectedIndex();
							double valorAtual = listaContaS.get(index).getSaldo(); 

							if(listaContaS.get(index) instanceof ContaSimples) {
								if(valorAtual >= valor) {
									listaContaS.get(index).setSaldo(valorAtual - valor);
									JOptionPane.showMessageDialog(null, "Saque Efetuado!");
								}
								else {
									JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
								}
							}
							else {
								
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Valor inválido!");
						}
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Valor inválido!");
					}
				}
			}

		});

		deposito.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JTextField txtValor = new JTextField();
				JPanel painelDeposito = new JPanel(new GridLayout(2,2));
				painelDeposito.add(new JLabel("Selecione a conta: ", SwingConstants.CENTER));
				painelDeposito.add(cConta);
				painelDeposito.add(new JLabel("Quantia: ", SwingConstants.CENTER));
				painelDeposito.add(txtValor);

				for(ContaSimples c : listaContaS) {
					cConta.addItem(c);
				}

				int resultado = JOptionPane.showConfirmDialog(null, painelDeposito, "Deposito", JOptionPane.OK_CANCEL_OPTION);

				if(resultado == JOptionPane.OK_OPTION) {
					try {
						double valor = Double.valueOf(txtValor.getText().toString());

						if(valor >= 0) {
							int index = cConta.getSelectedIndex();
							double valorAtual = listaContaS.get(index).getSaldo(); 
							listaContaS.get(index).setSaldo(valorAtual + valor);
							JOptionPane.showMessageDialog(null, "Deposito Efetuado!");
						}
						else {
							JOptionPane.showMessageDialog(null, "Valor inválido!");
						}
					}
					catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Valor inválido!");
					}
				}
			}

		});

		relatorioAutenticacao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String saida = Autenticacao.relatorioAutenticacao();
				JOptionPane.showMessageDialog(null, saida);
			}

		});

		relatorioClientes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String saida = "\t\tRelatorio de Contas \n\n";

				if(listaContaS.size() < 0) {
					saida += "Sem contas cadastradas!";
					JOptionPane.showMessageDialog(null, saida);
				}
				else {
					for(ContaSimples c : listaContaS) {
						saida += c.toString() + "\n\n";
					}

					JOptionPane.showMessageDialog(null, saida);
				}

			}

		});
	}

	private void fechar() {
		this.dispose();
	}

}
