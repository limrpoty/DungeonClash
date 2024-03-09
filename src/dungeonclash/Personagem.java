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
        classe.adicionarPontosAtributo(this);
    }

    public int atacar() {
        return classe.atacar(this);
    }

    public void receberDano(int dano) {
        PV -= dano;
        if (PV < 0) {
            PV = 0;
        }
    }

    public void reduzirTempoEspera() {
        tempoEspera--;
        if (tempoEspera < 0) {
            tempoEspera = 0;
        }
    }

    public Habilidades escolherHabilidade() {
        return classe.escolherHabilidade();
    }

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

    public float getPM() {
        return PM;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }

    public Classe getClasse() {
        return classe;
    }

    public int getID() {
        return ID;
    }
}