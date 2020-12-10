import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Borda {
	public static Border criaBorda(String titulo, Color cor) {
		return BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(cor),
				titulo
			   );
	}
}
