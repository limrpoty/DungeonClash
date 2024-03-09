package dungeonclash;

public class Habilidades {
	private String nome;
	private int pesosDano, pesosMana;
	private int tempoEspera;
	private boolean afetaTodos, afetaAmigos;
	private static int id;
	
	public Habilidades(String nome, int i, int j, int tempo, boolean afetaAmigos, boolean afetaTodos) {
		this.nome = nome;
		this.pesosDano = i;
		this.pesosMana = j;
		this.afetaAmigos = afetaAmigos;
		this.afetaTodos = afetaTodos;
		this.tempoEspera = tempo;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getPesosMana() {
		return pesosMana;
	}
	
	public void setPesosMana(int pesosMana) {
		this.pesosMana = pesosMana;
	}
	
	public int getTempo() {
		return tempoEspera;
	}
	
	public void setTempo(int tempo) {
		this.tempoEspera = tempo;
	}
	
	public boolean isAfetaAmigos() {
		return afetaAmigos;
	}
	
	public void setAfetaAmigos(boolean afetaAmigos) {
		this.afetaAmigos = afetaAmigos;
	}
	
	public int getPesosDano() {
		return pesosDano;
	}
	
	public void setPesosDano(int pesosDano) {
		this.pesosDano = pesosDano;
	}
	
	public boolean isAfetaTodos() {
		return afetaTodos;
	}
	
	public void setAfetaTodos(boolean afetaTodos) {
		this.afetaTodos = afetaTodos;
	}
	
	public static int getId() {
		return id;
	}
	
	public static void setId(int id) {
		Habilidades.id = id;
	}
}
