import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

public class Cliente {

    // Atributos

    private String nome;
    private String endereco;
    private String cidade;

    // VariÃ¡veis de classe

    private static JPanel painelPrincipal, painelBase, painelBotoes;
    private static JLabel lNome, lEndereco, lCidade;
    private static JTextField txtNome, txtEndereco, txtCidade;

    // Construtores

    public Cliente(){
        this.setNome("");
        this.setEndereco("");
        this.setCidade("");
    }

    public Cliente(String nome, String endereco, String cidade){
        this.setNome(nome);
        this.setEndereco(endereco);
        this.setCidade(cidade);
    }

    // Getters e Setters

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public void setCidade(String cidade){
        this.cidade = cidade;
    }

    public String getNome(){
        return this.nome;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public String getCidade(){
        return this.cidade;
    }

    // toString (para exibir apenas o nome no JComboBox)

    public String toString(){
        return String.format("%s",this.getNome());
    }

    // Verdadeiro toString()

    public String saida(){
        return String.format("Nome: %s, Endereço: %s, Cidade: %s",this.getNome(), this.getEndereco(), this.getCidade() );
    }

    // MÃ©todos de Classe

    public static JPanel criaPainel(){
        painelPrincipal = new JPanel(new BorderLayout());
        painelBase = new JPanel(new GridLayout(3,2));
        painelBotoes = new JPanel(new FlowLayout());

        painelBase.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Dados"));

        lNome = new JLabel("Nome: ", SwingConstants.LEFT);
        lEndereco = new JLabel("Endereço: ", SwingConstants.LEFT);
        lCidade = new JLabel("Cidade: ", SwingConstants.LEFT);

        txtNome = new JTextField(100);
        txtEndereco = new JTextField(100);
        txtCidade = new JTextField(100);

        painelBase.add(lNome); painelBase.add(txtNome);
        painelBase.add(lEndereco); painelBase.add(txtEndereco);
        painelBase.add(lCidade); painelBase.add(txtCidade);

        painelPrincipal.add(painelBase, BorderLayout.NORTH);
        painelPrincipal.add(painelBotoes,BorderLayout.SOUTH);

        return painelPrincipal;
    }

    public static String getTxtNome(){
        if(txtNome.getText().toString().isBlank()){
           JOptionPane.showMessageDialog(null, "Insira um nome");
           txtNome.setBackground(Color.red);

           Timer timer = new Timer(1000, event ->{
               txtNome.setBackground(Color.white);
           });
           timer.setRepeats(false);
           timer.start();
        
        }
        else{
            return txtNome.getText().toString();
        }

        return "";
    }

    public static String getTxtEndereco(){
        if(txtEndereco.getText().toString().isBlank()){
            JOptionPane.showMessageDialog(null, "Insira um endereço");
            txtEndereco.setBackground(Color.red);

            Timer timer = new Timer(1000, event ->{
                txtEndereco.setBackground(Color.white);
            });
            timer.setRepeats(false);
            timer.start();
        }
        else{
            return txtEndereco.getText().toString();
        }

        return "";
    }

    public static String getTxtCidade(){
        if(txtCidade.getText().toString().isBlank()){
            JOptionPane.showMessageDialog(null, "Insira uma cidade");
            txtCidade.setBackground(Color.red);

            Timer timer = new Timer(1000, event ->{
                txtCidade.setBackground(Color.white);
            });
            timer.setRepeats(false);
            timer.start();
        }
        else{
            return txtCidade.getText().toString();
        }

        return "";
    }

    public static void limparTela(){
        txtNome.setText("");
        txtEndereco.setText("");
        txtCidade.setText("");
    }

}  
