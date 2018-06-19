/*Descricao: classe associativa para relacao de muitos para muitos entre
 *playlists e musicas*/
public class PlayListMusica {
	private Musica musica;
	private PlayList playlist;
	private static int geradorId = 0;
	private int id;
	
	//construtores
	public PlayListMusica(){
		musica = null;
		playlist = null;
	}
	public PlayListMusica(PlayList playlist){
		this.playlist = playlist;
		id = geradorId++;
	}
	public PlayListMusica(PlayList playlist, Musica musica){
		this(playlist);
		this.musica = musica;
	}
	
	//getters e setters
	public Musica getMusica() {
		return musica;
	}
	public void setMusica(Musica musica) {
		this.musica = musica;
	}
	public PlayList getPlaylist() {
		return playlist;
	}
	public void setPlaylist(PlayList playlist) {
		this.playlist = playlist;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
