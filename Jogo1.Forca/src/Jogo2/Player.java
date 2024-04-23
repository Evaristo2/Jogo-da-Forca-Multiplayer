package Jogo2;

public class Player {
    private String nome;
    private int vidas;

    public Player(String nome) {
        this.nome = nome;
        this.vidas = 4;
    }

    public String getNome() {
        return nome;
    }

    public int getVidas() {
        return vidas;
    }

    public void perdeVida() {
        vidas--;
    }

    public boolean playerVivo() {
        return vidas > 0;
    }
}
