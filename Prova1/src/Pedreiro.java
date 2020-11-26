import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Pedreiro extends MaoDeObra implements Contas {

    // Atributos

    private tipoData dataInicio;
    private tipoData dataFinal;
    private double pagtoDiario;

    // Atributos de Classe

    private static JPanel painel, painelData, painelDataI, painelDataF;
    private static JLabel lNome, lCPF, lDiaria, lDataInicio, lDataFim, lData, lDia, lMes, lDiaI, lMesI, lDiaF, lMesF;
    private static JTextField txtNome, txtCPF, txtDiaria, txtDiaPagto, txtMesPagto, txtDiaInicio, txtMesInicio,
            txtDiaFim, txtMesFim;

    // Construtores

    public Pedreiro() {
        super();
        this.dataInicio = new tipoData();
        this.dataFinal = new tipoData();
        this.setPagtoDiario(0.00);
    }

    public Pedreiro(String cpf, String nome, tipoData dataPagto, tipoData dataInicio, tipoData dataFinal,
            double pagtoDiario) {
        super(cpf, nome, dataPagto);
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.setPagtoDiario(pagtoDiario);
    }

    // Métodos de Interface

    @Override
    public double getValor() {
        int dias = dataInicio.getQntdDias(dataFinal);

        return dias * this.getPagtoDiario();
    }

    // Getters e Setters

    public void setPagtoDiario(double pagtoDiario) {
        this.pagtoDiario = pagtoDiario;
    }

    public double getPagtoDiario() {
        return this.pagtoDiario;
    }

    // toString

    public String toString() {
        return String.format("%s\nData Inicio: %s, Data Fim: %s, Pagamento diario: R$ %.2f", super.toString(),
                this.dataInicio.getDataCompleta(), this.dataFinal.getDataCompleta(), this.getPagtoDiario());
    }

    // Métodos de classe

    public static JPanel criarPainel() {
        painel = new JPanel(new GridLayout(6, 2));
        painel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Dados"));

        painelData = new JPanel(new GridLayout(1, 4));
        painelData.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.lightGray), "Data"));

        painelDataI = new JPanel(new GridLayout(1, 4));
        painelDataI
                .setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.lightGray), "Data"));

        painelDataF = new JPanel(new GridLayout(1, 4));
        painelDataF
                .setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.lightGray), "Data"));

        lNome = new JLabel("Nome: ", SwingConstants.LEFT);
        lCPF = new JLabel("CPF: ", SwingConstants.LEFT);
        lDiaria = new JLabel("Pagamento diario: ", SwingConstants.LEFT);
        lDataInicio = new JLabel("Data de inicio: ", SwingConstants.LEFT);
        lDataFim = new JLabel("Data do final: ", SwingConstants.LEFT);
        lData = new JLabel("Data de Pagamento: ", SwingConstants.LEFT);
        lDia = new JLabel("Dia: ", SwingConstants.CENTER);
        lMes = new JLabel("Mes: ", SwingConstants.CENTER);
        lDiaI = new JLabel("Dia: ", SwingConstants.CENTER);
        lMesI = new JLabel("Mes: ", SwingConstants.CENTER);
        lDiaF = new JLabel("Dia: ", SwingConstants.CENTER);
        lMesF = new JLabel("Mes: ", SwingConstants.CENTER);

        txtNome = new JTextField(100);
        txtCPF = new JTextField(15);
        txtDiaria = new JTextField(100);

        txtDiaPagto = new JTextField(2);
        txtMesPagto = new JTextField(2);
        txtDiaInicio = new JTextField(2);
        txtMesInicio = new JTextField(2);
        txtDiaFim = new JTextField(2);
        txtMesFim = new JTextField(2);

        painelData.add(lDia);
        painelData.add(txtDiaPagto);
        painelData.add(lMes);
        painelData.add(txtMesPagto);

        painelDataI.add(lDiaI);
        painelDataI.add(txtDiaInicio);
        painelDataI.add(lMesI);
        painelDataI.add(txtMesInicio);

        painelDataF.add(lDiaF);
        painelDataF.add(txtDiaFim);
        painelDataF.add(lMesF);
        painelDataF.add(txtMesFim);

        painel.add(lNome);
        painel.add(txtNome);
        painel.add(lCPF);
        painel.add(txtCPF);
        painel.add(lDiaria);
        painel.add(txtDiaria);
        painel.add(lDataInicio);
        painel.add(painelDataI);
        painel.add(lDataFim);
        painel.add(painelDataF);
        painel.add(lData);
        painel.add(painelData);

        return painel;
    }

    public static void limparCampos() {
        txtNome.setText("");
        txtCPF.setText("");
        txtDiaPagto.setText("");
        txtMesPagto.setText("");
        txtDiaInicio.setText("");
        txtMesInicio.setText("");
        txtDiaFim.setText("");
        txtMesFim.setText("");
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

    public static double getTxtDiaria() {
        double diaria;
        if (txtDiaria.getText().toString().isEmpty()) {
            txtDiaria.setBackground(Color.red);

            Timer timer = new Timer(1000, event -> {
                txtDiaria.setBackground(Color.white);
            });
            timer.setRepeats(false);
            timer.start();

            JOptionPane.showMessageDialog(null, "Insira o valor da diária");
            return -1;
        } else {
            try {
                diaria = Double.valueOf(txtDiaria.getText().toString());
                return diaria;
            } catch (NumberFormatException e) {
                txtDiaria.setBackground(Color.red);

                Timer timer = new Timer(1000, event -> {
                    txtDiaria.setBackground(Color.white);
                });
                timer.setRepeats(false);
                timer.start();

                JOptionPane.showMessageDialog(null, "Insira um valor válido para a diária");
                return -1;
            }
        }
    }

    public static int getDiaPagto() {
        if (txtDiaPagto.getText().toString().isBlank()) {
            txtDiaPagto.setBackground(Color.red);

            Timer timer = new Timer(1000, event -> {
                txtDiaPagto.setBackground(Color.white);
            });
            timer.setRepeats(false);
            timer.start();

            JOptionPane.showMessageDialog(null, "Insira o Dia");

            return -1;
        } else {
            try {
                int dia = Integer.valueOf(txtDiaPagto.getText().toString());
                return dia;
            } catch (NumberFormatException e) {
                txtDiaPagto.setBackground(Color.red);

                Timer timer = new Timer(1000, event -> {
                    txtDiaPagto.setBackground(Color.white);
                });
                timer.setRepeats(false);
                timer.start();

                JOptionPane.showMessageDialog(null, "Insira o Dia");

                return -1;
            }
        }
    }

    public static int getMesPagto() {
        if (txtMesPagto.getText().toString().isBlank()) {
            txtMesPagto.setBackground(Color.red);

            Timer timer = new Timer(1000, event -> {
                txtMesPagto.setBackground(Color.white);
            });
            timer.setRepeats(false);
            timer.start();

            JOptionPane.showMessageDialog(null, "Insira o Dia");

            return -1;
        } else {
            try {
                int mes = Integer.valueOf(txtMesPagto.getText().toString());
                return mes;
            } catch (NumberFormatException e) {
                txtMesPagto.setBackground(Color.red);

                Timer timer = new Timer(1000, event -> {
                    txtMesPagto.setBackground(Color.white);
                });
                timer.setRepeats(false);
                timer.start();

                JOptionPane.showMessageDialog(null, "Insira o Mes");

                return -1;
            }
        }
    }

    public static int getDiaInicio() {
        if (txtDiaInicio.getText().toString().isBlank()) {
            txtDiaInicio.setBackground(Color.red);

            Timer timer = new Timer(1000, event -> {
                txtDiaInicio.setBackground(Color.white);
            });
            timer.setRepeats(false);
            timer.start();

            JOptionPane.showMessageDialog(null, "Insira o Dia");

            return -1;
        } else {
            try {
                int dia = Integer.valueOf(txtDiaInicio.getText().toString());
                return dia;
            } catch (NumberFormatException e) {
                txtDiaInicio.setBackground(Color.red);

                Timer timer = new Timer(1000, event -> {
                    txtDiaInicio.setBackground(Color.white);
                });
                timer.setRepeats(false);
                timer.start();

                JOptionPane.showMessageDialog(null, "Insira o Dia");

                return -1;
            }
        }
    }

    public static int getMesInicio() {

        if (txtMesInicio.getText().toString().isBlank()) {
            txtMesInicio.setBackground(Color.red);

            Timer timer = new Timer(1000, event -> {
                txtMesInicio.setBackground(Color.white);
            });
            timer.setRepeats(false);
            timer.start();

            JOptionPane.showMessageDialog(null, "Insira o Mes");

            return -1;
        } else {
            try {
                int mes = Integer.valueOf(txtMesInicio.getText().toString());
                return mes;
            } catch (NumberFormatException e) {
                txtMesInicio.setBackground(Color.red);

                Timer timer = new Timer(1000, event -> {
                    txtMesInicio.setBackground(Color.white);
                });
                timer.setRepeats(false);
                timer.start();

                JOptionPane.showMessageDialog(null, "Insira o Mes");

                return -1;
            }
        }
    }

    public static int getDiaFim() {
        if (txtDiaFim.getText().toString().isBlank()) {
            txtDiaFim.setBackground(Color.red);

            Timer timer = new Timer(1000, event -> {
                txtDiaFim.setBackground(Color.white);
            });
            timer.setRepeats(false);
            timer.start();

            JOptionPane.showMessageDialog(null, "Insira o Dia");

            return -1;
        } else {
            try {
                int dia = Integer.valueOf(txtDiaFim.getText().toString());
                return dia;
            } catch (NumberFormatException e) {
                txtDiaFim.setBackground(Color.red);

                Timer timer = new Timer(1000, event -> {
                    txtDiaFim.setBackground(Color.white);
                });
                timer.setRepeats(false);
                timer.start();

                JOptionPane.showMessageDialog(null, "Insira o Dia");

                return -1;
            }
        }
    }

    public static int getMesFim() {
        if (txtMesFim.getText().toString().isBlank()) {
            txtMesFim.setBackground(Color.red);

            Timer timer = new Timer(1000, event -> {
                txtMesFim.setBackground(Color.white);
            });
            timer.setRepeats(false);
            timer.start();

            JOptionPane.showMessageDialog(null, "Insira o Mes");

            return -1;
        } else {
            try {
                int mes = Integer.valueOf(txtMesFim.getText().toString());
                return mes;
            } catch (NumberFormatException e) {
                txtMesFim.setBackground(Color.red);

                Timer timer = new Timer(1000, event -> {
                    txtMesFim.setBackground(Color.white);
                });
                timer.setRepeats(false);
                timer.start();

                JOptionPane.showMessageDialog(null, "Insira o Mes");

                return -1;
            }
        }
    }
}
