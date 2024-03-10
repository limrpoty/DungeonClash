package dungeonclash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Jogo {
    private List<Fase> fases;
    
    public Jogo() {
        this.fases = new ArrayList<>();
    }

    public void iniciarJogo(String nomeArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("fase")) {
                    String descricaoFase = linha.substring(5).trim();
                    Fase faseAtual = new Fase(descricaoFase);
                    lerMonstrosFase(br, faseAtual);
                    fases.add(faseAtual);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        jogarFases();
    }

    private void lerMonstrosFase(BufferedReader br, Fase fase) throws IOException {
        String linha;
        
        while ((linha = br.readLine()) != null && !linha.startsWith(".")) {
            String[] partes = linha.split(" ");
            if (partes.length == 3) {
                String nomeInimigo = partes[0];
                int nivelInimigo = Integer.parseInt(partes[2]);
                String classeInimigo = partes[1];
                
                if (classeInimigo.equals("Arqueiro")) {
                	Classe classe = new Arqueiro(nivelInimigo);
                	Personagem inimigo = new Personagem(nomeInimigo, nivelInimigo, classe);
                    fase.adicionarInimigo(inimigo);
                    
                } else if (classeInimigo.equals("Guerreiro")) {
                	Classe classe = new Guerreiro(nivelInimigo);
                	Personagem inimigo = new Personagem(nomeInimigo, nivelInimigo, classe);
                    fase.adicionarInimigo(inimigo);
                    
                } else if (classeInimigo.equals("Mago")) {
                	Classe classe = new Mago(nivelInimigo);
                	Personagem inimigo = new Personagem(nomeInimigo, nivelInimigo, classe);
                    fase.adicionarInimigo(inimigo);
                    
                } else if (classeInimigo.equals("Monstro")) {
                	Classe classe = new Monstro(nivelInimigo);
                	Personagem inimigo = new Personagem(nomeInimigo, nivelInimigo, classe);
                    fase.adicionarInimigo(inimigo);
                } 
            } else {
                continue;
            }
        }
    }

    private void jogarFases() { 	
        for (int i = 0; i < fases.size(); i++) {
            System.out.println("Fase " + (i + 1) + ": " + fases.get(i).getDescricao());
            System.out.println("Inimigos:");
            for (Personagem inimigo : fases.get(i).getInimigos()) {
                System.out.println(inimigo.getNome() + " - Nível " + inimigo.getNivel() + " " + inimigo.getClasse().getNomeClasse());
                System.out.println(inimigo.getPV() + " " + inimigo.getPM());
            }
            
            System.out.println();
        }
    }
}
