package dungeonclash;

public class Monstro extends Classe {

	public Monstro(int nivel) {
		super(nivel * 4, nivel, 0);
		super.setNomeClasse("Monstro");
		adicionarHabilidades("Socar", calculaSocar(), 0, 5, false, false);
		adicionarHabilidades("Chutar", calculaChutar(), 0, 8, false, false);
		adicionarHabilidades("Grito Atordoante", calculaGritoAtordoante(), 0, 6, false, true);
	}
	
	private int calculaSocar() {
		return (int) Math.ceil(getAgilidade() * 0.4 + getForca() * 0.8);
	}

	private int calculaChutar() {
		return (int) Math.ceil(getForca() * 0.5 + getAgilidade() * 1.0);
	}

	private int calculaGritoAtordoante() {
		return (int) Math.ceil(getAgilidade() * 0.2 + getForca() * 0.4);
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
				
			case "Chutar"	: 
				poder.setPesosDano(calculaChutar());
				break;
				
			case "Grito Atordoante": 
				poder.setPesosDano(calculaGritoAtordoante());
				break;
				
			default 				:
				break;
			}
		}
	}
}
