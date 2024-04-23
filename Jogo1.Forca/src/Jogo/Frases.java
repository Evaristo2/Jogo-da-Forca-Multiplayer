package Jogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Frases {
    private List<String> frases = new ArrayList<>();

    {
        iniciarFrases();
    }

    public void iniciarFrases() {
        frases.add("ME DÊ MOTIVO");
        frases.add("NÃO QUERO DINHEIRO");
        frases.add("O DESCOBRIDOR DOS SETE MARES");
        frases.add("AZUL DA COR DO MAR");
        frases.add("GOSTAVA TANTO DE VOCÊ");
        frases.add("DEIXA AS COISAS TRISTES PRA DEPOIS");
        frases.add("DO LEME AO PONTAL");
        frases.add("NÃO VOU FICAR");
    }

    public String fraseEscolhida() {
        Random random = new Random();
        int num = random.nextInt(frases.size());
        return frases.get(num);
    }

    public List<String> getFrases() {
        return frases;
    }
}