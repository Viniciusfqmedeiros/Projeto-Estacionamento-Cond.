package classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Undo {
	private Map<Integer, String> acoes = new HashMap<>();

	public Undo() {
		// TODO Auto-generated constructor stub
	}
	
	public void inserir(int pos_at, String info) {
		getAcoes().put(pos_at, info);
	}
	
	public void recuperar(int pos_at) {
		int req = 1;//posição requirida
		
		while(req != 0) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("");
			System.out.println("MODO UNDO");
			System.out.println("Faça a entrada. ");
			System.out.println("Se negativa, você retornará passos de: " + pos_at);
			System.out.println("Se positiva, ele irá até a posição desejada");
			System.out.println("Se 0, ele sairá do modo UNDO");
			System.out.print("Entrada: ");
			System.out.println("");
			req = scanner.nextInt();
			if(req < 0) {
				req = pos_at + req;
			}
			
		    if (acoes.containsKey(req)) {
	            String valor = acoes.get(req);
	            System.out.println("Valor encontrado para a chave " + req + ": " + valor);
	        } else {
	            System.out.println("Chave não encontrada: " + req);
	        }
			
			
		}
		
	
		
	}

	public String recuperar(int pos_at, int req) {
		
	
			if(req < 0) {
				req = pos_at + req;
			}
			
		    if (acoes.containsKey(req)) {
	            String valor = acoes.get(req);
	            return("Valor encontrado para a chave " + req + ": " + valor);
	        } 
		    else {
	            return("Chave não encontrada: " + req);
	        }
			
			
		
		
	
		
	}
	
	
	
	
	public Map<Integer, String> getAcoes() {
		return acoes;
	}

	public void setAcoes(Map<Integer, String> acoes) {
		this.acoes = acoes;
	}

}
