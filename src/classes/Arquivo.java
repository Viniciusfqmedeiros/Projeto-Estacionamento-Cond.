package classes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
public class Arquivo {
	
	private String arquivoNome = "apt.txt";
	
	
	public Arquivo(){
	
		
		
		
		
		
		// TODO Auto-generated constructor stub
	}
	
	boolean existe(String nome){
		File arquivo = new File(nome);
		return arquivo.isFile();
		
	}
	
	
	  public ArrayList<String[]> lerArquivo(String nome){
		 
		  ArrayList<String[]> allInfo = new ArrayList();
		  
		  try (BufferedReader br = new BufferedReader(new FileReader(nome))) {
            String linha;
            
            while ((linha = br.readLine()) != null) {
            	
                
                String[] info = linha.split(" ");
                
                // Faça o processamento desejado com cada linha do arquivo
                allInfo.add(info);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	 
		  return allInfo;
	  }
	  
	  
	   public void escreverDados(){
		   try (BufferedWriter writer = new BufferedWriter(new FileWriter("apt.txt", false))){
			   for(Apartamento apartamento : Garagem.getApartamentos()) {
                writer.newLine();
				writer.write("*");
		   		writer.write(" ");
		   		
		   		
		   		
		   		writer.write(apartamento.getApartamentoNo());
		   		writer.newLine();
		   		for(Automovel automovel : apartamento.getAutomoveis()) {
		   			writer.write(automovel.getPlaca());
		   			writer.write(" ");
		   			if(automovel.getTipo() == 	1) {	writer.write("carro");	}
		   			else { 	writer.write("moto");	}
		   			writer.write(" ");
		   			if(automovel.isDentro()) {	writer.write("dentro");	}
		   			else { 	writer.write("fora");	}
		   			writer.newLine();
		   			
		   		}
		   		
		   		writer.write("*");
		   		writer.flush(); // Garante a gravação imediata das alterações
		   		
			   }
		   }
		   	catch(IOException e){
		   		e.printStackTrace();
		   }
		   
			
		   /*
		   Se o arquivo existir, apague
	   	
		   escrever:
	   		* + numero apartamento
	   		placa tipo dentro/fora
	   		*/
	   
		   
		   }
	   	
	   public void escreverLogins(){
		   boolean flag = true;
		   
			   try (BufferedWriter writer = new BufferedWriter(new FileWriter("login.txt", false))){
				   for(Pessoa pess : Garagem.getPessoas()) {
				   
				   if(flag && pess instanceof Funcionario) {
				
					writer.write("-");
					writer.write(" ");
					writer.write("Funcionarios");
			   		writer.newLine();
			   		flag = !flag;
			   		
				  }
			   	if(pess instanceof Funcionario) {
			   			
			   			Funcionario func = (Funcionario) pess;
			   			writer.write(func.getNome());
			   			writer.write(" ");
			   			writer.write(func.getCpf());
			   			writer.write(" ");
			   			writer.write(func.getId());
			   			writer.write(" ");
			   			writer.write(func.getSenha());
			   			writer.newLine();
			   			writer.flush(); // Garante a gravação imediata das alterações
			   		}
			   		
			   		
			  	  if(!flag && pess instanceof Gerente) {
						writer.write("-");
						writer.write(" ");
						writer.write("Gerentes");
				   		writer.newLine();
				   		flag = !flag;
				   		writer.flush(); // Garante a gravação imediata das alterações
					  }
			  	  
			  	if(pess instanceof Gerente) {
		   			Gerente ger = (Gerente) pess;
		   			writer.write(ger.getNome());
		   			writer.write(" ");
		   			writer.write(ger.getCpf());
		   			writer.write(" ");
		   			writer.write(ger.getId());
		   			writer.write(" ");
		   			writer.write(ger.getSenha());
		   			writer.newLine();
		   			writer.flush(); // Garante a gravação imediata das alterações
		   		}
			  				   		
			  	writer.flush(); // Garante a gravação imediata das alterações
				   
				   }
			   }
			   	catch(IOException e){
			   		e.printStackTrace();
			   }
			   
		   
		   
		   
	   }
	   
	   public static void apagarArquivo(String nome){
	   	try (BufferedWriter writer = Files.newBufferedWriter(Path.of(nome), StandardOpenOption.TRUNCATE_EXISTING)){
        writer.flush(); // Garante a gravação imediata das alterações
	
	   
	   }
	   	catch(IOException e){
	   		e.printStackTrace();
	   }
	   
	   
	   
	   }
	  
	 
	
	

}
