package classes;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private int tipo; //0 Funncionario, 1 gerente
	
	public Pessoa(String nome, String cpf, int tipo) {
		setNome(nome);
		setCpf(cpf);
		setTipo(tipo);
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


}
