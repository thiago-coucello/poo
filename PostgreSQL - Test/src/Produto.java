
public class Produto {
	private String CODIGO;          // Código do sistema
    private String COD_FABRI;       // Código de barras
    private String COD_ORIG;        // Código original
    private String DISCRIM;         // Nome
    private String ESTOQUE;         // Estoque atual
    private String QTD_ATAC;        // Quantidade mínima atacado
    private String VLR_URV;         // Preço
    private String VLR_ATAC;        // Preço atacado

    // Construtor

    public Produto(){
        this.CODIGO = "";
        this.COD_FABRI = "";
        this.COD_ORIG = "";
        this.DISCRIM = "";
        this.ESTOQUE = "";
        this.QTD_ATAC = "";
        this.VLR_URV = "";
        this.VLR_ATAC = "";
    }

    public Produto(String CODIGO, String COD_FABRI, String COD_ORIG, String DISCRIM, String ESTOQUE, String QTD_ATAC, String VLR_URV, String VLR_ATAC) {
        this.CODIGO = CODIGO;
        this.COD_FABRI = COD_FABRI;
        this.COD_ORIG = COD_ORIG;
        this.DISCRIM = DISCRIM;
        this.ESTOQUE = ESTOQUE;
        this.QTD_ATAC = QTD_ATAC;
        this.VLR_URV = VLR_URV;
        this.VLR_ATAC = VLR_ATAC;
    }

    //Getters and Setters
    public String getCODIGO() {
        return this.CODIGO;
    }

    public String getCOD_ORIG() {
        return this.COD_ORIG;
    }

    public String getCOD_FABRI() {
        return this.COD_FABRI;
    }

    public String getDISCRIM() {
        return this.DISCRIM;
    }

    public Double getVLR_URV() {
        String valor = this.VLR_URV.replaceAll("[,]", ".")
                .replaceAll("[ ]", "");

        return Double.parseDouble(valor);
    }

    public Double getVLR_ATAC() {
        String valor = this.VLR_ATAC.replaceAll("[,]", ".")
                .replaceAll("[ ]", "");
        return Double.parseDouble(valor);
    }

    public Double getQTD_ATAC() {
        String valor = this.QTD_ATAC.replaceAll("[,]", "")
                .replaceAll("[ ]", "");
        return Double.valueOf(valor);
    }

    public double getESTOQUE() {
        String e = this.ESTOQUE.replace(",",".");
        return Double.valueOf(e);
    }

    public void setCODIGO(String CODIGO) {
        this.CODIGO = CODIGO;
    }

    public void setCOD_FABRI(String COD_FABRI) {
        this.COD_FABRI = COD_FABRI;
    }

    public void setCOD_ORIG(String COD_ORIG) {
        this.COD_ORIG = COD_ORIG;
    }

    public void setDISCRIM(String DISCRIM) {
        this.DISCRIM = DISCRIM;
    }

    public void setQTD_ATAC(String QTD_ATAC) {
        this.QTD_ATAC = QTD_ATAC;
    }

    public void setVLR_URV(String VLR_URV) {
        this.VLR_URV = VLR_URV;
    }

    public void setVLR_ATAC(String VLR_ATAC) {
        this.VLR_ATAC = VLR_ATAC;
    }

    public void setESTOQUE(String ESTOQUE){
        this.ESTOQUE = ESTOQUE;
    }
}
