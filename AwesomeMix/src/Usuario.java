import java.util.ArrayList;

public class Usuario {
	private final int id;
	private String nome;
	private int idade;
	private String login;
	private String senha;
	private ArrayList <UsuarioPlayList> playLists;
	private static int qtdUsuarios;
	
	//Metodo Construtor
	public Usuario() {
		this.id=qtdUsuarios;
		this.nome=" ";
		this.idade=0;
		this.login=" ";
		this.senha=" ";
		qtdUsuarios++;
		playLists = new ArrayList <UsuarioPlayList>();
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
	public ArrayList<UsuarioPlayList> getPlayLists() {
		return playLists;
	}

	/*Metodo: criar playlist: 
	 *O que faz: o usuario deve criar um objeto do tipo playList e adiciona-la a sua lista de playLists.
	 *Ele deve setar a si mesmo como autor e deve ser incluido como contribuinte da playList
	 *Retorno: pode ser void, ou boolean se quiser dar feedBack
	 * */
	
	
	
}
