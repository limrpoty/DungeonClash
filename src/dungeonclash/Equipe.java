package dungeonclash;

import java.util.ArrayList;

public class Equipe {
	private ArrayList<Personagem> equipe;
	
	public void addHeroi(Personagem novoHeroi) {
		equipe.add(novoHeroi);
	}

	public ArrayList<Personagem> equipeInteira() {
		return equipe;
	}
	
	public void experienciaGeral(int nivelInimigo) {
		for(Personagem personagem : equipe) {
			personagem.ganhaExp(nivelInimigo);
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
	
	public ArrayList<Personagem> proximoAtacante() {
		for(Personagem personagem : equipe) {
			if(personagem.getTempoEspera() == 0) {
				
			}
		}
		return null;
	}
	
	public int atualizarTempoEspera(ArrayList<Habilidades> habilidades, String nome) {
		for (Habilidades habilidade : habilidades) {
			if (habilidade.getNome() == nome) {
				return habilidade.getTempo();
			}
		}
		return 0;
		
	}
 }
