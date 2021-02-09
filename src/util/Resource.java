package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Resource {

	public static BufferedReader getContent(String file) {
		
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader("res/"+file));
		} catch (FileNotFoundException e) {
			System.out.println("Não foi possível encontraro o arquivo '" + file + "' em 'res'");
		}
		
		return bf;
		
	}
	
}
