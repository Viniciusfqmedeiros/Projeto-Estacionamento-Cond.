package classes;

import classes.UI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		UI ui = new UI();
		Garagem garagem = new Garagem();

		int opcao = 0;
		String entrada;
		String aviso;
		

		String usr;
		String psswd;
		garagem.lerDados();
		garagem.lerLogins();
		
		
		  while(true){
			  ui.usr();
			  usr= scanner.nextLine();
			  ui.psswd();
			  psswd= scanner.nextLine();
		
			  
		try {	  
		if(garagem.conferirUsuario(usr, psswd)){
			  
			   break;
		 
		
		}//!< Login
		else {
			throw new Exception();
			
		}
			
		}
		catch(Exception e) {
			System.out.println("Login inválido");
		}
		  }
		  
		

		while (true) {
			garagem.gravarDados();
			garagem.gravarLogins();
			ui.mostrarAutomoveis(garagem.getEstacionados(true), garagem.getEstacionados(false));
			ui.mostrarOpcoes();
			if(garagem.isGerente(usr, psswd)) {
				ui.gerOp();
				
			}
			try {
				opcao = scanner.nextInt();
				if((opcao >= 7 && !garagem.isGerente(usr, psswd)) ||(opcao >= 11 && garagem.isGerente(usr, psswd))) {
					throw new Exception();
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Erro: Opção inválida. Insira um número inteiro.");
				System.out.println();
				
			}
			catch(Exception e) {
				System.out.println("Erro: Opção inválida. Insira um número dentro do limite opções.");
				System.out.println();
				
			}
			
			
			scanner.nextLine();
			switch (opcao) {
			case 1:

				ui.opcao1();
				entrada = scanner.nextLine();
				aviso = garagem.InfoApt(entrada);
				System.out.println(aviso);
				System.out.println();

				if (aviso.equals("INEXISTENTE") == true) {
					garagem.NovoApt(entrada);

				}
				break;
			case 2:
				ui.opcao2();
				entrada = scanner.nextLine();
				garagem.removerApartamento(entrada);
				break;
			case 3:
				ui.opcao3();
				entrada = scanner.nextLine();
				garagem.NovoAutomovel(entrada);
				break;
			case 4:
				ui.opcao4();
				entrada = scanner.nextLine();
				garagem.removerAutomovel(entrada);
				break;
		
			case 5:
				ui.opcao5();
				entrada = scanner.nextLine();
				
			  	if(entrada.indexOf('#') != -1){
			  		garagem.removerAutomovel(entrada);
			  
			  
			  }
			  	else {
			  		
			  		garagem.mudarEstado(entrada);
			  		
			  	}
				
				break;
			case 6:
				ui.opcao6();
				entrada = scanner.nextLine();
				garagem.visitante(entrada);
				break;
			
				
			}
			if(garagem.isGerente(usr, psswd) && opcao == 7) {
				ui.opcao7();
				entrada = scanner.nextLine();
				garagem.mudarMaximos(entrada);
				
				
			}
			else if(garagem.isGerente(usr, psswd) && opcao == 8) {
				ui.opcao8();
				entrada = scanner.nextLine();
				garagem.addPess(entrada);
			}
			else if(garagem.isGerente(usr, psswd) && opcao == 9) {
				ui.opcao9();	
				entrada = scanner.nextLine();
				garagem.remPess(entrada, usr, psswd);
			}
			else if(garagem.isGerente(usr, psswd) && opcao == 10) {
				ui.opcao10();	
				entrada = scanner.nextLine();
				ui		.mostrarPess(entrada);
			}
		}

	}
}//!< Programa
