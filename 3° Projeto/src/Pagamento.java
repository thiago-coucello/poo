import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public abstract class Pagamento {

    // Atributos

    private String dataPagto;
    Cliente cliente;
    double valorPagto;

    // Variáveis de classe

    private static JPanel painel;
    private static JLabel lDataPagto, lValorPagto, lCliente;
    private static JTextField txtDataPagto, txtValorPagto;
    private static JComboBox cCliente;

    // Construtores

    public Pagamento() {
        this.setDataPagto("");
        this.setValorPagto(0.00);
        this.setCliente(null);
    }

    public Pagamento(String dataPagto, Cliente cliente, double valorPagto) {
        this.setDataPagto(dataPagto);
        this.setValorPagto(valorPagto);
        this.setCliente(cliente);
    }

    // Getter e Setters

    public void setDataPagto(String dataPagto) {
        this.dataPagto = dataPagto;
    }

    public void setValorPagto(double valorPagto) {
        this.valorPagto = valorPagto;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDataPagto() {
        return this.dataPagto;
    }

    public double getValorPagto() {
        return this.valorPagto;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public String toString() {
        return String.format("%s\nData pagamento: %s, Valor pagamento: R$ %.2f", this.getCliente().saida(),
                this.getDataPagto(), this.getValorPagto());
    }

    // Métodos de classe

    public static JPanel criaPainelDadosPagamento() {
        painel = new JPanel(new GridLayout(3, 2));
        painel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Dados Pagamento"));

        lDataPagto = new JLabel("Data do pagamento: ", SwingConstants.CENTER);
        lValorPagto = new JLabel("Valor do pagamento: ", SwingConstants.CENTER);
        lCliente = new JLabel("Escolha o cliente: ", SwingConstants.CENTER);

        txtDataPagto = new JTextField(15);
        txtValorPagto = new JTextField(100);
        cCliente = new JComboBox<>();

        painel.add(lDataPagto);
        painel.add(txtDataPagto);
        painel.add(lValorPagto);
        painel.add(txtValorPagto);
        painel.add(lCliente);
        painel.add(cCliente);

        return painel;
    }

    public static String getTxtDataPagto() {
        if (txtDataPagto.getText().toString().isBlank()) {
            JOptionPane.showMessageDialog(null, "Insira uma data de pagamento");
            txtDataPagto.setBackground(Color.red);

            Timer timer = new Timer(1000, event -> {
                txtDataPagto.setBackground(Color.white);
            });
            timer.setRepeats(false);
            timer.start();
        } else {
            return txtDataPagto.getText().toString();
        }

        return "";
    }

    public static double getTxtValorPagto() {
        if (txtValorPagto.getText().toString().isBlank()) {
            JOptionPane.showMessageDialog(null, "Insira um valor");
            txtValorPagto.setBackground(Color.red);

            Timer timer = new Timer(1000, event -> {
                txtValorPagto.setBackground(Color.white);
            });
            timer.setRepeats(false);
            timer.start();
        } else {
            try {
                double valor = Double.valueOf(txtValorPagto.getText().toString());
                return valor;

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido");
                txtValorPagto.setBackground(Color.red);

                Timer timer = new Timer(1000, event -> {
                    txtValorPagto.setBackground(Color.white);
                });
                timer.setRepeats(false);
                timer.start();
            }
        }

        return -1;
    }

    public static void addCliente(Cliente c) {
        cCliente.addItem(c);
    }

    public static Cliente getClienteSelecionado() {
        Cliente c = (Cliente) cCliente.getSelectedItem();
        if(c == null){
            JOptionPane.showMessageDialog(null, "Nenhum cliente selecionado");
        }
        return c;
    }

	public static void limparTela() {
        txtDataPagto.setText("");
        txtValorPagto.setText("");
	}

}
