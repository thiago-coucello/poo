import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class MestreDeObra extends MaoDeObra implements Contas {

    // Atributos

    private double valorFixoPelaObra;

    // Atributos de Classe

    private static JPanel painel, painelData;
    private static JLabel lNome, lCPF, lValor, lDia, lMes, lData;
    private static JTextField txtNome, txtCPF, txtValor, txtDia, txtMes;

    // Construtores

    public MestreDeObra() {
        super();
        this.setValorFixoPelaObra(0.00);
    }

    public MestreDeObra(String cpf, String nome, tipoData dataPagto, double valorFixoPelaObra) {
        super(cpf, nome, dataPagto);
        this.setValorFixoPelaObra(valorFixoPelaObra);
    }

    // Método da Interface

    @Override
    public double getValor() {
        return this.getValorFixoPelaObra();
    }

    // Getters e Setters

    public void setValorFixoPelaObra(double valorFixoPelaObra) {
        this.valorFixoPelaObra = valorFixoPelaObra;
    }

    public double getValorFixoPelaObra() {
        return this.valorFixoPelaObra;
    }

    // toString

    public String toString() {
        return String.format("%s\nValor fixo por obra: R$ %.2f", super.toString(), this.getValorFixoPelaObra());
    }

    // Métodos de classe

    public static JPanel criarPainel() {
        painel = new JPanel(new GridLayout(4, 2));
        painel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Dados"));

        painelData = new JPanel(new FlowLayout());
        painelData.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.lightGray),"Data"));

        lNome = new JLabel("Nome: ", SwingConstants.LEFT);
        lCPF = new JLabel("CPF: ", SwingConstants.LEFT);
        lValor = new JLabel("Valor fixo: ", SwingConstants.LEFT);
        lData = new JLabel("Data de Pagamento: ", SwingConstants.LEFT);
        lDia = new JLabel("Dia: ", SwingConstants.LEFT);
        lMes = new JLabel("Mes: ", SwingConstants.LEFT);

        txtNome = new JTextField(100);
        txtCPF = new JTextField(15);
        txtValor = new JTextField(100);
        txtDia = new JTextField(2);
        txtMes = new JTextField(2);

        painelData.add(lDia);
        painelData.add(txtDia);
        painelData.add(lMes);
        painelData.add(txtMes);

        painel.add(lNome);
        painel.add(txtNome);
        painel.add(lCPF);
        painel.add(txtCPF);
        painel.add(lValor);
        painel.add(txtValor);
        painel.add(lData);
        painel.add(painelData);

        return painel;
    }

    public static void limparCampos() {
        txtNome.setText("");
        txtCPF.setText("");
        txtValor.setText("");
        txtDia.setText("");
        txtMes.setText("");
    }

    public static String getTxtNome() {
        if (txtNome.getText().toString().isBlank()) {
            txtNome.setBackground(Color.red);

            Timer timer = new Timer(1000, event -> {
                txtNome.setBackground(Color.white);
            });
            timer.setRepeats(false);
            timer.start();

            JOptionPane.showMessageDialog(null, "Insira o Nome");

            return "";
        } else {
            return txtNome.getText().toString();
        }
    }

    public static String getTxtCPF() {
        if (txtCPF.getText().toString().isBlank()) {
            txtCPF.setBackground(Color.red);

            Timer timer = new Timer(1000, event -> {
                txtCPF.setBackground(Color.white);
            });
            timer.setRepeats(false);
            timer.start();

            JOptionPane.showMessageDialog(null, "Insira o CPF");

            return "";
        } else {
            return txtCPF.getText().toString();
        }
    }

    public static double getTxtValor() {
        double valor;

        if (txtValor.getText().toString().isBlank()) {
            txtValor.setBackground(Color.red);

            Timer timer = new Timer(1000, event -> {
                txtValor.setBackground(Color.white);
            });
            timer.setRepeats(false);
            timer.start();

            JOptionPane.showMessageDialog(null, "Insira o Valor");

        } else {
            try {
                valor = Double.valueOf(txtValor.getText().toString());
                return valor;
            } catch (NumberFormatException e) {
                txtValor.setBackground(Color.red);

                Timer timer = new Timer(1000, event -> {
                    txtValor.setBackground(Color.white);
                });
                timer.setRepeats(false);
                timer.start();

                JOptionPane.showMessageDialog(null, "Valor Invalido");
            }
        }

        return 0.00;
    }

    public static int getDia() {
        if (txtDia.getText().toString().isBlank()) {
            txtDia.setBackground(Color.red);

            Timer timer = new Timer(1000, event -> {
                txtDia.setBackground(Color.white);
            });
            timer.setRepeats(false);
            timer.start();

            JOptionPane.showMessageDialog(null, "Insira o Dia");

            return -1;
        } else {
            try {
                int ano = Integer.valueOf(txtDia.getText().toString());
                return ano;
            } catch (NumberFormatException e) {
                txtDia.setBackground(Color.red);

                Timer timer = new Timer(1000, event -> {
                    txtDia.setBackground(Color.white);
                });
                timer.setRepeats(false);
                timer.start();

                JOptionPane.showMessageDialog(null, "Insira o Dia");

                return -1;
            }
        }
    }

    public static int getMes() {
        if (txtMes.getText().toString().isBlank()) {
            txtMes.setBackground(Color.red);

            Timer timer = new Timer(1000, event -> {
                txtMes.setBackground(Color.white);
            });
            timer.setRepeats(false);
            timer.start();

            JOptionPane.showMessageDialog(null, "Insira o Dia");

            return -1;
        } else {
            try {
                int ano = Integer.valueOf(txtMes.getText().toString());
                return ano;
            } catch (NumberFormatException e) {
                txtMes.setBackground(Color.red);

                Timer timer = new Timer(1000, event -> {
                    txtMes.setBackground(Color.white);
                });
                timer.setRepeats(false);
                timer.start();

                JOptionPane.showMessageDialog(null, "Insira o Mes");

                return -1;
            }
        }
    }

}
