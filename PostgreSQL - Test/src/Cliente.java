public class Cliente {

    private String NOME_FANTASIA;
    private String NOME_SOCIAL;
    private Long   CODIGO;
    private Long   FILIAL;
    private Long   ID;
    private String CPF_CNPJ;
    private String TIPO;

    public Cliente() {
        this.NOME_FANTASIA = "SEM NOME";
        this.NOME_SOCIAL = "";
        this.CODIGO = 000L;
        this.FILIAL = 0000L;
        this.ID =  000000L;
        this.CPF_CNPJ = "0";
        this.TIPO = "";
    }

//    public void   salvar() {
//        DatabaseReference firebaseRef = ConfiguracaoFirebase.getFirebase();
//        DatabaseReference clienteRef = firebaseRef
//                .child("clientesPedido").child(getCodigo());
//        clienteRef.setValue(this);
//    }

    public String getNOME_FANTASIA() {
        return NOME_FANTASIA;
    }

    public void   setNOME_FANTASIA(String NOME_FANTASIA) {
        this.NOME_FANTASIA = NOME_FANTASIA;
    }

    public String getNOME_SOCIAL() {
        return NOME_SOCIAL;
    }

    public void   setNOME_SOCIAL(String NOME_SOCIAL) {
        this.NOME_SOCIAL = NOME_SOCIAL;
    }

    public Long   getCODIGO() {
        return CODIGO;
    }

    public void   setCODIGO(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long   getFILIAL() {
        return FILIAL;
    }

    public void   etFILIAL(Long FILIAL) {
        this.FILIAL = FILIAL;
    }

    public String getCPF_CNPJ() {
        return CPF_CNPJ;
    }

    public void   setCPF_CNPJ(String CPF_CNPJ) {
        this.CPF_CNPJ = CPF_CNPJ;
    }

    public void   setFILIAL(Long FILIAL) {
        this.FILIAL = FILIAL;
    }

    public Long   getID() {
        return ID;
    }

    public void   setID(Long ID) {
        this.ID = ID;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void   setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }
}
