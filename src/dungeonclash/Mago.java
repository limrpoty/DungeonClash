package dungeonclash;

public class Mago extends Classe {

	public Mago(int nivel) {
		super(nivel, nivel * 2, nivel * 3);
		super.setNomeClasse("Mago");
		adicionarHabilidades("Socar", calculaSocar(), 0, 2,false, false);
		adicionarHabilidades("Enfraquecer", calculaEnfraquecer(), manaEnfraquecer(), 5, false, false);
		adicionarHabilidades("Cura Amigo", calculaCuraAmigo(), manaCuraAmigo(),4, true, false);
	}
	
	private int calculaSocar() {
		return (int) Math.ceil(super.getAgilidade() * 0.1 + super.getForca() * 0.1);
	}

	private int calculaEnfraquecer() {
		return (int) Math.ceil(super.getAgilidade() * 0.2 + super.getForca() * 0.3 + super.getInteligencia() * 0.5);
	}
	private int manaEnfraquecer() {
		return (int) Math.ceil(super.getInteligencia() * 0.5);
	}

	private int calculaCuraAmigo() {
		return (int) Math.ceil(super.getAgilidade() * 0.2 + super.getForca() * 0.5 + super.getInteligencia() * 0.8);
	}
	private int manaCuraAmigo() {
		return (int) Math.ceil(super.getInteligencia() * 0.7);
	}
	
    public void adicionarHabilidades(String nome, int valorDano, int valorMana, int tempo, boolean afetaAmigos, boolean afetaTodos) {
        Habilidades habilidade = new Habilidades(nome, valorDano, valorMana, tempo, afetaAmigos, afetaTodos);
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
				
			case "Enfraquecer"	: 
				poder.setPesosDano(calculaEnfraquecer());
				poder.setPesosMana(manaEnfraquecer());
				break;
				
			case "Cura Amigo": 
				poder.setPesosDano(calculaCuraAmigo());
				poder.setPesosMana(manaCuraAmigo());
				break;
				
			default 				:
				break;
			}
		}
	}
}
