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

    AtaqueDaMaquina() {
        for (int i = 0; i <= 48; i++) {
            ButtonsMaquina[i].addActionListener(ReceberAtaqueListener);
            ListaPossiveisTiros.add(48 - i);
            if (i >= 1 && i <= 16) {
                ListaPossiveisPrimeiroTiroDaSequencia.add((i * 3) - 1);
            }
        }
    }

    ActionListener ReceberAtaqueListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e4) {

            for (int i = 0; i <= 48; i++) {
                if (e4.getSource() == ButtonsMaquina[i]) {
                    ButtonsMaquina[i].removeActionListener(ReceberAtaqueListener);
                }
            }

            if (AcertosSeguidosMaquina == 0) {
                AtirarPrimeiroTiroDaSequencia();
            } else if (AcertosSeguidosMaquina == 1) {
                AtirarSegundoTiroDaSequencia();
            } else if (AcertosSeguidosMaquina == 2) {
                AtirarTerceiroTiroDaSequencia();
            }
            if (QuantAcertosMaquina == 9) {
                JOptionPane.showMessageDialog(null, "Você perdeu!", "Derrota", JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            }
        }
    }; // Bloco do listener

    public void AtirarPrimeiroTiroDaSequencia() {
        do {
            FirstTiroMaqRandomIndex = random.nextInt(ListaPossiveisPrimeiroTiroDaSequencia.size());
            PrimeiraCoordTiroMaquina = ListaPossiveisPrimeiroTiroDaSequencia.get(FirstTiroMaqRandomIndex);

        } while (ListaPossiveisPrimeiroTiroDaSequencia.get(FirstTiroMaqRandomIndex) < 0);
        ListaPossiveisPrimeiroTiroDaSequencia.set(FirstTiroMaqRandomIndex, -1);
        ListaPossiveisTiros.set(PrimeiraCoordTiroMaquina, -1);

        if (PrimeiraCoordTiroMaquina == CoordPrimeiroNavioProa ||
                PrimeiraCoordTiroMaquina == CoordPrimeiroNavioMeiaNau ||
                PrimeiraCoordTiroMaquina == CoordPrimeiroNavioPopa ||
                PrimeiraCoordTiroMaquina == CoordSegundoNavioProa ||
                PrimeiraCoordTiroMaquina == CoordSegundoNavioMeiaNau ||
                PrimeiraCoordTiroMaquina == CoordSegundoNavioPopa ||
                PrimeiraCoordTiroMaquina == CoordTerceiroNavioProa ||
                PrimeiraCoordTiroMaquina == CoordTerceiroNavioMeiaNau ||
                PrimeiraCoordTiroMaquina == CoordTerceiroNavioPopa) {
            ButtonsJogador[PrimeiraCoordTiroMaquina].setIcon(BlocoAtiradoAcerto);
            LabelFeitosMaquina.setText("Inimigo acertou!");
            QuantAcertosMaquina++;
            AcertosSeguidosMaquina = 1;
        } else {
            ButtonsJogador[PrimeiraCoordTiroMaquina].setIcon(BlocoAtiradoErro);
            LabelFeitosMaquina.setText("Inimigo errou!");
        }
    }

    public void AtirarSegundoTiroDaSequencia() {
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
        Lista2Possibilidades.removeAll(Lista2Possibilidades);
        Lista3Possibilidades.removeAll(Lista3Possibilidades);
        Lista4Possibilidades.removeAll(Lista4Possibilidades);
        ListaPossiveisTiros.set(SegundaCoordTiroMaquina, -1);
        if (CheckTestouTodasAsPossibilidades != 1) {
            if (SegundaCoordTiroMaquina == CoordPrimeiroNavioProa ||
                    SegundaCoordTiroMaquina == CoordPrimeiroNavioMeiaNau ||
                    SegundaCoordTiroMaquina == CoordPrimeiroNavioPopa ||
                    SegundaCoordTiroMaquina == CoordSegundoNavioProa ||
                    SegundaCoordTiroMaquina == CoordSegundoNavioMeiaNau ||
                    SegundaCoordTiroMaquina == CoordSegundoNavioPopa ||
                    SegundaCoordTiroMaquina == CoordTerceiroNavioProa ||
                    SegundaCoordTiroMaquina == CoordTerceiroNavioMeiaNau ||
                    SegundaCoordTiroMaquina == CoordTerceiroNavioPopa) {
                ButtonsJogador[SegundaCoordTiroMaquina].setIcon(BlocoAtiradoAcerto);
                LabelFeitosMaquina.setText("Inimigo acertou!");
                QuantAcertosMaquina++;
                AcertosSeguidosMaquina = 2;
            } else {
                ButtonsJogador[SegundaCoordTiroMaquina].setIcon(BlocoAtiradoErro);
                LabelFeitosMaquina.setText("Inimigo errou!");
            }
        } else {
            //CenarioEspecial1();
            System.out.println("buceta");
            AcertosSeguidosMaquina = 0;
        }
    }

    public void AtirarTerceiroTiroDaSequencia() {
        do {
            Chance2Possibilidades = random.nextInt(2) + 1;
            Chance3Possibilidades = random.nextInt(3) + 1;
            Chance4Possibilidades = random.nextInt(4) + 1;
            Lista2Possibilidades.add(Chance2Possibilidades);
            Lista3Possibilidades.add(Chance3Possibilidades);
            Lista4Possibilidades.add(Chance4Possibilidades);
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
            if (Lista2Possibilidades.contains(1) && Lista2Possibilidades.contains(2) &&
                    Lista3Possibilidades.contains(1) && Lista3Possibilidades.contains(2) &&
                    Lista3Possibilidades.contains(3) && Lista4Possibilidades.contains(1) &&
                    Lista4Possibilidades.contains(2) && Lista4Possibilidades.contains(3) &&
                    Lista4Possibilidades.contains(4)) {
                CheckTestouTodasAsPossibilidades = 1;
            } else {
                CheckTestouTodasAsPossibilidades = 0;
            }
        } while (ListaPossiveisTiros.get(TerceiraCoordTiroMaquina) < 0 && CheckTestouTodasAsPossibilidades == 0);
        Lista2Possibilidades.removeAll(Lista2Possibilidades);
        Lista3Possibilidades.removeAll(Lista3Possibilidades);
        Lista4Possibilidades.removeAll(Lista4Possibilidades);
        ListaPossiveisTiros.set(TerceiraCoordTiroMaquina, -1);
        if (CheckTestouTodasAsPossibilidades != 1) {
            if (TerceiraCoordTiroMaquina == CoordPrimeiroNavioProa ||
                    TerceiraCoordTiroMaquina == CoordPrimeiroNavioMeiaNau ||
                    TerceiraCoordTiroMaquina == CoordPrimeiroNavioPopa ||
                    TerceiraCoordTiroMaquina == CoordSegundoNavioProa ||
                    TerceiraCoordTiroMaquina == CoordSegundoNavioMeiaNau ||
                    TerceiraCoordTiroMaquina == CoordSegundoNavioPopa ||
                    TerceiraCoordTiroMaquina == CoordTerceiroNavioProa ||
                    TerceiraCoordTiroMaquina == CoordTerceiroNavioMeiaNau ||
                    TerceiraCoordTiroMaquina == CoordTerceiroNavioPopa) {
                ButtonsJogador[TerceiraCoordTiroMaquina].setIcon(BlocoAtiradoAcerto);
                LabelFeitosMaquina.setText("Inimigo acertou!");
                QuantAcertosMaquina++;
                AcertosSeguidosMaquina = 0;
            } else {
                ButtonsJogador[TerceiraCoordTiroMaquina].setIcon(BlocoAtiradoErro);
                LabelFeitosMaquina.setText("Inimigo errou!");
            }
        } else {
            //CenarioEspecial2();
            System.out.println("buceta");
            AcertosSeguidosMaquina = 0;
        }
    }

    public void CenarioEspecial1() {
        AcertosSeguidosMaquina = 2;
        AtirarTerceiroTiroDaSequencia();
        SegundaCoordTiroMaquina = PrimeiraCoordTiroMaquina;
    }

    public void CenarioEspecial2() {
        AcertosSeguidosMaquina = 1;
        AtirarSegundoTiroDaSequencia();
    }

}
