import java.util.ArrayList;

public class Usuario {
	private int id;
	private String nome;
	private int idade;
	private String login;
	private String senha;
	private static int qtdUsuarios = 0;
	private final ArrayList<UsuarioPlayList> playListsPublicas;
	private final ArrayList<PlayListPrivada> playListsPrivadas;
	
	//Metodo Construtor
	public Usuario() {
		playListsPrivadas = new ArrayList<PlayListPrivada>();
		playListsPublicas = new ArrayList<UsuarioPlayList>();
		this.id = 0;
		this.nome = " ";
		this.idade = 0;
		this.login = " ";
		this.senha = " ";
	}
	
	public Usuario(String nome, int idade, String login, String senha) {
		qtdUsuarios++;
		id = qtdUsuarios;
		this.nome = nome;
		this.idade = idade;
		this.login = login;
		this.senha = senha;
		playListsPrivadas = new ArrayList<PlayListPrivada>();
		playListsPublicas = new ArrayList<UsuarioPlayList>();
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
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
	public ArrayList<UsuarioPlayList> getPlayListsPublicas() {
		return playListsPublicas;
	}

	public ArrayList<PlayListPrivada> getPlayListsPrivadas() {
		return playListsPrivadas;
	}

	//Metodos que criam playlists publica ou privada, caso ja exista uma playlist com o nome retorna falso
	public boolean criaPlayListPublica(String nome) {
		for(int i=0; i<playListsPublicas.size(); i++) {
			if(playListsPublicas.get(i).getPlayList().getNome().equals(nome) == true) {
				return false;
			}
		}
		PlayListPublica novaPlayList = new PlayListPublica(nome, this);//adiciona este usuario como contribuinte da novaPlaylist
		UsuarioPlayList novaPlayListAssociativa = new UsuarioPlayList(this, novaPlayList);//Cria um objeto associando playlist e usuario
		playListsPublicas.add(novaPlayListAssociativa);//Adciona a playList criada a listaa de playLists do usuario.
		return true;
	}
	
	public boolean criaPlayListPrivada(String nome) {
		for(int i=0; i< playListsPrivadas.size(); i++) {
			if(playListsPrivadas.get(i).getPlayList().getNome() == nome) {
				return false;
			}
		}
		PlayListPrivada novaPlayList = new PlayListPrivada(nome, this); //cria playlist privada
		playListsPrivadas.add(novaPlayList);//Adciona a playList criada a listaa de playLists do usuario.
		return true;
	}
	
	//metodos que removem playlists publicas ou privadas, caso as playlists nao existam retorna falso
	/*public boolean removePlayListPublica(PlayListPublica playlist){
		boolean removeu = false;
		//remove o usuario de lista de  contribuintes da playList
		for(int i = 0; i < playlist.getContribuintesPlayList().size(); i++){
			if(playlist.getContribuintesPlayList().get(i).getUsuario() == this){
				playlist.getContribuintesPlayList().remove(i);
				removeu = true;
			}
		}
		//remove a playList da lista de playlists do usuario
		for(int i = 0; i < playlistsPublicas.size(); i++){
			if( playlistsPublicas.get(i).getPlayList() == playlist){
				playlistsPublicas.remove(i);
			}
		}
		return removeu;
	}
	
	public boolean removePlayListPrivada(PlayListPrivada playlist) {
		boolean removeu = false;
		//remove o usuario de lista de  contribuintes da playList
		for(int i = 0; i < playlist.getContribuintesPlayList().size(); i++){
			if(playlist.getContribuintesPlayList().get(i).getUsuario() == this){
				playlist.getContribuintesPlayList().remove(i);
				removeu = true;
			}
		}
		//remove a playList da lista de playlists do usuario
		for(int i = 0; i < playlistsPublicas.size(); i++){
			if( playlistsPublicas.get(i).getPlayList() == playlist){
				playlistsPublicas.remove(i);
			}
		}
		return removeu;
	}
	*/
	/*
	//Adiciona Musica a uma playlist publica (codigo 0) ou a uma playlist privada(codigo 1)
	public boolean adicionaMusicaPlaylist(String nome, int tipo, Musica musica) {
		//Playlist publica
		if(tipo == 0) {
			for(int i=0; i<playlistsPublicas.size(); i++) {
				if(playlistsPublicas.get(i).getPlayList().getNome() == nome) {
					playlistsPublicas.get(i).getPlayList().adicionarMusica(musica);
					return true;
				}
			}
		}
		//PlayListPrivada
		if(tipo == 1) {
			for(int i=0; i<playlistsPrivadas.size(); i++) {
				if(playlistsPrivadas.get(i).getPlayList().getNome() == nome) {
					playlistsPrivadas.get(i).getPlayList().adicionarMusica(musica);
					return true;
				}
			}
		}
		return false;
	}

	//Adiciona todas as musicas de um album em uma playlist publica (codigo 0) ou privada (codigo 1)
	public void adicionaAlbumPlaylist(String nome, int tipo, Album album) {
		for(int i=0; i<album.getMusicas().size(); i++) {
			adicionaMusicaPlaylist(nome, tipo, album.getMusicas().get(i));
		}
	}
	*/
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", idade=" + idade + ", login=" + login + ", senha=" + senha
				+ ", playlistsPublicas=" + playListsPublicas + ", playlistsPrivadas=" + playListsPrivadas + "]";
	}
}
