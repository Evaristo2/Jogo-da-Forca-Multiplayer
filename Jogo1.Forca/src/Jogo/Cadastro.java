package Jogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cadastro {
	private List<Jogador> jogadores;
	
	public Cadastro() {
		this.jogadores = new ArrayList<>();
	}

	public void cadastraPlayer() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o número de jogadores: ");
		int numeroDeJogadores = scan.nextInt();
		scan.nextLine();
		
		for(int contador = 1; contador <= numeroDeJogadores; contador++) {
			System.out.println("Digite o nome do jogador " + contador + ": ");
			String nome = scan.nextLine();
			
			Jogador jogador = new Jogador(nome);
			jogadores.add(jogador);
		}
	}
	
	
	public List<Jogador> getJogadores() {
		return jogadores;
	}
	
	public void mostraPlayers() {
		System.out.println("""
				Para conferir, estão aqui todos os jogadores
				e ordens de jogada:
				""");
		
		for(Jogador jogador : jogadores) {
			System.out.println(jogador.getNome());
		}
	}
}
