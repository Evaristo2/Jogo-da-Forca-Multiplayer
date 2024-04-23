package Jogo2;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static final String frase = "AZUL DA COR DO MAR";
    private List<Player> players;
    private Scanner scan;

    public Game(List<Player> players) {
        this.players = players;
        this.scan = new Scanner(System.in);
    }
    
    
    // MÉTODO DE INICIALIZAÇÃO DO JGOO
	public void iniciarJogo() {
        char[] palavraEscondida = new char[frase.length()];
        for (int contador = 0; contador < frase.length(); contador++) {
            if (frase.charAt(contador) == ' ') {
                palavraEscondida[contador] = ' ';
            } else {
                palavraEscondida[contador] = '_';
            }
        }

        boolean jogoRodando = true;
        int rodada = 1;
        Player vencedor = null;
        
        // LOOPING DO JOGO
        while (jogoRodando) {
            for (Player player : players) {
                if (!player.playerVivo()) {
                	System.out.println(player.getNome() + " perdeu todas as vidas e foi eliminado! ");
                    continue;
                }
                // EXIBE O DESENHO DA FORCA
                desenhoForca(player.getVidas(), player, palavraEscondida);
                
                
                if (player.getVidas() == 0) {
                    System.out.println("Você perdeu todas as vidas! Fim de jogo para " + player.getNome());
                    continue;
                }

                // RODADA 1
                if (rodada == 1) {
                    System.out.print("Digite uma letra: ");
                    char letra = scan.nextLine().toUpperCase().charAt(0);
                    boolean letraEncontrada = false;
                    
                    for (int contador = 0; contador < frase.length(); contador++) {
                        if (frase.charAt(contador) == letra) {
                            palavraEscondida[contador] = letra;
                            letraEncontrada = true;
                        }
                    }

                    // VERIFICA SE EXISTE A LETRA NA FRASE
                    if (!letraEncontrada) {
                        player.perdeVida();
                        System.out.println("Letra incorreta! Você perdeu uma vida.");
                    } else {
                        System.out.println("Letra correta!");
                    }
                } else {
                	
                    // RODADA 2 EM DIANTE
                    System.out.println("Escolha uma opção:");
                    System.out.println("1 - Chutar a palavra");
                    System.out.println("2 - Escolher uma letra");
                    int opcao = scan.nextInt();
                    scan.nextLine();
                    
                    // OPÇÃO 1 - CHUTAR A PALAVRA
                    if (opcao == 1) {
                        System.out.print("Digite a palavra: ");
                        String chute = scan.nextLine().toUpperCase();
                        if (chute.equals(frase)) {
                            System.out.println("Parabéns "+ player.getNome()+"! Você acertou a palavra e venceu o jogo.");
                            jogoRodando = false;
                            break;
                        } else {
                            player.perdeVida();
                            System.out.println("Palavra incorreta! Você perdeu uma vida.");
                        }
                        
                    // OPÇÃO 2 - ESCOLHER UMA LETRA
                    } else if (opcao == 2) {
                        System.out.print("Digite uma letra: ");
                        char letra = scan.nextLine().toUpperCase().charAt(0);
                        boolean letraEncontrada = false;
                        
                        for (int contador = 0; contador < frase.length(); contador++) {
                            if (frase.charAt(contador) == letra) {
                                palavraEscondida[contador] = letra;
                                letraEncontrada = true;
                            }
                        }

                        // VERIFICA SE EXISTE A LETRA NA FRASE
                        if (!letraEncontrada) {
                            player.perdeVida();
                            System.out.println("Letra incorreta! Você perdeu uma vida.");
                        }else if (player.getVidas() == 0) {
                            System.out.println("Você perdeu todas as vidas! Fim de jogo para " + player.getNome());
                            continue;
                        }else {
                            System.out.println("Letra correta!");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                }
                
                // VERIFICA SE A FRASE É A PALAVRA COMPLETA NO CONSOLE
                if (palavraCompleta(palavraEscondida)) {
                	vencedor = player;
                	jogoRodando = false;
                	System.out.println("Muito bem " + vencedor.getNome() + "!! Você ganhou o jogo.");
                	break;
                }
                
            }

            rodada++;
        }
      

        scan.close();
    }
    


	// VERIFICA SE A PALAVRA NO CONSOLE ESTÁ COMPLETA
    private boolean palavraCompleta(char[] palavra) {
    	for (char caracter : palavra) {
    		if (caracter == '_') {
    			return false;
    		}
    	}
    	return true;
    }

    
    // ESTRUTURA DA FORCA (DESENHO)
    private void desenhoForca(int vidasRestantes, Player jogadorAtual, char[] palavraEscondida) {
    	 System.out.println("\nVez de " + jogadorAtual.getNome());
         System.out.println();
         
    	switch (vidasRestantes) {
            case 4:
                System.out.println("____");
                System.out.println("|  |");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                break;
            case 3:
                System.out.println("____");
                System.out.println("|  |");
                System.out.println("|  O");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                break;
            case 2:
                System.out.println("____");
                System.out.println("|  |");
                System.out.println("|  O");
                System.out.println("| / \\");
                System.out.println("|");
                System.out.println("|");
                break;
            case 1:
                System.out.println("____");
                System.out.println("|  |");
                System.out.println("|  O");
                System.out.println("| /|\\");
                System.out.println("|");
                System.out.println("|");
                break;
            default:
                System.out.println("____");
                System.out.println("|  |");
                System.out.println("|  O");
                System.out.println("| /|\\");
                System.out.println("| / \\");
                System.out.println("|");
        }
    	System.out.println("Palavra: " + String.valueOf(palavraEscondida));
    	System.out.println(jogadorAtual.getNome() + " tem: " + jogadorAtual.getVidas() + " chances disponíveis.");
    	System.out.println();
    }

}
