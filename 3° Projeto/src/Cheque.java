import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

public class Cheque extends Pagamento {
    // Atributos

    private int numeroCheque;
    private int banco;

    // VariÃ¡veis de classe

    private static JPanel painelDados, painelBase, painelPrincipal;
    private static JLabel lNumeroCheque, lBanco;
    private static JTextField txtNumeroCheque, txtBanco;

    // Construtores

    public Cheque() {
        super();
        this.setNumeroCheque(0);
        this.setBanco(0);
    }

    public Cheque(String dataPagto, Cliente cliente, double valorPagto, int numeroCheque, int banco) {
        super(dataPagto, cliente, valorPagto);
        this.setNumeroCheque(numeroCheque);
        this.setBanco(banco);
    }

    // Getters e Setters
    public void setNumeroCheque(int numeroCheque) {
        this.numeroCheque = numeroCheque;
    }

    public void setBanco(int banco) {
        this.banco = banco;
    }

    public int getNumeroCheque() {
        return this.numeroCheque;
    }

    public int getBanco() {
        return this.banco;
    }

    // toString

    public String toString() {
        return String.format("%s\nNúmero Cheque: %d, Banco: %d", super.toString(), this.getNumeroCheque(),
                this.getBanco(), "Cheque");
    }

    // MÃ©todos de classe

    public static JPanel criarPainel() {
        painelDados = Pagamento.criaPainelDadosPagamento();
        painelBase = new JPanel(new GridLayout(2, 2));
        painelPrincipal = new JPanel(new BorderLayout());

        painelBase.setBorder(
            BorderFactory.createTitledBorder(
               BorderFactory.createLineBorder(Color.black), "Dados do Cheque"
            )
        );

        lNumeroCheque = new JLabel("Número Cheque: ", SwingConstants.CENTER);
        lBanco = new JLabel("Banco: ", SwingConstants.CENTER);

        txtNumeroCheque = new JTextField(50);
        txtBanco = new JTextField(50);

        painelBase.add(lNumeroCheque);
        painelBase.add(txtNumeroCheque);
        painelBase.add(lBanco);
        painelBase.add(txtBanco);

        painelPrincipal.add(painelDados, BorderLayout.NORTH);
        painelPrincipal.add(painelBase, BorderLayout.CENTER);

        return painelPrincipal;
    }

    public static String getTxtDataPagto() {
        return Pagamento.getTxtDataPagto();
    }

    public static double getTxtValorPagto() {
        return Pagamento.getTxtValorPagto();
    }

    public static void addCliente(Cliente c) {
        Pagamento.addCliente(c);
    }

    public static Cliente getClienteSelecionado() {
        return Pagamento.getClienteSelecionado();
    }

    public static int getTxtNumeroCheque() {
        if (txtNumeroCheque.getText().toString().isBlank()) {
            JOptionPane.showMessageDialog(null, "Insira o número do cheque");
            txtNumeroCheque.setBackground(Color.red);

            Timer timer = new Timer(1000, event -> {
                txtNumeroCheque.setBackground(Color.white);
            });
            timer.setRepeats(false);
            timer.start();
        } else {
            try {
                int numeroCheque = Integer.valueOf(txtNumeroCheque.getText().toString());
                return numeroCheque;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Insira um número vÃ¡lido");
                txtNumeroCheque.setBackground(Color.red);

                Timer timer = new Timer(1000, event -> {
                    txtNumeroCheque.setBackground(Color.white);
                });
                timer.setRepeats(false);
                timer.start();
            }
        }

        return -1;
    }

    public static int getTxtBanco() {
        if (txtBanco.getText().toString().isBlank()) {
            JOptionPane.showMessageDialog(null, "Insira o número do Banco");
            txtBanco.setBackground(Color.red);

            Timer timer = new Timer(1000, event -> {
                txtBanco.setBackground(Color.white);
            });
            timer.setRepeats(false);
            timer.start();
        } else {
            try {
                int banco = Integer.valueOf(txtBanco.getText().toString());
                return banco;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Insira um número válido");
                txtBanco.setBackground(Color.red);

                Timer timer = new Timer(1000, event -> {
                    txtBanco.setBackground(Color.white);
                });
                timer.setRepeats(false);
                timer.start();
            }
        }

        return -1;
    }

    public static void limparTela(){
        Pagamento.limparTela();
        txtBanco.setText("");
        txtNumeroCheque.setText("");
    }
}
