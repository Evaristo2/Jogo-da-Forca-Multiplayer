package Jogo;

public class TesteJogar {
	public static void main(String[] args) {

		TelaInicial.inicio();

		Cadastro cadastro = new Cadastro();
		cadastro.cadastraPlayer();
		cadastro.mostraPlayers();

		Jogo jogo = new Jogo(cadastro.getJogadores());
		jogo.jogar();
		
	}
}
