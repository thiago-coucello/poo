import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class MaterialDeConstrucao implements Contas {

    // Atributos

    private String nomeLoja;
    private String descricao;
    private double valorGasto;
    private tipoData dataVencto;

    // Atributos de Classe

    private static JPanel painel, painelData;
    private static JLabel lNomeLoja, lDescricao, lDataVencto, lValor, lDia, lMes, lAno;
    private static JTextField txtNome, txtDescricao, txtValor, txtAno, txtDia, txtMes;

    // Construtores

    public MaterialDeConstrucao() {
        this.setNomeLoja("");
        this.setDescricao("");
        this.setValorGasto(0);
        this.dataVencto = new tipoData();
    }

    public MaterialDeConstrucao(String nomeLoja, String descricao, double valorGasto, tipoData dataVencto) {
        this.setNomeLoja(nomeLoja);
        this.setDescricao(descricao);
        this.setValorGasto(valorGasto);
        this.dataVencto = dataVencto;
    }

    // Métodos da interface

    @Override
    public double getValor() {
        return this.getValorGasto();
    }

    // Getters e Setters

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValorGasto(double valorGasto) {
        this.valorGasto = valorGasto;
    }

    public String getNomeLoja() {
        return this.nomeLoja;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public double getValorGasto() {
        return this.valorGasto;
    }

    // toString

    public String toString() {
        return String.format("Nome da loja: %s, Descricao: %s, Valor gasto: R$ %.2f, Data de vencimento: %s",
                this.getNomeLoja(), this.getDescricao(), this.getValor(), this.dataVencto.getDataCompleta());
    }

    // Métodos de classe

    public static JPanel criarPainel() {
        painel = new JPanel(new GridLayout(4, 2));
        painel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Dados"));

        painelData = new JPanel(new FlowLayout());
        painelData.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.lightGray), "Data"));

        lNomeLoja = new JLabel("Nome da Loja: ", SwingConstants.LEFT);
        lDescricao = new JLabel("Descricao: ", SwingConstants.LEFT);
        lValor = new JLabel("Valor gasto: ", SwingConstants.LEFT);
        lDataVencto = new JLabel("Data de vencimento: ", SwingConstants.LEFT);
        lDia = new JLabel("Dia: ", SwingConstants.LEFT);
        lMes = new JLabel("Mes: ", SwingConstants.LEFT);
        lAno = new JLabel("Ano: ", SwingConstants.LEFT);

        txtNome = new JTextField(100);
        txtDescricao = new JTextField(150);
        txtValor = new JTextField(100);
        txtAno = new JTextField(4);

        txtDia = new JTextField(2);
        txtMes = new JTextField(2);

        painelData.add(lDia);
        painelData.add(txtDia);
        painelData.add(lMes);
        painelData.add(txtMes);
        painelData.add(lAno);
        painelData.add(txtAno);

        painel.add(lNomeLoja);
        painel.add(txtNome);
        painel.add(lDescricao);
        painel.add(txtDescricao);
        painel.add(lValor);
        painel.add(txtValor);
        painel.add(lDataVencto);
        painel.add(painelData);

        return painel;
    }

    public static void limparCampos(){
        txtNome.setText("");
        txtDescricao.setText("");
        txtValor.setText("");
        txtDia.setText("");
        txtMes.setText("");
        txtAno.setText("");
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

    public static String getTxtDescricao() {
        if (txtDescricao.getText().toString().isBlank()) {
            txtDescricao.setBackground(Color.red);

            Timer timer = new Timer(1000, event -> {
                txtDescricao.setBackground(Color.white);
            });
            timer.setRepeats(false);
            timer.start();

            JOptionPane.showMessageDialog(null, "Insira a Descrição");

            return "";
        } else {
            return txtDescricao.getText().toString();
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

        return -1;
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
                int dia = Integer.valueOf(txtDia.getText().toString());
                return dia;
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

            JOptionPane.showMessageDialog(null, "Insira o Mes");

            return -1;
        } else {
            try {
                int mes = Integer.valueOf(txtMes.getText().toString());
                return mes;
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

    public static int getAno() {
        if (txtAno.getText().toString().isBlank()) {
            txtAno.setBackground(Color.red);

            Timer timer = new Timer(1000, event -> {
                txtAno.setBackground(Color.white);
            });
            timer.setRepeats(false);
            timer.start();

            JOptionPane.showMessageDialog(null, "Insira o Ano");

            return -1;
        } else {
            try {
                int ano = Integer.valueOf(txtAno.getText().toString());
                return ano;
            } catch (NumberFormatException e) {
                txtAno.setBackground(Color.red);

                Timer timer = new Timer(1000, event -> {
                    txtAno.setBackground(Color.white);
                });
                timer.setRepeats(false);
                timer.start();

                JOptionPane.showMessageDialog(null, "Insira o Ano");

                return -1;
            }
        }
    }

}
