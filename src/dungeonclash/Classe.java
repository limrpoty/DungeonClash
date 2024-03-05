package dungeonclash;

import java.util.List;

public abstract class Classe {
	private int forca;
	private int agilidade;
	private int inteligencia;
	private List<Habilidades> habilidade;
	
	public Classe(int forca, int agilidade, int inteligencia) {
		this.agilidade = agilidade;
		this.forca = forca;
		this.inteligencia = inteligencia;
	}
	
	public List<Habilidades> getHabilidade() {
		return habilidade;
	}
	
	public void setHabilidade(Habilidades habilidade) {
		this.habilidade.add(habilidade);
	}
	
	public int getInteligencia() {
		return inteligencia;
	}
	
	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}
	
	public int getAgilidade() {
		return agilidade;
	}
	
	public void setAgilidade(int agilidade) {
		this.agilidade = agilidade;
	}
	
	public int getForca() {
		return forca;
	}
	
	public void setForca(int forca) {
		this.forca = forca;
	}
}
