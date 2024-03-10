package dungeonclash;

public class Arqueiro extends Classe {
	
	public Arqueiro(int nivel) {
		super(nivel, nivel * 3, nivel * 2);
		super.setNomeClasse("Arqueiro");
		adicionarHabilidades("Socar", calculaSocar(), 0, 3, false, false);
        adicionarHabilidades("Atirar Flecha", calculaAtirarFlecha(), 0, 4, false, false);
        adicionarHabilidades("Flecha Encantada", calculaFlechaEncantada(), manaFlechaEncantada(), 7, false, false);
    }

    private int calculaSocar() {
        return (int) Math.ceil(getAgilidade() * 0.1 + getForca() * 0.3);
    }

    private int calculaAtirarFlecha() {
        return (int) Math.ceil(getForca() * 0.3 + getAgilidade() * 0.5);
    }

    private int calculaFlechaEncantada() {
        return (int) Math.ceil(getForca() * 0.3 + getAgilidade() * 0.5 + getInteligencia() * 0.4);
    }
    private int manaFlechaEncantada() {
        return (int) Math.ceil(getInteligencia() + getAgilidade() * 0.2);
    }

    public void adicionarHabilidades(String nome, int i, int j, int tempo, boolean afetaAmigos, boolean afetaTodos) {
        Habilidades habilidade = new Habilidades(nome, i, j, tempo, afetaAmigos, afetaTodos);
        super.setHabilidades(habilidade);
    }

	@Override
	public int atacar(Personagem personagem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void adicionarPontosAtributo() {
		setForca(getForca() + 1);
		setAgilidade(getAgilidade() + 3);
		setInteligencia(getInteligencia() + 2);		
		ajustarHabilidades();
	}
	
	public void ajustarHabilidades() {
		for (Habilidades poder : super.getHabilidades()) {
			String nome = poder.getNome();
			
			switch (nome) {
			case "Socar"			: 
				poder.setPesosDano(calculaSocar());
				break;
				
			case "Atirar Flecha"	: 
				poder.setPesosDano(calculaAtirarFlecha());
				break;
				
			case "Flecha Encantada": 
				poder.setPesosDano(calculaFlechaEncantada());
				poder.setPesosMana(manaFlechaEncantada());
				break;
				
			default 				:
				break;
			}
		}
	}
}
