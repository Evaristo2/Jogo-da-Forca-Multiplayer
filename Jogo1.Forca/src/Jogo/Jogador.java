package Jogo;

public class Jogador {
    private String nome;
    private int vidas;
    private int rodada;

    public Jogador(String nome) {
        this.nome = nome;
        this.vidas = 4;
        this.rodada = 1;
    }

    public String getNome() {
        return nome;
    }

    public int getVidas() {
        return vidas;
    }

    public void perderVida() {
        vidas--;
        if(vidas==0) {
        	Jogo.setJogoRodando(false);
        }
    }

    public int getRodada() {
        return rodada;
    }

	public void incrementarRodada() {
		rodada++;
	}
}
