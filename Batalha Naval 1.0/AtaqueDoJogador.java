import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AtaqueDoJogador extends ColocarNaviosMaquina {

    ImageIcon BlocoAtiradoAcerto = new ImageIcon("Acerto.png");
    ImageIcon BlocoAtiradoErro = new ImageIcon("Erro.png");

    int QuantAcertosJogador = 0;
    int Rodada = 1;

    ActionListener AtacarNaviosDaMaquinaListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e2) {
            for (int i = 0; i <= 48; i++) {
                if (e2.getSource() == ButtonsMaquina[i]) {
                    if (i == PrimeiraColocadaMaquina1 || i == SegundaColocadaMaquina1 ||
                            i == TerceiraColocadaMaquina1 || i == PrimeiraColocadaMaquina2 ||
                            i == SegundaColocadaMaquina2 || i == TerceiraColocadaMaquina2 ||
                            i == PrimeiraColocadaMaquina3 || i == SegundaColocadaMaquina3 ||
                            i == TerceiraColocadaMaquina3) {
                        ButtonsMaquina[i].setIcon(BlocoAtiradoAcerto);
                        LabelFeitosJogador.setText("Você acertou!");
                        ButtonsMaquina[i].removeActionListener(AtacarNaviosDaMaquinaListener);
                        QuantAcertosJogador++;
                        if (QuantAcertosJogador == 9) {
                            JOptionPane.showMessageDialog(null, "Você ganhou!", "Vitória", JOptionPane.PLAIN_MESSAGE);
                            menuPrincipal.MenuInicialFrame.setVisible(true);
                            MenuJogoFrame.setVisible(false);
                        }
                        //=======================================================================================
                    } else {
                        ButtonsMaquina[i].setIcon(BlocoAtiradoErro);
                        LabelFeitosJogador.setText("Você errou!");
                        ButtonsMaquina[i].removeActionListener(AtacarNaviosDaMaquinaListener);
                    }
                    Rodada++;
                    LabelRodadaCounter.setText("Rodada: " + Rodada);
                }
            }
        }
    };
}
