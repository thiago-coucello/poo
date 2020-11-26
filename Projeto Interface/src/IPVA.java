import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.GridLayout;

public class IPVA implements Estado {

    // Atributos normais

    private String placaCarro;
    private char marcaCarro;
    private double valorAnual;

    // Atributos estáticos

    private static JPanel painel;
    private static JLabel lPlaca, lMarca, lValor;
    private static JTextField txtPlaca, txtValor;
    private static JComboBox cMarca;

    // Construtores

    public IPVA() {
        this.setPlacaCarro("");
        this.setMarcaCarro(' ');
        this.setValorAnual(0.00);
    }

    public IPVA(String placaCarro, char marcaCarro, double valorAnual) {
        this.setPlacaCarro(placaCarro);
        this.setMarcaCarro(marcaCarro);
        this.setValorAnual(valorAnual);
    }

    // Métodos da interface

    @Override
    public double arrecadaImposto() {
        double imposto = 0.00;
        switch (this.getMarcaCarro()) {
            case 'W': {
                imposto = 1000;
                break;
            }
            case 'G': {
                imposto = 1200;
                break;
            }
            case 'F': {
                imposto = 900;
                break;
            }
            case 'O': {
                imposto = 1500;
                break;
            }
        }
        return imposto;
    }

    // Getters e Setters

    public void setPlacaCarro(String placaCarro) {
        this.placaCarro = placaCarro;
    }

    public void setMarcaCarro(char marcaCarro) {
        this.marcaCarro = marcaCarro;
    }

    public void setValorAnual(double valorAnual) {
        this.valorAnual = valorAnual;
    }

    public String getPlacaCarro() {
        return this.placaCarro;
    }

    public char getMarcaCarro() {
        return this.marcaCarro;
    }

    public double getValorAnual() {
        return this.valorAnual;
    }

    // ToString

    public String toString() {
        return String.format("Placa do carro: %s, Marca do carro: %c, Valor anual: R$ %.2f\n\n", this.getPlacaCarro(),
                this.getMarcaCarro(), this.getValorAnual());
    }

    // Métodos Estáticos

    public static JPanel criarPainel() {
        painel = new JPanel(new GridLayout(3, 2));
        painel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        lPlaca = new JLabel("Placa: ", SwingConstants.LEFT);
        lMarca = new JLabel("Marca: ", SwingConstants.LEFT);
        lValor = new JLabel("Valor Anual: ", SwingConstants.LEFT);

        txtPlaca = new JTextField(10);
        txtValor = new JTextField(100);

        cMarca = new JComboBox<>();
        cMarca.addItem("Wolkswagen");
        cMarca.addItem("Gm");
        cMarca.addItem("Fiat");
        cMarca.addItem("Outros");

        painel.add(lPlaca); painel.add(txtPlaca);
        painel.add(lMarca); painel.add(cMarca);
        painel.add(lValor); painel.add(txtValor);

        return painel;
    }

    public static String getPlaca(){
        return txtPlaca.getText().toString();
    }

    public static char getMarca(){
        return cMarca.getSelectedItem().toString().charAt(0);
    }

    public static double getValor(){
        double valor;

        try{
            valor = Double.valueOf(txtValor.getText().toString());
            return valor;
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Valor inválido");
            
            txtValor.setBackground(Color.red);

            Timer timer = new Timer(1000, event -> {
	            txtValor.setBackground(Color.white);
	        });
	        timer.setRepeats(false);
            timer.start();
            
            return -1;
        }

    }

    public static void setPlaca(String texto){
        txtPlaca.setText(texto);
    }

    public static void setValor(String texto){
        txtValor.setText(texto);
    }

}
