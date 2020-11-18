import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ExemploLayout extends JFrame{

	private JButton btnEsq = new JButton("Esq");
	private JButton btnDir = new JButton("Dir");
	private JButton btnCentro = new JButton("Centro");
	private JButton btnOeste = new JButton("Oeste");
	private JButton btnLeste = new JButton("Leste");
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //Número serial padrão gerado pelo eclipse

	/*//FlowLayout -> Três botões na janela
	public ExemploLayout() {
		setLayout(new FlowLayout());
		add(btnEsq);
		add(btnCentro);
		add(btnDir);

	}//*/
	
	/*// GridLayout -> 3 linhas 2 colunas
	public ExemploLayout() {
		setLayout(new GridLayout(3,2));
		add(btnEsq);
		add(btnCentro);
		add(btnDir);
		add(btnOeste);
		add(btnLeste);

	}// */
	
	// BorderLayout
	public ExemploLayout() {
		setLayout(new BorderLayout());
		add(btnEsq, BorderLayout.SOUTH);
		add(btnDir,BorderLayout.NORTH);
		add(btnOeste,BorderLayout.WEST);
		add(btnLeste,BorderLayout.EAST);
		add(btnCentro, BorderLayout.CENTER);
	
	} // */

	public static void main(String[] args) {
		ExemploLayout tela = new ExemploLayout();
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setSize(300,200);
		tela.setLocation(750, 450);
		tela.setVisible(true);
	}

}
