package dungeonclash;

public class Arqueiro extends Classe {
	
	public Arqueiro(int nivel) {
		super(nivel, nivel * 3, nivel * 2);
		super.setNomeClasse("Arqueiro");
		adicionarHabilidades("Socar", calculaSocar(super.getForca(), super.getAgilidade()), 0, 3, false, false);
        adicionarHabilidades("Atirar Flecha", calculaAtirarFlecha(super.getForca(), super.getAgilidade()), 0, 4, false, false);
        adicionarHabilidades("Flecha Encantada", calculaFlechaEncantada(super.getForca(), super.getAgilidade()), manaFlechaEncantada(super.getForca(), super.getAgilidade()), 7, false, false);
    }

    private int calculaSocar(int forca, int agilidade) {
        return (int) Math.ceil(agilidade * 0.1 + forca * 0.3);
    }

    private int calculaAtirarFlecha(int forca, int agilidade) {
        return (int) Math.ceil(forca * 0.3 + agilidade * 0.5);
    }

    private int calculaFlechaEncantada(int forca, int agilidade) {
        return (int) Math.ceil(forca * 0.3 + agilidade * 0.5 + getInteligencia() * 0.4);
    }
    private int manaFlechaEncantada(int agilidade, int inteligencia) {
        return (int) Math.ceil(inteligencia + agilidade * 0.2);
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
	public void adicionarPontosAtributo(Personagem personagem) {
		personagem.getClasse().setForca(personagem.getClasse().getForca() + 1);
		personagem.getClasse().setAgilidade(personagem.getClasse().getAgilidade() + 3);
		personagem.getClasse().setInteligencia(personagem.getClasse().getInteligencia() + 2);		
	}
}
