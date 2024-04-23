package Jogo;

public class AmbienteDoJogo {
    private String frase;
    private StringBuilder palavraEscondida;
    private int vidasRestantes;

    public AmbienteDoJogo(String frase) {
        this.frase = frase.toUpperCase();
        this.palavraEscondida = new StringBuilder();
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ') {
                palavraEscondida.append(' ');
            } else {
                palavraEscondida.append(Jogo.getVazio());
            }
        }
        this.vidasRestantes = Jogo.getVidas();
    }

    public void revelarLetra(char letra) {
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == letra) {
                palavraEscondida.setCharAt(i, letra);
            }
        }
    }

    public void revelarFrase() {
        palavraEscondida = new StringBuilder(frase);
    }

    public void desenharProximo() {
        vidasRestantes--;
    }

    public void mostrar() {
        
        System.out.println("Forca:");
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
        System.out.println(" " + palavraEscondida);
        System.out.println("O jogador tem " + vidasRestantes + " vidas restantes: ");
        System.out.println();
        System.out.println("##############################################");
    }

    public boolean isFraseCompleta() {
        return palavraEscondida.toString().equals(frase);
    }
}