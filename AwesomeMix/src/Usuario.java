import java.util.ArrayList;

public class Usuario {
	private final int id;
	private String nome;
	private int idade;
	private String login;
	private String senha;
	private static int qtdUsuarios;
	private ArrayList<PlayListPublica> playlistsPublicas;
	private ArrayList<PlayListPrivada> playlistsPrivadas;
	
	//Metodo Construtor
	public Usuario() {
		playlistsPrivadas = new ArrayList<PlayListPrivada>();
		playlistsPublicas = new ArrayList<PlayListPublica>();
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
	
	public boolean criaPlayListPublica(String nome) {
		for(int i=0; i<playlistsPublicas.size(); i++) {
			if(playlistsPublicas.get(i).getNome() == nome) {
				return false;
			}
		}
		playlistsPublicas.add(new PlayListPublica(nome, this));
		return true;
	}
	
	public boolean criaPlayListPrivada(String nome) {
		for(int i=0; i<playlistsPrivadas.size(); i++) {
			if(playlistsPrivadas.get(i).getNome() == nome) {
				return false;
			}
		}
		playlistsPrivadas.add(new PlayListPrivada(nome, this));
		return true;
	}
	
	public boolean removePlayListPublica(String nome) {
		for(int i=0; i<playlistsPublicas.size(); i++) {
			if(playlistsPublicas.get(i).getNome() == nome) {
				playlistsPublicas.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean removePlayListPrivada(String nome) {
		for(int i=0; i<playlistsPrivadas.size(); i++) {
			if(playlistsPrivadas.get(i).getNome() == nome) {
				playlistsPrivadas.remove(i);
				return true;
			}
		}
		return false;
	}

	public void criaUsuario(String nome, int idade, String login, String senha) {
		setNome(nome);
		setIdade(idade);
		setLogin(login);
		setSenha(senha);
	}
	
	public boolean adicionaMusicaPlaylist(String nome, int tipo, Musica musica) {
		//Playlist publica
		if(tipo == 0) {
			for(int i=0; i<playlistsPublicas.size(); i++) {
				if(playlistsPublicas.get(i).getNome() == nome) {
					playlistsPublicas.get(i).adicionarMusica(musica);
					return true;
				}
			}
		}
		//PlayListPrivada
		if(tipo == 1	) {
			for(int i=0; i<playlistsPrivadas.size(); i++) {
				if(playlistsPrivadas.get(i).getNome() == nome) {
					playlistsPrivadas.get(i).adicionarMusica(musica);
					return true;
				}
			}
		}
		return false;
	}

	public void adicionaAlbumPlaylist(String nome, int tipo, Album album) {
		for(int i=0; i<album.getMusicas().size(); i++) {
			adicionaMusicaPlaylist(nome, tipo, album.getMusicas().get(i));
		}
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", idade=" + idade + ", login=" + login + ", senha=" + senha
				+ ", playlistsPublicas=" + playlistsPublicas + ", playlistsPrivadas=" + playlistsPrivadas + "]";
	}
}
