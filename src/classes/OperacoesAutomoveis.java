package classes;

import java.util.ArrayList;

public interface OperacoesAutomoveis {
	public void NovoAutomovel(String aptNo);
	public ArrayList <String> getEstacionados(boolean e);
	public void mudarEstado(String placa);
	public void removerAutomovel(String placa);
	
}
