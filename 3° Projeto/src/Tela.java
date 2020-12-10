import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class Tela extends JFrame {

    private JPanel painelCliente, painelPagamento, painelDados, painelBotoesCliente, painelBotoesPagamento,
            painelRadioButtons;
    private JRadioButton rdDinheiro, rdCartao, rdCheque;
    private ButtonGroup grupo;
    private JButton btnInsereCliente, btnRelatorioClientes, btnInserePagamento, btnRelatorioPagamentos;
    private JTabbedPane menu;
    private JLabel lRadioButtons;
    private List<Cliente> listaClientes = new ArrayList<Cliente>();
    private List<Pagamento> listaPagamentos = new ArrayList<Pagamento>();
    private List<String> nomes = new ArrayList<String>();

    public Tela() {
        super("3� Projeto");
        setLayout(new BorderLayout());

        grupo = new ButtonGroup();

        rdDinheiro = new JRadioButton("Dinheiro", true);
        rdCartao = new JRadioButton("Cartao", false);
        rdCheque = new JRadioButton("Cheque", false);

        grupo.add(rdDinheiro);
        grupo.add(rdCartao);
        grupo.add(rdCheque);

        btnInsereCliente = new JButton("Insere Cliente");
        btnRelatorioClientes = new JButton("Relatorio Clientes");
        btnInserePagamento = new JButton("Insere Pagamento");
        btnRelatorioPagamentos = new JButton("Relatorio Pagamentos");

        lRadioButtons = new JLabel("Forma de Pagamento", SwingConstants.CENTER);

        painelBotoesCliente = new JPanel(new FlowLayout());
        painelBotoesPagamento = new JPanel(new FlowLayout());
        painelRadioButtons = new JPanel(new GridLayout(4, 1));

        painelBotoesCliente.add(btnInsereCliente);
        painelBotoesCliente.add(btnRelatorioClientes);

        painelBotoesPagamento.add(btnInserePagamento);
        painelBotoesPagamento.add(btnRelatorioPagamentos);

        painelRadioButtons.add(lRadioButtons);
        painelRadioButtons.add(rdDinheiro);
        painelRadioButtons.add(rdCartao);
        painelRadioButtons.add(rdCheque);

        painelCliente = montarPainelCliente(Cliente.criaPainel(), painelBotoesCliente);
        painelPagamento = montarPainelPagamento(Dinheiro.criarPainel(), painelBotoesPagamento, painelRadioButtons);

        menu = new JTabbedPane();
        menu.addTab("Cliente", painelCliente);
        menu.addTab("Pagamento", painelPagamento);

        add(menu);

        btnInsereCliente.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = Cliente.getTxtNome();
                String endereco = Cliente.getTxtEndereco();
                String cidade = Cliente.getTxtCidade();

                if (!nome.isEmpty() || !endereco.isEmpty() || !cidade.isEmpty()) {
                    Cliente c = new Cliente(nome, endereco, cidade);
                    listaClientes.add(c);
                    Pagamento.addCliente(c);
                    Cliente.limparTela();
                    JOptionPane.showMessageDialog(null, "Cliente inserido");
                }
            }

        });

        btnRelatorioClientes.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String saida = "\tRelatório de Clientes\n\n";

                for (Cliente c : listaClientes) {
                    saida += c.saida() + "\n\n";
                }

                JOptionPane.showMessageDialog(null, saida);
            }

        });

        btnInserePagamento.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String dataPagamento    = Pagamento.getTxtDataPagto();
                double valorPagamento   = Pagamento.getTxtValorPagto();
                Cliente c               = Pagamento.getClienteSelecionado();

                if(rdCartao.isSelected()){
                    String numero = Cartao.getTxtNumeroCartao();
                    String operadora = Cartao.getTxtOperadora();

                    if(!(dataPagamento.isEmpty() || valorPagamento == -1 || numero.isEmpty() || operadora.isEmpty() || c == null)){
                        Cartao cartao = new Cartao(dataPagamento, c, valorPagamento, numero, operadora);
                        listaPagamentos.add(cartao);
                        Cartao.limparTela();
                        JOptionPane.showMessageDialog(null, "Pagamento inserido");
                    }
                }

                else if(rdCheque.isSelected()){
                    int numero  = Cheque.getTxtNumeroCheque();
                    int banco   = Cheque.getTxtBanco();

                    if(!(dataPagamento.isEmpty() || valorPagamento == -1 || numero == -1 || banco == -1 || c == null)){
                        Cheque cheque = new Cheque(dataPagamento, c, valorPagamento, numero, banco);
                        listaPagamentos.add(cheque);
                        Cheque.limparTela();
                        JOptionPane.showMessageDialog(null, "Pagamento inserido");
                    }
                }

                else if(!(dataPagamento.isEmpty() || valorPagamento == -1 || c == null)){    
                    Dinheiro dinheiro = new Dinheiro(dataPagamento,c,valorPagamento);
                    listaPagamentos.add(dinheiro);
                    Dinheiro.limparTela();
                    JOptionPane.showMessageDialog(null, "Pagamento inserido");
                }
            }

        });

        btnRelatorioPagamentos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String saida = "\tRelatorio de Pagamentos\n\n";

                if (listaPagamentos.size() > 0) {
                    for (Pagamento p : listaPagamentos) {
                        saida += p.toString() + "\n\n";
                    }
                } else {
                    saida += "Não foram efetuados pagamentos";
                }

                JOptionPane.showMessageDialog(null, saida);

            }

        });

        rdDinheiro.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    painelPagamento.remove(painelDados);
                    painelDados = Dinheiro.criarPainel();
                    painelPagamento.add(painelDados, BorderLayout.CENTER);
                    menu.setComponentAt(1, painelPagamento);

                    for(Cliente c : listaClientes){
                        Dinheiro.addCliente(c);
                    }

                    repaint();
                    revalidate();
                }
            }

        });

        rdCartao.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    painelPagamento.remove(painelDados);
                    painelDados = Cartao.criarPainel();
                    painelPagamento.add(painelDados, BorderLayout.CENTER);
                    menu.setComponentAt(1, painelPagamento);

                    for(Cliente c : listaClientes){
                        Cartao.addCliente(c);
                    }

                    revalidate();
                    repaint();
                }
            }

        });

        rdCheque.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    painelPagamento.remove(painelDados);
                    painelDados = Cheque.criarPainel();
                    painelPagamento.add(painelDados, BorderLayout.CENTER);
                    menu.setComponentAt(1, painelPagamento);

                    for(Cliente c : listaClientes){
                        Dinheiro.addCliente(c);
                    }

                    repaint();
                    revalidate();
                }

            }

        }); 
    }

    public JPanel montarPainelPagamento(JPanel painelDados, JPanel painelBotoes, JPanel painelRadioButtons) {
        JPanel painel = new JPanel(new BorderLayout());
        this.painelDados = painelDados;
        painel.add(this.painelDados, BorderLayout.CENTER);
        painel.add(painelRadioButtons, BorderLayout.WEST);
        painel.add(painelBotoes, BorderLayout.SOUTH);

        return painel;
    }

    public JPanel montarPainelCliente(JPanel painelDados, JPanel painelBotao) {
        JPanel painel = new JPanel(new BorderLayout());

        painel.add(painelDados, BorderLayout.CENTER);
        painel.add(painelBotao, BorderLayout.SOUTH);

        return painel;
    }

    public static void main(String[] args) {
        Tela tela = new Tela();
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setVisible(true);
        tela.setSize(500, 300);
        tela.setLocationRelativeTo(null);
    }
}
