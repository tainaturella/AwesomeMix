/*Descricao: classe associativa entre PlayListPublica e Musica*/

public class MusicaplaylistsPublica {
	
	//atributos
	private Musica musica;
	private PlayListPublica playlist;
	private static int geradorId = 0;
	private int id;
	
	//construtores
	public  MusicaplaylistsPublica(){
		musica = null;
		playlist = null;
		
	}
	public  MusicaplaylistsPublica(PlayListPublica playlist){
		this.playlist = playlist;
		id = geradorId++;
	}
	public  MusicaplaylistsPublica(PlayListPublica playlist, Musica musica){
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
	public PlayListPublica getPlaylist() {
		return playlist;
	}
	public void setPlaylist(PlayListPublica playlist) {
		this.playlist = playlist;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
