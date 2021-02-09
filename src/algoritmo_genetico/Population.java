package algoritmo_genetico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Population {
	
	private List<Individuo> individuos = new ArrayList<>();
	private int geracaoAtual = 1;
	private Individuo melhorIndividuo;
	
	public Population(int quantIndivPorGer, int maxGer) throws Exception {
		
		if(quantIndivPorGer % 2 != 0) {
			throw new Exception("O número da quantidade de indivíduos deve ser par"); 
		}
		
		for(int i = 0; i < quantIndivPorGer; i++) {
			individuos.add(new Individuo());
		}
		gerarVencedor();
	}
	
	private void gerarVencedor() {
		Collections.sort(this.individuos);
		this.melhorIndividuo = individuos.get(0);
	}
	
	public Individuo vencedor() {
		return this.melhorIndividuo;
	}
	
//	public Population crossover() {
//		
//		List<Individuo> listI = new ArrayList<>();
//		
//		int i = 0;
//		while(this.individuos.size() > i) {
//			
//			Individuo a = this.individuos.get(i);
//			Individuo b = this.individuos.get(i + 1);
//			
//			listI.addAll(new Crossover(a, b).filhos());
//			
//			i += 2;
//		}
//		
//		return this;
//	}

	
	
}
