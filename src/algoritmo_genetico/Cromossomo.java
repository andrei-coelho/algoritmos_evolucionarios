package algoritmo_genetico;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import util.Resource;

public class Cromossomo {

	
	private Double preco;
	private Double tamanho;
	private String nome;
	
	private static List<Double> precos = new ArrayList<>();
	private static List<Double> tamanhos = new ArrayList<>();
	private static List<Cromossomo> cromossomos = new ArrayList<>();
	
	
	private Cromossomo(String nome, Double tamanho, Double preco) {
		this.nome = nome;
		this.preco = preco;
		this.tamanho = tamanho;
		precos.add(preco);
		tamanhos.add(tamanho);
	}
	
	
	public static List<Cromossomo> getCromossomos() {
		
		if(cromossomos.size() == 0) {
			generateList();
		}
		return cromossomos;
	}
	
	
	private static void generateList() {
		
		if(cromossomos.size() == 0) { // lista é gerada apenas uma vez
			
			try {
				
				BufferedReader bf = Resource.getContent("lista_produtos.txt");
			    String linha = bf.readLine();

			    while (linha != null) {
			       String[] values = linha.split(",");
			       cromossomos.add(
			    		new Cromossomo(
			    		   values[0], 
			    		   Double.parseDouble(values[1]), 
			    		   Double.parseDouble(values[2])
			    		)
			    	);
			       linha = bf.readLine();
			    }
			    
			} catch (IOException e2) {
				System.out.println("Erro ao tentar ler o arquivo");
			}
			
		}
		
	}
	
	
	
	public Double getTamanho() {
		return tamanho;
	}

	public Double getPreco() {
		return preco;
	}

	public String getNome() {
		return nome;
	}
	
	
	
}
