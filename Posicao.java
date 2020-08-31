package oitorainhas;

public class Posicao {
	private int i;
	private int j;
	
	public Posicao(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public int getLinha() {
		return this.i;
	}
	
	public int getColuna() {
		return this.j;
	}
}
