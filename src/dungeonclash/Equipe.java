package dungeonclash;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
	private ArrayList<Personagem> equipe;
	
	public Equipe() {
		this.equipe = new ArrayList<>();
	}
	
	public void addPersonagem(Personagem novoPersonagem) {
		equipe.add(novoPersonagem);
	}
	
	public void addAll(List<Personagem> personagem) {
		equipe.addAll(personagem);
	}

	public ArrayList<Personagem> equipeInteira() {
		return equipe;
	}
	
	public void experienciaGeral(int nivelInimigo) {
		for(Personagem personagem : equipe) {
			personagem.adicionarPE(nivelInimigo);
		}
	}
	
	public Personagem buscaPersonagem(String nomePersonagem) {
		for (Personagem persona : equipe) {
			if (persona.getNome() == nomePersonagem) {
				return persona;
			}
		}
		return null;
	}
	
	public Personagem buscaPersonagem(int indentificador) {
		for (Personagem persona : equipe) {
			if (persona.getID() == indentificador) {
				return persona;
			}
		}
		return null;
	}
	
	public Personagem removerPersonagem(String nome) {
		equipe.remove(buscaPersonagem(nome));
		return buscaPersonagem(nome);
	}
	
	public ArrayList<Personagem> proximoAtacante() {
		for(Personagem personagem : equipe) {
			if(personagem.getTempoEspera() == 0) {
				
			}
		}
		return null;
	}
	
	public boolean estaVazio() {
		if (!equipeInteira().isEmpty()) {
			return false;
		}
		return true;
	}
	
	public int atualizarTempoEspera() {
		for (Personagem personagem : equipe) {
			personagem.reduzirTempoEspera();
		}
		return 0;
		
	}
 }
