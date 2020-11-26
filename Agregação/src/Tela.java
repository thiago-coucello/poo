import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

public class Tela extends JFrame {
    private JLabel lNome, lSaldo, lLimite, lNumero, lData, lCliente;
    private JTextField tNome, tSaldo, tLimite, tNumero, tData;
    private JComboBox cCliente;
    private JButton bInsCli, bExiCli, bInsCar, bExiCar, bSaque, bDeposito;
    private int posicao;
    private Cliente c;
    private JTabbedPane tabPainel;
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private List<Cartao> cartoes = new ArrayList<Cartao>();
    private JPanel pCliente, pCartao, pSul;

    // Construtor
    public Tela() {
        super("Agregação");
        setLayout(new BorderLayout());

        // Painel Clientes
        lNome = new JLabel("Nome.....: ", SwingConstants.LEFT);
        lSaldo = new JLabel("Saldo.....: ", SwingConstants.LEFT);
        lLimite = new JLabel("Limite.....: ", SwingConstants.LEFT);

        tNome = new JTextField(20);
        tSaldo = new JTextField(20);
        tLimite = new JTextField(20);

        pCliente = new JPanel(new GridLayout(3, 2, 5, 5));

        pCliente.add(lNome);
        pCliente.add(tNome);
        pCliente.add(lSaldo);
        pCliente.add(tSaldo);
        pCliente.add(lLimite);
        pCliente.add(tLimite);

        // Painel Cartões
        lNumero = new JLabel("Numero.....: ", SwingConstants.LEFT);
        lData = new JLabel("Data.....: ", SwingConstants.LEFT);
        lCliente = new JLabel("Cliente.....: ", SwingConstants.LEFT);

        tNumero = new JTextField(20);
        tData = new JTextField(20);

        cCliente = new JComboBox<>();
        cCliente.setMaximumRowCount(15);

        pCartao = new JPanel(new GridLayout(3, 2, 5, 5));

        pCartao.add(lNumero);
        pCartao.add(tNumero);
        pCartao.add(lData);
        pCartao.add(tData);
        pCartao.add(lCliente);
        pCartao.add(cCliente);

        tabPainel = new JTabbedPane();
        tabPainel.addTab("Cliente", null, pCliente, "Cliente");
        tabPainel.addTab("Cartão", null, pCartao, "Cartão");

        add(tabPainel, BorderLayout.CENTER);

        bInsCli = new JButton("Inserir Cliente");
        bExiCli = new JButton("Exibir Clientes");
        bInsCar = new JButton("Inserir Cartão");
        bExiCar = new JButton("Exibe Cartões");
        bSaque = new JButton("Saque");
        bDeposito = new JButton("Deposito");

        pSul = new JPanel(new GridLayout(2, 3, 2, 2));

        pSul.add(bInsCli);
        pSul.add(bExiCli);
        pSul.add(bSaque);
        pSul.add(bInsCar);
        pSul.add(bExiCar);
        pSul.add(bDeposito);

        add(pSul, BorderLayout.SOUTH);

        cCliente.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {

            }

        });

        bInsCli.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bInsCli.setBackground(Color.BLUE);
            }

        });

        bExiCli.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bExiCli.setBackground(Color.CYAN);
            }

        });

        bInsCar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bInsCar.setBackground(Color.GRAY);
            }

        });

        bExiCar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bExiCar.setBackground(Color.DARK_GRAY);
            }

        });

        bSaque.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bSaque.setBackground(Color.GREEN);
                
            }
            
        });

        bDeposito.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bDeposito.setBackground(Color.MAGENTA);
            }
            
        });
    }
    public static void main(String[] args) throws Exception {
        Tela tela = new Tela();
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.pack();
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);
    }
}
