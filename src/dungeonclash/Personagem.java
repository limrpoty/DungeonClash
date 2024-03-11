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
    
    public float causarDano(String habilidade, Personagem atacado, Equipe equipe) {
    	return this.usarHabilidade(habilidade, atacado, equipe);
    }
    
    public float recebeDano(float dano) {
    	this.PV -= dano;
    	if (this.PV < 0) {
    		this.PV = 0;
    	}
		return dano;
    }
    
    public float usarHabilidade(String nomeHabilidade, Personagem atacado, Equipe equipe) {
    	float danoOuCura = 0.0f;
    	String nomeAlvo = atacado.getNome();
    	Personagem alvo = equipe.buscaPersonagem(nomeAlvo);
    	
    	if (this.PV > 0) {
    		for (Habilidades habilidades : classe.getHabilidades()) {
    			if (habilidades.getNome().equals(nomeHabilidade)) {
    				if (this.PM - habilidades.getPesosMana() <= 0) {
    					tempoEspera = 1;
    					break;
    				}
    				PM -= habilidades.getPesosMana();
    				tempoEspera = habilidades.getTempo();
    				danoOuCura = habilidades.getPesosDano() * this.nivel;
    				if (habilidades.isAfetaAmigos()) {
    					return alvo.PV += danoOuCura;
    				
    				} else if (habilidades.isAfetaTodos()) {
    					for (Personagem persona : equipe.equipeInteira()) {
    						return persona.recebeDano(danoOuCura);
    					}
    				} else {
    					return alvo.recebeDano(danoOuCura);
    				}
    			}
    		}
    	}
		return danoOuCura;
    }
    
    
    private int calcularPVMax() {
        return nivel * classe.getForca() + (nivel * classe.getAgilidade() / 2);
    }

    private int calcularPMMax() {
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