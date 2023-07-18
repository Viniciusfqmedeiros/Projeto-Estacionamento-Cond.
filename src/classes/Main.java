package classes;




import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		UI ui = new UI();
		Undo undo = new Undo();
		Garagem garagem = new Garagem();
		
		
		
		int opcao = 0;
		String entrada;
		String aviso;
		int pos_at = 1;//posição atual do loop principal na incrementação

		String usr= " ";
		String psswd= " ";
		
		garagem.lerDados();
		garagem.lerLogins();
		

		
		
		
		 
		  
		  
		TelaLogin login = new TelaLogin();
		login.setVisible(true);	
		
		
	
		
	
		while(!garagem.conferirUsuario(usr, psswd)) {
			
		
			usr= login.getUsr();
			psswd= login.getPsswd();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		}
		
		login.setClose(false);
		
		TelaExecucao execucao = new TelaExecucao(garagem, usr, psswd);
		execucao.setVisible(true);
		execucao.setGer(garagem.isGerente(usr, psswd));
	

		while(!TelaExecucao.isClose()) {
		
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			execucao.updateTable();
			
		
		}
		
		
	
	
	garagem = execucao.getGar();
	garagem.gravarDados();
	garagem.gravarLogins();
	
	undo = execucao.getUnd();
	
	
	
	
	
	
	
		
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
			case 0:
				ui.opcao0();
				undo.recuperar(pos_at);
				undo.inserir(pos_at, "Você entrou no modo UNDO");
			break;
			case 1:

				ui.opcao1();
				entrada = scanner.nextLine();
				aviso = garagem.InfoApt(entrada);
				System.out.println(aviso);
				System.out.println();

				if (aviso.equals("INEXISTENTE")) {
					garagem.NovoApt(entrada);

				}
				
				undo.inserir(pos_at, "Você conferiu/inseriu o apartamento: " + entrada);
				
				
				break;
			case 2:
				ui.opcao2();
				entrada = scanner.nextLine();
				garagem.removerApartamento(entrada);
				undo.inserir(pos_at, "Você tentou/removeu o apartamento: " + entrada);
				break;
			case 3:
				ui.opcao3();
				entrada = scanner.nextLine();
				garagem.NovoAutomovel(entrada);
				undo.inserir(pos_at, "Você tentou/cadastrou o veiculo: " + entrada);
				break;
			case 4:
				ui.opcao4();
				entrada = scanner.nextLine();
				garagem.removerAutomovel(entrada);
				undo.inserir(pos_at, "Você tentou/removeu  o veiculo: " + entrada);

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
				undo.inserir(pos_at, "Você tentou/mudou o estado da placa: " + entrada);
				break;
			case 6:
				ui.opcao6();
				entrada = scanner.nextLine();
				garagem.visitante(entrada);
				undo.inserir(pos_at, "Você tentou/adicionou o visitante: " + entrada);
				break;
			
				
			}
			if(garagem.isGerente(usr, psswd) && opcao == 7) {
				ui.opcao7();
				entrada = scanner.nextLine();
				garagem.mudarMaximos(entrada);
				undo.inserir(pos_at, "Você tentou/mudou o n maximo do apt: " + entrada);
				
			}
			else if(garagem.isGerente(usr, psswd) && opcao == 8) {
				ui.opcao8();
				entrada = scanner.nextLine();
				garagem.addPess(entrada);
				undo.inserir(pos_at, "Você tentou/adicionou a pessoa: " + entrada);

			}
			else if(garagem.isGerente(usr, psswd) && opcao == 9) {
				ui.opcao9();	
				entrada = scanner.nextLine();
				garagem.remPess(entrada, usr, psswd);
				undo.inserir(pos_at, "Você tentou/removeu a pessoa: " + entrada);

			}
			else if(garagem.isGerente(usr, psswd) && opcao == 10) {
				ui.opcao10();	
				entrada = scanner.nextLine();
				ui.mostrarPess(entrada);
				undo.inserir(pos_at, "Você tentou/consultou a pessoa: " + entrada);

			}
			
			pos_at++;
		}
		
		

	}
	
}//!< Programa
