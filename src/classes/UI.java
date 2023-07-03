package classes;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
	Scanner scanner = new Scanner(System.in);
	
	public UI() {
		// TODO Auto-generated constructor stub
	}
	
	public void mostrarOpcoes() {
		System.out.println("Escolha:");
		System.out.println("[1] Cadastrar/Conferir apartamento");
		System.out.println("[2] Remover apartamento");
		System.out.println("[3] Cadastrar novo veiculo");
		System.out.println("[4] Remover veiculo");
		System.out.println("[5] Placa que saiu/voltou");
		System.out.println("[6] Visitante");//Vai virar condomino temporário
		//Vai virar condomino temporário
	}


	public void mostrarAutomoveis(ArrayList <String> estacionados, ArrayList <String> foras){
		System.out.println("Veiculos estacionados:");
		
		for(String estacionado : estacionados){
			System.out.println(estacionado);
		
		
		}
		System.out.println();	
		System.out.println("Veiculos fora:");
		
		for(String fora : foras){
			System.out.println(fora);
		
		
		}
		System.out.println();
	
	
	
	
	}
	public void usr(){
		System.out.print("Usuario: ");
		System.out.println();
	}	
	public void psswd(){
		System.out.print("Senha: ");
		System.out.println();
	}	

	public void opcao1(){
		System.out.println("Cadastrar/Conferir Apartamento");
		System.out.println("Qual o numero?");
	}

	public void opcao2(){
		
		System.out.println("Remover apartamento.");
		System.out.println("Qual o numero?");
	}
	
	public void opcao3(){
		System.out.println("Cadastrar novo automovel.");
		System.out.println("Qual o numero do apt?");
	}
	public void opcao4(){
	
		System.out.println("Remover um automovel.");	
		System.out.println("Digite a placa.");
	
	
	}

	public void opcao5(){
		System.out.println("Digite a placa que saiu/voltou:");
		
	}
	
	public void opcao6(){
		System.out.println("Visitante.");
		System.out.println("Apartamento visitado:");
	}
	
	
	
	public void opcao7(){
		System.out.println("Qual o número do apartamento a ser alterado?");
	}
	
	public void opcao8(){
		System.out.println("Deseja adicionar funcionário ou gerente	[F|G]?");
	}

	public void opcao9(){
		System.out.println("Deseja remover funcionário ou gerente? Digite o CPF");
	}
	
	public void opcao10(){
		System.out.println("Digite o CPF do funcionário/gerente.");
		
	}


	public void ShowInfo(String info){
		System.out.println(info);
	
	}

	public  boolean Wish(String wish){
		String p = "placeholder";
		System.out.println("Deseja "+ wish + "? [S/N]");
		
		
		try {
			p = scanner.nextLine();
			if(!p.equals("S") && !p.equals("N")) {
				throw  new Exception();
			}
			
		}
		catch(Exception e) {
			System.out.println("Entrada não esperada. Insira S/N. Operação cancelada");
			
		}
		
		if(p.equals("S")){
			
			return true;
		}

			return false;
	}


	public ArrayList <String> GetInfo(){
		String leitura;
		ArrayList <String> info = new ArrayList<>();
		System.out.println("Qual a placa?");
		leitura= scanner.nextLine();
		info.add(leitura);
		System.out.println("Esta dentro?[S/N]");
		
		try {
			leitura= scanner.nextLine();
			if(!leitura.equals("S") && !leitura.equals("N")) {
				throw  new Exception();
			}
			
		}
		catch(Exception e) {
			System.out.println("Entrada não esperada. Operação cancelada");
			
		}
		info.add(leitura);
		return info;
	
	}
	
	
	public void gerOp() {
		System.out.println("[7] Mudar número máximo de automóveis de determinado apt");
		System.out.println("[8] Adicionar funcionário/gerente");
		System.out.println("[9] Remover funcionário/gerente");
		System.out.println("[10] Consultar funcionário/gerente");
		
		
	}
	
	public ArrayList <String> lerUsr(){
		ArrayList <String> usr = new ArrayList<>();
		String info;
		
		System.out.println("Qual o nome?");
		info = scanner.nextLine();
		usr.add(info);
		System.out.println("Qual o cpf?");
		info = scanner.nextLine();
		usr.add(info);
		System.out.println("Qual o id?");
		info = scanner.nextLine();
		usr.add(info);
		System.out.println("Qual a senha?");
		info = scanner.nextLine();
		usr.add(info);
		return usr;
		
	}
	
	public void mostrarPess(String cpf) {
		boolean find = false;
		for(Pessoa pessoa : Garagem.getPessoas()) {
			if(pessoa.getCpf().equals(cpf)) {
				find = !find;
				System.out.println("");
				System.out.println("Nome: "+pessoa.getNome());
				System.out.println("CPF: "+pessoa.getCpf());
				if(pessoa.getTipo() == 0) {
					Funcionario func = (Funcionario) pessoa;
					System.out.println("Tipo: Funcionário");
					System.out.println("Identificador: "+func.getId());
					System.out.println("Senha: " + func.getSenha());
				}
				else if(pessoa.getTipo() == 1) {
					Gerente func = (Gerente) pessoa;
					System.out.println("Tipo: Gerente");
					System.out.println("Identificador: "+func.getId());
					System.out.println("Senha: " + func.getSenha());
					
				}
				System.out.println("");
			}
			
		}
		try {
		if(!find) {
			throw new Exception();
		}
		}
		catch(Exception e) {
			System.out.println("");
			System.out.println("Usuário com cpf informado não encontrado.");
			System.out.println("");
		}
		
	}

}
