import java.util.ArrayList;

public class Usuario {
	private int id;
	private String nome;
	private int idade;
	private String login;
	private String senha;
	private static int qtdUsuarios = 0;
	private final ArrayList<UsuarioPlayListPublica> playListsPublicas;
	private final ArrayList<PlayListPrivada> playListsPrivadas;
	private final ArrayList<UsuarioMusica> musicasAvaliadas;
	
	//Metodo Construtor sem parametros
	public Usuario() {
		id = 0;
		nome=" ";
		idade=0;
		login=" ";
		senha=" ";
		playListsPrivadas = new ArrayList<PlayListPrivada>();
		playListsPublicas = new ArrayList<UsuarioPlayListPublica>();
		musicasAvaliadas = new ArrayList<UsuarioMusica>();
	}
	
	public Usuario(String nome, int idade, String login, String senha) {
		id = qtdUsuarios++;
		this.nome = nome;
		this.idade= idade;
		this.login= login;
		this.senha= senha;
		playListsPrivadas = new ArrayList<PlayListPrivada>();
		playListsPublicas = new ArrayList<UsuarioPlayListPublica>();
		musicasAvaliadas = new ArrayList<UsuarioMusica>();
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
	
	public ArrayList<UsuarioPlayListPublica> getPlayListsPublicas() {
		return playListsPublicas;
	}

	public ArrayList<PlayListPrivada> getPlayListsPrivadas() {
		return playListsPrivadas;
	}

	public ArrayList<UsuarioMusica> getMusicasAvaliadas(){
		return musicasAvaliadas;
	}
	
	//************ CRIACAO DE PLAYLISTS ***********
	
	//Cria playlist publica
	public boolean criaPlayListPublica(String nome) {
		//verifica se ja existe uma playlist com o mesmo nome
		for(int i=0; i<playListsPublicas.size(); i++) {
			if(playListsPublicas.get(i).getPlayListPublica().getNome().equals(nome)) {
				return false;
			}
		}
		PlayListPublica novaPlayListPublica = new PlayListPublica(nome); //cria playlist publica
		UsuarioPlayListPublica novaPlayListAssociativa = new UsuarioPlayListPublica(this, novaPlayListPublica);//Cria um objeto associando playlist e usuario
		playListsPublicas.add(novaPlayListAssociativa); //Adciona a playList criada a lista de playLists desse usuario.
		return true;
	}
	
	//Cria playlist privada
	public boolean criaPlayListPrivada(String nome) {
		for(int i=0; i<playListsPrivadas.size(); i++) {
			if(playListsPrivadas.get(i).getNome().equals(nome)) {
				return false;
			}
		}
		PlayListPrivada novaPlayListPrivada = new PlayListPrivada(nome, this); //adiciona este usuario como dono da novaPlaylist
		playListsPrivadas.add(novaPlayListPrivada); //Adciona a playList criada a lista de playLists do usuario.
		return true;
	}
	
	//**************** REMOCAO DE PLAYLISTS ************************
	
	//remove playlist publica
	public boolean removePlayListPublica(PlayListPublica playListPublica){
		boolean removeu = false;
		
		//remove o usuario da lista de contribuintes da playList publica
		for(int i = 0; i < playListPublica.getContribuintesPlayList().size(); i++){
			if(playListPublica.getContribuintesPlayList().get(i).getUsuario().getId() == this.getId()){
				playListPublica.getContribuintesPlayList().remove(i);
				removeu = true;
				break;
			}
		}
		
		//remove a playList da lista de playlists publicas do usuario
		for(int i = 0; i < playListsPublicas.size(); i++){
			if( playListsPublicas.get(i).getPlayListPublica().getId() == playListPublica.getId()){
				playListsPublicas.remove(i);
				if(removeu != false) removeu = true;
				break;
			}
		}
		
		return removeu;
	}
	
	/*Como temos uma relacao de 1 para n (de usuario para PlayListPrivada, basta
	 *apagarmos a referencia da playList na lista de playLists privadas do usuario*/
	public boolean removePlayListPrivada(PlayListPrivada playListPrivada) {
		boolean removeu = false;
		
		//remove a playlist privada da lista do usuario
		for(int i = 0; i < playListsPrivadas.size(); i++){
			if( playListsPrivadas.get(i).getId() == playListPrivada.getId()){
				playListsPrivadas.remove(i);
				removeu = true;
				break;
			}
		}
		
		return removeu;
	}

	
	/*Metodo: adicionaMusicaPlayList
	 *Parametros: a musica a ser adicionada e uma referencia do tipo PlayList
	 *O que faz: verifica qual o tipo do objeto, se for uma PlayListPublica, verifica
	 *se o usuario eh contribuinte dela, se sim ele pode adicionar. Se o tipo for PlayListPrivada
	 *verifica se o usuario eh o dono, se sim entao ele pode adicionar*/
	public boolean adicionaMusicaPlayList(Musica musica, PlayList playList) {
		boolean adicionou = true;
		if(playList instanceof PlayListPublica){
			PlayListPublica temp = (PlayListPublica)playList;
			temp.adicionarContribuinte(this); //adiciona criando o associativo
			temp.adicionarMusica(musica); //adiciona criando o associativo
		}else if (playList instanceof PlayListPrivada){
			if(((PlayListPrivada) playList).getDono().getId() == this.getId()){
				playList.adicionarMusica(musica);
			}
		}
		return adicionou;
	}
	

	//atribuir nota pra musica
	
	
	
	//Adiciona todas as musicas de um album em uma playlist publica 
	/*public void adicionaAlbumPlaylist(Album album,  PlayList playlist) {
		for(int i=0; i<album.getMusicas().size(); i++) {
			adicionaMusicaPlaylist(album.getMusicas().get(i),playlist);
		}
	}*/
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", idade=" + idade + ", login=" + login + ", senha=" + senha
				+ ", playlistsPublicas=" + playListsPublicas + ", playlistsPrivadas=" + playListsPrivadas + "]";
	}
}
