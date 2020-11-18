import java.text.DecimalFormat;

public class Usuario {

    private String email;
    private String senha;
    private String nome;
    private String idUsuario;
    private String filial;
    private String tipo;
    private Double desconto;
    private int    codigo; //5 casas
    private int    pedirDesconto;

    //Construtor
    public        Usuario() {
        

    }

    //Métodos
    public void   salvar() {
        
    }

    public void   salvarADM(String userId) {
        
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void   setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void   setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void   setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        DecimalFormat df = new DecimalFormat("000");
        int num_filial = Integer.valueOf(filial);
        filial = df.format(num_filial);

        this.filial = filial;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void   setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void   setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int    getPedirDesconto() {
        return pedirDesconto;
    }

    public void   setPedirDesconto(int pedirDesconto) {
        this.pedirDesconto = pedirDesconto;
    }
}
