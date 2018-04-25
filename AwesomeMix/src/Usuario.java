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
	
	//Metodos que criam playlists publica ou privada, caso ja exista uma playlist com o nome retorna falso
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
	
	//metodos que removem playlists publicas ou privadas, caso as playlists nao existam retorna falso
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

	//metodo que cria um usuario e altera os campos nome, idade, login e senha
	public void criaUsuario(String nome, int idade, String login, String senha) {
		setNome(nome);
		setIdade(idade);
		setLogin(login);
		setSenha(senha);
	}
	
	//Adiciona Musica a uma playlist publica (codigo 0) ou a uma playlist privada(codigo 1)
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

	//Adiciona todas as musicas de um album em uma playlist puclica (codigo 0) ou privada (codigo 1)
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
