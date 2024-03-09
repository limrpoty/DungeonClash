package dungeonclash;

public class Personagem {
	private String nome;
	private int nivel, pe;
	private float pv, pm;
	private float pvMax, pmMax;
	private int tempoEspera;
	private Classe classe;
	private static int id;
	
	public Personagem(String nome, Classe classe) {
		this.nome = nome;
		this.nivel = 1;
		this.pe = 0;
		this.classe = classe;
		this.tempoEspera = 0;
		this.pv = (nivel * classe.getForca() + (nivel * classe.getAgilidade() / 2));
		this.pm = (nivel * classe.getInteligencia() + (nivel * classe.getAgilidade() / 3));
	}
	
	public void ganhaExp(int nivelInimigo) {
		this.pe += nivelInimigo * 5;
		
		if(this.pe >= (this.nivel * 25)) {
			this.pe %= this.nivel * 25;
			this.nivel++;
			setPvMax(nivel * classe.getForca() + (nivel * classe.getAgilidade() / 2));
			setPmMax(nivel * classe.getInteligencia() + (nivel * classe.getAgilidade() / 3));
			
			int [] aux = PesosDeAtributos.levelUp(this.classe.getNomeDaClasse()); 
			
			this.classe.setAgilidade(this.classe.getAgilidade() + aux[0]);
			this.classe.setForca(this.classe.getForca() + aux[1]);
			this.classe.setInteligencia(this.classe.getInteligencia() + aux[2]);
		}
	}
	
	public void atacarInimigo(Personagem atacante, Personagem atacado) {
		
		atacado.danoSofrido(atacante.getNome(), atacado.getNome(), 0);
	}
	
	public void danoSofrido(String atacante, String atacado, float dano) {
		
	}
	
	public void atacarEquipe(Equipe equipeInimiga) {
		
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

	public float getPvMax() {
		return pvMax;
	}

	public void setPvMax(float pvMax) {
		this.pvMax = pvMax;
	}

	public float getPmMax() {
		return pmMax;
	}

	public void setPmMax(float pmMax) {
		this.pmMax = pmMax;
	}
}