package dungeonclash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jogo {
    private List<Fase> fases;
    private List<Equipe> viloes;
    private Equipe herois;
    private Scanner scanner;
    private Random random;
    
    public Jogo() {
        this.fases = new ArrayList<>();
        this.viloes = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.random = new Random();
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
        dividirInimigosEquipes();
        criarFases();
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
    
    private void dividirInimigosEquipes() {
    	for (Fase fase : fases) {
    		Equipe inimigos = new Equipe();
    		for (Personagem persona : fase.getInimigos()) {
    			inimigos.addPersonagem(persona);
    		}
    		viloes.add(inimigos);
    	}
    }
    
    public void exibirMenu() {
        boolean sair = false;

        while (!sair) {
            System.out.println("----- MENU -----");
            System.out.println("1. Adicionar Personagem");
            System.out.println("2. Iniciar Jogo");
            System.out.println("3. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarPersonagem();
                    break;
                case 2:
                    this.iniciarJogo("src/dungeonclash/jogo.txt");
                    break;
                case 3:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
    
    public void adicionarPersonagem() {
    	
    }
    
    private void criarFases() {
    	for (Fase fase : fases) {
    		System.out.println("Fase" + ": " + fase.getDescricao());
    		iniciarBatalha();
    		System.out.println();
        	viloes.remove(0);
    	}
    }
    
    public void iniciarBatalha() {
        System.out.println("Batalha Iniciada!");

        while (!verificarFimDaBatalha()) {
            if (verificarPersonagensComTempoZero()) {
                Personagem personagem = escolherPersonagemAleatorio();
                if (personagem != null) {
                    System.out.println(personagem.getNome() + " está atacando!");   
                    personagem.setTempoEspera(personagem.getTempoEspera() - 1);
                }
            } else {
                System.out.println("Todos os personagens estão esperando...");
            }
            atualizarTemposEspera();
        }

        System.out.println("Fim da Batalha!");
    }

    private boolean verificarFimDaBatalha() {
        return herois.estaVazio() || viloes.get(0).estaVazio();
    }

    private boolean verificarPersonagensComTempoZero() {
        for (Personagem personagem : herois.equipeInteira()) {
            if (personagem.getTempoEspera() == 0) {
                return true;
            }
        }
        return false;
    }

    private Personagem escolherPersonagemAleatorio() {
        List<Personagem> personagensDisponiveis = new ArrayList<>();
        for (Personagem personagem : herois.equipeInteira()) {
            if (personagem.getTempoEspera() == 0) {
                personagensDisponiveis.add(personagem);
            }
        }

        if (!personagensDisponiveis.isEmpty()) {
            int indiceAleatorio = random.nextInt(personagensDisponiveis.size());
            return personagensDisponiveis.get(indiceAleatorio);
        }

        return null;
    }

    private void atualizarTemposEspera() {
        for (Personagem personagem : herois.equipeInteira()) {
            personagem.setTempoEspera(Math.max(0, personagem.getTempoEspera() - 1));
        }
    }

    
    private void menuCombate(Personagem persona) {
    	
    }

	//private void jogarFases() {
    	
    //}
}
