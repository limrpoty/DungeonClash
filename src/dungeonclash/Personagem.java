package dungeonclash;

public class Personagem {
	private String nome;
	private int nivel, pe;
	private float pv, pm;
	private int tempoEspera;
	private Classe classe;
	private static int id;
	
	public void ganhaExp(int nivelInimigo) {
		this.pe += nivelInimigo * 5;
		
		if(this.pe >= (this.nivel * 25)) {
			this.pe %= this.nivel * 25;
			this.nivel++;
		}
	}
	
	public void atacarInimigo() {
		
	}
	
	public void danoSofrido(String atacante, String atacado, int dano) {
		
	}
	
	public int getNivel() {
		return nivel;
	}
	
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public int getPe() {
		return pe;
	}
	
	public void setPe(int pe) {
		this.pe = pe;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTempoEspera() {
		return tempoEspera;
	}

	public void setTempoEspera(int tempoEspera) {
		this.tempoEspera = tempoEspera;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Personagem.id = id;
	}

	public float getPm() {
		return pm;
	}

	public void setPm(float pm) {
		this.pm = pm;
	}

	public float getPv() {
		return pv;
	}

	public void setPv(float pv) {
		this.pv = pv;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
}
