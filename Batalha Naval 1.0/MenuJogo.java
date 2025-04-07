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

public class MenuJogo extends JFrame {
    ImageIcon logo = new ImageIcon("logo.jpg");
    ImageIcon IconMar = new ImageIcon("Mar Vazio.png");

    Color CorMar = new Color(150,200,200);
    Color CorDesconhecido = new Color(64,84,136);
    Border BorderRaised = BorderFactory.createRaisedSoftBevelBorder();
    Border BorderLowered = BorderFactory.createLoweredBevelBorder();
    Border BorderMatriz = BorderFactory.createLineBorder(new Color(100,100,100),1);
    Border BorderGreen = BorderFactory.createLineBorder(new Color(50,150,50),4);
    Color CorPadraoClara = new Color(200, 200, 200);
    Color CorPadraoEscura = new Color(150, 150, 150);
    Font FontePadrao = new Font("New Courier", Font.BOLD,16);

    JButton[] ButtonsJogador = new JButton[49];
    JButton[] ButtonsMaquina = new JButton[49];

    JLabel LabelFeitosMaquina = new JLabel();
    JLabel LabelFeitosJogador = new JLabel();
    JLabel LabelRodadaCounter = new JLabel();

    JButton ButtonConfirmar = new JButton();
    JButton ButtonReiniciar = new JButton();

    MenuInicial menuPrincipal= new MenuInicial();

    JFrame MenuJogoFrame = new JFrame();

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
            //ButtonsMaquina[i].setBackground(CorDesconhecido);
            ButtonsMaquina[i].setIcon(IconMar);
            ButtonsMaquina[i].setFont(new Font("New Courier", Font.BOLD,8));
		}
        JPanel TabuleiroMaquina = new JPanel();
        TabuleiroMaquina.setLayout(new BorderLayout());
        TabuleiroMaquina.setBackground(CorPadraoClara);
        TabuleiroMaquina.setBorder(BorderRaised);
        TabuleiroMaquina.setBounds(295,5, 280,280);
        TabuleiroMaquina.add(CoordenadaNumMaquina, BorderLayout.NORTH);
        TabuleiroMaquina.add(CoordenadaLetraMaquina, BorderLayout.WEST);
        TabuleiroMaquina.add(MatrizMaquina, BorderLayout.CENTER);

        LabelFeitosMaquina.setText("Coloque seus navios.");
        LabelFeitosMaquina.setVerticalAlignment(JLabel.CENTER);
        LabelFeitosMaquina.setHorizontalAlignment(JLabel.CENTER);
        LabelFeitosMaquina.setBounds(5,5,180,50);
        LabelFeitosMaquina.setOpaque(true);
        LabelFeitosMaquina.setBackground(CorPadraoClara);
        LabelFeitosMaquina.setBorder(BorderRaised);
        LabelFeitosMaquina.setFont(FontePadrao);

        LabelFeitosJogador.setBounds(380,5,180,50);
        LabelFeitosJogador.setVerticalAlignment(JLabel.CENTER);
        LabelFeitosJogador.setHorizontalAlignment(JLabel.CENTER);
        LabelFeitosJogador.setOpaque(true);
        LabelFeitosJogador.setBackground(CorPadraoClara);
        LabelFeitosJogador.setBorder(BorderRaised);
        LabelFeitosJogador.setFont(FontePadrao);

        LabelRodadaCounter.setText("Rodada 1");
        LabelRodadaCounter.setBounds(233,5,100,50);
        LabelRodadaCounter.setVerticalAlignment(JLabel.CENTER);
        LabelRodadaCounter.setHorizontalAlignment(JLabel.CENTER);
        LabelRodadaCounter.setOpaque(true);
        LabelRodadaCounter.setBackground(CorPadraoClara);
        LabelRodadaCounter.setBorder(BorderRaised);
        LabelRodadaCounter.setVisible(false);
        LabelRodadaCounter.setFont(FontePadrao);

        ButtonConfirmar.setText("Confirmar");
        ButtonConfirmar.setBackground(CorPadraoClara);
        ButtonConfirmar.setBounds(210,5,70,50);
        ButtonConfirmar.setFocusable(false);
        ButtonConfirmar.setBorder(BorderRaised);
        ButtonConfirmar.setVisible(false);

        ButtonReiniciar.setText("Reiniciar");
        ButtonReiniciar.setBackground(CorPadraoClara);
        ButtonReiniciar.setBounds(290,5,60,50);
        ButtonReiniciar.setFocusable(false);
        ButtonReiniciar.setBorder(BorderRaised);
        ButtonReiniciar.setVisible(false);

        JPanel PanelInstrucoesInterno = new JPanel();
        PanelInstrucoesInterno.setOpaque(true);
        PanelInstrucoesInterno.setBackground(CorPadraoEscura);
        PanelInstrucoesInterno.setBorder(BorderLowered);
        PanelInstrucoesInterno.setBounds(10,5, 565,60);
        PanelInstrucoesInterno.setLayout(null);
        PanelInstrucoesInterno.add(LabelFeitosJogador);
        PanelInstrucoesInterno.add(LabelFeitosMaquina);
        PanelInstrucoesInterno.add(LabelRodadaCounter);
        PanelInstrucoesInterno.add(ButtonConfirmar);
        PanelInstrucoesInterno.add(ButtonReiniciar);

        JPanel PanelInstrucoesBorda = new JPanel();
        PanelInstrucoesBorda.setBounds(0,0, 600,70);
        PanelInstrucoesBorda.setOpaque(true);
        PanelInstrucoesBorda.setBackground(CorPadraoClara);
        PanelInstrucoesBorda.setLayout(null);
        PanelInstrucoesBorda.add(PanelInstrucoesInterno);

        JPanel MatrizJogador = new JPanel();
        MatrizJogador.setLayout(new GridLayout(7,7));
        for(int i=0; i<=48; i++){
			ButtonsJogador[i] = new JButton();
			MatrizJogador.add(ButtonsJogador[i]);
			ButtonsJogador[i].setFocusable(false);
            ButtonsJogador[i].setBorder(BorderMatriz);
            //ButtonsJogador[i].setBackground(CorMar);
            ButtonsJogador[i].setIcon(IconMar);
            ButtonsJogador[i].setFont(new Font("New Courier", Font.BOLD,13));
            ButtonsJogador[i].setFont(new Font("New Courier", Font.BOLD,7));
		}

        JPanel TabuleiroJogador = new JPanel();
        TabuleiroJogador.setLayout(new BorderLayout());
        TabuleiroJogador.setBorder(BorderRaised);
        TabuleiroJogador.setBackground(CorPadraoClara);
        TabuleiroJogador.setBounds(5,5, 280,280);
        TabuleiroJogador.add(CoordenadaNumJogador, BorderLayout.NORTH);
        TabuleiroJogador.add(CoordenadaLetraJogador, BorderLayout.WEST);
        TabuleiroJogador.add(MatrizJogador, BorderLayout.CENTER);

        JPanel Tabuleiros = new JPanel();
        Tabuleiros.setLayout(null);
        Tabuleiros.setBounds(0,70,585,295);
        Tabuleiros.setBackground(CorPadraoEscura);
        Tabuleiros.add(TabuleiroJogador);
        Tabuleiros.add(TabuleiroMaquina);
        
        MenuJogoFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        MenuJogoFrame.setTitle("Batalha Naval");
        MenuJogoFrame.setIconImage(logo.getImage());
        MenuJogoFrame.setResizable(false);
        MenuJogoFrame.setSize(600,400);
        MenuJogoFrame.setLocationRelativeTo(null);
        MenuJogoFrame.setLayout(null);
        MenuJogoFrame.add(PanelInstrucoesBorda);
        MenuJogoFrame.add(Tabuleiros);
    }
}
