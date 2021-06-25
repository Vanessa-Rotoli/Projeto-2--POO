package edu.fatecmm;

import edu.fatecmm.model.Jogador;

import java.util.Scanner;

public class BatalhaNaval {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int VS = 0;
        int vez = 1;
        int opcao;
        Jogador jogador1, jogador2;

        jogador1 = new Jogador();
        System.out.println("Digite o seu nome: ");
        jogador1.nome = sc.nextLine();
        jogador1.idBarco();
        jogador1.MontarTabuleiro();

        jogador2 = new Jogador();
        do {
            System.out.println("Digite:");
            System.out.println(" 1 para acrescentar um novo jogador");
            System.out.println(" 2 para jogar contra a máquina");
            opcao = Integer.parseInt(sc.nextLine());
        } while ((opcao <0) || (opcao > 2));

        if (opcao == 1) {
            System.out.println("Digite o seu nome: ");
            jogador2.nome = sc.nextLine();
            jogador2.idBarco();
            jogador2.MontarTabuleiro();
        }
        else {
            jogador2.nome = "Máquina";
            jogador2.idBarco();
            jogador2.MontarTabuleiroMaquina();
        }

        while (VS == 0) {
            if (vez == 1) {
                System.out.println("Jogador 1 " + jogador1.nome);

                jogador1.jogar(jogador2);

                VS = jogador2.VerificarStatus(jogador2.cruzador.isStatus, jogador2.destruidor.isStatus,
                        jogador2.navioGuerra.isStatus, jogador2.portaAvioes.isStatus,
                        jogador2.submarino.isStatus);
                if (VS == 1) {
                    System.out.println("Voce Ganhou o jogo!! ");
                    System.out.println("Ganhador" + jogador1.nome);
                    jogador1.imprimirTabuleiro();
                    System.out.println("");
                    System.out.println("Tabuleiro derrotado");
                    jogador2.imprimirTabuleiro();
                }
                vez = 2;

            }
            else {

                if (opcao == 1) {
                    System.out.println("Jogador 2 " + jogador2.nome);
                    jogador2.jogar(jogador1);

                    VS = jogador1.VerificarStatus(jogador1.cruzador.isStatus, jogador1.destruidor.isStatus,
                            jogador1.navioGuerra.isStatus, jogador1.portaAvioes.isStatus,
                            jogador1.submarino.isStatus);
                    if (VS == 1) {
                        System.out.println("Voce Ganhou o jogo!! ");
                        System.out.println("Ganhador" + jogador2.nome);
                        jogador2.imprimirTabuleiro();
                        System.out.println("");
                        System.out.println("Tabuleiro derrotado");
                        jogador1.imprimirTabuleiro();
                    }
                    vez = 1;
                }
                else {
                    System.out.println("Jogador 2 " + jogador2.nome);
                    jogador2.jogarMaquina(jogador1);

                    VS = jogador1.VerificarStatus(jogador1.cruzador.isStatus, jogador1.destruidor.isStatus,
                            jogador1.navioGuerra.isStatus, jogador1.portaAvioes.isStatus,
                            jogador1.submarino.isStatus);
                    if (VS == 1) {
                        System.out.println("A máquina ganhou o jogo!! ");
                        System.out.println("Tabuleiro Ganhador");
                        jogador2.imprimirTabuleiro();
                        System.out.println("");
                        System.out.println("Tabuleiro derrotado");
                        jogador1.imprimirTabuleiro();
                    }
                    vez = 1;
                }

            }

        }
    }

}

