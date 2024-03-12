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
        this.herois = new Equipe();
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
        	System.out.println();
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
                    System.out.println("Todos os monstros foram derrotados. \nVocê conseguiu sair da Dungeon!");
                    sair = true;
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
    	System.out.println("Digite o nome do personagem: ");
    	String nome = scanner.nextLine();
    	System.out.println("Digite a classe: ");
    	String classes = scanner.nextLine();
    	if (classes.equals("Arqueiro")) {
        	Classe classe = new Arqueiro(1);
        	Personagem inimigo = new Personagem(nome, 1, classe);
            herois.addPersonagem(inimigo);
            
        } else if (classes.equals("Guerreiro")) {
        	Classe classe = new Guerreiro(1);
        	Personagem inimigo = new Personagem(nome, 1, classe);
            herois.addPersonagem(inimigo);
            
        } else if (classes.equals("Mago")) {
        	Classe classe = new Mago(1);
        	Personagem inimigo = new Personagem(nome, 1, classe);
            herois.addPersonagem(inimigo);
            
        } else if (classes.equals("Monstro")) {
        	Classe classe = new Monstro(1);
        	Personagem inimigo = new Personagem(nome, 1, classe);
            herois.addPersonagem(inimigo);
        } 
    }
    
    private void criarFases() {
    	for (Fase fase : fases) {
    		System.out.println("Fase" + ": " + fase.getDescricao());
    		iniciarBatalha();
    		viloes.remove(0);
    		System.out.println();
    	}
    }
    
    public void iniciarBatalha() {
        System.out.println("Batalha Iniciada!");

        while (!verificarFimDaBatalha()) {
            if (verificarPersonagensComTempoZero()) {
                Personagem personagem = escolherPersonagemAleatorio();
                if (personagem != null) {
                    System.out.println(personagem.getNome() + " está atacando!");
                    System.out.println("Nivel: " + personagem.getNivel() + " || PV: " + personagem.getPV() 
                    													+ " || PM: " + personagem.getPM());
                    System.out.println();
                    menuEscolha(personagem);
                }
            } else {
                System.out.println("Todos os personagens estão esperando...");
                System.out.println();
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
        herois.atualizarTempoEspera();
        viloes.get(0).atualizarTempoEspera();
    }

    private void menuEscolha(Personagem persona) {
    	System.out.println("Escolha o inimigo: ");
    	
    	for (Personagem inimigo : viloes.get(0).equipeInteira()) {
    		System.out.println(inimigo.getID() + ". " + inimigo.getNome() + "  Pv: " + inimigo.getPV());
    	}
    	int quem = scanner.nextInt();
    	menuCombate(persona, viloes.get(0).buscaPersonagem(quem));
    }
    
    private void menuCombate(Personagem persona, Personagem inimigo) {
    	System.out.println("Habilidades: ");
    	for (int i = 0; i < 3; i++) {
    		System.out.println(i + ":" + persona.getClasse().getHabilidades().get(i).getNome() + " || Custo: " + 
    								persona.getClasse().getHabilidades().get(i).getPesosMana());
    	}
    	System.out.print("Digite o número da habilidade: ");
    	int habilidade = scanner.nextInt();
    	String dano = persona.getClasse().getHabilidades().get(habilidade).getNome();
    	float danos = persona.causarDano(dano, inimigo, viloes.get(0));
    	System.out.println(inimigo.getNome() + " tomou " + danos + " de dano!");
    	System.out.println();
    	
    	if (inimigo.getPV() <= 0) {
    		herois.experienciaGeral(inimigo.getNivel());
    		System.out.println(inimigo.getNome() + " está morto!\n");
    		viloes.get(0).removerPersonagem(inimigo.getNome());
    	}
    }
}