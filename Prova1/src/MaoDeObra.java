import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public abstract class MaoDeObra {

    // Atributos de classe

    private String CPF;
    private String nome;
    private tipoData dataPagto;

    // Construtores

    public MaoDeObra() {
        this.setCPF("");
        this.setNome("");
        this.dataPagto = new tipoData();
    }

    public MaoDeObra(String cpf, String nome, tipoData dataPagto) {
        this.setCPF(cpf);
        this.setNome(nome);
        this.dataPagto = dataPagto;
    }

    // Getter e Setters

    public void setCPF(String cpf) {
        MaskFormatter mascara;
        try {
            mascara = new MaskFormatter("###.###.###-##");
            mascara.setValueContainsLiteralCharacters(false);
            this.CPF = mascara.valueToString(cpf);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCPF(){
        return this.CPF;
    }

    public String getNome(){
        return this.nome;
    }

    // To String

    public String toString(){
        return String.format("Nome: %s, CPF: %s, Data de Pagamento = %s", this.getNome(), this.getCPF(), dataPagto.getDataDiaMes());
    }
}
