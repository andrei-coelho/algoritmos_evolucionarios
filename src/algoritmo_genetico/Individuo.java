package algoritmo_genetico;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class Individuo implements Comparable<Individuo> {
	
	
	private List<Boolean> solution = new ArrayList<>();
	
	private static Double limiteEspaco = 3.00;
	
	private Double notaAvaliacao = 0.00;
	private Double espacoUsado = 0.00;
	private Integer geracao = 1;
	
	
	public Individuo() {
		
		List<Cromossomo> lista =  Cromossomo.getCromossomos();
		int i = 0;
		while(lista.size() > i) {
			this.solution.add(Math.random() < 0.5);
			i++;
		}
		
		geraNotaAvaliacao();
		
	}
	
	
	public Individuo(List<Boolean> solution, int geracao) {
		
		this.geracao = geracao;
		this.solution = solution;
		geraNotaAvaliacao();
	}
	
	
	private void geraNotaAvaliacao() {
		
		List<Cromossomo> lista =  Cromossomo.getCromossomos();
		
		Double notaFinal = 0.0;
		
		int i = 0;
		for(Cromossomo cromo : lista) {
			if(solution.get(i)) {
				 notaFinal += cromo.getPreco();
				 this.espacoUsado += cromo.getTamanho();
			}
			i++;
		}
		
		if(this.espacoUsado > limiteEspaco) {
			notaFinal = 1.0;
		}
		
		this.notaAvaliacao = notaFinal;
	}
	
	
	public void show() {
		
		String dados  = "Nota Avalicao: " + notaAvaliacao + "\n";
			   dados += "Espaco Usado: " + espacoUsado + "\n";
			   dados += "Produtos: \n [ \n";
			   
		int i = 0;
		for(Cromossomo cromo : Cromossomo.getCromossomos()) {
			if(solution.get(i)) {
				dados += "    "+cromo.getNome()+"\n";
			}
			i++;
		}
		
		dados += " ]";
		
		System.out.println(dados);
		
	}
	
	public List<Boolean> getSolution(){
		return this.solution;
	}
	
	public int getGeracao() {
		return this.geracao;
	}
	
	public Double getNotaAvaliacao() {
		return this.notaAvaliacao;
	}
	
	
	@Override
	public int compareTo(Individuo i) {
		if(this.notaAvaliacao > i.getNotaAvaliacao()) {
			return -1;
		}
		if(this.notaAvaliacao < i.getNotaAvaliacao()) {
			return 1;
		}
		return 0;
	}
	
	
	public void indentidade() {
		System.out.println("Nota: " + notaAvaliacao);
		System.out.println("Geracao: " + geracao + "\n");
	}
	
}
