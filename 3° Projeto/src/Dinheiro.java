import javax.swing.JPanel;

public class Dinheiro extends Pagamento {
    
    private static JPanel painel;
    
    public Dinheiro(){
        super();
    }

    public Dinheiro(String dataPagto, Cliente cliente, double valorPagto){
        super(dataPagto, cliente, valorPagto);
    }

    public String toString(){
        return String.format("%s",super.toString(), "Dinheiro");
    }

    public static JPanel criarPainel(){
        painel = Pagamento.criaPainelDadosPagamento();
        return painel;
    }

    public static String getTxtDataPagto() {
        return Pagamento.getTxtDataPagto();
    }

    public static double getTxtValorPagto() {
        return Pagamento.getTxtValorPagto();
    }

    public static void addCliente(Cliente c) {
        Pagamento.addCliente(c);
    }

    public static Cliente getClienteSelecionado() {
        return Pagamento.getClienteSelecionado();
    }

    public static void limparTela(){
        Pagamento.limparTela();
    }
}
