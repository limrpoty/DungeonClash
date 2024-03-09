package dungeonclash;

public class Guerreiro extends Classe {

	public Guerreiro(int nivel) {
		super(nivel * 4, nivel, nivel);
		super.setNomeClasse("Guerreiro");
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
