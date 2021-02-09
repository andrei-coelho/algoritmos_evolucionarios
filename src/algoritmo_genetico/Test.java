package algoritmo_genetico;


public class Test {

	public static void main(String[] args) {
		
		try {
			// populacao de 1000 com 20 geracoes
			// total de 11000 individuos gerados
			new Population(1000, 20)
				.avaliar()
				.vencedor()
				.show();
		} catch (Exception e) {
			System.out.println("O numero de individuos nao eh par");
		}
		
	}

}
