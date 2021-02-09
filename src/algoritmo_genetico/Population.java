package algoritmo_genetico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Population {
	
	
	private List<Individuo> individuos = new ArrayList<>();
	private int geracaoAtual = 1;
	private int maxGer;
	private Individuo melhorIndividuo;
	private static Double somaValIndividuos = 0.0;
	
	
	public Population(int quantIndivPorGer, int maxGer) throws Exception {
		
		if(quantIndivPorGer % 2 != 0) {
			throw new Exception("O número da quantidade de indivíduos deve ser par"); 
		}
		
		this.maxGer = maxGer;
		
		for(int i = 0; i < quantIndivPorGer; i++) {
			this.individuos.add(new Individuo());
		}
		
	}
	
	
	public Population avaliar() {
		
		if(maxGer == geracaoAtual) {
			gerarVencedor();
			return this;
		}
		
		gerarNovosIndividuos();
		
		return avaliar();
		
	}
	
	private void gerarNovosIndividuos() {
		
		geracaoAtual++;
		
		somaAvaliacoes();
		
		List<Individuo> pais = pais();
		List<Individuo> filhos = filhos(pais);
		
		this.individuos = pais;
		this.individuos.addAll(filhos);
		
		
	}
	
	
	private List<Individuo> pais(){
		
		List<Individuo> lista = new ArrayList<>();
		
		for(int i = 0; i < this.individuos.size() / 2; i++) {
			lista.add(selecionaPai());
		}
		
		return lista;
		
	}
	
	
	private Individuo selecionaPai() {
		
		Double sorteio = Math.random() * somaValIndividuos;
		Double somafinal = 0.00;
		
		int i = 0;
		int indicePai;
		
		while(i < this.individuos.size() && somafinal < sorteio) {
			somafinal += individuos.get(i).getNotaAvaliacao();
			i++;
		}
		
		indicePai = i - 1;
		return indicePai > -1 ? individuos.get(indicePai) : null;
		
		
	}
	
	
	private List<Individuo> filhos(List<Individuo> pais){
		
		int i = 0;
		
		List<Individuo> filhos = new ArrayList<>();
		
		while(i < pais.size()) {
			
			Individuo a = pais.get(i);
			Individuo b = pais.get(i + 1);
			
			filhos.addAll(new Crossover(a, b).filhos());
			
			i += 2;
		}
		
		return filhos;
		
	}
	
	
	private void somaAvaliacoes() {
		
		somaValIndividuos = 0.00;
		for(Individuo ind : this.individuos) {
			somaValIndividuos += ind.getNotaAvaliacao();
		}
	}
	
	
	private void gerarVencedor() {
		
		Collections.sort(this.individuos);
		this.melhorIndividuo = individuos.get(0);
	}
	
	
	public Individuo vencedor() {
		
		return this.melhorIndividuo;
	}

	
	
}
