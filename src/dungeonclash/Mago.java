package dungeonclash;

public class Mago extends Classe {

	public Mago(int nivel) {
		super(nivel, nivel * 2, nivel * 3);
		super.setNomeClasse("Mago");
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
