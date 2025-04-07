import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.Border;

public class MenuInicial extends JFrame{

    ImageIcon logo = new ImageIcon("LogoMenuInicial.png");
    Border BorderRaised = BorderFactory.createRaisedSoftBevelBorder();
    Border BorderLowered = BorderFactory.createLoweredBevelBorder();
    Font FontePadrao = new Font("New Courier", Font.BOLD, 16);
    Color CorBotoesMenuInicial = new Color(230, 230, 230);
    Color CorPadraoEscura = new Color(150, 150, 150);

    JButton BotaoIniciar = new JButton();
    JButton BotaoSair = new JButton();
    JFrame MenuInicialFrame = new JFrame();

    MenuInicial() {

        JLabel LabelIconeInicial = new JLabel();
        LabelIconeInicial.setBounds(20, 0, 300, 300);
        LabelIconeInicial.setIcon(logo);

        BotaoIniciar.setText("Iniciar Jogo");
        BotaoIniciar.setBackground(CorBotoesMenuInicial);
        BotaoIniciar.setBounds(70, 100, 200, 60);
        BotaoIniciar.setFocusable(false);
        BotaoIniciar.setBorder(BorderRaised);
        BotaoIniciar.setFont(FontePadrao);

        BotaoSair.setText("Sair");
        BotaoSair.setBackground(CorBotoesMenuInicial);
        BotaoSair.setBounds(70, 170, 200, 60);
        BotaoSair.setFocusable(false);
        BotaoSair.setBorder(BorderRaised);
        BotaoSair.setFont(FontePadrao);

        JLayeredPane PanelInicial = new JLayeredPane();
        PanelInicial.setBackground(Color.black);
        PanelInicial.setOpaque(true);
        PanelInicial.add(BotaoIniciar);
        PanelInicial.add(BotaoSair);
        PanelInicial.add(LabelIconeInicial);

        MenuInicialFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        MenuInicialFrame.setTitle(null);
        MenuInicialFrame.setIconImage(logo.getImage());
        MenuInicialFrame.setResizable(false);
        MenuInicialFrame.setSize(350, 350);
        MenuInicialFrame.setLocationRelativeTo(null);
        MenuInicialFrame.setLayout(new GridLayout());
        MenuInicialFrame.add(PanelInicial);
        MenuInicialFrame.setVisible(true);
    }

}
