package dungeonclash;

import java.util.ArrayList;

abstract class Classe {
	private String nomeClasse;
    private int forca, agilidade, inteligencia;
    private ArrayList<Habilidades> habilidades;

    public Classe(int forca, int agilidade, int inteligencia) {
        this.forca = forca;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        this.habilidades = new ArrayList<>();
    }

    public void adicionarHabilidade(Habilidades habilidade) {
        habilidades.add(habilidade);
    }

    public abstract int atacar(Personagem personagem);

    public abstract void adicionarPontosAtributo();

    /*public Habilidades escolherHabilidade() {
        int index = (int) (Math.random() * habilidades.size());
        return habilidades.get(index);
    }*/
    
    public void setHabilidades(Habilidades habilidade) {
    	this.habilidades.add(habilidade);
    }
    
    public ArrayList<Habilidades> getHabilidades() {
    	return habilidades;
    }

    public int getForca() {
        return forca;
    }
    
    public void setForca(int forca) {
    	this.forca = forca;
    }

    public int getAgilidade() {
        return agilidade;
    }
    
    public void setAgilidade(int agilidade) {
    	this.agilidade = agilidade;
    }

    public int getInteligencia() {
        return inteligencia;
    }
    
    public void setInteligencia(int inteligencia) {
    	this.inteligencia = inteligencia;
    }
   
	public String getNomeClasse() {
		return nomeClasse;
	}

	public void setNomeClasse(String nomeClasse) {
		this.nomeClasse = nomeClasse;
	}
}