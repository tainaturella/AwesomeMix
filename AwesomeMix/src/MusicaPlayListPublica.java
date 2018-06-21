/*Descricao: classe associativa entre PlayListPublica e Musica*/

public class MusicaPlayListPublica {
	
	//atributos
	private Musica musica;
	private final PlayListPublica playlist;
	private static int geradorId = 0;
	private int id;
	
	//construtores
	public  MusicaPlayListPublica(){
		musica = null;
		playlist = null;
		
	}
	public  MusicaPlayListPublica(PlayListPublica playlist){
		this.playlist = playlist;
		id = geradorId++;
	}
	public  MusicaPlayListPublica(PlayListPublica playlist, Musica musica){
		this(playlist);
		this.musica = musica;
		id = geradorId++;
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
