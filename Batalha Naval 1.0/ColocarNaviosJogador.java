import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class ColocarNaviosJogador extends MenuJogo{
    Font FonteButtons = new Font("New Courier", Font.BOLD, 14);

    Color CorNavioProa = new Color(100, 100, 100);
    Color CorNavioMeiaNau = new Color(70, 70, 70);
    Color CorNavioPopa = new Color(50, 50, 50);

    ImageIcon IconProaVertical = new ImageIcon("Proa Vertical.png");
    ImageIcon IconMNVertical = new ImageIcon("Meia-Nau Vertical.png");
    ImageIcon IconPopaVertical = new ImageIcon("Popa Vertical.png");
    ImageIcon IconMNHorizontal = new ImageIcon("Meia-Nau Horizontal.png");
    ImageIcon IconProaHorizontal = new ImageIcon("Proa Horizontal.png");
    ImageIcon IconPopaHorizontal = new ImageIcon("Popa Horizontal.png");
    //---------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------

    int PrimeiroBlocoNavio; //Atualizazação coordenada 1 colocada -> 2 colocada
    int SegundoBlocoNavio; ////Atualizazação coordenada 2 colocada -> 3 colocada
    int NavioCicloCheckJogador = 1; //Contador do bloco do submarino
    int CheckJogadorBlocosColocados = 0; //Contador da quantidade de submarinos
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
        ButtonReiniciar.addActionListener(PanelInstrucoesButtonsListener);
        ButtonConfirmar.addActionListener(PanelInstrucoesButtonsListener);
    }

    ActionListener ColocarNaviosJogadorListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e1) {
            System.out.println("CheckJogadorBlocosColocados");
            // Para NavioCicloCheckJogador = 1 -> Segunda colocada do submarino atual
            // Para NavioCicloCheckJogador = 2 -> Terceira e última colocada do submarino atual(primeira vem do
            // primeiro clique do jogador na Matriz)
            if (CheckJogadorBlocosColocados < 9) {
                CheckJogadorBlocosColocados++;
                if (NavioCicloCheckJogador == 1) {
                    for (int i = 0; i <= 48; i++) {
                        if (e1.getSource() == ButtonsJogador[i]) {
                            for (int j = 0; j <= 48; j++) {
                                ButtonsJogador[j].setEnabled(false);
                            }
                            ButtonsJogador[i].setText(null);
                            //ButtonsJogador[i].setBackground(CorNavioProa);
                            ButtonsJogador[i].setIcon(IconProaVertical);

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
                            if(CheckJogadorBlocosColocados > 3){
                            ButtonsJogador[CoordPrimeiroNavioProa].setEnabled(false);
                            ButtonsJogador[CoordPrimeiroNavioMeiaNau].setEnabled(false);
                            ButtonsJogador[CoordPrimeiroNavioPopa].setEnabled(false);
                            ButtonsJogador[CoordPrimeiroNavioProa].setBorder(BorderMatriz);
                            ButtonsJogador[CoordPrimeiroNavioMeiaNau].setBorder(BorderMatriz);
                            ButtonsJogador[CoordPrimeiroNavioPopa].setBorder(BorderMatriz);
                            }
                            if(CheckJogadorBlocosColocados > 6){
                            ButtonsJogador[CoordSegundoNavioProa].setEnabled(false);
                            ButtonsJogador[CoordSegundoNavioMeiaNau].setEnabled(false);
                            ButtonsJogador[CoordSegundoNavioPopa].setEnabled(false);
                            ButtonsJogador[CoordSegundoNavioProa].setBorder(BorderMatriz);
                            ButtonsJogador[CoordSegundoNavioMeiaNau].setBorder(BorderMatriz);
                            ButtonsJogador[CoordSegundoNavioPopa].setBorder(BorderMatriz);
                            }
                        }
                    }
                    NavioCicloCheckJogador++;
                }
                // Segunda(?) colocada do navio atual. ->
                else if (NavioCicloCheckJogador == 2){
                    for (int i = 0; i <= 48; i++) {
                        if (e1.getSource() == ButtonsJogador[i]){
                            for (int j = 0; j <= 48; j++) {
                                ButtonsJogador[j].setEnabled(false);
                                ButtonsJogador[j].setBorder(BorderMatriz);
                            }
                            ButtonsJogador[i].setText(null);
                            //=================================================================================
                            //ButtonsJogador[i].setBackground(CorNavioMeiaNau);
                            if(i == PrimeiroBlocoNavio - 1){
                                ButtonsJogador[i].setIcon(IconMNHorizontal);
                                ButtonsJogador[PrimeiroBlocoNavio].setIcon(IconProaHorizontal);
                            } else if (i == PrimeiroBlocoNavio + 1){
                                ButtonsJogador[i].setIcon(IconMNHorizontal);
                                ButtonsJogador[PrimeiroBlocoNavio].setIcon(IconPopaHorizontal);
                            //---------------------------------------------------------------------------------
                            } else if(i == PrimeiroBlocoNavio - 7){
                                ButtonsJogador[i].setIcon(IconMNVertical);
                                ButtonsJogador[PrimeiroBlocoNavio].setIcon(IconPopaVertical);
                            } else if (i == PrimeiroBlocoNavio + 7){
                                ButtonsJogador[i].setIcon(IconMNVertical);
                                ButtonsJogador[PrimeiroBlocoNavio].setIcon(IconProaVertical);
                            }
                            //=================================================================================
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
                            if(CheckJogadorBlocosColocados > 3){
                            ButtonsJogador[CoordPrimeiroNavioProa].setEnabled(false);
                            ButtonsJogador[CoordPrimeiroNavioMeiaNau].setEnabled(false);
                            ButtonsJogador[CoordPrimeiroNavioPopa].setEnabled(false);
                            ButtonsJogador[CoordPrimeiroNavioProa].setBorder(BorderMatriz);
                            ButtonsJogador[CoordPrimeiroNavioMeiaNau].setBorder(BorderMatriz);
                            ButtonsJogador[CoordPrimeiroNavioPopa].setBorder(BorderMatriz);
                            }
                            if(CheckJogadorBlocosColocados > 6){
                            ButtonsJogador[CoordSegundoNavioProa].setEnabled(false);
                            ButtonsJogador[CoordSegundoNavioMeiaNau].setEnabled(false);
                            ButtonsJogador[CoordSegundoNavioPopa].setEnabled(false);
                            ButtonsJogador[CoordSegundoNavioProa].setBorder(BorderMatriz);
                            ButtonsJogador[CoordSegundoNavioMeiaNau].setBorder(BorderMatriz);
                            ButtonsJogador[CoordSegundoNavioPopa].setBorder(BorderMatriz);
                            }
                        }
                    }
                    NavioCicloCheckJogador++;
                }
                else if (NavioCicloCheckJogador == 3){
                    for (int i = 0; i <= 48; i++){
                        if (e1.getSource() == ButtonsJogador[i]) {
                            for (int j = 0; j <= 48; j++) {
                                ButtonsJogador[j].setEnabled(true);
                                ButtonsJogador[j].setBorder(BorderMatriz);
                            }
                            if(CheckJogadorBlocosColocados == 3){
                                CoordPrimeiroNavioProa = PrimeiroBlocoNavio;
                                CoordPrimeiroNavioMeiaNau= SegundoBlocoNavio;
                                CoordPrimeiroNavioPopa= i;
                                CoordsPrimeiroNavioJogador.add(CoordPrimeiroNavioProa);
                                CoordsPrimeiroNavioJogador.add(CoordPrimeiroNavioMeiaNau);
                                CoordsPrimeiroNavioJogador.add(CoordPrimeiroNavioPopa);
                                ButtonsJogador[CoordPrimeiroNavioProa].setEnabled(false);
                                ButtonsJogador[CoordPrimeiroNavioMeiaNau].setEnabled(false);
                                ButtonsJogador[CoordPrimeiroNavioPopa].setEnabled(false);
                            } else if (CheckJogadorBlocosColocados == 6){
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
                            } else if(CheckJogadorBlocosColocados == 9){
                                CoordTerceiroNavioProa = PrimeiroBlocoNavio;
                                CoordTerceiroNavioMeiaNau = SegundoBlocoNavio;
                                CoordTerceiroNavioPopa = i;
                                CoordsTerceiroNavioJogador.add(CoordTerceiroNavioProa);
                                CoordsTerceiroNavioJogador.add(CoordTerceiroNavioMeiaNau);
                                CoordsTerceiroNavioJogador.add(CoordTerceiroNavioPopa);
                            }
                            ButtonsJogador[i].setText(null);
                            //ButtonsJogador[i].setBackground(CorNavioPopa);
                            //=================================================================================
                            if (i == SegundoBlocoNavio - 1){
                                ButtonsJogador[i].setIcon(IconPopaHorizontal);
                            } else if (i == PrimeiroBlocoNavio + 1) {
                                ButtonsJogador[PrimeiroBlocoNavio].setIcon(IconMNHorizontal);
                                ButtonsJogador[SegundoBlocoNavio].setIcon(IconPopaHorizontal);
                                ButtonsJogador[i].setIcon(IconProaHorizontal);
                            } else if (i == SegundoBlocoNavio + 1){
                                ButtonsJogador[i].setIcon(IconProaHorizontal);
                            } else if (i == PrimeiroBlocoNavio - 1){
                                ButtonsJogador[PrimeiroBlocoNavio].setIcon(IconMNHorizontal);
                                ButtonsJogador[SegundoBlocoNavio].setIcon(IconProaHorizontal);
                                ButtonsJogador[i].setIcon(IconPopaHorizontal);
                            //---------------------------------------------------------------------------------
                            }  else if (i == SegundoBlocoNavio - 7){
                                ButtonsJogador[i].setIcon(IconProaVertical);
                            } else if (i == PrimeiroBlocoNavio + 7) {
                                ButtonsJogador[PrimeiroBlocoNavio].setIcon(IconMNVertical);
                                ButtonsJogador[SegundoBlocoNavio].setIcon(IconProaVertical);
                                ButtonsJogador[i].setIcon(IconPopaVertical);
                            } else if (i == SegundoBlocoNavio + 7){
                                ButtonsJogador[i].setIcon(IconPopaVertical);
                            } else if (i == PrimeiroBlocoNavio - 7){
                                ButtonsJogador[PrimeiroBlocoNavio].setIcon(IconMNVertical);
                                ButtonsJogador[SegundoBlocoNavio].setIcon(IconPopaVertical);
                                ButtonsJogador[i].setIcon(IconProaVertical);
                            }
                            //=================================================================================
                        }
                    }
                    NavioCicloCheckJogador = 1;
                }
                if(CheckJogadorBlocosColocados >=5 && CheckJogadorBlocosColocados<=8){
                    ButtonReiniciar.setVisible(true);
                }
                if (CheckJogadorBlocosColocados == 9) {
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
                    ButtonsJogador[j].setBorder(BorderMatriz);
                }
                CoordsTodosNavioJogador.clear();
                CoordsPrimeiroNavioJogador.clear();
                CoordsSegundoNavioJogador.clear();
                CoordsTerceiroNavioJogador.clear();
                LabelFeitosJogador.setText("Coloque seus navios.");
                ButtonConfirmar.setVisible(false);
                ButtonReiniciar.setVisible(false);
                NavioCicloCheckJogador = 1;
                CheckJogadorBlocosColocados = 0;
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
                    ButtonsJogador[j].removeActionListener(ColocarNaviosJogadorListener);
                }
                CoordsTodosNavioJogador.addAll(CoordsPrimeiroNavioJogador);
                CoordsTodosNavioJogador.addAll(CoordsSegundoNavioJogador);
                CoordsTodosNavioJogador.addAll(CoordsTerceiroNavioJogador);
            }
        }
    };
}
