package oitorainhas;

import java.util.Random;

public class Tabuleiro {
	
	private int tamanhoTabuleiro;
	private int[][] tabuleiro;
	private int quantidadeRainhas;
	
	public Tabuleiro(int tamanho) {
		this.tamanhoTabuleiro = tamanho;
		this.tabuleiro = new int[tamanho][tamanho];
		this.quantidadeRainhas = 0;
	}

	public int[][] getTabuleiro() {
		return this.tabuleiro;
	}
	
	public int getQuantidadeRainhas() {
		return this.quantidadeRainhas;
	}
	
	/*
	 * Retorna uma posição disponível e aleatória do tabuleiro
	 */
	public Posicao posicaoAleatoria() {
		Random random = new Random();
		int i = random.nextInt(this.tamanhoTabuleiro);
		int j = random.nextInt(this.tamanhoTabuleiro);
		
		while(this.tabuleiro[i][j] != 0) { // Gera uma nova posição enquanto não encontrar uma disponível
			i = random.nextInt(this.tamanhoTabuleiro);
			j = random.nextInt(this.tamanhoTabuleiro);
		}
		return new Posicao(i,j);
	}
	
	/*
	 * Preenche com 1 as casas bloqueadas pela rainha recém inserida no tabuleiro
	 */
	public void bloqueiaCasas(int linha, int coluna) {
		for(int i = 0; i < this.tamanhoTabuleiro; i++) {
			this.tabuleiro[i][coluna] = 1; // bloqueia a linha
			for(int j = 0; j < this.tamanhoTabuleiro; j++) {
				if(i == linha+coluna-j || i == linha-coluna+j) {  // bloqueia as diagonais
					this.tabuleiro[i][j] = 1;
				}
				this.tabuleiro[linha][j] = 1;  // bloqueia a coluna
			}
		}
	}
	
	/*
	 * Verifica se a casa está disponível
	 */
	public boolean isCasaDisponivel() {
		for(int i = 0; i < this.tamanhoTabuleiro; i++) {
			for(int j = 0; j < this.tamanhoTabuleiro; j++) {
				if(this.tabuleiro[i][j] == 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	/*
	 * Conta as casas disponíveis
	 */
	public int casasDisponiveis() {
		int casasDisponiveis = 0;
		for(int i = 0; i < this.tamanhoTabuleiro; i++) {
			for(int j = 0; j < this.tamanhoTabuleiro; j++) {
				if(this.tabuleiro[i][j] == 0) {
					casasDisponiveis++;
				}
			}
		}
		return casasDisponiveis;
	}
	
	/*
	 * Insere uma rainha no tabuleiro
	 */
	public boolean colocaRainha() {
		if(this.isCasaDisponivel()) {
			Posicao posicao = this.posicaoAleatoria();
			this.bloqueiaCasas(posicao.getLinha(), posicao.getColuna());
			this.tabuleiro[posicao.getLinha()][posicao.getColuna()] = 2; // Preeche com 2 a casa onde a rainha está
			this.quantidadeRainhas++;
			return true;
		}
		return false;
	}
	
	/*
	 * Preenche o tabuleiro com zeros
	 */
	public void limpaTabuleiro() {
		for(int i = 0; i < this.tamanhoTabuleiro; i++) {
			for(int j = 0; j < this.tamanhoTabuleiro; j++) {
				this.tabuleiro[i][j] = 0;
			}
		}
		this.quantidadeRainhas = 0;
	}
	
	/*
	 * Imprime o tabuleiro na tela mostrando a posição de cada rainha
	 */
	public void imprimeTabuleiro() {
		for(int i = 0; i < this.tamanhoTabuleiro; i++) {
			for(int j = 0; j < this.tamanhoTabuleiro; j++) {
				System.out.printf("%2s", this.tabuleiro[i][j] == 2 ? 'R' : '0');
			}
			System.out.println();
		}
		System.out.printf("Quantidade de rainhas: %d\n", this.quantidadeRainhas);
	}
	
}
