import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IniciarAtaque extends AtaqueDaMaquina{
    //=======================================================================================
    IniciarAtaque(){
        ButtonConfirmar.addActionListener(ComecarAtaqueListener);
    }
    //=======================================================================================
    ActionListener ComecarAtaqueListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e3) {
            LabelFeitosJogador.setText("Ataque o inimigo.");
            LabelFeitosMaquina.setText(null);
            ButtonConfirmar.setVisible(false);
            ButtonReiniciar.setVisible(false);
            LabelRodadaCounter.setVisible(true);
            for (int j = 0; j <= 48; j++) {
                ButtonsMaquina[j].addActionListener(ReceberAtaqueListener);
                ButtonsJogador[j].removeActionListener(ColocarNaviosJogadorListener);
                ButtonsMaquina[j].addActionListener(AtacarNaviosDaMaquinaListener);
            }
        }
    };
}
