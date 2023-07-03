 package classes;

import java.util.ArrayList;
import java.util.Scanner;

public  class Garagem implements OperacoesAutomoveis, OperacoesApartamentos, OperacoesUsuarios {

	private static ArrayList<Apartamento> apartamentos;
	private static ArrayList<Pessoa> pessoas;
	


	UI ui = new UI();

	public Garagem() {
		
		this.setApartamentos(new ArrayList<>());
		this.pessoas = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
	
	
	
 void visitante(String aptNo){
  int dentroCar = 0;
  int dentroMot = 0;
  boolean dentro;
  
  ArrayList<String> info;
  
  int index = EncontrarApt(aptNo);
  for(Automovel automovel : apartamentos.get(index).getAutomoveis()){
  	  
	  if(automovel.isDentro() && automovel.getTipo() == 1){
				dentroCar++;
	   }
	   
	   if(automovel.isDentro() && automovel.getTipo() == 2){		
	  		dentroMot++;
	  }
	  
  }//!< Conta a quantidade de motos e carros estacionados
  
  
  if(dentroCar < apartamentos.get(index).getVagaTotalCarro()  
	&& ui.Wish("estacionar um novo carro")){
		info = ui.GetInfo();
   		String nome = '#' + info.get(0);
   		System.out.println(nome);
   		dentro = (info.get(1).equals("S")) ? true : false;
   		getApartamentos().get(index).addCarro(nome, dentro);
  
  }//!< estaciona um carro no apartamento se houver vaga disponível
	  
  
  if(dentroMot < apartamentos.get(index).getVagaTotalMoto()  
	&& ui.Wish("estacionar uma novo moto")){
		info = ui.GetInfo();
	    String nome = '#' + info.get(0);
	    
	    dentro = (info.get(1).equals("S")) ? true : false;
	    //getApartamentos().get(index).addMoto(nome, dentro);
  
  }//!< estaciona um carro no apartamento se houver vaga disponível
  
  
	  }

	public void lerLogins(){
		
		Arquivo arquivo = new Arquivo();
		
		
		if(arquivo.existe("login.txt")) {
			ArrayList<String[]> allInf = arquivo.lerArquivo("login.txt");
			
			
			
			/*
			 
			 estrutura do txt:
			 
			 - funcionario
			   nome cpf login senha	
			  
			 - gerente
			  nome cpf login senha	
			 *
			 
			 	*/
			boolean flag = false;
			
			for(String[] linha : allInf) {
				 if(linha[1].equals("Funcionarios") || linha[1].equals("Gerentes")){
					 flag = !flag;
					 continue;
					 
				 }
				if(flag && conferirCpf(linha[2])) {
					//System.out.println(linha[0]);
					pessoas.add(new Funcionario(linha[0], linha[1], linha[2], linha[3]));
					 
					 
				 }
				
		
			
				
				 
				
				
			}
			
			flag = true;
			
			for(String[] linha : allInf) {
				if(linha[1].equals("Funcionarios") || linha[1].equals("Gerentes")){
					 flag = !flag;
					 continue;
					 
				 }
				
				if(flag && conferirCpf(linha[2]) ) {
				
					
					pessoas.add(new Gerente(linha[0], linha[1], linha[2], linha[3]));
					 
					 
				 }
				
				
				 
				
				
			}
			
			
			
		}
		
			
	    Gerente admin = new Gerente("sysadm","xxx.xxx-xx", "sysadm", "999" );	
	    if(conferirCpf("xxx.xxx-xx")) {
	    	pessoas.add(admin);
	    }
	
	}
	  
	 
	
	public void lerDados() {
		
		
		
		
		
		Apartamento apartamento = null;
		Arquivo arquivo = new Arquivo();
		
		if(arquivo.existe("apt.txt")) {
			
			ArrayList<String[]> allInf = arquivo.lerArquivo("apt.txt");
			
			
			
			/*
			 
			 estrutura do apt.txt:
			 
			 * numapt
			   aesho moto dent	
			   wije carro for	
			 * 
			 
			  
			 	*/
			
			boolean flag = false;
			
			for(String[] linha : allInf) {
						
			 
				
				
			  if(linha[0].equals("*")){
				flag = !flag;
				
				if(linha.length > 1 && flag){
					
					apartamento =  new Apartamento(linha[1]);
					
				}
				if(!flag) {
					getApartamentos().add(apartamento);
				}
		  }//!< O asterisco é uma flag para mudar o estado
			
			  if(flag){
				
			  	if(linha[1].equals("moto")){
			  		apartamento.addMoto(linha[0], linha[2].equals("dentro"));
			  		
			  	}
			  	else if(linha[1].equals("carro")){
			  			apartamento.addCarro(linha[0], linha[2].equals("dentro"));
			  			
			  	}
			  
			  }
			
			}
			
		}
	}//Ler dados e montar banco de dados
	
	public void gravarDados(){
		Arquivo arquivo = new Arquivo();
		Arquivo.apagarArquivo("apt.txt");			
		arquivo.escreverDados();
			
		
	} 
	
	public void gravarLogins(){
		Arquivo arquivo = new Arquivo();
		Arquivo.apagarArquivo("login.txt");			
		arquivo.escreverLogins();
			
		
	} 
	

	
	public boolean conferirUsuario(String id, String psswd) {
		
		for(Pessoa pess : pessoas) {
			
			if(pess instanceof Funcionario) {
				
				
				 Funcionario func = (Funcionario) pess;
				 if(func.getId().equals(id) && func.getSenha().equals(psswd) ) {
				
					return true;
				
				}
					
			
		}
			if(pess instanceof Gerente) {
				
				 Gerente ger = (Gerente) pess;
				 if(ger.getId().equals(id) && ger.getSenha().equals(psswd) ) {
				
					return true;
				
				}
					
			
		}
		}
		
		return false;
		
		
	}

	public String InfoApt(String numero) {
		String info;
		int index = EncontrarApt(numero);
		if (index != -1) {
			info = "n de motos nesse apt: " + String.valueOf(getApartamentos().get(index).getVagaAtualMoto());
			info = info + "\nn  de carros nesse apt: " + String.valueOf(getApartamentos().get(index).getVagaAtualCarro());
			info = info + "\nn  de motos estacionadas nesse apt: " + String.valueOf(getApartamentos().get(index).getVagaAtualEstacionadaMoto());
			info = info + "\nn  de carros estacionados nesse apt: " + String.valueOf(getApartamentos().get(index).getVagaAtualEstacionadaCarro());
			return info;
		}

		return "INEXISTENTE";

	}

	public void NovoApt(String numero) {
		if (ui.Wish("adicionar")) {
			Apartamento apt = new Apartamento(numero);
			getApartamentos().add(apt);
		}
	}

	public void NovoAutomovel(String aptNo) {
		ArrayList <String> info;
		boolean dentro;
		int index = EncontrarApt(aptNo);
		
		if ( index != -1 && ui.Wish("adicionar um novo carro") ) {
			info = ui.GetInfo();
			dentro = (info.get(1).equals("S")) ? true : false;
			getApartamentos().get(index).addCarro(info.get(0), dentro);
		}
		if ( index != -1 && ui.Wish("adicionar uma nova moto")) {
			info = ui.GetInfo();
			dentro = (info.get(1).equals("S")) ? true : false;
			getApartamentos().get(index).addMoto(info.get(0), dentro);
		}

	}

	public int  EncontrarApt(String aptno) {

		for (int i = 0; i < getApartamentos().size(); i++) {

			if (aptno.equals(getApartamentos().get(i).getApartamentoNo()) == true) {
				return i;

			}

		}
		
		

		return -1;//Se n�o encontrar

	}


	public ArrayList <String> getEstacionados(boolean e){
		ArrayList <String> lista = new ArrayList<>();
		for(Apartamento apartamento: getApartamentos()){
			lista.addAll(apartamento.getAutomovelEst(e));
	
		}
		return lista;
	}

	public void mudarEstado(String placa){
		for(Apartamento apartamento : getApartamentos()){
			apartamento.mudarEstado(placa);

		
		}
	
	}

	public void removerApartamento(String aptNo){
		int index = EncontrarApt(aptNo);
		getApartamentos().remove(index);	
	
	}
	public void removerAutomovel(String placa){
	        for(Apartamento apartamento : getApartamentos()){
			apartamento.removerVeiculo(placa);
			

		
		}
	
	}

	public static ArrayList<Apartamento> getApartamentos() {
		
			return apartamentos;
		
	}
	
	
	public static ArrayList<Pessoa> getPessoas() {
		
		return pessoas;
	
}

	public void setApartamentos(ArrayList<Apartamento> apartamentos) {
		this.apartamentos = apartamentos;
	} 
	
	public void mudarMaximos(String aptNo) {
		Scanner scanner = new Scanner(System.in);
		int index = EncontrarApt(aptNo);
		boolean entrada;
		int n;
		entrada = ui.Wish(" aumentar o número máximo de carros");
		
		if(entrada) {
			n = scanner.nextInt();
			apartamentos.get(index).setVagaTotalCarro(n);
			
		}
		
		entrada = ui.Wish(" aumentar o número máximo de motos");
		
		if(entrada) {
			n = scanner.nextInt();
			apartamentos.get(index).setVagaTotalCarro(n);
			
		}
	
	
	
	}
	
	public boolean isGerente(String name, String psswd) {
		for(Pessoa pess : pessoas) {
			if(pess instanceof Gerente) {
				
				Gerente ger = (Gerente) pess;
				
				if(ger.getId().equals(name) && ger.getSenha().equals(psswd)) {
					
					return true;
				}
			}
			
			
		}
		
		return false;
		
		
	}
	
	public void addPess(String tip){
	  	ArrayList <String> usr= ui.lerUsr();
	  	try {
	  		
	  		if(conferirCpf(usr.get(1))) {
	  		
	  			if(tip.equals("F")) {
	  		
	  			pessoas.add(new Funcionario(usr.get(0), usr.get(1), usr.get(2), usr.get(3)));
	  		
	  		}
	  	
	  		if(tip.equals("G")) {
	  			pessoas.add(new Gerente(usr.get(0), usr.get(1), usr.get(2), usr.get(3)));	  			
	  		}
	  	
	  	
	  	}
	  	else {
	  		throw new Exception();
	  	}
	  	
	  	}
	  	catch(Exception e) {
	  		
	  		System.out.println("CPF já cadastrado.");
	  		System.out.println("");
	  		
	  	}
	  
	  }
	
	public boolean conferirCpf(String cpf) {
		for(Pessoa pess: pessoas) {
			if(pess.getCpf().equals(cpf)) {
				
				return false;
			}
			
		}
		
		
		return true;
	}
	
	
	public void remPess(String cpf, String usr, String psswd){
	  	int i  = 0;
	  	for(Pessoa pess : pessoas) {
	  	try {
	  		if(pess.getCpf().equals(cpf) && pess instanceof Funcionario){
		  		Funcionario ger = (Funcionario) pess;
	  			if(!ger.getId().equals(usr) && !ger.getSenha().equals(psswd)) {
	  				System.out.println("Teste1");
	  				pessoas.remove(i);
	  			}
	  			else {
	  				throw new Exception();
	  			}
	  		
	  			
	  		
	  		}
	  		
	  		
			if(pess.getCpf().equals(cpf) && pess instanceof Gerente){
		  		Gerente ger = (Gerente) pess;
	  			if(!ger.getId().equals(usr) && !ger.getSenha().equals(psswd)) {
	  				System.out.println("Teste1");
	  				pessoas.remove(i);
	  			}
	  			else {
	  				throw new Exception();
	  			}
	  		
	  			
	  		
	  		}
	  			
	  		
	  	}
	  	catch(Exception e) {
	  		System.out.println("Não pode excluir a própria conta.");
	  		
	  	}
	  		i++;
	  		
	  		
	  	}
	  	
	  
	  
	  
	  }
	
	
	 
}
