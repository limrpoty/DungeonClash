package dungeonclash;

public class Habilidades {
	private String nome;
	private PesosDeAtributos pesosDano, pesosMana;
	private int tempo;
	private boolean afetaTodos, afetaAmigos;
	private static int id;

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public PesosDeAtributos getPesosMana() {
		return pesosMana;
	}
	
	public void setPesosMana(PesosDeAtributos pesosMana) {
		this.pesosMana = pesosMana;
	}
	
	public int getTempo() {
		return tempo;
	}
	
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	
	public boolean isAfetaAmigos() {
		return afetaAmigos;
	}
	
	public void setAfetaAmigos(boolean afetaAmigos) {
		this.afetaAmigos = afetaAmigos;
	}
	
	public PesosDeAtributos getPesosDano() {
		return pesosDano;
	}
	
	public void setPesosDano(PesosDeAtributos pesosDano) {
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
