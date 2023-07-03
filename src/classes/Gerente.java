package classes;

public class Gerente extends Pessoa {
	private String id;
	private String senha;
	public Gerente(String nome, String cpf, String id, String senha) {
		super(nome, cpf, 1);
		setId(id);
		setSenha(senha);
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
