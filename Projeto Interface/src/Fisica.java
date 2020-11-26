import java.awt.Color;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.text.MaskFormatter;

public class Fisica extends Contribuinte implements Estado {
    
    private static final String l1 = "CPF: ";
    private static final String l2 = "Gasto Saude: ";
    private static final String l3 = "Gasto Educacao: ";

    // Atributos

    private String CPF;
    private double gastoSaude;
    private double gastoEducacao;

    // Atributos de classe

    private static JPanel painel;
    private static JLabel lNome, lRenda;
    private static JTextField txtNome, txtRenda;
    private static JLabel lbl1, lbl2, lbl3;
    private static JTextField txt1, txt2, txt3;

    // Construtores

    public Fisica(){
        super();
        this.setCPF("");
        this.setGastoSaude(0.00);
        this.setGastoEducacao(0.00);
    }

    public Fisica(String nome, double renda,String CPF, double gastoSaude, double gastoEducacao){
        super(renda, nome);
        this.setCPF(CPF);
        this.setGastoSaude(gastoSaude);
        this.setGastoEducacao(gastoEducacao);
    }

    // Métodos da Interface

    @Override
    public double arrecadaImposto() {
    
        return (this.getRendaBrutaAnual() - this.getGastoSaude() - this.getGastoEducacao());
    }

    // Getters e Setters

    public void setCPF(String CPF){
        this.CPF = CPF;
    }

    public void setGastoSaude(double gastoSaude){
        this.gastoSaude = gastoSaude;
    }

    public void setGastoEducacao(double gastoEducacao){
        this.gastoEducacao = gastoEducacao;
    }

    public String getCPF(){
        return this.CPF;
    }

    public double getGastoSaude(){
        return this.gastoSaude;
    }

    public double getGastoEducacao(){
        return this.gastoEducacao;
    }

    // Métodos de classe

    public static JPanel criarPainel(){
        painel = new JPanel(new GridLayout(5, 2));
        
        painel.setBorder(BorderFactory.createLineBorder(Color.black));

        lNome = new JLabel("Nome: ", SwingConstants.LEFT);
        lRenda = new JLabel("Renda: ", SwingConstants.LEFT);
        lbl1 = new JLabel(l1, SwingConstants.LEFT);
        lbl2 = new JLabel(l2, SwingConstants.LEFT);
        lbl3 = new JLabel(l3, SwingConstants.LEFT);

        txtNome = new JTextField(100);
        txtRenda = new JTextField(100);
        txt1 = new JTextField(100);
        txt2 = new JTextField(100);
        txt3 = new JTextField(100);

        painel.add(lNome);
        painel.add(txtNome);
        painel.add(lRenda);
        painel.add(txtRenda);
        painel.add(lbl1);
        painel.add(txt1);
        painel.add(lbl2);
        painel.add(txt2);
        painel.add(lbl3);
        painel.add(txt3);

        return painel;
    }

    public static String getNomeContribuinte() {
        return txtNome.getText().toString();
    }

    public static void setNomeContribuinte(String texto) {
        txtNome.setText(texto);
    }

    public static double getRenda() {
        double renda;
        if(txtRenda.getText().toString().isEmpty()){
            txtRenda.setBackground(Color.red);

            Timer timer = new Timer(1000, event -> {
                txtRenda.setBackground(Color.white);
            });
            timer.setRepeats(false);
            timer.start();

            JOptionPane.showMessageDialog(null, "Valor inválido");

            return -1;
        }
        else{
            try {
                renda = Double.valueOf(txtRenda.getText().toString());
                return renda;
            } catch (NumberFormatException e) {

                txtRenda.setBackground(Color.red);

                Timer timer = new Timer(1000, event -> {
                    txtRenda.setBackground(Color.white);
                });
                timer.setRepeats(false);
                timer.start();

                JOptionPane.showMessageDialog(null, "Valor inválido");

                return -1;
            }
        }
    }

    public static void setRenda(String texto) {
        txtRenda.setText(texto);
    }

    public static String getDado() {
        String cpf = txt1.getText().toString();

        if(cpf.matches("[0-9]+")){
            
            try {
                MaskFormatter mascara = new MaskFormatter("###.###.###-##");
                mascara.setValueContainsLiteralCharacters(false);
                cpf = mascara.valueToString(cpf);
                return cpf;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        else{
            txt1.setBackground(Color.red);
                    
            Timer timer = new Timer(1000, event ->{
                txt1.setBackground(Color.white);
            });

            timer.setRepeats(false);
            timer.start();
            JOptionPane.showMessageDialog(null, "CPF inválido: Insira apenas números");
                    
            return "";
        }
        return "";
    }

    public static void setDado(String texto) {
        txt1.setText(texto);
    }

    public static double getGastos1(){
        double gasto;
        try{
            gasto = Double.valueOf(txt2.getText().toString());
            return gasto;
        }
        catch(NumberFormatException e){
            txt2.setBackground(Color.red);
                    
            Timer timer = new Timer(1000, event ->{
               txt2.setBackground(Color.white);
            });

            timer.setRepeats(false);
            timer.start();

            JOptionPane.showMessageDialog(null, "Valor inválido");

            return -1;
        }
    }

    public static void setGastos1(String texto) {
        txt2.setText(texto);
    }

    public static double getGastos2(){
        double gasto;
        try{
            gasto = Double.valueOf(txt3.getText().toString());
            return gasto;
        }
        catch(NumberFormatException e){
            txt3.setBackground(Color.red);
                    
            Timer timer = new Timer(1000, event ->{
               txt3.setBackground(Color.white);
            });

            timer.setRepeats(false);
            timer.start();

            JOptionPane.showMessageDialog(null, "Valor inválido");

            return -1;
        }
    }

    public static void setGastos2(String texto) {
        txt3.setText(texto);
    }
    
    // ToString

    public String toString(){
        return String.format("%s\nCPF: %s, Gasto Saúde: R$ %.2f, Gasto Educação: R$ %.2f\n\n", super.toString(), this.getCPF(), this.getGastoSaude(), this.getGastoEducacao());
    }

}
