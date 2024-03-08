package dungeonclash;

public class Arqueiro extends Classe {
	
	public Arqueiro(int forca, int agilidade, int inteligencia) {
		super(forca, agilidade, inteligencia);
		adicionarHabilidades("Socar", 3, false, false);
		adicionarHabilidades("Atirar Flecha", 4, false, false);
		adicionarHabilidades("Flecha Encantada", 5, false, false);
	}
	
	public void adicionarHabilidades(String nome, int tempo, boolean afetaAmigos, boolean afetaTodos) {
		Habilidades habilidade = new Habilidades(nome, tempo, afetaAmigos, afetaTodos);
		super.setHabilidade(habilidade);
	}
}
