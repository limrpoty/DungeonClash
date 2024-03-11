package dungeonclash;

public class Guerreiro extends Classe {

	public Guerreiro(int nivel) {
		super(nivel * 4, nivel, nivel);
		super.setNomeClasse("Guerreiro");
		adicionarHabilidades("Socar", calculaSocar(), 0, 4, false, false);
		adicionarHabilidades("Golpe de Espada", calculaGolpeEspada(),0, 5, false, false);
		adicionarHabilidades("Espada Flamejante", calculaEspadaFlamejante(),manaEspadaFlamejante(), 7, false, false);
	}
	
	private int calculaSocar() {
		return (int) Math.ceil(getAgilidade() * 0.1 + getForca() * 0.3);
	}

	private int calculaGolpeEspada() {
		return (int) Math.ceil(getAgilidade() * 0.3 + getForca() * 0.7);
	}

	private int calculaEspadaFlamejante() {
		return (int) Math.ceil(getForca() * 0.3 + getAgilidade() * 0.5 + getInteligencia() * 0.4);
	}
	private int manaEspadaFlamejante() {
		return (int) Math.ceil(getInteligencia() + getForca() * 0.2);
	}
	
    public void adicionarHabilidades(String nome, int i, int j, int tempo, boolean afetaAmigos, boolean afetaTodos) {
        Habilidades habilidade = new Habilidades(nome, i, j, tempo, afetaAmigos, afetaTodos);
        super.setHabilidades(habilidade);
    }

	@Override
	public void adicionarPontosAtributo() {
		setForca(getForca() + 1);
		setAgilidade(getAgilidade() + 3);
		setInteligencia(getInteligencia() + 2);
		ajustarHabilidades();
	}
	
	public void ajustarHabilidades() {
		for (Habilidades poder : super.getHabilidades()) {
			String nome = poder.getNome();
			
			switch (nome) {
			case "Socar"			: 
				poder.setPesosDano(calculaSocar());
				break;
				
			case "Golpe de Espada"	: 
				poder.setPesosDano(calculaGolpeEspada());
				break;
				
			case "Espada Flamejante": 
				poder.setPesosDano(calculaEspadaFlamejante());
				poder.setPesosMana(manaEspadaFlamejante());
				break;
				
			default 				:
				continue;
			}
		}
	}
}
