
public class Usuario {
	private final int id;
	private String nome;
	private int idade;
	private String login;
	private String senha;
	private static int qtdUsuarios;
	
	//Metodo Construtor
	public Usuario() {
		this.id=qtdUsuarios;
		this.nome=" ";
		this.idade=0;
		this.login=" ";
		this.senha=" ";
		qtdUsuarios++;
	}
	
	//Metodos Getters e Setters da classe Usuario
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public static int getQtdUsuarios() {
		return qtdUsuarios;
	}
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", idade=" + idade + ", login=" + login + ", senha=" + senha
				+ "]";
	}

	public void criaUsuario(String nome, int idade, String login, String senha) {
		setNome(nome);
		setIdade(idade);
		setLogin(login);
		setSenha(senha);
	}
}
