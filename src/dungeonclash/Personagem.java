package dungeonclash;

class Personagem {
    private static int contadorIDs = 1;
    private String nome;
    private int nivel, PE;
    private float PV, PM;
    private int tempoEspera;
    private Classe classe;
    private int ID;

    public Personagem(String nome, int nivel, Classe classe) {
        this.nome = nome;
        this.classe = classe;
        this.ID = contadorIDs++;
        this.nivel = nivel;
        this.PE = 0;
        this.PV = calcularPVMax();
        this.PM = calcularPMMax();
        this.tempoEspera = 0;
    }
    
    public void causarDano(String habilidade, Personagem atacado, Equipe equipe) {
    	atacado.usarHabilidade(habilidade, atacado, equipe);
    }
    
    public void recebeDano(int dano) {
    	this.PV -= dano;
    	if (this.PV < 0) {
    		this.PV = 0;
    	}
    }
    
    public void usarHabilidade(String nomeHabilidade, Personagem atacado, Equipe equipe) {
    	int danoOuCura = 0;
    	String nomeAlvo = atacado.getNome();
    	Personagem alvo = equipe.buscaPersonagem(nomeAlvo);
    	
    	for (Habilidades habilidades : classe.getHabilidades()) {
    		if (habilidades.getNome().equals(nomeHabilidade)) {
    			danoOuCura = habilidades.getPesosDano() * nivel;
    			if (habilidades.isAfetaAmigos()) {
    				alvo.PV += danoOuCura;
    				
    			} else if (habilidades.isAfetaTodos()) {
    				for (Personagem persona : equipe.equipeInteira()) {
    					persona.recebeDano(danoOuCura);
    				}
    			} else {
    				alvo.recebeDano(danoOuCura);
    			}
    			PM -= habilidades.getPesosMana();
    			tempoEspera = habilidades.getTempo();
    		}
    	}
    }
    
    
    private float calcularPVMax() {
        return nivel * classe.getForca() + (nivel * classe.getAgilidade() / 2);
    }

    private float calcularPMMax() {
        return nivel * classe.getInteligencia() + (nivel * classe.getAgilidade() / 3);
    }

    public void adicionarPE(int pe) {
        this.PE += pe;
        while (PE >= nivel * 25) {
            subirNivel();
        }
    }

    private void subirNivel() {
        nivel++;
        PE -= nivel * 25;
        PV = calcularPVMax();
        PM = calcularPMMax();
        classe.adicionarPontosAtributo();
    }

    public void reduzirTempoEspera() {
        tempoEspera--;
        if (tempoEspera < 0) {
            tempoEspera = 0;
        }
    }

    /*public Habilidades escolherHabilidade() {
        return classe.escolherHabilidade();
    }*/

    //getters e setters
    public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPE() {
        return PE;
    }

    public float getPV() {
        return PV;
    }
    
    public void setPV(float PV) {
    	this.PV = PV;
    }
    public float getPM() {
        return PM;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }
    
    public void setTempoEspera(int tempoEspera) {
    	this.tempoEspera = tempoEspera;
    }
    
    public Classe getClasse() {
        return classe;
    }

    public int getID() {
        return ID;
    }
    
}