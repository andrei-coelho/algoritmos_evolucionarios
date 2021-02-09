package algoritmo_genetico;


public class Test {

	public static void main(String[] args) {
		
		try {
			new Population(1000, 3).vencedor().show();
		} catch (Exception e) {
			System.out.println("O numero nao eh par");
		}
		
	}

}
