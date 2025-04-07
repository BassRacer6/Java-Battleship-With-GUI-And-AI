import java.util.Random;

public class ColocarNaviosMaquina extends ColocarNaviosJogador {

    Random random = new Random();
    int PrimeiraColocadaMaquina1 = -1;
    int SegundaColocadaMaquina1 = -1;
    int TerceiraColocadaMaquina1 = -1;
    int PrimeiraColocadaMaquina2 = -1;
    int SegundaColocadaMaquina2 = -1;
    int TerceiraColocadaMaquina2 = -1;
    int PrimeiraColocadaMaquina3 = -1;
    int SegundaColocadaMaquina3 = -1;
    int TerceiraColocadaMaquina3 = -1;

    int NavioCicloCheckMaquina = 1;

    int PrimeiraColocadaMaquina;
    int Chance2Possibilidades;
    int Chance3Possibilidades;
    int Chance4Possibilidades;

    int SegundaColocadaMaquina = 80085;
    int TerceiraColocadaMaquina = 80085;
        
    public void colocarNaviosMaquina() {

        while (NavioCicloCheckMaquina <= 3) {
            PrimeiraColocadaMaquina = random.nextInt(49);
            Chance2Possibilidades = random.nextInt(2) + 1;
            Chance3Possibilidades = random.nextInt(3) + 1;
            Chance4Possibilidades = random.nextInt(4) + 1;

            // Segunda Colocada do Primeiro Navio
            if (PrimeiraColocadaMaquina >= 7 && PrimeiraColocadaMaquina <= 41) {
                if (PrimeiraColocadaMaquina % 7 == 0) {
                    if (Chance3Possibilidades == 1) {
                        SegundaColocadaMaquina = (PrimeiraColocadaMaquina + 1);
                    } else if (Chance3Possibilidades == 2) {
                        SegundaColocadaMaquina = (PrimeiraColocadaMaquina + 7);
                    } else if (Chance3Possibilidades == 3) {
                        SegundaColocadaMaquina = (PrimeiraColocadaMaquina - 7);
                    }
                } else if ((PrimeiraColocadaMaquina + 1) % 7 == 0) {
                    if (Chance3Possibilidades == 1) {
                        SegundaColocadaMaquina = (PrimeiraColocadaMaquina - 1);
                    } else if (Chance3Possibilidades == 2) {
                        SegundaColocadaMaquina = (PrimeiraColocadaMaquina + 7);
                    } else if (Chance3Possibilidades == 3) {
                        SegundaColocadaMaquina = (PrimeiraColocadaMaquina - 7);
                    }
                } else {
                    if (Chance4Possibilidades == 1) {
                        SegundaColocadaMaquina = (PrimeiraColocadaMaquina + 1);
                    } else if (Chance4Possibilidades == 2) {
                        SegundaColocadaMaquina = (PrimeiraColocadaMaquina - 1);
                    } else if (Chance4Possibilidades == 3) {
                        SegundaColocadaMaquina = (PrimeiraColocadaMaquina + 7);
                    } else if (Chance4Possibilidades == 4) {
                        SegundaColocadaMaquina = (PrimeiraColocadaMaquina - 7);
                    }
                }
            } else if (PrimeiraColocadaMaquina >= 1 && PrimeiraColocadaMaquina <= 5) {
                if (Chance3Possibilidades == 1) {
                    SegundaColocadaMaquina = (PrimeiraColocadaMaquina + 1);
                } else if (Chance3Possibilidades == 2) {
                    SegundaColocadaMaquina = (PrimeiraColocadaMaquina - 1);
                } else if (Chance3Possibilidades == 3) {
                    SegundaColocadaMaquina = (PrimeiraColocadaMaquina + 7);
                }
            } else if (PrimeiraColocadaMaquina >= 43 && PrimeiraColocadaMaquina <= 47) {
                if (Chance3Possibilidades == 1) {
                    SegundaColocadaMaquina = (PrimeiraColocadaMaquina + 1);
                } else if (Chance3Possibilidades == 2) {
                    SegundaColocadaMaquina = (PrimeiraColocadaMaquina - 1);
                } else if (Chance3Possibilidades == 3) {
                    SegundaColocadaMaquina = (PrimeiraColocadaMaquina - 7);
                }
            } else if (PrimeiraColocadaMaquina == 0) {
                if (Chance2Possibilidades == 1) {
                    SegundaColocadaMaquina = (PrimeiraColocadaMaquina + 1);
                } else if (Chance2Possibilidades == 2) {
                    SegundaColocadaMaquina = (PrimeiraColocadaMaquina + 7);
                }
            } else if (PrimeiraColocadaMaquina == 6) {
                if (Chance2Possibilidades == 1) {
                    SegundaColocadaMaquina = (PrimeiraColocadaMaquina - 1);
                } else if (Chance2Possibilidades == 2) {
                    SegundaColocadaMaquina = (PrimeiraColocadaMaquina + 7);
                }
            } else if (PrimeiraColocadaMaquina == 42) {
                if (Chance2Possibilidades == 1) {
                    SegundaColocadaMaquina = (PrimeiraColocadaMaquina + 1);
                } else if (Chance2Possibilidades == 2) {
                    SegundaColocadaMaquina = (PrimeiraColocadaMaquina - 7);
                }
            } else if (PrimeiraColocadaMaquina == 48) {
                if (Chance2Possibilidades == 1) {
                    SegundaColocadaMaquina = (PrimeiraColocadaMaquina - 1);
                } else if (Chance2Possibilidades == 2) {
                    SegundaColocadaMaquina = (PrimeiraColocadaMaquina - 7);
                }
            }
            // Terceira Colocada do Primeiro Navio
            if (SegundaColocadaMaquina == (PrimeiraColocadaMaquina - 7)) {
                if (SegundaColocadaMaquina >= 0 && SegundaColocadaMaquina <= 6) {
                    TerceiraColocadaMaquina = (SegundaColocadaMaquina + 14);
                } else if (SegundaColocadaMaquina >= 35 && SegundaColocadaMaquina <= 41) {
                    TerceiraColocadaMaquina = (SegundaColocadaMaquina - 7);
                } else {
                    if (Chance2Possibilidades == 1) {
                        TerceiraColocadaMaquina = (SegundaColocadaMaquina - 7);
                    } else if (Chance2Possibilidades == 2) {
                        TerceiraColocadaMaquina = (SegundaColocadaMaquina + 14);
                    }
                }
            } else if (SegundaColocadaMaquina == (PrimeiraColocadaMaquina + 7)) {
                if (SegundaColocadaMaquina >= 7 && SegundaColocadaMaquina <= 13) {
                    TerceiraColocadaMaquina = (SegundaColocadaMaquina + 7);
                } else if (SegundaColocadaMaquina >= 42 && SegundaColocadaMaquina <= 48) {
                    TerceiraColocadaMaquina = (SegundaColocadaMaquina - 14);
                } else {
                    if (Chance2Possibilidades == 1) {
                        TerceiraColocadaMaquina = (SegundaColocadaMaquina + 7);
                    } else if (Chance2Possibilidades == 2) {
                        TerceiraColocadaMaquina = (SegundaColocadaMaquina - 14);
                    }
                }
            } else if (SegundaColocadaMaquina == (PrimeiraColocadaMaquina - 1)) {
                if (SegundaColocadaMaquina == 0 || SegundaColocadaMaquina % 7 == 0) {
                    TerceiraColocadaMaquina = (SegundaColocadaMaquina + 2);
                } else if ((SegundaColocadaMaquina + 2) % 7 == 0) {
                    TerceiraColocadaMaquina = (SegundaColocadaMaquina - 1);
                } else {
                    if (Chance2Possibilidades == 1) {
                        TerceiraColocadaMaquina = (SegundaColocadaMaquina - 1);
                    } else if (Chance2Possibilidades == 2) {
                        TerceiraColocadaMaquina = (SegundaColocadaMaquina + 2);
                    }
                }
            } else if (SegundaColocadaMaquina == (PrimeiraColocadaMaquina + 1)) {
                if ((SegundaColocadaMaquina - 1) % 7 == 0 || (SegundaColocadaMaquina - 1) == 0) {
                    TerceiraColocadaMaquina = (SegundaColocadaMaquina + 1);
                } else if ((SegundaColocadaMaquina + 1) % 7 == 0) {
                    TerceiraColocadaMaquina = (SegundaColocadaMaquina - 2);
                } else {
                    if (Chance2Possibilidades == 1) {
                        TerceiraColocadaMaquina = (SegundaColocadaMaquina + 1);
                    } else if (Chance2Possibilidades == 2) {
                        TerceiraColocadaMaquina = (SegundaColocadaMaquina - 2);
                    }
                }
            }
            if (NavioCicloCheckMaquina == 1) {
                PrimeiraColocadaMaquina1 = PrimeiraColocadaMaquina;
                SegundaColocadaMaquina1 = SegundaColocadaMaquina;
                TerceiraColocadaMaquina1 = TerceiraColocadaMaquina;
                //ButtonsMaquina[PrimeiraColocadaMaquina1].setBackground(CorNavioProa); ////
                //ButtonsMaquina[SegundaColocadaMaquina1].setBackground(CorNavioMeiaNau); ////
                //ButtonsMaquina[TerceiraColocadaMaquina1].setBackground(CorNavioPopa); ////

                NavioCicloCheckMaquina++;

            } else if (NavioCicloCheckMaquina == 2) {
                PrimeiraColocadaMaquina2 = PrimeiraColocadaMaquina;
                SegundaColocadaMaquina2 = SegundaColocadaMaquina;
                TerceiraColocadaMaquina2 = TerceiraColocadaMaquina;
                if(PrimeiraColocadaMaquina1 != PrimeiraColocadaMaquina2 &&
                 PrimeiraColocadaMaquina1 != SegundaColocadaMaquina2 &&
                 PrimeiraColocadaMaquina1 != TerceiraColocadaMaquina2 &&
                 SegundaColocadaMaquina1 != PrimeiraColocadaMaquina2 &&
                 SegundaColocadaMaquina1 != SegundaColocadaMaquina2 &&
                 SegundaColocadaMaquina1 != TerceiraColocadaMaquina2 &&
                 TerceiraColocadaMaquina1 != PrimeiraColocadaMaquina2 &&
                 TerceiraColocadaMaquina1 != SegundaColocadaMaquina2 &&
                 TerceiraColocadaMaquina1 != TerceiraColocadaMaquina2) {
                    //ButtonsMaquina[PrimeiraColocadaMaquina2].setBackground(CorNavioProa); ////
                    //ButtonsMaquina[SegundaColocadaMaquina2].setBackground(CorNavioMeiaNau); ////
                    //ButtonsMaquina[TerceiraColocadaMaquina2].setBackground(CorNavioPopa); ////
                    NavioCicloCheckMaquina ++;
                } else {
                    for (int j = 0; j <= 48; j++) {
                        ButtonsMaquina[j].setBackground(CorDesconhecido);
                    }
                    NavioCicloCheckMaquina = 1;
                }

            } else if (NavioCicloCheckMaquina == 3) {
                PrimeiraColocadaMaquina3 = PrimeiraColocadaMaquina;
                SegundaColocadaMaquina3 = SegundaColocadaMaquina;
                TerceiraColocadaMaquina3 = TerceiraColocadaMaquina;
                if (PrimeiraColocadaMaquina3 != PrimeiraColocadaMaquina1 &&
                 PrimeiraColocadaMaquina3 != SegundaColocadaMaquina1 &&
                 PrimeiraColocadaMaquina3 != TerceiraColocadaMaquina1 &&
                 SegundaColocadaMaquina3 != PrimeiraColocadaMaquina1 &&
                 SegundaColocadaMaquina3 != SegundaColocadaMaquina1 &&
                 SegundaColocadaMaquina3 != TerceiraColocadaMaquina1 &&
                 TerceiraColocadaMaquina3 != PrimeiraColocadaMaquina1 &&
                 TerceiraColocadaMaquina3 != SegundaColocadaMaquina1 &&
                 TerceiraColocadaMaquina3 != TerceiraColocadaMaquina1 &&
                 PrimeiraColocadaMaquina3 != PrimeiraColocadaMaquina2 &&
                 PrimeiraColocadaMaquina3 != SegundaColocadaMaquina2 &&
                 PrimeiraColocadaMaquina3 != TerceiraColocadaMaquina2 &&
                 SegundaColocadaMaquina3 != PrimeiraColocadaMaquina2 &&
                 SegundaColocadaMaquina3 != SegundaColocadaMaquina2 &&
                 SegundaColocadaMaquina3 != TerceiraColocadaMaquina2 &&
                 TerceiraColocadaMaquina3 != PrimeiraColocadaMaquina2 &&
                 TerceiraColocadaMaquina3 != SegundaColocadaMaquina2 &&
                 TerceiraColocadaMaquina3 != TerceiraColocadaMaquina2){
                    //ButtonsMaquina[PrimeiraColocadaMaquina3].setBackground(CorNavioProa); ////
                    //ButtonsMaquina[SegundaColocadaMaquina3].setBackground(CorNavioMeiaNau); ////
                    //ButtonsMaquina[TerceiraColocadaMaquina3].setBackground(CorNavioPopa); ////
                    NavioCicloCheckMaquina++;
                } else{
                    for (int j = 0; j <= 48; j++) {
                        ButtonsMaquina[j].setBackground(CorDesconhecido);
                    }
                    NavioCicloCheckMaquina = 1;
                } // Fim da sequência de check do terceiro navio
            } // Último check da sequência de todos os navios
        } // Ciclo de repetição para colocação dos navios
    } // Bloco do método
} // Bloco da Classe
