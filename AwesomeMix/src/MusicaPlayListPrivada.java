/*Descricao: classe associativa entre Musica e PlayListPrivada*/

public class MusicaPlayListPrivada {
	private Musica musica;
	private final PlayListPrivada playList;
	private static int geradorId = 0;
	private int id;
	
	//construtores
	public MusicaPlayListPrivada(){
		musica = null;
		playList = null;
		
	}
	public MusicaPlayListPrivada(PlayListPrivada playlist){
		this.playList = playlist;
		id = geradorId++;
	}
	public MusicaPlayListPrivada(PlayListPrivada playList, Musica musica){
		this(playList);
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
	public PlayListPrivada getPlayList() {
		return playList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
