import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AtacarNavios extends ColocarNaviosMaquina{

    int QuantAcertosJogador = 0;
    int QuantAcertosMaquina = 0;
    int CoordTiroMaquina;
    ImageIcon BlocoAtiradoAcerto = new ImageIcon("Acerto.png");
    ImageIcon BlocoAtiradoErro = new ImageIcon("Erro.png");

    int [] PossiveisTirosMaquina = new int[49];

    AtacarNavios(){

        for (int i = 0; i <= 48; i++){
            ButtonsMaquina[i].addActionListener(AtacarNaviosDaMaquinaListener);
            PossiveisTirosMaquina[i] = i;
        }
        ButtonConfirmar.addActionListener(ComecarAtaqueListener);
    }

    ActionListener AtacarNaviosDaMaquinaListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e2){
            for (int i = 0; i <= 48; i++) {
                if (e2.getSource() == ButtonsMaquina[i]){
                    if(i == PrimeiraColocadaMaquina1 || i == SegundaColocadaMaquina1 ||
                     i == TerceiraColocadaMaquina1 || i == PrimeiraColocadaMaquina2 ||
                     i == SegundaColocadaMaquina2 || i == TerceiraColocadaMaquina2 ||
                     i == PrimeiraColocadaMaquina3 || i == SegundaColocadaMaquina3 ||
                     i == TerceiraColocadaMaquina3){
                        ButtonsMaquina[i].setIcon(BlocoAtiradoAcerto);
                        LabelInstrucoes.setText("Você acertou!");
                        ButtonsMaquina[i].removeActionListener(AtacarNaviosDaMaquinaListener);
                        QuantAcertosJogador++;
                        if(QuantAcertosJogador == 9){
                            JOptionPane.showMessageDialog(null, "Você ganhou!", "Vitória", JOptionPane.PLAIN_MESSAGE);
                            System.exit(0);
                        }
                    } else {
                        ButtonsMaquina[i].setIcon(BlocoAtiradoErro);
                        LabelInstrucoes.setText("Você errou!");
                        ButtonsMaquina[i].removeActionListener(AtacarNaviosDaMaquinaListener);
                    }

                    //Tiro da máquina ->
                    do{
                    CoordTiroMaquina = random.nextInt(48);
                    }while(PossiveisTirosMaquina[CoordTiroMaquina] < 0);

                        if (CoordTiroMaquina == CoordPrimeiroNavioProa ||
                                CoordTiroMaquina == CoordPrimeiroNavioMeiaNau ||
                                CoordTiroMaquina == CoordPrimeiroNavioPopa ||
                                CoordTiroMaquina == CoordSegundoNavioProa ||
                                CoordTiroMaquina == CoordSegundoNavioMeiaNau ||
                                CoordTiroMaquina == CoordSegundoNavioPopa ||
                                CoordTiroMaquina == CoordTerceiroNavioProa ||
                                CoordTiroMaquina == CoordTerceiroNavioMeiaNau ||
                                CoordTiroMaquina == CoordTerceiroNavioPopa) {
                            ButtonsJogador[CoordTiroMaquina].setIcon(BlocoAtiradoAcerto);
                            LabelInstrucoes.setText("Inimigo acertou!");
                            QuantAcertosMaquina++;
                            if (QuantAcertosMaquina == 9) {
                                JOptionPane.showMessageDialog(null, "Você perdeu!", "Derrota",
                                        JOptionPane.PLAIN_MESSAGE);
                                System.exit(0);
                            }
                        } else {
                            ButtonsJogador[CoordTiroMaquina].setIcon(BlocoAtiradoErro);
                            LabelInstrucoes.setText("Inimigo errou!");
                        }
                        PossiveisTirosMaquina[CoordTiroMaquina] = -49;
                }
            }
        }
    };
    ActionListener ComecarAtaqueListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e3) {
            LabelInstrucoes.setText("Ataque o inimigo.");
            ButtonConfirmar.setVisible(false);
            ButtonReiniciar.setVisible(false);
            for (int j = 0; j <= 48; j++) {
                ButtonsMaquina[j].setEnabled(true);
                ButtonsJogador[j].removeActionListener(ColocarNaviosJogadorListener);
                ButtonsJogador[CoordTiroMaquina].addActionListener(AtacarNaviosDaMaquinaListener);
            }
        }
    };

}
