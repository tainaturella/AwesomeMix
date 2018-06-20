/*Descricao: classe associativa entre Musica e PlayListPrivada*/

public class MusicaPlayListPrivada {
	private Musica musica;
	private PlayListPrivada playlist;
	private static int geradorId = 0;
	private int id;
	
	
	//construtores
	public MusicaPlayListPrivada(){
		musica = null;
		playlist = null;
		
	}
	public MusicaPlayListPrivada(PlayListPrivada playlist){
		this.playlist = playlist;
		id = geradorId++;
	}
	public MusicaPlayListPrivada(PlayListPrivada playlist, Musica musica){
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
