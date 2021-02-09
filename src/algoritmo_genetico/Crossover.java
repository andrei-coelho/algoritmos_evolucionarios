package algoritmo_genetico;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Crossover {
	
	Double mutation = 0.05; // probabilidade de  ocorrer mutação
	Individuo a, b;
	
	
	public Crossover(Individuo a, Individuo b) {
		this.a = a;
		this.b = b;
	}
	
	
	public List<Individuo> filhos(){
		
		List<Boolean> solutionA = this.a.getSolution();
		List<Boolean> solutionB = this.b.getSolution();
		
		int nextgen = a.getGeracao();
		
		int totalA = solutionA.size();
		int totalB = solutionA.size();
		
		int corte = (int) (Math.random() * (totalA <= totalB ? totalA : totalB));
		
		return Arrays.asList(
				new Individuo(gerarListaCromo(solutionA, solutionB, corte), nextgen), 
				new Individuo(gerarListaCromo(solutionB, solutionA, corte), nextgen)
			);
		
	}
	
	
	private List<Boolean> gerarListaCromo(List<Boolean> a, List<Boolean> b, int corte){
		
		List<Boolean> lista = new ArrayList<>();
		lista.addAll(a.subList(0, corte));
		lista.addAll(b.subList(corte, b.size()));
		
		// gera a mutação
		for(int i = 0; i < lista.size(); i++) 
			if(Math.random() < this.mutation)
				lista.set(i, !lista.get(i));
			
		return lista;
		
	}
	
}
