import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ColocarNaviosJogador extends MenuJogo{
    Font FonteButtons = new Font("New Courier", Font.BOLD, 14);

    Color CorNavioProa = new Color(100, 100, 100);
    Color CorNavioMeiaNau = new Color(70, 70, 70);
    Color CorNavioPopa = new Color(50, 50, 50);

    // IconSubmarinoProa = new ImageIcon("NavioProa.png");
    //ImageIcon IconSubmarinoMeiaNau = new ImageIcon("NavioMeiaNau.png");
    //ImageIcon IconSubmarinoPopa = new ImageIcon("NavioPopa.png");

    int PrimeiroBlocoNavio; //Atualizazação coordenada 1 colocada -> 2 colocada
    int SegundoBlocoNavio; ////Atualizazação coordenada 2 colocada -> 3 colocada
    int k = 1; //Contador do bloco do submarino
    int m = 0; //Contador da quantidade de submarinos
    int CoordPrimeiroNavioProa;
    int CoordPrimeiroNavioMeiaNau;
    int CoordPrimeiroNavioPopa;
    int CoordSegundoNavioProa;
    int CoordSegundoNavioMeiaNau;
    int CoordSegundoNavioPopa;
    int CoordTerceiroNavioProa;
    int CoordTerceiroNavioMeiaNau;
    int CoordTerceiroNavioPopa;

    ArrayList<Integer> CoordsPrimeiroNavioJogador = new ArrayList<>();
    ArrayList<Integer> CoordsSegundoNavioJogador = new ArrayList<>();
    ArrayList<Integer> CoordsTerceiroNavioJogador = new ArrayList<>();
    ArrayList<Integer> CoordsTodosNavioJogador = new ArrayList<>();

    ColocarNaviosJogador(){
        for (int i = 0; i <= 48; i++) {
            ButtonsJogador[i].addActionListener(ColocarNaviosJogadorListener);
            ButtonsJogador[i].addActionListener(e -> m++);
        }
        ButtonReiniciar.addActionListener(PanelInstrucoesButtonsListener);
        ButtonConfirmar.addActionListener(PanelInstrucoesButtonsListener);
    }

    ActionListener ColocarNaviosJogadorListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e1) {
            // Para k = 1 -> Segunda colocada do submarino atual
            // Para k = 2 -> Terceira e última colocada do submarino atual(primeira vem do
            // primeiro clique do jogador na Matriz)
            // Para m = 1 -> Fase de colocação do primeiro navio
            // Para m = 2 -> Fase de colocação do segundo navio
            // Para m = 3 -> Fase de colocação do terceiro navio
            if (m <= 9) {
                if (k == 1) {
                    for (int i = 0; i <= 48; i++) {
                        if (e1.getSource() == ButtonsJogador[i]) {
                            for (int j = 0; j <= 48; j++) {
                                ButtonsJogador[j].setEnabled(false);
                            }
                            ButtonsJogador[i].setText(null);
                            ButtonsJogador[i].setBackground(CorNavioProa);
                            //ButtonsJogador[i].setIcon(IconSubmarinoProa);

                            if (i >= 7 && i <= 41) {
                                if (i % 7 == 0) {
                                    ButtonsJogador[i + 1].setEnabled(true);
                                    ButtonsJogador[i + 7].setEnabled(true);
                                    ButtonsJogador[i - 7].setEnabled(true);
                                    ButtonsJogador[i + 1].setBorder(BorderGreen);
                                    ButtonsJogador[i + 7].setBorder(BorderGreen);
                                    ButtonsJogador[i - 7].setBorder(BorderGreen);
                                } else if ((i+1) % 7  == 0) {
                                    ButtonsJogador[i - 1].setEnabled(true);
                                    ButtonsJogador[i + 7].setEnabled(true);
                                    ButtonsJogador[i - 7].setEnabled(true);
                                    ButtonsJogador[i - 1].setBorder(BorderGreen);
                                    ButtonsJogador[i + 7].setBorder(BorderGreen);
                                    ButtonsJogador[i - 7].setBorder(BorderGreen);
                                } else {
                                    ButtonsJogador[i + 1].setEnabled(true);
                                    ButtonsJogador[i - 1].setEnabled(true);
                                    ButtonsJogador[i + 7].setEnabled(true);
                                    ButtonsJogador[i - 7].setEnabled(true);
                                    ButtonsJogador[i + 1].setBorder(BorderGreen);
                                    ButtonsJogador[i - 1].setBorder(BorderGreen);
                                    ButtonsJogador[i + 7].setBorder(BorderGreen);
                                    ButtonsJogador[i - 7].setBorder(BorderGreen);
                                }
                            } else if (i >= 1 && i <= 5) {
                                ButtonsJogador[i + 1].setEnabled(true);
                                ButtonsJogador[i - 1].setEnabled(true);
                                ButtonsJogador[i + 7].setEnabled(true);
                                ButtonsJogador[i + 1].setBorder(BorderGreen);
                                ButtonsJogador[i - 1].setBorder(BorderGreen);
                                ButtonsJogador[i + 7].setBorder(BorderGreen);
                            } else if (i >= 43 && i <= 47) {
                                ButtonsJogador[i + 1].setEnabled(true);
                                ButtonsJogador[i - 1].setEnabled(true);
                                ButtonsJogador[i - 7].setEnabled(true);
                                ButtonsJogador[i + 1].setBorder(BorderGreen);
                                ButtonsJogador[i - 1].setBorder(BorderGreen);
                                ButtonsJogador[i - 7].setBorder(BorderGreen);
                            } else if (i == 0) {
                                ButtonsJogador[i + 1].setEnabled(true);
                                ButtonsJogador[i + 7].setEnabled(true);
                                ButtonsJogador[i + 1].setBorder(BorderGreen);
                                ButtonsJogador[i + 7].setBorder(BorderGreen);
                            } else if (i == 6) {
                                ButtonsJogador[i - 1].setEnabled(true);
                                ButtonsJogador[i + 7].setEnabled(true);
                                ButtonsJogador[i - 1].setBorder(BorderGreen);
                                ButtonsJogador[i + 7].setBorder(BorderGreen);
                            } else if (i == 42) {
                                ButtonsJogador[i + 1].setEnabled(true);
                                ButtonsJogador[i - 7].setEnabled(true);
                                ButtonsJogador[i + 1].setBorder(BorderGreen);
                                ButtonsJogador[i - 7].setBorder(BorderGreen);
                            } else if (i == 48) {
                                ButtonsJogador[i - 1].setEnabled(true);
                                ButtonsJogador[i - 7].setEnabled(true);
                                ButtonsJogador[i - 1].setBorder(BorderGreen);
                                ButtonsJogador[i - 7].setBorder(BorderGreen);
                            }
                            PrimeiroBlocoNavio = i;
                            if(m > 3){
                            ButtonsJogador[CoordPrimeiroNavioProa].setEnabled(false);
                            ButtonsJogador[CoordPrimeiroNavioMeiaNau].setEnabled(false);
                            ButtonsJogador[CoordPrimeiroNavioPopa].setEnabled(false);
                            ButtonsJogador[CoordPrimeiroNavioProa].setBorder(BorderLowered);
                            ButtonsJogador[CoordPrimeiroNavioMeiaNau].setBorder(BorderLowered);
                            ButtonsJogador[CoordPrimeiroNavioPopa].setBorder(BorderLowered);
                            }
                            if(m > 6){
                            ButtonsJogador[CoordSegundoNavioProa].setEnabled(false);
                            ButtonsJogador[CoordSegundoNavioMeiaNau].setEnabled(false);
                            ButtonsJogador[CoordSegundoNavioPopa].setEnabled(false);
                            ButtonsJogador[CoordSegundoNavioProa].setBorder(BorderLowered);
                            ButtonsJogador[CoordSegundoNavioMeiaNau].setBorder(BorderLowered);
                            ButtonsJogador[CoordSegundoNavioPopa].setBorder(BorderLowered);
                            }
                        }
                    }
                    k++;
                }
                // Segunda(?) colocada do navio atual. ->
                else if (k == 2){
                    for (int i = 0; i <= 48; i++) {
                        if (e1.getSource() == ButtonsJogador[i]){
                            for (int j = 0; j <= 48; j++) {
                                ButtonsJogador[j].setEnabled(false);
                                ButtonsJogador[j].setBorder(BorderLowered);
                            }
                            ButtonsJogador[i].setText(null);
                            //---------------------------------------------------------------------------------
                            ButtonsJogador[i].setBackground(CorNavioMeiaNau);
                            //ButtonsJogador[i].setIcon(IconSubmarinoMeiaNau);
                            //---------------------------------------------------------------------------------
                            if (i == (PrimeiroBlocoNavio - 7)) {
                                if(i >= 0 && i <= 6){
                                ButtonsJogador[i + 14].setEnabled(true);
                                ButtonsJogador[i + 14].setBorder(BorderGreen);
                                } else if(i >= 35 && i <= 41){
                                    ButtonsJogador[i - 7].setEnabled(true);
                                    ButtonsJogador[i - 7].setBorder(BorderGreen);
                                } else{
                                    ButtonsJogador[i - 7].setEnabled(true);
                                    ButtonsJogador[i + 14].setEnabled(true);
                                    ButtonsJogador[i - 7].setBorder(BorderGreen);
                                    ButtonsJogador[i + 14].setBorder(BorderGreen);
                                }
                            } else if (i == (PrimeiroBlocoNavio + 7)) {
                                if(i >= 7 && i <= 13){
                                ButtonsJogador[i + 7].setEnabled(true);
                                ButtonsJogador[i + 7].setBorder(BorderGreen);
                                } else if(i >= 42 && i <= 48){
                                    ButtonsJogador[i - 14].setEnabled(true);
                                    ButtonsJogador[i - 14].setBorder(BorderGreen);
                                } else{
                                    ButtonsJogador[i + 7].setEnabled(true);
                                    ButtonsJogador[i - 14].setEnabled(true);
                                    ButtonsJogador[i + 7].setBorder(BorderGreen);
                                    ButtonsJogador[i - 14].setBorder(BorderGreen);
                                }
                            } else if (i == (PrimeiroBlocoNavio - 1)) {
                                if(i == 0 || i%7 == 0) {
                                    ButtonsJogador[i + 2].setEnabled(true);
                                    ButtonsJogador[i + 2].setBorder(BorderGreen);
                                } else if((i+2) % 7 == 0) {
                                    ButtonsJogador[i - 1].setEnabled(true);
                                    ButtonsJogador[i - 1].setBorder(BorderGreen);
                                }else{
                                ButtonsJogador[i - 1].setEnabled(true);
                                ButtonsJogador[i + 2].setEnabled(true);
                                ButtonsJogador[i - 1].setBorder(BorderGreen);
                                ButtonsJogador[i + 2].setBorder(BorderGreen);
                                }
                            } else if (i == (PrimeiroBlocoNavio + 1)) {
                                if((i-1) % 7 == 0 || (i - 1) == 0){ //
                                    ButtonsJogador[i + 1].setEnabled(true);
                                    ButtonsJogador[i + 1].setBorder(BorderGreen);
                                } else if((i+1) % 7 ==0) {
                                    ButtonsJogador[i - 2].setEnabled(true);
                                    ButtonsJogador[i - 2].setBorder(BorderGreen);
                                } else{
                                ButtonsJogador[i + 1].setEnabled(true);
                                ButtonsJogador[i - 2].setEnabled(true);
                                ButtonsJogador[i + 1].setBorder(BorderGreen);
                                ButtonsJogador[i - 2].setBorder(BorderGreen);
                                }
                            }
                            SegundoBlocoNavio = i;
                            if(m > 3){
                            ButtonsJogador[CoordPrimeiroNavioProa].setEnabled(false);
                            ButtonsJogador[CoordPrimeiroNavioMeiaNau].setEnabled(false);
                            ButtonsJogador[CoordPrimeiroNavioPopa].setEnabled(false);
                            ButtonsJogador[CoordPrimeiroNavioProa].setBorder(BorderLowered);
                            ButtonsJogador[CoordPrimeiroNavioMeiaNau].setBorder(BorderLowered);
                            ButtonsJogador[CoordPrimeiroNavioPopa].setBorder(BorderLowered);
                            }
                            if(m > 6){
                            ButtonsJogador[CoordSegundoNavioProa].setEnabled(false);
                            ButtonsJogador[CoordSegundoNavioMeiaNau].setEnabled(false);
                            ButtonsJogador[CoordSegundoNavioPopa].setEnabled(false);
                            ButtonsJogador[CoordSegundoNavioProa].setBorder(BorderLowered);
                            ButtonsJogador[CoordSegundoNavioMeiaNau].setBorder(BorderLowered);
                            ButtonsJogador[CoordSegundoNavioPopa].setBorder(BorderLowered);
                            }
                        }
                    }
                    k++;
                }
                else if (k == 3){
                    for (int i = 0; i <= 48; i++){
                        if (e1.getSource() == ButtonsJogador[i]) {
                            for (int j = 0; j <= 48; j++) {
                                ButtonsJogador[j].setEnabled(true);
                                ButtonsJogador[j].setBorder(BorderLowered);
                            }
                            if(m == 3){
                                CoordPrimeiroNavioProa = PrimeiroBlocoNavio;
                                CoordPrimeiroNavioMeiaNau= SegundoBlocoNavio;
                                CoordPrimeiroNavioPopa= i;
                                CoordsPrimeiroNavioJogador.add(CoordPrimeiroNavioProa);
                                CoordsPrimeiroNavioJogador.add(CoordPrimeiroNavioMeiaNau);
                                CoordsPrimeiroNavioJogador.add(CoordPrimeiroNavioPopa);
                                ButtonsJogador[CoordPrimeiroNavioProa].setEnabled(false);
                                ButtonsJogador[CoordPrimeiroNavioMeiaNau].setEnabled(false);
                                ButtonsJogador[CoordPrimeiroNavioPopa].setEnabled(false);
                            } else if (m == 6){
                            CoordSegundoNavioProa = PrimeiroBlocoNavio;
                            CoordSegundoNavioMeiaNau = SegundoBlocoNavio;
                            CoordSegundoNavioPopa = i;
                            CoordsSegundoNavioJogador.add(CoordSegundoNavioProa);
                            CoordsSegundoNavioJogador.add(CoordSegundoNavioMeiaNau);
                            CoordsSegundoNavioJogador.add(CoordSegundoNavioPopa);
                            ButtonsJogador[CoordPrimeiroNavioProa].setEnabled(false);
                            ButtonsJogador[CoordPrimeiroNavioMeiaNau].setEnabled(false);
                            ButtonsJogador[CoordPrimeiroNavioPopa].setEnabled(false);
                            ButtonsJogador[CoordSegundoNavioProa].setEnabled(false);
                            ButtonsJogador[CoordSegundoNavioMeiaNau].setEnabled(false);
                            ButtonsJogador[CoordSegundoNavioPopa].setEnabled(false);
                            } else if(m == 9){
                                CoordTerceiroNavioProa = PrimeiroBlocoNavio;
                                CoordTerceiroNavioMeiaNau = SegundoBlocoNavio;
                                CoordTerceiroNavioPopa = i;
                                CoordsTerceiroNavioJogador.add(CoordTerceiroNavioProa);
                                CoordsTerceiroNavioJogador.add(CoordTerceiroNavioMeiaNau);
                                CoordsTerceiroNavioJogador.add(CoordTerceiroNavioPopa);
                            }
                            ButtonsJogador[i].setText(null);
                            ButtonsJogador[i].setBackground(CorNavioPopa);
                            //ButtonsJogador[i].setIcon(IconSubmarinoPopa);
                        }
                    }
                    k = 1;
                }
                if(m >=5 && m<=8){
                    ButtonReiniciar.setVisible(true);
                }
                if (m == 9) {
                    ButtonConfirmar.setVisible(true);
                }
            }
        }
    };
    ActionListener PanelInstrucoesButtonsListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e2) {
            if (e2.getSource() == ButtonReiniciar){
                for (int j = 0; j <= 48; j++) {
                    ButtonsJogador[j].setEnabled(true);
                    //ButtonsJogador[j].setBackground(CorMar);
                    ButtonsJogador[j].setIcon(IconMar);
                    ButtonsJogador[j].setBorder(BorderLowered);
                }
                CoordsTodosNavioJogador.removeAll(CoordsPrimeiroNavioJogador);
                CoordsTodosNavioJogador.removeAll(CoordsSegundoNavioJogador);
                CoordsTodosNavioJogador.removeAll(CoordsTerceiroNavioJogador);
                LabelFeitosJogador.setText("Coloque seus navios.");
                ButtonConfirmar.setVisible(false);
                ButtonReiniciar.setVisible(false);
                k = 1;
                m = 0;
                CoordPrimeiroNavioProa = -1;
                CoordPrimeiroNavioMeiaNau= -1;
                CoordPrimeiroNavioPopa= -1;
                CoordSegundoNavioProa= -1;
                CoordSegundoNavioMeiaNau= -1;
                CoordSegundoNavioPopa= -1;
                CoordTerceiroNavioProa= -1;
                CoordTerceiroNavioMeiaNau= -1;
                CoordTerceiroNavioPopa= -1;
            } else if (e2.getSource() == ButtonConfirmar){
                for (int j = 0; j <= 48; j++) {
                    if(m ==9){
                        ButtonsJogador[j].removeActionListener(ColocarNaviosJogadorListener);
                    }
                }
                CoordsTodosNavioJogador.addAll(CoordsPrimeiroNavioJogador);
                CoordsTodosNavioJogador.addAll(CoordsSegundoNavioJogador);
                CoordsTodosNavioJogador.addAll(CoordsTerceiroNavioJogador);
            }
        }
    };
}
