import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

public class Cartao extends Pagamento{
    // Atributos

    private String numeroCartao;
    private String operadora;

    // VariÃ¡veis de classe

    private static JPanel painelDados, painelBase, painelPrincipal;
    private static JLabel lNumeroCartao, lOperadora;
    private static JTextField txtNumeroCartao, txtOperadora;

    // Construtores

    public Cartao(){
        super();
        this.setNumeroCartao("");
        this.setOperadora("");
    }

    public Cartao(String dataPagto, Cliente cliente, double valorPagto, String numeroCartao, String operadora){
        super(dataPagto, cliente, valorPagto);
        this.setNumeroCartao(numeroCartao);
        this.setOperadora(operadora);
    }

    // Getters e Setters

    public void setNumeroCartao(String numeroCartao){
        this.numeroCartao = numeroCartao;
    }

    public void setOperadora(String operadora){
        this.operadora = operadora;
    }

    public String getNumeroCartao(){
        return this.numeroCartao;
    }

    public String getOperadora(){
        return this.operadora;
    }

    // toString

    public String toString(){
        return String.format("%s\nNúmero do Cartão: %s, Operadora: %s",
        super.toString(), this.getNumeroCartao(), this.getOperadora());
    }

    // MÃ©todos de Classe

    public static JPanel criarPainel(){
        painelDados = Pagamento.criaPainelDadosPagamento();
        painelBase = new JPanel(new GridLayout(2,2));
        painelPrincipal = new JPanel(new BorderLayout());

        painelBase.setBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.black),
                "Dados Cartão"
            )
        );

        lNumeroCartao = new JLabel("Numero do Cartão: ", SwingConstants.CENTER);
        lOperadora = new JLabel("Operadora: ", SwingConstants.CENTER);

        txtNumeroCartao = new JTextField(50);
        txtOperadora = new JTextField(50);

        painelBase.add(lNumeroCartao);
        painelBase.add(txtNumeroCartao);
        painelBase.add(lOperadora);
        painelBase.add(txtOperadora);

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

    public static String getTxtNumeroCartao(){
        if(txtNumeroCartao.getText().toString().isBlank()){
            txtNumeroCartao.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Insira o número do cartão");

            Timer timer = new Timer(1000, event->{
                txtNumeroCartao.setBackground(Color.white);
            });
            timer.setRepeats(false);
            timer.start();
        }
        else{
            return txtNumeroCartao.getText().toString();
        }

        return "";
    }

    public static String getTxtOperadora(){
        if(txtOperadora.getText().toString().isBlank()){
            JOptionPane.showMessageDialog(null, "Insira a operadora");
            txtOperadora.setBackground(Color.red);

            Timer timer = new Timer(1000, event ->{
                txtOperadora.setBackground(Color.white);
            });
            timer.setRepeats(false);
            timer.start();
        }
        else{
            return txtOperadora.getText().toString();
        }

        return "";
    }

    public static void limparTela(){
        Pagamento.limparTela();
        txtNumeroCartao.setText("");
        txtOperadora.setText("");
    }
}
