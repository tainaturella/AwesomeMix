import java.util.ArrayList;

public class Usuario {
	private int id;
	private String nome;
	private int idade;
	private String login;
	private String senha;
	private static int qtdUsuarios;
	private ArrayList<UsuarioPlayList> playlistsPublicas;
	private ArrayList<PlayListPrivada> playlistsPrivadas;
	
	//Metodo Construtor
	public Usuario() {
		playlistsPrivadas = new ArrayList<PlayListPrivada>();
		playlistsPublicas = new ArrayList<UsuarioPlayList>();
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
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
	public ArrayList<UsuarioPlayList> getPlaylistsPublicas() {
		return playlistsPublicas;
	}

	public ArrayList<PlayListPrivada> getPlaylistsPrivadas() {
		return playlistsPrivadas;
	}

	//Metodos que criam playlists publica ou privada, caso ja exista uma playlist com o nome retorna falso
	public boolean criaPlayListPublica(String nome) {
		for(int i=0; i<playlistsPublicas.size(); i++) {
			if(playlistsPublicas.get(i).getPlayList().getNome() == nome) {
				return false;
			}
		}
		//PlayListPublica novaPlayList= new PlayListPublica(nome, this);//adiciona este usuario como contribuinte da novaPlaylist
		//UsuarioPlayList novaPlayListAssociativa = new UsuarioPlayList(this, novaPlayList);//Cria um objeto associando playlist e usuario
		//playlistsPublicas.add(novaPlayListAssociativa);//Adciona a playList criada a listaa de playLists do usuario.
		return true;
	}
	
	public boolean criaPlayListPrivada(String nome) {
		for(int i=0; i<playlistsPrivadas.size(); i++) {
			if(playlistsPrivadas.get(i).getNome() == nome) {
				return false;
			}
		}
		//PlayListPrivada novaPlayList= new PlayListPrivada(nome, this);//adiciona este usuario como contribuinte da novaPlaylist
		//UsuarioPlayList novaPlayListAssociativa = new UsuarioPlayList(this, novaPlayList);//Cria um objeto associando playlist e usuario
		//playlistsPublicas.add(novaPlayListAssociativa);//Adciona a playList criada a listaa de playLists do usuario.
		return true;
	}
	
	//metodos que removem playlists publicas ou privadas, caso as playlists nao existam retorna falso
	public boolean removePlayListPublica(PlayListPublica playlist){
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
	
	/*Como temos uma relacao de 1 para n (de usuario para PlayListPrivada, basta
	 *apagarmos a referencia da playList na lista de playLists do usuario*/
	public boolean removePlayListPrivada(PlayListPrivada playlist) {
		boolean removeu = false;
		//remove o usuario de lista de  contribuintes da playList
		
		return removeu;
	}

	
	/*Metodo: adicionaMusicaPlayList
	 *Parametros: a musica a ser adicionada e uma referencia do tipo PlayList
	 *O que faz: verifica qual o tipo do objeto, se for uma PlayListPublica, verifica
	 *se o usuario eh contribuinte dela, se sim ele pode adicionar. Se o tipo for PlayListPrivada
	 *verifica se o usuario eh o dono, se sim entao ele pode adicionar*/
	public boolean adicionaMusicaPlaylist(Musica musica, PlayList playlist) {
		boolean adicionou = true;
		if(playlist instanceof PlayListPublica){
			PlayListPublica temp = (PlayListPublica)playlist;
			for(int i = 0; i < temp.getContribuintesPlayList().size(); i++){
				if(temp.getContribuintesPlayList().get(i).getUsuario() == this){
					playlist.adicionarMusica(musica);
				}
			}
		}else if (playlist instanceof PlayListPrivada){
			if(((PlayListPrivada) playlist).getDono()== this){
				playlist.adicionarMusica(musica);
			}
		}
		return adicionou;
	}
	

	//Adiciona todas as musicas de um album em uma playlist puclica 
	public void adicionaAlbumPlaylist(Album album,  PlayList playlist) {
		for(int i=0; i<album.getMusicas().size(); i++) {
			adicionaMusicaPlaylist(album.getMusicas().get(i),playlist);
		}
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", idade=" + idade + ", login=" + login + ", senha=" + senha
				+ ", playlistsPublicas=" + playlistsPublicas + ", playlistsPrivadas=" + playlistsPrivadas + "]";
	}
}
