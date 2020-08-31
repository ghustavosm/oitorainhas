package oitorainhas;

public class Aplicacao {
	
	public static void main(String[] args) {
		// Cria o desafio com um tabuleiro 8x8
		OitoRainhas oitoRainhas = new OitoRainhas(8);
		
		// Encontra uma solu��o
		oitoRainhas.encontrarUmaSolucao();
		
		System.out.println();
		System.out.println();
		
		// Realiza 1000 itera��es e exibe os resultados
		oitoRainhas.milIteracoes();
	}
}
