package classes;

public class Funcionario extends Pessoa {
	private String id;
	private String senha;
	public Funcionario(String nome, String cpf, String id, String senha) {
		super(nome, cpf, 0);
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
