package dungeonclash;

import java.util.ArrayList;

public class Fase {
	private String descricao;
    private Equipe inimigos;

    public Fase(String descricao) {
        this.descricao = descricao;
        this.inimigos = new Equipe();
    }

    public String getDescricao() {
        return descricao;
    }

    public void adicionarInimigo(Personagem inimigo) {
        inimigos.addPersonagem(inimigo);;
    }

    public ArrayList<Personagem> getInimigos() {
        return inimigos.equipeInteira();
    }
}