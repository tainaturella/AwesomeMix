/*Descricao: classe associativa entre Musica e PlayListPrivada*/

public class MusicaPlayListPrivada {
	private Musica musica;
	private PlayListPrivada playList;
	private static int geradorId = (int) (Math.random()*2147483647);
	private int id;
	
	//construtores
	public MusicaPlayListPrivada(){
		musica = null;
		playList = null;
		
	}
	public MusicaPlayListPrivada(PlayListPrivada playlist){
		this.playList = playlist;
		id = ++geradorId;
	}
	
	public MusicaPlayListPrivada(PlayListPrivada playList, Musica musica){
		this.playList = playList;
		this.musica = musica;
		id = ++geradorId;
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
	public void setPlayList(PlayListPrivada novaPlay) {
		this.playList = novaPlay;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
