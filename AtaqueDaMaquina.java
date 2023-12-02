import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AtaqueDaMaquina extends AtaqueDoJogador {

    int PrimeiraCoordTiroMaquina;
    int SegundaCoordTiroMaquina;
    int TerceiraCoordTiroMaquina;

    int AcertosSeguidosMaquina = 0;
    int QuantAcertosMaquina = 0;

    ArrayList<Integer> ListaPossiveisPrimeiroTiroDaSequencia = new ArrayList<>();
    int FirstTiroMaqRandomIndex;
    ArrayList<Integer> ListaPossiveisTiros = new ArrayList<>();

    ArrayList<Integer> Lista2Possibilidades = new ArrayList<>();
    ArrayList<Integer> Lista3Possibilidades = new ArrayList<>();
    ArrayList<Integer> Lista4Possibilidades = new ArrayList<>();
    int CheckTestouTodasAsPossibilidades = 0;

    int Chance2Possibilidades;
    int Chance3Possibilidades;
    int Chance4Possibilidades;

    int FaseCenarioEspecial1Ativo = 0;
    int VariavelArmazenadaParaCenario1;
    int FaseCenarioEspecial2Ativo = 0;
    int Variavel1ArmazenadaParaCenario2;
    int Variavel2ArmazenadaParaCenario2;

    ArrayList<Integer> ListaCoordsAcertosMaquina = new ArrayList<>();
    int NavioJogador1Destruído = 0;
    int NavioJogador2Destruído = 0;
    int NavioJogador3Destruído = 0;
    int QuantNaviosJogadorDestruidos = 0;

    //=======================================================================================
    AtaqueDaMaquina() {

        for (int i = 0; i <= 48; i++) {
            ButtonsMaquina[i].addActionListener(ReceberAtaqueListener);
            ListaPossiveisTiros.add(i);
            if (i <= 15) {
                ListaPossiveisPrimeiroTiroDaSequencia.add((i * 3) - 1);
            }
        }
    }
    //=======================================================================================
    ActionListener ReceberAtaqueListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e4) {
            for (int i = 0; i <= 48; i++) {
                if (e4.getSource() == ButtonsMaquina[i]) {
                    ButtonsMaquina[i].removeActionListener(ReceberAtaqueListener);
                }
            }
            if(FaseCenarioEspecial1Ativo == 0 && FaseCenarioEspecial2Ativo == 0){
                if (AcertosSeguidosMaquina == 0) {
                    AtirarPrimeiroTiroDaSequencia();
                    System.out.println("AtirarPrimeiroTiroDaSequencia");
                } else if (AcertosSeguidosMaquina == 1) {
                    AtirarSegundoTiroDaSequencia();
                    System.out.println("AtirarSegundoTiroDaSequencia");
                } else if (AcertosSeguidosMaquina == 2) {
                    AtirarTerceiroTiroDaSequencia();
                    System.out.println("AtirarTerceiroTiroDaSequencia");
                }
            } else if(FaseCenarioEspecial1Ativo > 0){
                CenarioEspecial1();
            } else if(FaseCenarioEspecial2Ativo > 0){
                CenarioEspecial2();
            }
            if (QuantAcertosMaquina == 9) {
                JOptionPane.showMessageDialog(null, "Você perdeu!", "Derrota", JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            }
        }
    }; // Bloco do listener
    //=======================================================================================
    public void AtirarPrimeiroTiroDaSequencia() {
        //Aqui pega um valor de todas as possibilidades para o primeiro tiro. ->
        do {
            FirstTiroMaqRandomIndex = random.nextInt(ListaPossiveisPrimeiroTiroDaSequencia.size());
            PrimeiraCoordTiroMaquina = ListaPossiveisPrimeiroTiroDaSequencia.get(FirstTiroMaqRandomIndex);
        } while (ListaPossiveisPrimeiroTiroDaSequencia.get(FirstTiroMaqRandomIndex) < 0);
        //---------------------------------------------------------------------------------------
        // Aqui checa se o tiro acertou ou errou. ->
        if (CoordsTodosNavioJogador.contains(PrimeiraCoordTiroMaquina)) {
            ButtonsJogador[PrimeiraCoordTiroMaquina].setIcon(BlocoAtiradoAcerto);
            LabelFeitosMaquina.setText("Inimigo acertou!");
            QuantAcertosMaquina++;
            ListaCoordsAcertosMaquina.add(PrimeiraCoordTiroMaquina);
            AcertosSeguidosMaquina = 1;
        } else {
            ButtonsJogador[PrimeiraCoordTiroMaquina].setIcon(BlocoAtiradoErro);
            LabelFeitosMaquina.setText("Inimigo errou!");
        }
        //---------------------------------------------------------------------------------------
        // Aqui retira valores das possibilidades para não serem cenários repetíveis. ->
        ListaPossiveisTiros.set(PrimeiraCoordTiroMaquina, -1);
        for (int i = 0; i <= 15; i++) {
            if(ListaPossiveisPrimeiroTiroDaSequencia.get(i) == PrimeiraCoordTiroMaquina){
                ListaPossiveisPrimeiroTiroDaSequencia.set(i, -1);
            }
        }
    }
    //=======================================================================================
    public void AtirarSegundoTiroDaSequencia() {
        //Aqui pega um valor de todas as possibilidades para o segundo tiro. ->
        do {
            Chance2Possibilidades = random.nextInt(2) + 1;
            Chance3Possibilidades = random.nextInt(3) + 1;
            Chance4Possibilidades = random.nextInt(4) + 1;
            Lista2Possibilidades.add(Chance2Possibilidades);
            Lista3Possibilidades.add(Chance3Possibilidades);
            Lista4Possibilidades.add(Chance4Possibilidades);
            if (PrimeiraCoordTiroMaquina >= 7 && PrimeiraCoordTiroMaquina <= 41) {
                if (PrimeiraCoordTiroMaquina % 7 == 0) {
                    if (Chance3Possibilidades == 1) {
                        SegundaCoordTiroMaquina = (PrimeiraCoordTiroMaquina + 1);
                    } else if (Chance3Possibilidades == 2) {
                        SegundaCoordTiroMaquina = (PrimeiraCoordTiroMaquina + 7);
                    } else if (Chance3Possibilidades == 3) {
                        SegundaCoordTiroMaquina = (PrimeiraCoordTiroMaquina - 7);
                    }
                } else if ((PrimeiraCoordTiroMaquina + 1) % 7 == 0) {
                    if (Chance3Possibilidades == 1) {
                        SegundaCoordTiroMaquina = (PrimeiraCoordTiroMaquina - 1);
                    } else if (Chance3Possibilidades == 2) {
                        SegundaCoordTiroMaquina = (PrimeiraCoordTiroMaquina + 7);
                    } else if (Chance3Possibilidades == 3) {
                        SegundaCoordTiroMaquina = (PrimeiraCoordTiroMaquina - 7);
                    }
                } else {
                    if (Chance4Possibilidades == 1) {
                        SegundaCoordTiroMaquina = (PrimeiraCoordTiroMaquina + 1);
                    } else if (Chance4Possibilidades == 2) {
                        SegundaCoordTiroMaquina = (PrimeiraCoordTiroMaquina - 1);
                    } else if (Chance4Possibilidades == 3) {
                        SegundaCoordTiroMaquina = (PrimeiraCoordTiroMaquina + 7);
                    } else if (Chance4Possibilidades == 4) {
                        SegundaCoordTiroMaquina = (PrimeiraCoordTiroMaquina - 7);
                    }
                }
            } else if (PrimeiraCoordTiroMaquina >= 1 && PrimeiraCoordTiroMaquina <= 5) {
                if (Chance3Possibilidades == 1) {
                    SegundaCoordTiroMaquina = (PrimeiraCoordTiroMaquina + 1);
                } else if (Chance3Possibilidades == 2) {
                    SegundaCoordTiroMaquina = (PrimeiraCoordTiroMaquina - 1);
                } else if (Chance3Possibilidades == 3) {
                    SegundaCoordTiroMaquina = (PrimeiraCoordTiroMaquina + 7);
                }
            } else if (PrimeiraCoordTiroMaquina >= 43 && PrimeiraCoordTiroMaquina <= 47) {
                if (Chance3Possibilidades == 1) {
                    SegundaCoordTiroMaquina = (PrimeiraCoordTiroMaquina + 1);
                } else if (Chance3Possibilidades == 2) {
                    SegundaCoordTiroMaquina = (PrimeiraCoordTiroMaquina - 1);
                } else if (Chance3Possibilidades == 3) {
                    SegundaCoordTiroMaquina = (PrimeiraCoordTiroMaquina - 7);
                }
            } else if (PrimeiraCoordTiroMaquina == 0) {
                if (Chance2Possibilidades == 1) {
                    SegundaCoordTiroMaquina = (PrimeiraCoordTiroMaquina + 1);
                } else if (Chance2Possibilidades == 2) {
                    SegundaCoordTiroMaquina = (PrimeiraCoordTiroMaquina + 7);
                }
            } else if (PrimeiraCoordTiroMaquina == 6) {
                if (Chance2Possibilidades == 1) {
                    SegundaCoordTiroMaquina = (PrimeiraCoordTiroMaquina - 1);
                } else if (Chance2Possibilidades == 2) {
                    SegundaCoordTiroMaquina = (PrimeiraCoordTiroMaquina + 7);
                }
            } else if (PrimeiraCoordTiroMaquina == 42) {
                if (Chance2Possibilidades == 1) {
                    SegundaCoordTiroMaquina = (PrimeiraCoordTiroMaquina + 1);
                } else if (Chance2Possibilidades == 2) {
                    SegundaCoordTiroMaquina = (PrimeiraCoordTiroMaquina - 7);
                }
            } else if (PrimeiraCoordTiroMaquina == 48) {
                if (Chance2Possibilidades == 1) {
                    SegundaCoordTiroMaquina = (PrimeiraCoordTiroMaquina - 1);
                } else if (Chance2Possibilidades == 2) {
                    SegundaCoordTiroMaquina = (PrimeiraCoordTiroMaquina - 7);
                }
            }
            if (Lista2Possibilidades.contains(1) && Lista2Possibilidades.contains(2) &&
                    Lista3Possibilidades.contains(1) && Lista3Possibilidades.contains(2) &&
                    Lista3Possibilidades.contains(3) && Lista4Possibilidades.contains(1) &&
                    Lista4Possibilidades.contains(2) && Lista4Possibilidades.contains(3) &&
                    Lista4Possibilidades.contains(4)) {
                CheckTestouTodasAsPossibilidades = 1;
            } else {
                CheckTestouTodasAsPossibilidades = 0;
            }
        } while (ListaPossiveisTiros.get(SegundaCoordTiroMaquina) < 0 && CheckTestouTodasAsPossibilidades == 0);
        //---------------------------------------------------------------------------------
        Lista2Possibilidades.removeAll(Lista2Possibilidades);
        Lista3Possibilidades.removeAll(Lista3Possibilidades);
        Lista4Possibilidades.removeAll(Lista4Possibilidades);
        //---------------------------------------------------------------------------------
        if (ListaPossiveisTiros.get(SegundaCoordTiroMaquina) > 0) { // Se a coordenada do tiro ainda não foi usada.
            //---------------------------------------------------------------------------------
            // Aqui checa se o tiro acertou ou errou ->
            if (CoordsTodosNavioJogador.contains(SegundaCoordTiroMaquina)) {
                ButtonsJogador[SegundaCoordTiroMaquina].setIcon(BlocoAtiradoAcerto);
                LabelFeitosMaquina.setText("Inimigo acertou!");
                QuantAcertosMaquina++;
                ListaCoordsAcertosMaquina.add(SegundaCoordTiroMaquina);
                AcertosSeguidosMaquina = 2;
                if(FaseCenarioEspecial1Ativo == 0){
                    VariavelArmazenadaParaCenario1 = SegundaCoordTiroMaquina;
                }
                if(FaseCenarioEspecial2Ativo == 0){
                Variavel1ArmazenadaParaCenario2 = SegundaCoordTiroMaquina;
            }
            } else {
                ButtonsJogador[SegundaCoordTiroMaquina].setIcon(BlocoAtiradoErro);
                LabelFeitosMaquina.setText("Inimigo errou!");
            }
        } else { // Se todas as coordenada possíveis para o caso já foram usadas.
            System.out.println("FUDEU BERG");
        }
        //---------------------------------------------------------------------------------
        // Aqui tira a TerceiraCoordTiroMaquina das possibilidades de tiro ->
        ListaPossiveisTiros.set(SegundaCoordTiroMaquina, -1);
        for (int i = 0; i <= 15; i++) {
            if(ListaPossiveisPrimeiroTiroDaSequencia.get(i) == SegundaCoordTiroMaquina){
                ListaPossiveisPrimeiroTiroDaSequencia.set(i, -1);
            }
        }
    }
    //=======================================================================================
    public void AtirarTerceiroTiroDaSequencia() {
        //Aqui pega um valor de todas as possibilidades para o terceiro tiro. ->
        do {
            Chance2Possibilidades = random.nextInt(2) + 1;
            Lista2Possibilidades.add(Chance2Possibilidades);
            if (SegundaCoordTiroMaquina == (PrimeiraCoordTiroMaquina - 7)) {
                if (SegundaCoordTiroMaquina >= 0 && SegundaCoordTiroMaquina <= 6) {
                    TerceiraCoordTiroMaquina = (SegundaCoordTiroMaquina + 14); // 1
                } else if (SegundaCoordTiroMaquina >= 35 && SegundaCoordTiroMaquina <= 41) {
                    TerceiraCoordTiroMaquina = (SegundaCoordTiroMaquina - 7); // 2
                } else {
                    if (Chance2Possibilidades == 1) {
                        TerceiraCoordTiroMaquina = (SegundaCoordTiroMaquina - 7);
                    } else if (Chance2Possibilidades == 2) {
                        TerceiraCoordTiroMaquina = (SegundaCoordTiroMaquina + 14);
                    }
                }
            } else if (SegundaCoordTiroMaquina == (PrimeiraCoordTiroMaquina + 7)) {
                if (SegundaCoordTiroMaquina >= 7 && SegundaCoordTiroMaquina <= 13) {
                    TerceiraCoordTiroMaquina = (SegundaCoordTiroMaquina + 7); // 3
                } else if (SegundaCoordTiroMaquina >= 42 && SegundaCoordTiroMaquina <= 48) {
                    TerceiraCoordTiroMaquina = (SegundaCoordTiroMaquina - 14); // 4
                } else {
                    if (Chance2Possibilidades == 1) {
                        TerceiraCoordTiroMaquina = (SegundaCoordTiroMaquina + 7);
                    } else if (Chance2Possibilidades == 2) {
                        TerceiraCoordTiroMaquina = (SegundaCoordTiroMaquina - 14);
                    }
                }
            } else if (SegundaCoordTiroMaquina == (PrimeiraCoordTiroMaquina - 1)) {
                if (SegundaCoordTiroMaquina == 0 || SegundaCoordTiroMaquina % 7 == 0) {
                    TerceiraCoordTiroMaquina = (SegundaCoordTiroMaquina + 2); // 5
                } else if ((SegundaCoordTiroMaquina + 2) % 7 == 0) {
                    TerceiraCoordTiroMaquina = (SegundaCoordTiroMaquina - 1); // 6
                } else {
                    if (Chance2Possibilidades == 1) {
                        TerceiraCoordTiroMaquina = (SegundaCoordTiroMaquina - 1);
                    } else if (Chance2Possibilidades == 2) {
                        TerceiraCoordTiroMaquina = (SegundaCoordTiroMaquina + 2);
                    }
                }
            } else if (SegundaCoordTiroMaquina == (PrimeiraCoordTiroMaquina + 1)) {
                if ((SegundaCoordTiroMaquina - 1) % 7 == 0 || (SegundaCoordTiroMaquina - 1) == 0) {
                    TerceiraCoordTiroMaquina = (SegundaCoordTiroMaquina + 1);
                } else if ((SegundaCoordTiroMaquina + 1) % 7 == 0) {
                    TerceiraCoordTiroMaquina = (SegundaCoordTiroMaquina - 2);
                } else {
                    if (Chance2Possibilidades == 1) {
                        TerceiraCoordTiroMaquina = (SegundaCoordTiroMaquina + 1);
                    } else if (Chance2Possibilidades == 2) {
                        TerceiraCoordTiroMaquina = (SegundaCoordTiroMaquina - 2);
                    }
                }
            }
            if (Lista2Possibilidades.contains(1) && Lista2Possibilidades.contains(2)) {
                CheckTestouTodasAsPossibilidades = 1;
            } else {
                CheckTestouTodasAsPossibilidades = 0;
            }
        } while (ListaPossiveisTiros.get(TerceiraCoordTiroMaquina) < 0 && CheckTestouTodasAsPossibilidades == 0);
        //---------------------------------------------------------------------------------
        Lista2Possibilidades.removeAll(Lista2Possibilidades);
        //---------------------------------------------------------------------------------
        if (ListaPossiveisTiros.get(TerceiraCoordTiroMaquina) > 0) { // Se a coordenada do tiro ainda não foi usada.
            // Aqui checa se o tiro acertou ou errou ->
            if (CoordsTodosNavioJogador.contains(TerceiraCoordTiroMaquina)) {
                ButtonsJogador[TerceiraCoordTiroMaquina].setIcon(BlocoAtiradoAcerto);
                LabelFeitosMaquina.setText("Inimigo acertou!");
                QuantAcertosMaquina++;
                ListaCoordsAcertosMaquina.add(TerceiraCoordTiroMaquina);
                if(FaseCenarioEspecial2Ativo == 0){
                Variavel2ArmazenadaParaCenario2 = TerceiraCoordTiroMaquina;
            }
                //---------------------------------------------------------------------------------
                // Aqui checa se depois da primeria iteração tri-fásica um sumarino é destruído por completo ou não. ->
                if(ListaCoordsAcertosMaquina.containsAll(CoordsPrimeiroNavioJogador)){
                    NavioJogador1Destruído = 1;
                }
                if(ListaCoordsAcertosMaquina.containsAll(CoordsSegundoNavioJogador)){
                    NavioJogador2Destruído = 1;
                }
                if(ListaCoordsAcertosMaquina.containsAll(CoordsTerceiroNavioJogador)){
                    NavioJogador3Destruído = 1;
                }
                if(NavioJogador1Destruído + NavioJogador2Destruído + NavioJogador3Destruído > QuantNaviosJogadorDestruidos){
                    QuantNaviosJogadorDestruidos = NavioJogador1Destruído + NavioJogador2Destruído + NavioJogador3Destruído;
                    AcertosSeguidosMaquina = 0;
                } else {
                    FaseCenarioEspecial2Ativo = 1;
                }
                //---------------------------------------------------------------------------------
            } else {
                ButtonsJogador[TerceiraCoordTiroMaquina].setIcon(BlocoAtiradoErro);
                LabelFeitosMaquina.setText("Inimigo errou!");
            }
        } else { // Se todas as coordenada possíveis para o caso já foram usadas.
            FaseCenarioEspecial1Ativo = 1;
            CenarioEspecial1();
        }
        //---------------------------------------------------------------------------------
        // Aqui retira valores das possibilidades para não serem cenários repetíveis. ->
        ListaPossiveisTiros.set(TerceiraCoordTiroMaquina, -1);
        for (int i = 0; i <= 15; i++) {
            if(ListaPossiveisPrimeiroTiroDaSequencia.get(i) == TerceiraCoordTiroMaquina){
                ListaPossiveisPrimeiroTiroDaSequencia.set(i, -1);
            }
        }
    } // Fim da sequência de tiro tri-partidária padrão
    //=======================================================================================
    public void CenarioEspecial1() { // Quando tem um 3x2 e ele acerta uma nas extremidas que está no sentido oposto(horizontal-vertical, e vice-versa).
        //---------------------------------------------------------------------------------
        // Aqui retorna para
        if(FaseCenarioEspecial1Ativo == 1){
            AcertosSeguidosMaquina = 1;
            AtirarSegundoTiroDaSequencia();
            System.out.println("CenarioEspecial1 fase 1");
            //---------------------------------------------------------------------------------
            // Aqui confere se o houve acerto. Só se houver, prossegue. ->
            if(AcertosSeguidosMaquina == 2){
                FaseCenarioEspecial1Ativo = 2;
            }
            //---------------------------------------------------------------------------------
        } else if(FaseCenarioEspecial1Ativo == 2){
            AtirarTerceiroTiroDaSequencia();
            System.out.println("CenarioEspecial1 fase 2");
            //---------------------------------------------------------------------------------
            // Aqui confere se o houve acerto. Só se houver, prossegue. ->
            if(AcertosSeguidosMaquina == 0){
                FaseCenarioEspecial1Ativo = 3;
            }
            //---------------------------------------------------------------------------------
        } else if(FaseCenarioEspecial1Ativo == 3){
            AcertosSeguidosMaquina = 1;
            PrimeiraCoordTiroMaquina = VariavelArmazenadaParaCenario1;
            AtirarSegundoTiroDaSequencia();
            System.out.println("CenarioEspecial1 fase 3");
            //---------------------------------------------------------------------------------
            // Aqui confere se o houve acerto. Só se houver, prossegue. ->
            if(AcertosSeguidosMaquina == 2){
                FaseCenarioEspecial1Ativo = 4;
            }
            //---------------------------------------------------------------------------------
        } else if(FaseCenarioEspecial1Ativo == 4){
            AtirarTerceiroTiroDaSequencia();
            System.out.println("CenarioEspecial1 fase 4");
            //---------------------------------------------------------------------------------
            // Aqui confere se o houve acerto. Só se houver, prossegue. ->
            if(AcertosSeguidosMaquina == 0){
                FaseCenarioEspecial1Ativo = 0;
            }
        }
    }
    //=======================================================================================
    public void CenarioEspecial2() {
        // Nesse bloco, os AcertosSeguidos não são esses acertos mas o valor que a variável recebe quando há acerto.
        // Tipo, se a TerceiraCoordTiroMaquina acerta, o valor de AcertosSeguidos vira 0.
        //---------------------------------------------------------------------------------
        // Cada um destes 3 blocos(->) é a Segunda e Terceira fase de tiro para o primeiro, segundo e terceiro acerto, respectivamente.
        if(FaseCenarioEspecial2Ativo == 1){
            AtirarSegundoTiroDaSequencia();
            if(AcertosSeguidosMaquina == 2){
                FaseCenarioEspecial2Ativo = 2;
            }
        } else if(FaseCenarioEspecial2Ativo == 2) {
            AtirarTerceiroTiroDaSequencia();
            if(AcertosSeguidosMaquina == 0){
                FaseCenarioEspecial2Ativo = 3;
            }
        //---------------------------------------------------------------------------------
        } else if(FaseCenarioEspecial2Ativo == 3) {
            PrimeiraCoordTiroMaquina = Variavel1ArmazenadaParaCenario2;
            AtirarSegundoTiroDaSequencia();
            if(AcertosSeguidosMaquina == 2){
                FaseCenarioEspecial2Ativo = 4;
            }
        } else if(FaseCenarioEspecial2Ativo == 4) {
            AtirarTerceiroTiroDaSequencia();
            if(AcertosSeguidosMaquina == 0){
                FaseCenarioEspecial2Ativo = 5;
            }
        //---------------------------------------------------------------------------------
        } else if(FaseCenarioEspecial2Ativo == 5) {
            PrimeiraCoordTiroMaquina = Variavel2ArmazenadaParaCenario2;
            AtirarSegundoTiroDaSequencia();
            if(AcertosSeguidosMaquina == 2){
                FaseCenarioEspecial2Ativo = 6;
            }
        } else if(FaseCenarioEspecial2Ativo == 6) {
            AtirarTerceiroTiroDaSequencia();
            if(AcertosSeguidosMaquina == 0){
                FaseCenarioEspecial2Ativo = 0;
            }
        }
        //---------------------------------------------------------------------------------
    }

}
