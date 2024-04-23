package Jogo;

import java.util.List;
import java.util.Scanner;

public class Jogo {
    private static final String frase = "AZUL DA COR DO MAR";
    private static final int vidas = 4;
    private static final char vazio = '_';
	private static boolean jogoRodando = true;
    private List<Jogador> jogadores;
    private AmbienteDoJogo ambiente;
    

    public Jogo(List<Jogador> jogadores) {
        this.jogadores = jogadores;
        this.ambiente = new AmbienteDoJogo(frase);
    }
    

    public void jogar() {
        int playerAtual = 0;

        while (isJogoRodando() && !jogadores.isEmpty()) {
            Jogador jogador = jogadores.get(playerAtual);

            if (jogador.getVidas() <= 0) {
                System.out.println("O jogador " + jogador.getNome() + " não tem mais vidas e foi eliminado do jogo.");
                jogadores.remove(playerAtual);
                playerAtual %= jogadores.size();
                continue;
            }

            if (jogador.getRodada() == 1) {
                jogadaLetra(jogador);
            } else {
                jogadaOpcao(jogador);
            }

            ambiente.mostrar();

            if (ambiente.isFraseCompleta()) {
                System.out.println("Muito bem! " + jogador.getNome().toUpperCase() + " acertou a frase e ganhou o jogo");
                setJogoRodando(false);
            }

            jogador.incrementarRodada();
            playerAtual = (playerAtual + 1) % jogadores.size();
        }
    }

    
    private void jogadaLetra(Jogador jogador) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\nVez do " + jogador.getNome().toUpperCase());
        System.out.println("Digite uma letra:");
        
        char letra = scan.nextLine().toUpperCase().charAt(0);

        if (frase.contains(String.valueOf(letra))) {
            ambiente.revelarLetra(letra);
            System.out.println("Letra correta!");
            System.out.println("##############################################");
        } else {
            jogador.perderVida();
            ambiente.desenharProximo();
            System.out.println("Letra incorreta! Você perdeu uma vida.");
            System.out.println("##############################################");
        }
    }
    

    private void jogadaOpcao(Jogador jogador) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vez de " + jogador.getNome().toUpperCase());
        System.out.println("Escolha uma opção:");
        System.out.println("1. Chutar a palavra");
        System.out.println("2. Tentar outra letra");

        int opcao = scan.nextInt();
        scan.nextLine();

        if (opcao == 1) {
            System.out.println("Digite a palavra:");
            String chute = scan.nextLine().toUpperCase();

            if (chute.equals(frase)) {
                ambiente.revelarFrase();
                System.out.println("Parabéns! Você acertou a palavra.");
                System.out.println("##############################################");
            } else {
                jogador.perderVida();
                ambiente.desenharProximo();
                System.out.println("Palavra incorreta! Você perdeu uma vida.");
                System.out.println("##############################################");
            }
        } else if (opcao == 2) {
            jogadaLetra(jogador);
        }
    }
    

	public static int getVidas() {
		return vidas;
	}

	public static char getVazio() {
		return vazio;
	}


	public static boolean isJogoRodando() {
		return jogoRodando;
	}


	public static void setJogoRodando(boolean jogoRodando) {
		Jogo.jogoRodando = jogoRodando;
	}
}