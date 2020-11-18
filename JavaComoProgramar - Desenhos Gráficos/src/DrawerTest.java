import javax.swing.JFrame;

public class DrawerTest extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Drawer panel = new Drawer();
		
		JFrame tela = new JFrame();
		
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.add(panel);
		tela.setSize(300,500);
		tela.setVisible(true);
		
	}

}
