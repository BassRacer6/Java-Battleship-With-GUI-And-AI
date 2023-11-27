import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class MenuJogo extends JFrame{
    ImageIcon logo = new ImageIcon("logo.jpg");
    ImageIcon confirmar = new ImageIcon("confirmar.png");
    ImageIcon reiniciar = new ImageIcon("reiniciar.png");

    Color CorMar = new Color(150,200,200);
    Color CorDesconhecido = new Color(64,84,136);
    Border BorderRaised = BorderFactory.createRaisedSoftBevelBorder();
    Border BorderLowered = BorderFactory.createLoweredSoftBevelBorder();
    Border BorderGreen = BorderFactory.createLineBorder(new Color(50,150,50),4);
    Color corPadraoClara = new Color(210, 230, 230);
    Color corPadraoEscura = new Color(190, 210, 210);

    JButton[] ButtonsJogador = new JButton[50];
    JButton[] ButtonsMaquina = new JButton[49];

    JLabel LabelInstrucoes = new JLabel();
    JButton ButtonConfirmar = new JButton();
    JButton ButtonReiniciar = new JButton();

    MenuJogo(){

        JLabel CoordenadaNumMaquina = new JLabel();
        CoordenadaNumMaquina.setText("     1   2   3   4   5   6   7");
        CoordenadaNumMaquina.setFont(new Font("New Courier", Font.BOLD,26));

        JLabel CoordenadaLetraMaquina = new JLabel();
        CoordenadaLetraMaquina.setText("<html>A<p>B<p>C<p>D<p>E<p>F<p>G");
        CoordenadaLetraMaquina.setFont(new Font("New Courier", Font.BOLD,26));

        JLabel CoordenadaNumJogador = new JLabel();
        CoordenadaNumJogador.setText("     1   2   3   4   5   6   7");
        CoordenadaNumJogador.setFont(new Font("New Courier", Font.BOLD,26));

        JLabel CoordenadaLetraJogador = new JLabel();
        CoordenadaLetraJogador.setText("<html>A<p>B<p>C<p>D<p>E<p>F<p>G");
        CoordenadaLetraJogador.setFont(new Font("New Courier", Font.BOLD,26));

        JPanel MatrizMaquina = new JPanel();
        MatrizMaquina.setLayout(new GridLayout(7,7));
        for(int i=0; i<=48; i++){
			ButtonsMaquina[i] = new JButton();
			MatrizMaquina.add(ButtonsMaquina[i]);
			ButtonsMaquina[i].setFocusable(false);
            ButtonsMaquina[i].setBorder(BorderLowered);
            ButtonsMaquina[i].setEnabled(false);
            ButtonsMaquina[i].setBackground(CorDesconhecido);
            ButtonsMaquina[i].setFont(new Font("New Courier", Font.BOLD,13));
            ButtonsMaquina[i].setFont(new Font("New Courier", Font.BOLD,8));
		}
        JPanel TabuleiroMaquina = new JPanel();
        TabuleiroMaquina.setLayout(new BorderLayout());
        TabuleiroMaquina.setBackground(corPadraoClara);
        TabuleiroMaquina.setBorder(BorderRaised);
        TabuleiroMaquina.setBounds(295,5, 280,280);
        TabuleiroMaquina.add(CoordenadaNumMaquina, BorderLayout.NORTH);
        TabuleiroMaquina.add(CoordenadaLetraMaquina, BorderLayout.WEST);
        TabuleiroMaquina.add(MatrizMaquina, BorderLayout.CENTER);

        LabelInstrucoes.setText("Coloque seus navios.");
        LabelInstrucoes.setBounds(5,5,180,50);
        LabelInstrucoes.setOpaque(true);
        LabelInstrucoes.setBackground(corPadraoClara);
        LabelInstrucoes.setFont(new Font("New Courier", Font.BOLD,16));

        ButtonConfirmar.setText("Confirmar");
        ButtonConfirmar.setBackground(corPadraoClara);
        ButtonConfirmar.setBounds(200,5,70,50);
        ButtonConfirmar.setFocusable(false);
        ButtonConfirmar.setBorder(BorderLowered);
        ButtonConfirmar.setVisible(false);

        ButtonReiniciar.setText("Reiniciar");
        ButtonReiniciar.setBackground(corPadraoClara);
        ButtonReiniciar.setBounds(280,5,60,50);
        ButtonReiniciar.setFocusable(false);
        ButtonReiniciar.setBorder(BorderLowered);
        ButtonReiniciar.setVisible(false);

        
        JPanel PanelInstrucoesColocarNavios = new JPanel();
        PanelInstrucoesColocarNavios.setOpaque(true);
        PanelInstrucoesColocarNavios.setBackground(corPadraoEscura);
        PanelInstrucoesColocarNavios.setBounds(100,5, 355,60);
        PanelInstrucoesColocarNavios.setLayout(null);
        PanelInstrucoesColocarNavios.add(LabelInstrucoes);
        PanelInstrucoesColocarNavios.add(ButtonConfirmar);
        PanelInstrucoesColocarNavios.add(ButtonReiniciar);

        JPanel PanelInstrucoes = new JPanel();
        PanelInstrucoes.setBounds(0,0, 600,70);
        PanelInstrucoes.setOpaque(true);
        PanelInstrucoes.setBackground(corPadraoClara);
        PanelInstrucoes.setLayout(null);
        PanelInstrucoes.add(PanelInstrucoesColocarNavios);

        JPanel MatrizJogador = new JPanel();
        MatrizJogador.setLayout(new GridLayout(7,7));
        for(int i=0; i<=48; i++){
			ButtonsJogador[i] = new JButton();
			MatrizJogador.add(ButtonsJogador[i]);
			ButtonsJogador[i].setFocusable(false);
            ButtonsJogador[i].setBorder(BorderLowered);
            ButtonsJogador[i].setBackground(CorMar);
            ButtonsJogador[i].setFont(new Font("New Courier", Font.BOLD,13));
            ButtonsJogador[i].setFont(new Font("New Courier", Font.BOLD,7));
		}

        JPanel TabuleiroJogador = new JPanel();
        TabuleiroJogador.setLayout(new BorderLayout());
        TabuleiroJogador.setBorder(BorderRaised);
        TabuleiroJogador.setBackground(corPadraoClara);
        TabuleiroJogador.setBounds(5,5, 280,280);
        TabuleiroJogador.add(CoordenadaNumJogador, BorderLayout.NORTH);
        TabuleiroJogador.add(CoordenadaLetraJogador, BorderLayout.WEST);
        TabuleiroJogador.add(MatrizJogador, BorderLayout.CENTER);

        JPanel Tabuleiros = new JPanel();
        Tabuleiros.setLayout(null);
        Tabuleiros.setBounds(0,70,585,295);
        Tabuleiros.setBackground(corPadraoEscura);
        Tabuleiros.add(TabuleiroJogador);
        Tabuleiros.add(TabuleiroMaquina);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Batalha Naval");
        this.setIconImage(logo.getImage());
        this.setResizable(false);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.add(PanelInstrucoes);
        this.add(Tabuleiros);
        this.setVisible(true);
    }
}
