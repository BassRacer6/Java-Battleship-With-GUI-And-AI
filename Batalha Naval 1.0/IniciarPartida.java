import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IniciarPartida extends IniciarAtaque implements ActionListener{

    IniciarPartida() {
        menuPrincipal.BotaoIniciar.addActionListener(this);
        menuPrincipal.BotaoSair.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuPrincipal.BotaoIniciar) {
            MenuJogoFrame.setVisible(true);
            menuPrincipal.MenuInicialFrame.setVisible(false);
            // ---------------------------------------------------------------------------------------
            NavioCicloCheckJogador = 1;
            NavioCicloCheckMaquina = 1;
            CheckJogadorBlocosColocados = 0;
            QuantAcertosMaquina = 0;
            QuantAcertosJogador = 0;
            QuantNaviosJogadorDestruidos = 0;
            Rodada = 0;
            AcertosSeguidosMaquina = 0;
            FaseCenarioEspecial1Ativo = 0;
            FaseCenarioEspecial2Ativo = 0;
            // ---------------------------------------------------------------------------------------
            LabelRodadaCounter.setVisible(false);
            LabelFeitosMaquina.setText("Coloque seus navios.");
            LabelFeitosJogador.setText(null);
            // ---------------------------------------------------------------------------------------
            CoordsTodosNavioJogador.clear();
            CoordsPrimeiroNavioJogador.clear();
            CoordsSegundoNavioJogador.clear();
            CoordsTerceiroNavioJogador.clear();
            ListaCoordsAcertosMaquina.clear();
            // ---------------------------------------------------------------------------------------
            ListaPossiveisTiros.clear();
            ListaPossiveisPrimeiroTiroDaSequencia.clear();
            // ---------------------------------------------------------------------------------------
            for (int j = 0; j <= 48; j++) {
                ButtonsMaquina[j].setIcon(null);
                ButtonsJogador[j].setIcon(null);
                ButtonsMaquina[j].setBackground(CorDesconhecido);
                //ButtonsJogador[j].setBackground(CorMar);
                ButtonsJogador[j].setIcon(IconMar);
                // ---------------------------------------------------------------------------------------
                ButtonsMaquina[j].removeActionListener(AtacarNaviosDaMaquinaListener);
                ButtonsMaquina[j].removeActionListener(ReceberAtaqueListener);
                ButtonsJogador[j].addActionListener(ColocarNaviosJogadorListener);
                ListaPossiveisTiros.add(j);
                if (j>=1 && j <= 16) {
                    ListaPossiveisPrimeiroTiroDaSequencia.add((j * 3) - 1);
                }
            }
            colocarNaviosMaquina();
        // =======================================================================================
        } else if (e.getSource() == menuPrincipal.BotaoSair) {
            System.exit(0);
        }
    }
}
