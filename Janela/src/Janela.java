import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Janela extends JFrame implements ActionListener{
	
	// Botões dos exemplos de layout simples
	private JButton BotaoEsq, BotaoDir, BotaoCentro;
	private JButton UM,DOIS,TRES,QUATRO,CINCO,SEIS;
	private JButton NORTE,SUL,CENTRO,LESTE,OESTE;
	
	// Componentes do exemplo da calculadora
	
	private JTextField valor1, valor2, resultado;
	private JLabel label1, label2, label3;
	private JButton limpar, adicao, subtracao, multiplicacao, divisao;	
	
	public Janela() {
		//super("Exemplo Janelas");
		
		// Exemplo FlowLayout
		
		/*
		setLayout(new FlowLayout());
		BotaoEsq = new JButton("Esq");			add(BotaoEsq);
		BotaoCentro = new JButton("Centro");	add(BotaoCentro);
		BotaoDir =  new JButton("Dir");		add(BotaoDir);
		*/
		
		//Exemplo GridLayout
		
		/*
		setLayout(new GridLayout(3,2));
		UM = new JButton("UM");			DOIS = new JButton("DOIS");
		TRES = new JButton("TRES");		QUATRO = new JButton("QUATRO");
		CINCO = new JButton("CINCO");	SEIS = new JButton("SEIS");
		
		add(UM);		add(DOIS);		add(TRES);
		add(QUATRO);	add(CINCO);		add(SEIS);
		*/
		
		//Exemplo BorderLayout
		
		/*
		setLayout(new BorderLayout());
		NORTE = new JButton("NORTE");
		CENTRO = new JButton("CENTRO");
		SUL = new JButton("SUL");
		LESTE = new JButton("LESTE");
		OESTE = new JButton("OESTE");
		
		add(NORTE,BorderLayout.NORTH);
		add(SUL,BorderLayout.SOUTH);
		add(OESTE,BorderLayout.WEST);
		add(LESTE,BorderLayout.EAST);
		add(CENTRO,BorderLayout.CENTER);
		*/
		
		super("Exemplo Calculadora");
		setLayout(new BorderLayout());
		
		//TextFields
		valor1 = new JTextField(5);
		valor2 = new JTextField(5);
		resultado = new JTextField(5);
		
		//Não pode editar o campo de resultado
		resultado.setEditable(false);
		
		//Labels
		label1 = new JLabel("Valor 1..:", SwingConstants.RIGHT);
		label2 = new JLabel("Valor 2..:", SwingConstants.RIGHT);
		label3 = new JLabel("Resultado:", SwingConstants.RIGHT);
		
		//Buttons
		limpar = new JButton("Limpar");
		adicao = new JButton("+");
		subtracao = new JButton("-");
		divisao = new JButton("/");
		multiplicacao = new JButton("*");
		
		//Eventos dos botões
		
		adicao.addActionListener(this);
		subtracao.addActionListener(this);
		divisao.addActionListener(this);
		multiplicacao.addActionListener(this);
		limpar.addActionListener(this);
		
		//Panels
		
		JPanel centro = new JPanel(new GridLayout(3,2,10,10));
		JPanel leste = new JPanel(new GridLayout(4,1));
		
		//Adicionando componentes aos paineis
		
		centro.add(label1);
		centro.add(valor1);
		centro.add(label2);
		centro.add(valor2);
		centro.add(label3);
		centro.add(resultado);
		
		leste.add(adicao);
		leste.add(subtracao);
		leste.add(multiplicacao);
		leste.add(divisao);
		
		add(centro, BorderLayout.CENTER);
		add(leste, BorderLayout.EAST);
		add(limpar, BorderLayout.SOUTH);
	}
	
	// Método de adição
	public void adicao() {
		//Declarando variaveis
		double numero1, numero2, resposta;
		
		try {
			//Se o campo VALOR1 não estiver vazio
			if(!valor1.getText().toString().isEmpty()) {
				numero1 = Double.valueOf(valor1.getText().toString());
			}
			else {
				numero1 = 0;
			}
		
		}
		catch(NumberFormatException e) {
			resultado.setText("ERROR");
			return;
		}
		
		try {
			//Se o campo VALOR2 não estiver vazio
			if(!valor2.getText().toString().isEmpty()) {
				numero2 = Double.valueOf(valor2.getText().toString());
			}
			else {
				numero2 = 0;
			}
		
		}
		catch(NumberFormatException e) {
			resultado.setText("ERROR");
			return;
		}
		
		resposta = numero1 + numero2;
		
		resultado.setText(String.format("%.2f", resposta));
	}
	
	// Método de subtração
		public void subtracao() {
			//Declarando variaveis
			double numero1, numero2, resposta;
			
			try {
				//Se o campo VALOR1 não estiver vazio
				if(!valor1.getText().toString().isEmpty()) {
					numero1 = Double.valueOf(valor1.getText().toString());
				}
				else {
					numero1 = 0;
				}
			
			}
			catch(NumberFormatException e) {
				resultado.setText("ERROR");
				return;
			}
			
			try {
				//Se o campo VALOR2 não estiver vazio
				if(!valor2.getText().toString().isEmpty()) {
					numero2 = Double.valueOf(valor2.getText().toString());
				}
				else {
					numero2 = 0;
				}
			
			}
			catch(NumberFormatException e) {
				resultado.setText("ERROR");
				return;
			}
			
			resposta = numero1 - numero2;
			
			resultado.setText(String.format("%.2f", resposta));
		}
		
		// Método de multiplicacao
		public void multiplicacao() {
			//Declarando variaveis
			double numero1, numero2, resposta;
			
			try {
				//Se o campo VALOR1 não estiver vazio
				if(!valor1.getText().toString().isEmpty()) {
					numero1 = Double.valueOf(valor1.getText().toString());
				}
				else {
					numero1 = 0;
				}
			
			}
			catch(NumberFormatException e) {
				resultado.setText("ERROR");
				return;
			}
			
			try {
				//Se o campo VALOR2 não estiver vazio
				if(!valor2.getText().toString().isEmpty()) {
					numero2 = Double.valueOf(valor2.getText().toString());
				}
				else {
					numero2 = 0;
				}
			
			}
			catch(NumberFormatException e) {
				resultado.setText("ERROR");
				return;
			}
			
			resposta = numero1 * numero2;
			
			resultado.setText(String.format("%.2f", resposta));
		}
		
		// Método de divisão
		public void divisao() {
			//Declarando variaveis
			double numero1, numero2, resposta;
			
			try {
				//Se o campo VALOR1 não estiver vazio
				if(!valor1.getText().toString().isEmpty()) {
					numero1 = Double.valueOf(valor1.getText().toString());
				}
				else {
					numero1 = 0;
				}
			
			}
			catch(NumberFormatException e) {
				resultado.setText("ERROR");
				return;
			}
			
			try {
				//Se o campo VALOR2 não estiver vazio
				if(!valor2.getText().toString().isEmpty()) {
					numero2 = Double.valueOf(valor2.getText().toString());
					
					if(numero2 == 0) {
						resultado.setText("ERROR");
						return;
					}
				}
				else {
					numero2 = 1;
				}
			
			}
			catch(NumberFormatException e) {
				resultado.setText("ERROR");
				return;
			}
			
			resposta = numero1 / numero2;
			
			resultado.setText(String.format("%.2f", resposta));
		}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
		if(event.getSource() == adicao) {
			adicao();
		}
		
		if(event.getSource() == subtracao) {
			subtracao();
		}
		
		if(event.getSource() == multiplicacao) {
			multiplicacao();
		}
		
		if(event.getSource() == divisao) {
			divisao();
		}
		
		if(event.getSource() == limpar) {
			valor1.setText("");
			valor2.setText("");
			resultado.setText("");
		}
		
	}
	
	// Método principal (main), que será executado
	public static void main(String[] args) {
		Janela f = new Janela();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Tamanho da janela
		f.pack();
		
		//Deixa a janela visivel
		f.setVisible(true);
		
		//coloca a janela no centro da tela
		f.setLocationRelativeTo(null);
		
	}

}
