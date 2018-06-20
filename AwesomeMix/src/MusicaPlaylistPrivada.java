/*Descricao: classe associativa entre Musica e PlayListPrivada*/

public class MusicaPlaylistPrivada {
	private Musica musica;
	private PlayListPrivada playlist;
	private static int geradorId = 0;
	private int id;
	
	//construtores
	public MusicaPlaylistPrivada(){
		musica = null;
		playlist = null;
		
	}
	public MusicaPlaylistPrivada(PlayListPrivada playlist){
		this.playlist = playlist;
		id = geradorId++;
	}
	public MusicaPlaylistPrivada(PlayListPrivada playlist, Musica musica){
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
	public PlayListPrivada getPlaylist() {
		return playlist;
	}
	public void setPlaylist(PlayListPrivada playlist) {
		this.playlist = playlist;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
