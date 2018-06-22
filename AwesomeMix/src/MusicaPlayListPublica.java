/*Descricao: classe associativa entre PlayListPublica e Musica*/

public class MusicaPlayListPublica {
	
	//atributos
	private Musica musica;
	private PlayListPublica playList;
	private static int geradorId = 0;
	private int id;
	
	//construtores
	public  MusicaPlayListPublica(){
		musica = null;
		playList = null;
		
	}
	public  MusicaPlayListPublica(PlayListPublica playList){
		this.playList = playList;
		id = ++geradorId;
	}
	public  MusicaPlayListPublica(PlayListPublica playList, Musica musica){
		this(playList);
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
	public PlayListPublica getPlayList() {
		return playList;
	}
	public void setPlayList(PlayListPublica publica) {
		this.playList = publica;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
