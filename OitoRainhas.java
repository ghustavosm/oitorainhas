package oitorainhas;

import java.util.ArrayList;
import java.util.Collections;

public class OitoRainhas {
	
	private Tabuleiro tabuleiro;
	private ArrayList<int[][]> solucoesEncontradas;
	private int tentativas;
	
	public OitoRainhas(int tamanhoTabuleiro) {
		this.tabuleiro = new Tabuleiro(tamanhoTabuleiro);
		this.tentativas = 0;
		this.solucoesEncontradas = new ArrayList<>();
	}
	
	public Tabuleiro getTabuleiro() {
		return this.tabuleiro;
	}
	
	/*
	 * Tenta encontrar uma solução e retorna true se encontrou ou false se não encontrou
	 */
	public boolean tentativaDeSolucao() {
		for(int i = 0; i < 8; i++) {
			tabuleiro.colocaRainha();
			if(tabuleiro.getQuantidadeRainhas() == 4 && tabuleiro.casasDisponiveis() < 4) {
				tabuleiro.limpaTabuleiro();
				return false;
			} else if(tabuleiro.getQuantidadeRainhas() == 5 && tabuleiro.casasDisponiveis() < 3) {
				tabuleiro.limpaTabuleiro();
				return false;
			} else if(tabuleiro.getQuantidadeRainhas() == 6 && tabuleiro.casasDisponiveis() < 2) {
				tabuleiro.limpaTabuleiro();
				return false;
			} else if(tabuleiro.getQuantidadeRainhas() == 7 && tabuleiro.casasDisponiveis() < 1) {
				tabuleiro.limpaTabuleiro();
				return false;
			}
		}
		this.solucoesEncontradas.add(this.tabuleiro.getTabuleiro());
		tabuleiro.limpaTabuleiro();
		return true;
	}
	
	/*
	 * Limpa o tabuleiro e contabiliza as tentativas
	 */
	private void novaTentativa() {
		tabuleiro.limpaTabuleiro();
		this.tentativas++;
	}
	
	/*
	 * Encontra uma solução para as 8 rainhas e exibe a quantidade de tentativas
	 */
	public void encontrarUmaSolucao() {
		this.tentativas = 1;
		while(tabuleiro.getQuantidadeRainhas() < 8) {
			tabuleiro.colocaRainha();
			if(tabuleiro.getQuantidadeRainhas() == 4 && tabuleiro.casasDisponiveis() < 4) {
				this.novaTentativa();
			} else if(tabuleiro.getQuantidadeRainhas() == 5 && tabuleiro.casasDisponiveis() < 3) {
				this.novaTentativa();
			} else if(tabuleiro.getQuantidadeRainhas() == 6 && tabuleiro.casasDisponiveis() < 2) {
				this.novaTentativa();
			} else if(tabuleiro.getQuantidadeRainhas() == 7 && tabuleiro.casasDisponiveis() < 1) {
				this.novaTentativa();
			}
		}
		tabuleiro.imprimeTabuleiro();
		System.out.printf("Tentativas: %d\n", this.tentativas);
	}
	
	/*
	 * Executa 1000 iterações e exibe os resultados
	 */
	public void milIteracoes() {
		System.out.printf("%-12s %-18s\n", "Iteração", "Solução encontrada");
		int i;
		for(i = 1; i <= 1000; i++) {
			System.out.printf("%-12d %-18s\n", i, this.tentativaDeSolucao() ? "Verdadeiro" : "Falso");
		}
		System.out.println(String.join("", Collections.nCopies(31, "*")));
		System.out.printf("%-12s %-18s\n", "Total", "Soluções");
		System.out.printf("%-12d %-18s\n", 1000, this.solucoesEncontradas.size());
	}
	
}