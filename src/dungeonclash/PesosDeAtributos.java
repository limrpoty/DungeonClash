package dungeonclash;

public class PesosDeAtributos {
	static private int forcaArqueiro = 1;
	static private int inteligenciaArqueiro = 2;
	static private int agilidadeArqueiro = 3;
	
	static private int forcaGuerreiro = 4;
	static private int inteligenciaGuerreiro = 1;
	static private int agilidadeGuerreiro = 1;
		
	static private int forcaMago = 1;
	static private int inteligenciaMago = 3;
	static private int agilidadeMago = 2;
		
	static private int forcaMonstro = 1;
	static private int inteligenciaMonstro = 1;
	static private int agilidadeMonstro= 4;
	
	public static int[] levelUp(String classeNome) {
		switch (classeNome) {
		case "arqueiro": {
			int[] aux = {forcaArqueiro, inteligenciaArqueiro, agilidadeArqueiro};
			return aux;
		}
		case "monstro": {
			int[] aux = {forcaMonstro, inteligenciaMonstro, agilidadeMonstro};
			return aux;
		}
		case "guerreiro": {
			int[] aux = {forcaGuerreiro, inteligenciaGuerreiro, agilidadeGuerreiro};
			return aux;
		}
		case "mago": {
			int[] aux = {forcaMago, inteligenciaMago, agilidadeMago};
			return aux;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + classeNome);
		}
	}
}
