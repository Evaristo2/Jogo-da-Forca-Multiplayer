package Jogo2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // CHAMA O MÉTODO DE BOAS VINDAS
        Inicio.inicio();
        
        
        // LÓGICA DO CADASTRO DE JOGADORES (IMPLEMENTAR EM UMA CLASSE DEPOIS)
        List<Player> jogadores = new ArrayList<>();
        System.out.println("Quantos jogadores vão participar?");
        int numJogadores = scan.nextInt();
        scan.nextLine();

        for (int contador = 1; contador <= numJogadores; contador++) {
            System.out.print("Digite o nome do jogador " + contador + ": ");
            String nome = scan.nextLine();
            Player jogador = new Player(nome);
            jogadores.add(jogador);
        }

        // VERIFICAÇÃO DE CADASTRADOS
        System.out.println("\nJogadores cadastrados:");
        for (Player jogador : jogadores) {
            System.out.println(jogador.getNome());
        }

        // CHAMA O MÉTODO DE INICIALIZAÇÃO O JOGO
        Game jogo = new Game(jogadores);
        jogo.iniciarJogo();
        
        // IMPLEMENTAR A CLASSE FRASES, PARA AS FRASES VIREM DE FORMA ALEATÓRIA
        
        // IMPLEMENTAR UM EXCEPTION
        
        // IMPLEMENTAR PALAVRAS QUE JÁ FORAM (palavrasErradas

        // IMPLEMENTAR O limpaConsole()
    }
    
}
