public class tipoData{
    
    // Atributos
    
    private int dia;
    private int mes;
    private int ano;

    // Construtores

    public tipoData(){
        this.setDia(1);
        this.setMes(1);
        this.setAno(1);
    }

    public tipoData(int dia, int mes, int ano){
        this.setDia(dia);
        this.setMes(mes);
        this.setAno(ano);
    }

    // Getters e Setters

    public void setDia(int dia){
        this.dia = dia;
    }

    public void setMes(int mes){
        this.mes = mes;
    }

    public void setAno(int ano){
        this.ano = ano;
    }

    public int getDia(){
        return this.dia;
    }

    public int getMes(){
        return this.mes;
    }

    public int getAno(){
        return this.ano;
    }

    // Retorna a data completa (formato dd/mm/aaaa);  

    public String getDataCompleta(){
        return String.format("%d/%d/%04d",this.getDia(), this.getMes(), this.getAno());
    }

    public String getDataDiaMes(){
        return String.format("%d/%d",this.getDia(), this.getMes());
    }

    public int getQntdDias(tipoData dataFim){
        int diaF, mesF, anoF;
        
        diaF = dataFim.getDia();
        mesF = dataFim.getMes();
        anoF = dataFim.getAno();

        int total = (diaF - this.getDia()) + (mesF - this.getMes()) * 12 + (anoF - this.getAno()) * 365;

        return total;
    }
}