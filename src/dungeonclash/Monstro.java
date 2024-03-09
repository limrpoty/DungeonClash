package dungeonclash;

public class Monstro extends Classe {

	public Monstro(int nivel) {
		super(nivel * 4, nivel, 0);
		super.setNomeClasse("Monstro");
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
