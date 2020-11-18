import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

public class Jogo extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	//JavaFX Panel
	JFXPanel fx_panel = new JFXPanel();
	
	//Baralhos com todos os tipos de lista pedidos
	Baralho baralho_Array, baralho_Lista, baralho_Vector, baralho_Stack;
	
	//Morto
	List<Carta> morto_Array = new ArrayList<>();
	List<Carta> morto_Lista = new ArrayList<>();
	List<Carta> morto_Stack = new ArrayList<>();
	List<Carta> morto_Vector = new ArrayList<>();
	Carta c;
	
	//Cartas fechadas para todos os tipos de lista
	JButton btnFechado_Array, btnFechado_Lista, btnFechado_Vector, btnFechado_Stack;

	//Cartas abertas para todos os tipos de lista
	JButton btnAberto_Array, btnAberto_Lista, btnAberto_Vector, btnAberto_Stack;
	
	//Bot�es de a��o
	JButton btnCriaBaralho, btnEmbaralha, btnZeraTudo, btnExibe, btnExibeMorto, btnSair;
	
	//Icones
	ImageIcon fechado, aberto, vazio;
	JLabel background = new JLabel(new ImageIcon("C:\\Users\\thiag\\OneDrive\\Documentos\\Apostilas\\2020.1\\Programa��o Orientada a Objetos\\Aula5\\bin\\mesa.png"));
	
	public Jogo() {
		super.setTitle("Baralho");
		// Border Layout principal
		
		setLayout(new BorderLayout());
		
		//Iniciando os icones
		fechado = new ImageIcon(getClass().getResource("fechado.png"));
		vazio = new ImageIcon(getClass().getResource("fechado2.png"));
		
		//Inicia os baralhos "fechados" de cada tela com seu icone correspondente
		btnFechado_Array = new JButton(fechado);
		btnFechado_Lista = new JButton(fechado);
		btnFechado_Vector = new JButton(fechado);
		btnFechado_Stack = new JButton(fechado);
		
		//Inicia os baralhos "abertos" de cada tela com seu icone correspondente
		btnAberto_Array = new JButton(vazio);
		btnAberto_Lista = new JButton(vazio);
		btnAberto_Vector = new JButton(vazio);
		btnAberto_Stack = new JButton(vazio);
		
		//Inicia os bot�es de a��o com seus nomes correspondentes
		btnCriaBaralho = new JButton("Cria Baralho");
		btnEmbaralha = new JButton("Embaralha");
		btnZeraTudo = new JButton("Zerar Baralho");
		btnExibe = new JButton("Exibe");
		btnExibeMorto = new JButton("Exibe Morto");
		btnSair = new JButton("Sair");
		
		//Cria os baralhos com sua determinada lista 'a'= Array, 'l'= Lista Encadeada, 'v'= Vector e 's'= Stack (Pilha)
		baralho_Array =  new Baralho('a');
		baralho_Lista = new Baralho('l');
		baralho_Vector = new Baralho('v');
		baralho_Stack = new Baralho('s');
		
		//Embaralha todos eles
		baralho_Array.embaralha();
		baralho_Lista.embaralha();
		baralho_Vector.embaralha();
		baralho_Stack.embaralha();
		
		//Limpa os mortos
		morto_Array.clear();
		morto_Lista.clear();
		morto_Vector.clear();
		morto_Stack.clear();
		
		//Canto Superior-Esquerdo da tela
		JPanel norte_oeste = new JPanel(new FlowLayout());
		
		//Cria a borda com t�tulo e adiciona no JPanel
		TitledBorder borda_NO = CriaBorda("Pilha - Stack");
		norte_oeste.setBorder(borda_NO);
		
		//Coloca os bot�es no JPanel
		norte_oeste.add(btnFechado_Stack);
		norte_oeste.add(btnAberto_Stack);
		
		//Canto Superior-Direito da tela
		JPanel norte_centro = new JPanel(new FlowLayout());
		
		TitledBorder borda_NC = CriaBorda("Lista Encadeada - LinkedList");
		norte_centro.setBorder(borda_NC);
		
		norte_centro.add(btnFechado_Lista);
		norte_centro.add(btnAberto_Lista);
		
		//Parte Superior da tela
		JPanel norte = new JPanel(new BorderLayout());
		
		//Adiciona os dois pain�is ao painel que ficar� no norte do layout principal nas suas devidas posi��es
		norte.add(norte_oeste,BorderLayout.WEST);
		norte.add(norte_centro, BorderLayout.CENTER);
		
		//Parte Centro-Esquerda da tela
		JPanel centro_oeste = new JPanel(new FlowLayout());
		
		TitledBorder borda_CO = CriaBorda("Array - ArrayList");
		centro_oeste.setBorder(borda_CO);

		centro_oeste.add(btnFechado_Array);
		centro_oeste.add(btnAberto_Array);
		
		//Parte Centro-Direita da tela
		JPanel centro_centro = new JPanel(new FlowLayout());
		
		TitledBorder borda_CC = CriaBorda("Vector - Vetor Sincronizado");
		centro_centro.setBorder(borda_CC);
		
		centro_centro.add(btnFechado_Vector);
		centro_centro.add(btnAberto_Vector);
		
		//Parte Central da tela
		JPanel centro = new JPanel(new BorderLayout());
		
		//Adiciona os dois JPanels ao JPanel que ficar� no centro, cada um na sua devida posi��o
		centro.add(centro_oeste,BorderLayout.WEST);
		centro.add(centro_centro,BorderLayout.CENTER);
		
		
		//Parte Inferior da tela, respons�vel pelos bot�es de a��o com o baralho
		JPanel sul = new JPanel(new FlowLayout());
		
		//Adiciona todos os bot�es de a��o
		sul.add(btnCriaBaralho);
		sul.add(btnEmbaralha);
		sul.add(btnZeraTudo);
		sul.add(btnExibe);
		sul.add(btnExibeMorto);
		sul.add(btnSair);
		
		//Adiciona os JPanels "principais" as suas posi��es no Layout principal
		add(norte,BorderLayout.NORTH);
		add(centro,BorderLayout.CENTER);
		add(sul,BorderLayout.SOUTH);
		
		//JavaFX panel, exclusivamente para execu��o do MediaPlayer
		add(fx_panel,BorderLayout.WEST);
		
		
		//Adiciona os ActionListeners em cada bot�o do layout
		btnFechado_Array.addActionListener(this);
		btnFechado_Lista.addActionListener(this);
		btnFechado_Vector.addActionListener(this);
		btnFechado_Stack.addActionListener(this);
		btnCriaBaralho.addActionListener(this);
		btnEmbaralha.addActionListener(this);
		btnZeraTudo.addActionListener(this);
		btnExibe.addActionListener(this);
		btnExibeMorto.addActionListener(this);
		btnSair.addActionListener(this);
		
		//M�todo para executar a parte JavaFX
		Platform.runLater(new Runnable() {
            @Override
            public void run() {
            	//Inicializar o JFXPanel
                initFX(fx_panel);
            }
       });
	}
	
	protected void initFX(JFXPanel fx_panel2) {
		Group  root  =  new  Group();
        Scene  scene  =  new  Scene(root);
		fx_panel.setScene(scene);
	}

	@SuppressWarnings("deprecation")
	@Override
	//Executar a��es caso clique em bot�o
	public void actionPerformed(ActionEvent a) {
		
		if(a.getSource() == btnSair) {
			//fecha o JFrame (caso seja o �nico, fecha o programa)
			super.dispose();
		}
		
		if(a.getSource() == btnExibeMorto) {
			//Chama o Menu de Baralho com a opera��o Exibir Morto
			MenuBaralho("Morto");
		}
		
		if(a.getSource() == btnCriaBaralho) {
			//Chama o Menu de Baralho com a opera��o Criar Baralho
			MenuBaralho("Cria");
		}
		
		if(a.getSource() == btnExibe) {
			//Chama o Menu de Baralho com a opera��o Exibir Baralho
			MenuBaralho("Exibe");
		}
		
		if(a.getSource() == btnEmbaralha) {
			//Chama o Menu de Baralho com a opera��o Embaralha
			MenuBaralho("Embaralha");
		}
		
		if(a.getSource() == btnZeraTudo) {
			//Chama o Menu de Baralho com a opera��o Zerar Baralho
			MenuBaralho("Zerar");
		}
		
		if(a.getSource() == btnFechado_Array){
			if(baralho_Array.getBaralhoArray().isEmpty()) {
				btnFechado_Array.setIcon(vazio);
				btnFechado_Array.disable();
			}
			else {
				//Executa no JFXPanel
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						//Nome da m�sica que vai ser tocada
						String bip = "som_carta.mp3";
						
						//Cria a m�dia com esse arquivo em quest�o
						Media hit = new Media(new File(bip).toURI().toString());
						
						//Cria o mediaPlayer com a m�dia em quest�o
						MediaPlayer mediaPlayer = new MediaPlayer(hit);
						
						//Ajusta o volume para 0.25
						mediaPlayer.setVolume(0.025);
						
						//Se o mediaPlayer estiver tocando
						if(mediaPlayer.getStatus().equals(Status.PLAYING)) {
							//para
							mediaPlayer.stop();
							
							//come�a novamente
							mediaPlayer.play();
						}
						//Se n�o estiver tocando
						else {
							//toca
							mediaPlayer.play();
						}
					}
					
				});
				
				c = baralho_Array.getCarta(0);
				morto_Array.add(c);
				
				aberto = new ImageIcon(getClass().getResource(c.getImagem()));
				btnAberto_Array.setIcon(aberto);
			}
			
		}
		
		if(a.getSource() == btnFechado_Lista){
			if(baralho_Lista.getBaralhoLista().isEmpty()) {
				btnFechado_Lista.setIcon(vazio);
				btnFechado_Lista.disable();
			}
			else {
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						
						String bip = "som_carta.mp3";
						Media hit = new Media(new File(bip).toURI().toString());
						MediaPlayer mediaPlayer = new MediaPlayer(hit);
						
						mediaPlayer.setVolume(0.025);
						
						if(mediaPlayer.getStatus().equals(Status.PLAYING)) {
							mediaPlayer.stop();
							mediaPlayer.play();
						}
						else {
							mediaPlayer.play();
						}
					}
					
				});
				c = baralho_Lista.getCarta(0);
				morto_Lista.add(c);
				
				aberto = new ImageIcon(getClass().getResource(c.getImagem()));
				btnAberto_Lista.setIcon(aberto);
			}
			
		}
		
		if(a.getSource() == btnFechado_Vector){
			if(baralho_Vector.getBaralhoVector().isEmpty()) {
				btnFechado_Vector.setIcon(vazio);
				btnFechado_Vector.disable();
			}
			else {
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						String bip = "som_carta.mp3";
						Media hit = new Media(new File(bip).toURI().toString());
						MediaPlayer mediaPlayer = new MediaPlayer(hit);
						
						mediaPlayer.setVolume(0.025);
						
						if(mediaPlayer.getStatus().equals(Status.PLAYING)) {
							mediaPlayer.stop();
							mediaPlayer.play();
						}
						else {
							mediaPlayer.play();
						}
					}
					
				});
				c = baralho_Vector.getCarta(0);
				morto_Vector.add(c);
				
				aberto = new ImageIcon(getClass().getResource(c.getImagem()));
				btnAberto_Vector.setIcon(aberto);
			}
			
		}
		
		if(a.getSource() == btnFechado_Stack){
			if(baralho_Stack.getBaralhoStack().isEmpty()) {
				btnFechado_Stack.setIcon(vazio);
				btnFechado_Stack.disable();
			}
			else {
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						String bip = "som_carta.mp3";
						Media hit = new Media(new File(bip).toURI().toString());
						MediaPlayer mediaPlayer = new MediaPlayer(hit);
						
						mediaPlayer.setVolume(0.025);
						
						if(mediaPlayer.getStatus().equals(Status.PLAYING)) {
							mediaPlayer.stop();
							mediaPlayer.play();
						}
						else {
							mediaPlayer.play();
						}
					}
					
				});
				c = baralho_Stack.getCarta(0);
				morto_Stack.add(c);
				
				aberto = new ImageIcon(getClass().getResource(c.getImagem()));
				btnAberto_Stack.setIcon(aberto);
			}
			
		}
		
	}
	
	//M�todo para chamar a segunda tela (Menu de Baralho)
	public void MenuBaralho(String operacao) {
		TelaSecundaria tela = new TelaSecundaria(operacao);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//Ao inv�s de sair do porgrama ao fechar, apenas fecha a tela em quest�o
		tela.setSize(265, 165);
		tela.setLocationRelativeTo(null);
		tela.setVisible(true);
	}
	
	// M�todo auxiliar para criar as bordas, recebe o t�tulo da borda como par�metro
	public TitledBorder CriaBorda(String titulo) { 
		
		//Borda linha preta
		Border b = BorderFactory.createLineBorder(Color.black);	
		
		//Borda linha preta com o t�tulo definido
		TitledBorder b2 = BorderFactory.createTitledBorder(b,titulo); 
		
		// T�tulo no centro da borda
		b2.setTitleJustification(TitledBorder.CENTER);
		
		// Retorna a borda constru�da
		return b2;
	}
	
	//Classe auxiliar para chamada da segunda tela
	private class TelaSecundaria extends JFrame implements ItemListener, ActionListener{
		private static final long serialVersionUID = 1L;
		
		//Declara��o das CheckBoxes
		JCheckBox Array, Lista, Vector, Stack, SelecionarTudo;
		
		//Vari�veis de controle do estado das CheckBoxes
		boolean check_Array, check_Lista, check_Vector, check_Stack;
		
		//Bot�o de confirma��o
		JButton Confirma;
		
		//Qual opera��o vai ser realizada (Criar, Embaralhar, Zerar e Exibir)
		String operacao = "";
		
		public TelaSecundaria(String operacao) { //Opera��o desejada � passada por par�metro ao construtor
			super.setTitle("Menu Baralhos");
			setLayout(new GridLayout(6,1));
			
			//Inicializando as vari�veis de checkagem como falsa, e guardando a opera��o pedida
			this.operacao = operacao;
			check_Array = check_Lista = check_Vector = check_Stack = false;
			
			//Inicializando as CheckBoxes e o Bot�o
			SelecionarTudo = new JCheckBox("Selecionar Tudo");
			Array = new JCheckBox("Array - ArrayList");
			Lista = new JCheckBox("Lista Encadeada - LinkedList");
			Vector = new JCheckBox("Vector - Vetor Sincronizado");
			Stack = new JCheckBox("Pilha - Stack");
			Confirma = new JButton("Confirma");
			
			//Adiciona Item Listener nas CheckBoxes (objetivo = ver quais mudaram e pra qual estado mudaram)
			SelecionarTudo.addItemListener(this);
			Array.addItemListener(this);
			Lista.addItemListener(this);
			Vector.addItemListener(this);
			Stack.addItemListener(this);
			
			//Adiciona Action Listener no bot�o para checar se foi clicado ou n�o
			Confirma.addActionListener(this);
			
			//Adiciona as CheckBoxes e o Bot�o ao layout
			add(SelecionarTudo);
			add(Stack);
			add(Lista);
			add(Array);
			add(Vector);
			add(Confirma);
		}
		
		

		//M�todo chamado quando o estado de qualquer CheckBox � alterado
		@Override
		public void itemStateChanged(ItemEvent e) {
			
			//Se a CheckBox "SelecionarTudo" foi alterada
			if(e.getItemSelectable() == SelecionarTudo) {
				//Se foi alterada pra 1 (verdadeiro / foi marcada)
				if(e.getStateChange()==1) {
					//Todas as vari�veis controle das CheckBoxes se tornam verdadeiras
					check_Array = check_Lista = check_Vector = check_Stack = true; 
					
					//Marca as outras CheckBoxes (este m�todo n�o aciona nenhuma atividade)
					Array.setSelected(true);
					Lista.setSelected(true);
					Vector.setSelected(true);
					Stack.setSelected(true);
				}
				//Se foi alterada para 0 (falso / foi desmarcada)
				else { 
					//Todas as vari�veis controle das CheckBoxes se tornam falsas
					check_Array = check_Lista = check_Vector = check_Stack = false;
					
					//Desmarca todas as outras CheckBoxes
					Array.setSelected(false);
					Lista.setSelected(false);
					Vector.setSelected(false);
					Stack.setSelected(false);
				}
			}
			
			//Se a CheckBox "Array" foi alterada
			if(e.getItemSelectable() == Array) {
				//Se foi marcada
				if(e.getStateChange()== 1) {
					//vari�vel controle verdadeira
					check_Array = true;
				}
				//Se foi desmarcada
				else {
					//vari�vel controle falsa
					check_Array = false;
				}
			}
			
			if(e.getItemSelectable() == Lista) {
				if(e.getStateChange()== 1) {
					check_Lista = true;
				}
				else {
					check_Lista = false;
				}
			}
			
			if(e.getItemSelectable() == Vector) {
				if(e.getStateChange()== 1) {
					check_Vector = true;
				}
				else {
					check_Vector = false;
				}
			}
			
			if(e.getItemSelectable() == Stack) {
				if(e.getStateChange()== 1) {
					check_Stack = true;
				}
				else {
					check_Stack = false;
				}
			}
		}
		
		//M�todo chamado quando o Bot�o � apertado
		@Override
		public void actionPerformed(ActionEvent b) {
			//Se o bot�o "Confirma" for apertado
			if(b.getSource() == Confirma) {
				//Torna a janela invisivel
				super.setVisible(false);
				//Chama o m�todo que realizar� a opera��o pedida
				Operacao();
				//Depois fecha a janela (voltando pra janela principal)
				super.dispose();
			}
			
		}
		
		//M�todo que realiza a opera��o solicitada
		@SuppressWarnings("deprecation")
		public void Operacao() {
			

			//Caso n�o tenha sido selecionada nenhuma CheckBox
			if(!(check_Array || check_Lista || check_Vector || check_Stack)) {
				JOptionPane.showMessageDialog(null, ".... Opera��o n�o foi realizada em nenhum baralho ....");
				return;
			}
			
			//If's e Else's para checar qual a opera��o solicitada
			
			//Se a opera��o for "Criar Baralho"
			if(this.operacao.equals("Cria")) {
				
				//Cria um novo baralho (ordenado) para todas as op��es escolhidas nas CheckBoxes
				
				if(check_Stack) {
					baralho_Stack.zeraBaralho();
					baralho_Stack = new Baralho('s');
					btnFechado_Stack.setIcon(fechado);
					btnAberto_Stack.setIcon(vazio);
					btnFechado_Stack.enable();
					morto_Stack.clear();
				}
				
				if(check_Lista) {
					baralho_Lista.zeraBaralho();
					baralho_Lista = new Baralho('l');
					btnFechado_Lista.setIcon(fechado);
					btnAberto_Lista.setIcon(vazio);
					btnFechado_Lista.enable();
					morto_Lista.clear();
				}
				
				if(check_Array) {
					baralho_Array.zeraBaralho();
					baralho_Array = new Baralho('a');
					btnFechado_Array.setIcon(fechado);
					btnAberto_Array.setIcon(vazio);
					btnFechado_Array.enable();
					morto_Array.clear();
				}
					
				if(check_Vector) {
					baralho_Vector.zeraBaralho();
					baralho_Vector = new Baralho('v');
					btnFechado_Vector.setIcon(fechado);
					btnAberto_Vector.setIcon(vazio);
					btnFechado_Vector.enable();
					morto_Vector.clear();
				}
				
			} //fim if "Cria
			
			//Se a opera��o solicitada for "Exibir"
			else if(this.operacao.equals("Exibe")) {
				
				//Exibe todos os baralhos selecionados nas CheckBoxes
				String saida = "";
			
				if(check_Stack) {
					if(baralho_Stack.getBaralhoStack().isEmpty()) {
						saida = "-----------/ Baralho - Pilha vazio /-----------";
						JOptionPane.showConfirmDialog(null, saida, "Baralho",-1);
					}
					else {
						saida = baralho_Stack.toString();
						JOptionPane.showConfirmDialog(null, saida, "Baralho",-1);
					}
				}
				
				
				if(check_Lista) {
					if(baralho_Lista.getBaralhoLista().isEmpty()) {
						saida = "-----------/ Baralho - Lista vazio /-----------";
						JOptionPane.showConfirmDialog(null, saida, "Baralho",-1);
					}
					else {
						saida = baralho_Lista.toString();
						JOptionPane.showConfirmDialog(null, saida, "Baralho",-1);
					}
				}

				if(check_Array) {
					if(baralho_Array.getBaralhoArray().isEmpty()) {
						saida = "-----------/ Baralho - Array vazio /-----------";
						JOptionPane.showConfirmDialog(null, saida, "Baralho",-1);
					}
					else {
						saida = baralho_Array.toString();
						JOptionPane.showConfirmDialog(null, saida, "Baralho",-1);
					}
				}
				
				if(check_Vector) {
					if(baralho_Vector.getBaralhoVector().isEmpty()) {
						saida = "-----------/ Baralho - Vector vazio /-----------";
						JOptionPane.showConfirmDialog(null, saida, "Baralho",-1);
					}
					else {
						saida = baralho_Vector.toString();
						JOptionPane.showConfirmDialog(null, saida, "Baralho",-1);
					}
				}
				
				
			} //fim else if "Exibe"
			
			//Se a op��o solicitada for "Zerar Baralhos"
			else if(this.operacao.equals("Zerar")) {
				
				//Zera todos os baralhos selecionados nas CheckBoxes
				
				if(check_Stack) {
					baralho_Stack.zeraBaralho();
					btnFechado_Stack.setIcon(vazio);
					btnAberto_Stack.setIcon(vazio);
				}
				
				if(check_Lista) {
					baralho_Lista.zeraBaralho();
					btnFechado_Lista.setIcon(vazio);
					btnAberto_Lista.setIcon(vazio);
				}

				if(check_Array) {
					baralho_Array.zeraBaralho();
					btnFechado_Array.setIcon(vazio);
					btnAberto_Array.setIcon(vazio);
				}
				
				if(check_Vector) {
					baralho_Vector.zeraBaralho();
					btnFechado_Vector.setIcon(vazio);
					btnAberto_Vector.setIcon(vazio);
				}
				
				
			} // fim else if "Zera Tudo"
			
			//Se a opera��o solicitada for "Embaralha"
			else if(this.operacao.equals("Embaralha")) {
				
				//Embaralha todos os baralhos selecionados nas CheckBoxes
				
				if(check_Stack) {
					baralho_Stack.embaralha();
				}
				
				if(check_Lista) {
					baralho_Lista.embaralha();
				}

				if(check_Array) {
					baralho_Array.embaralha();
				}
				
				if(check_Vector) {
					baralho_Vector.embaralha();
				}
				
			
			} // fim else if "Embaralha"
			
			else if(this.operacao.equals("Morto")) {

				if(check_Stack) {
					ExibeMorto(morto_Stack,"Morto - Pilha");
				}
				
				if(check_Lista) {
					ExibeMorto(morto_Lista,"Morto - Lista");
				}
				

				if(check_Array) {
					ExibeMorto(morto_Array,"Morto - Array");
				}
				
				if(check_Vector) {
					ExibeMorto(morto_Vector,"Morto - Vector");
				}
				
			}
			
		}
		
		//M�todo Auxiliar para a exibi��o do morto desejado
		private void ExibeMorto(List<Carta> morto, String nome) {
			if(morto.isEmpty()) {
				JOptionPane.showMessageDialog(null,".... " + nome + " vazio .....");
				return;
			}
			
			String saida = "------------/ "+ nome + " /------------\n\n";
			for(Carta c: morto) {
				saida += c.toString() + "\n";
			}
			JOptionPane.showConfirmDialog(null, saida, null, -1);
		}
		
	}

	//M�todo main
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Jogo tela = new Jogo();
		tela.setCursor(Cursor.HAND_CURSOR);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setVisible(true);
		tela.pack();
		tela.setLocationRelativeTo(null);
		
	}
	
}
