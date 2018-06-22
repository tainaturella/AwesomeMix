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
		id = ++qtdUsuarios;
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
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", idade=" + idade + ", login=" + login + ", senha=" + senha
				+ ", playlistsPublicas=" + playListsPublicas + ", playlistsPrivadas=" + playListsPrivadas + "]";
	}
	
	//************ CRIACAO DE PLAYLISTS ***********
	
	//Cria playlist publica
	public PlayListPublica criaPlayListPublica(String nome) {
		//verifica se ja existe uma playlist com o mesmo nome
		for(int i=0; i<playListsPublicas.size(); i++) {
			if(playListsPublicas.get(i).getPlayListPublica().getNome().equals(nome)) {
				return null;
			}
		}
		PlayListPublica novaPlayListPublica = new PlayListPublica(nome); //cria playlist publica
		UsuarioPlayListPublica novaPlayListAssociativa = new UsuarioPlayListPublica(this, novaPlayListPublica);//Cria um objeto associando playlist e usuario
		playListsPublicas.add(novaPlayListAssociativa); //Adciona a playList criada a lista de playLists desse usuario.
		return novaPlayListPublica;
	}
	
	//Cria playlist privada
	public PlayListPrivada criaPlayListPrivada(String nome) {
		for(int i=0; i<playListsPrivadas.size(); i++) {
			if(playListsPrivadas.get(i).getNome().equals(nome)) {
				return null;
			}
		}
		PlayListPrivada novaPlayListPrivada = new PlayListPrivada(nome, this); //adiciona este usuario como dono da novaPlaylist
		playListsPrivadas.add(novaPlayListPrivada); //Adciona a playList criada a lista de playLists do usuario.
		return novaPlayListPrivada;
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
	
	/*Método: adicionaAlbumPlaylist
	 *O que faz: Adiciona todas as musicas de um album em uma playlist
	 *Parametros: o album que deve ser copiado e a playList para a qual este ultimo
	 *deve ser copiado
	 *Retorno: true se todas as musicas foram adicionadas, false se pelo menos uma nao foi*/
	public boolean adicionaAlbumPlaylist(Album album,  PlayList playlist) {
		boolean adicionou =true;
		for(int i=0; i<album.getMusicas().size(); i++) {
			adicionou = adicionaMusicaPlayList(album.getMusicas().get(i),playlist);
		}
		return adicionou;
	}
	
	
	
	
	/*Metodo Avaliar Musica
	 *Parametros: uma musica que este usuario (this) deve avaliar e a nota que ele quer atribuir
	 *O que faz: percorre a lista de musicas avaliadas pelo usuario, se a musica ja tiver sido
	 *avaliada por ele anteriormente apenas modifica a nota, caso constrario cria o
	 *associativo.
	 *Retorno: void
	 **/
	public void avaliaMusica(Musica musica, double avaliacao){
		boolean jaAvaliou = false;
		for(int i = 0; i < musicasAvaliadas.size(); i++){
			//caso a musica ja tier sido avaliada pelo usuario anteriormente
			if(musicasAvaliadas.get(i).getMusica().getId() == musica.getId()){
				musicasAvaliadas.get(i).setAvaliacao(avaliacao);
				jaAvaliou = true;
				break;
			}
		}
		//caso nunca tenha avaliado a musica, cria um associativo
		if(jaAvaliou == false){
			UsuarioMusica associativo = new UsuarioMusica(this, musica);
			associativo.setAvaliacao(avaliacao);
			musicasAvaliadas.add(associativo);
			musica.getAvaliacoesRecebidas().add(associativo);
		}
	}
}
