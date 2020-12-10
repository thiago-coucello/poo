import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela extends JFrame {
    private List<Estado> lista = new ArrayList<Estado>();
    private JMenuBar barraPrincipal;
    private JMenu Cadastrar, Relatorios;
    private JMenuItem cadastrarFisica, cadastrarJuridica, cadastrarIPVA, Sair;
    private JMenuItem relatorioFisica, relatorioJuridica, relatorioIPVA, relatorioGeral;
    private JDesktopPane janela;
    private JPanel painelPrincipal, painelBotoes, painelBase;
    private JButton btnInsereF, btnInsereJ, btnInsereI, btnCancela;

    public Tela() {
        super("Exercicio Interface com Menu");
        setLayout(new BorderLayout());
        janela = new JDesktopPane();
        janela.setLayout(new BorderLayout());

        barraPrincipal = new JMenuBar();

        Cadastrar = new JMenu("Cadastrar");
        Relatorios = new JMenu("Relatorios");
        Sair = new JMenuItem("Sair");
        Sair.setMaximumSize(new Dimension(40, 20));

        cadastrarFisica = new JMenuItem("Cadastrar pessoa fisica");
        cadastrarJuridica = new JMenuItem("Cadastrar pessoa jurídica");
        cadastrarIPVA = new JMenuItem("Cadastrar IPVA");

        relatorioFisica = new JMenuItem("Relatorio pessoas físicas");
        relatorioJuridica = new JMenuItem("Relatorio pessoas jurídicas");
        relatorioIPVA = new JMenuItem("Relatorio IPVA");
        relatorioGeral = new JMenuItem("Relatorio Geral");

        Cadastrar.add(cadastrarFisica);
        Cadastrar.add(cadastrarJuridica);
        Cadastrar.add(cadastrarIPVA);

        Relatorios.add(relatorioFisica);
        Relatorios.add(relatorioJuridica);
        Relatorios.add(relatorioIPVA);
        Relatorios.add(relatorioGeral);

        barraPrincipal.add(Cadastrar);
        barraPrincipal.add(Relatorios);
        barraPrincipal.add(Sair);

        setJMenuBar(barraPrincipal);

        btnInsereF = new JButton("Inserir");
        btnInsereJ = new JButton("Inserir");
        btnInsereI = new JButton("Inserir");
        btnCancela = new JButton("Cancelar");

        cadastrarFisica.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();

                painelBotoes = new JPanel(new FlowLayout());

                painelBotoes.add(btnInsereF);
                painelBotoes.add(btnCancela);

                painelBase = Fisica.criarPainel();

                painelPrincipal = new JPanel(new BorderLayout());

                painelPrincipal.add(painelBase, BorderLayout.CENTER);
                painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

                getContentPane().add(painelPrincipal);
                revalidate();
                repaint();
            }

        });

        cadastrarJuridica.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();

                painelBotoes = new JPanel(new FlowLayout());

                painelBotoes.add(btnInsereJ);
                painelBotoes.add(btnCancela);

                painelBase = Juridica.criarPainel();

                painelPrincipal = new JPanel(new BorderLayout());

                painelPrincipal.add(painelBase, BorderLayout.CENTER);
                painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

                getContentPane().add(painelPrincipal);
                revalidate();
                repaint();
            }

        });

        cadastrarIPVA.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();

                painelBotoes = new JPanel(new FlowLayout());

                painelBotoes.add(btnInsereI);
                painelBotoes.add(btnCancela);

                painelBase = IPVA.criarPainel();

                painelPrincipal = new JPanel(new BorderLayout());

                painelPrincipal.add(painelBase, BorderLayout.CENTER);
                painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

                getContentPane().add(painelPrincipal);
                revalidate();
                repaint();

            }

        });

        relatorioFisica.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String saida = "";
                double total = 0;

                for (Estado E : lista) {
                    if (E instanceof Fisica) {
                        saida += E.toString();
                        total += E.arrecadaImposto();
                    }
                }

                if (!saida.isEmpty()) {
                    JOptionPane.showMessageDialog(null, saida + "\n\nTotal de impostos arrecadados: R$ " + total);
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum registro encontrado\n\n");
                }
            }

        });

        relatorioJuridica.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String saida = "";
                double total = 0;

                for (Estado E : lista) {
                    if (E instanceof Juridica) {
                        saida += E.toString();
                        total += E.arrecadaImposto();
                    }
                }

                if (!saida.isEmpty()) {
                    JOptionPane.showMessageDialog(null, saida + "\n\nTotal de impostos arrecadados: R$ " + total);
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum registro encontrado\n\n");
                }
            }

        });

        relatorioIPVA.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String saida = "";
                double total = 0;

                for (Estado E : lista) {
                    if (E instanceof IPVA) {
                        saida += E.toString();
                        total += E.arrecadaImposto();
                    }
                }

                if (!saida.isEmpty()) {
                    JOptionPane.showMessageDialog(null, saida + "\n\nTotal de impostos arrecadados: R$ " + total);
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum registro encontrado\n\n");
                }
            }

        });

        relatorioGeral.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String saida = "";
                double total = 0;

                for (Estado E : lista) {
                    saida += E.toString();
                    total += E.arrecadaImposto();
                }

                if (!saida.isEmpty()) {
                    JOptionPane.showMessageDialog(null, saida + "\n\nTotal de impostos arrecadados: R$ " + total);
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum registro encontrado\n\n");
                }
            }

        });

        btnInsereF.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = Fisica.getNomeContribuinte();
                double renda = Fisica.getRenda();
                String cpf = Fisica.getDado();
                double gastoSaude = Fisica.getGastos1();
                double gastoEducacao = Fisica.getGastos2();

                Fisica f = new Fisica(nome, renda, cpf, gastoSaude, gastoEducacao);
                lista.add(f);

                if (cpf.isBlank() || gastoSaude == -1 || gastoEducacao == -1) {
                    JOptionPane.showMessageDialog(null, "Erro ao inserir pessoa fisica");
                } else {
                    JOptionPane.showMessageDialog(null, "Pessoa fisica inserida com sucesso");
                    Fisica.setDado("");
                    Fisica.setGastos1("");
                    Fisica.setGastos2("");
                    Fisica.setRenda("");
                    Fisica.setNomeContribuinte("");
                    revalidate();
                    repaint();
                }
            }

        });

        btnInsereJ.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = Juridica.getNomeContribuinte();
                double renda = Juridica.getRenda();
                String cgc = Juridica.getDado();
                double gastoPessoal = Juridica.getGastos1();
                double gastoEquipamento = Juridica.getGastos2();

                Juridica j = new Juridica(nome, renda, cgc, gastoPessoal, gastoEquipamento);
                lista.add(j);

                if (cgc.isEmpty() || gastoPessoal == -1 || gastoEquipamento == -1) {
                    JOptionPane.showMessageDialog(null, "Erro ao inserir pessoa juridica");
                } else {
                    JOptionPane.showMessageDialog(null, "Pessoa juridica inserida com sucesso");
                    Juridica.setDado("");
                    Juridica.setGastos1("");
                    Juridica.setGastos2("");
                    Juridica.setRenda("");
                    Juridica.setNomeContribuinte("");
                    revalidate();
                    repaint();
                }
            }

        });

        btnInsereI.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String placa = IPVA.getPlaca();
                char marca = IPVA.getMarca();
                double valor = IPVA.getValor();

                IPVA i = new IPVA(placa, marca, valor);

                lista.add(i);
                if (valor != -1 && !placa.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "IPVA inserido com sucesso");
                    IPVA.setPlaca("");
                    IPVA.setValor("");
                    revalidate();
                    repaint();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao inserir IPVA");
                }
            }

        });

        btnCancela.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                revalidate();
                repaint();
            }

        });

        Sair.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	fechar();
            }

        });
    }
    
    public void fechar() {
    	this.dispose();
    }

    public static void main(String[] args) {
        Tela tela = new Tela();
        tela.setSize(300, 300);
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
    }
}
