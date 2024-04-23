package Jogo;

public class TelaInicial {
	
	public static void inicio() {
		System.out.println("""
				##############################################
				
					   Bem vindo(a) ao jogo da
						   FORCA
						
				##############################################
				""");
		System.out.println("""
				  	 	AS REGRAS SÃO:
				- Apenas a partir da segunda rodada será 
				possível realizar tentativas de chute.
				
				- Se escolher uma letra que já foi mencionada
				perde a rodada e uma parte do corpo.
				
				- Todos terão 4 erros disponíveis.
				
				- Todas as regras do jogo da forca são 
				aplicadas à esse jogo.
				
				##############################################
				""");
		System.out.println("Vamos para o cadastro dos jogadores?");

	}
}
