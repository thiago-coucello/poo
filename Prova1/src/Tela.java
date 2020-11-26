import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Tela extends JFrame {

    // Atributos

    private JRadioButton rdMaterial, rdPedreiro, rdMestre;
    private ButtonGroup grupo;
    private JPanel painelPrincipal, painelBase, painelRadio, painelBotoes;
    private JButton btnInsereMaterial, btnInserePedreiro, btnInsereMestre, btnRelatorio;
    private List<Contas> lista = new ArrayList<Contas>();

    // Construtor

    public Tela() {
        super("Prova 1");
        setLayout(new BorderLayout());

        rdMaterial = new JRadioButton("Material de Construção", true);
        rdPedreiro = new JRadioButton("Pedreiro", false);
        rdMestre = new JRadioButton("Mestre de Obras", false);

        grupo = new ButtonGroup();
        grupo.add(rdMaterial);
        grupo.add(rdPedreiro);
        grupo.add(rdMestre);

        painelRadio = new JPanel(new GridLayout(3, 1));
        painelRadio.setBorder(
                BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.lightGray), "Tipo de Conta"));
        painelRadio.add(rdMaterial);
        painelRadio.add(rdPedreiro);
        painelRadio.add(rdMestre);

        painelBase = MaterialDeConstrucao.criarPainel();

        btnInsereMaterial = new JButton("Insere Material de Construção");
        btnInserePedreiro = new JButton("Insere Pedreiro");
        btnInsereMestre = new JButton("Insere Mestre de Obras");
        btnRelatorio = new JButton("Relatório de Contas");

        painelBotoes = new JPanel(new GridLayout(2, 2));
        painelBotoes.add(btnInsereMaterial);
        painelBotoes.add(btnInserePedreiro);
        painelBotoes.add(btnInsereMestre);
        painelBotoes.add(btnRelatorio);

        this.add(painelRadio, BorderLayout.NORTH);
        this.add(painelBase, BorderLayout.CENTER);
        this.add(painelBotoes, BorderLayout.SOUTH);

        rdMaterial.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                getContentPane().remove(painelBase);
                painelBase = MaterialDeConstrucao.criarPainel();
                getContentPane().add(painelBase, BorderLayout.CENTER);
                revalidate();
                repaint();
            }

        });

        rdMestre.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                getContentPane().remove(painelBase);
                painelBase = MestreDeObra.criarPainel();
                getContentPane().add(painelBase, BorderLayout.CENTER);
                revalidate();
                repaint();
            }

        });

        rdPedreiro.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                getContentPane().remove(painelBase);
                painelBase = Pedreiro.criarPainel();
                getContentPane().add(painelBase, BorderLayout.CENTER);
                revalidate();
                repaint();
            }

        });

        btnInsereMaterial.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String NomeLoja = MaterialDeConstrucao.getTxtNome();
                String descricao = MaterialDeConstrucao.getTxtDescricao();
                double valor = MaterialDeConstrucao.getTxtValor();
                int dia = MaterialDeConstrucao.getDia();
                int mes = MaterialDeConstrucao.getMes();
                int ano = MaterialDeConstrucao.getAno();

                if (NomeLoja.isEmpty() || descricao.isEmpty() || valor == -1 || dia == -1 || mes == -1 || ano == -1) {
                    JOptionPane.showMessageDialog(null, "Erro ao inserir conta de Materiais de Construção");
                } else {
                    tipoData data = new tipoData(dia, mes, ano);

                    MaterialDeConstrucao mc = new MaterialDeConstrucao(NomeLoja, descricao, valor, data);
                    lista.add(mc);
                    JOptionPane.showMessageDialog(null, "Conta de Material de Construção inserida com sucesso");
                    MaterialDeConstrucao.limparCampos();
                }
            }

        });

        btnInserePedreiro.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = Pedreiro.getTxtNome();
                String cpf = Pedreiro.getTxtCPF();
                double diaria = Pedreiro.getTxtDiaria();
                int diaP = Pedreiro.getDiaPagto();
                int mesP = Pedreiro.getMesPagto();
                int diaI = Pedreiro.getDiaInicio();
                int mesI = Pedreiro.getMesInicio();
                int diaF = Pedreiro.getDiaFim();
                int mesF = Pedreiro.getMesFim();

                tipoData dataPagto = new tipoData(diaP, mesP, 0);
                tipoData datai = new tipoData(diaI, mesI, 0);
                tipoData dataf = new tipoData(diaF, mesF, 0);

                if (nome.isEmpty() || cpf.isEmpty() || diaP == -1 || mesP == -1 || diaI == -1 || mesI == -1
                        || diaF == -1 || mesF == -1) {
                    JOptionPane.showMessageDialog(null, "Erro ao inserir conta de Pedreiro");
                } else {
                    Pedreiro p = new Pedreiro(nome, cpf, dataPagto, datai, dataf, diaria);
                    lista.add(p);
                    JOptionPane.showMessageDialog(null, "Conta de Pedreiro inserida com sucesso");
                }
            }

        });

        btnInsereMestre.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = MestreDeObra.getTxtNome();
                String cpf = MestreDeObra.getTxtCPF();
                double valor = MestreDeObra.getTxtValor();
                int dia = MestreDeObra.getDia();
                int mes = MestreDeObra.getMes();

                tipoData data = new tipoData(dia, mes, 0);

                if (nome.isEmpty() || cpf.isEmpty() || valor == -1 || dia == -1 || mes == -1) {
                    JOptionPane.showMessageDialog(null, "Erro ao inserir conta de Mestre de Obras");
                } else {
                    MestreDeObra m = new MestreDeObra(cpf, nome, data, valor);
                    lista.add(m);
                    JOptionPane.showMessageDialog(null, "Conta de Pedreiro inserida com sucesso");
                }
            }

        });

        btnRelatorio.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String saida = "";

                for (Contas c : lista) {
                    saida += c.toString();
                }

                JOptionPane.showMessageDialog(null, saida);
            }

        });

    }

    public static void main(String[] args) {
        Tela tela = new Tela();
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setSize(600,500);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
    }

}
