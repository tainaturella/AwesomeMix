import java.util.ArrayList;

public class Musica{
	private int id;
	private int geradorId = 0;
	private static int qtdMusicasTotal;
	private String nomeMusica;
	private double tempoDuracao;
	private double avaliacaoMusica;
	private Album album;
	private ArrayList <MusicaPlayListPrivada> playListsPrivadas;
	private ArrayList <MusicaPlayListPublica> playListsPublicas;
	
	//Metodos Construtores
	public Musica(){
		this.playListsPrivadas = new ArrayList <MusicaPlayListPrivada>();
		this.playListsPublicas = new ArrayList <MusicaPlayListPublica>();
	}
	
	public Musica(String nomeMusica, double tempoDuracao, Album album){
		this();
		this.id = qtdMusicasTotal;
		this.nomeMusica = nomeMusica;
		this.tempoDuracao = tempoDuracao;
		this.album = album;
		qtdMusicasTotal++;
		album.adicionarMusica(this);
		id = geradorId++;
	}
	
	
	//Metodos Getters e Setters da classe Musica
	public static int getQtdMusicasTotal() {
		return qtdMusicasTotal;
	}

	public String getNomeMusica() {
		return nomeMusica;
	}

	public void setNomeMusica(String nomeMusica) {
		this.nomeMusica = nomeMusica;
	}

	public double getTempoDuracao() {
		return tempoDuracao;
	}

	public void setTempoDuracao(double tempoDuracao) {
		this.tempoDuracao = tempoDuracao;
	}

	
	public double getAvaliacaoMusica() {
		return avaliacaoMusica;
	}


	public void setAvaliacaoMusica(double avaliacaoMusica) {
		this.avaliacaoMusica = avaliacaoMusica;
	}


	int getId() {
		return id;
	}	
	
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	//Metodo que atribui uma nota a musica
	public void atribuirNota(double avaliacao) {
		if(this.avaliacaoMusica > 0) {
			this.avaliacaoMusica = (this.avaliacaoMusica + avaliacao)/2;
		}else {
			this.avaliacaoMusica = avaliacao;
		}
	}
	
	//metodo toString
	@Override
	public String toString() {
		return "Musica [id=" + id + ", nomeMusica=" + nomeMusica + ", tempoDuracao=" + tempoDuracao + ", avaliacao="
				+ avaliacaoMusica + "]";
	}


	public ArrayList <MusicaPlayListPrivada> getPlayListsPrivadas() {
		return playListsPrivadas;
	}


	public void setPlayListsPrivadas(ArrayList <MusicaPlayListPrivada> playListsPrivadas) {
		this.playListsPrivadas = playListsPrivadas;
	}


	public ArrayList <MusicaPlayListPublica> getPlayListsPublicas() {
		return playListsPublicas;
	}


	public void setPlayListsPublicas(ArrayList <MusicaPlayListPublica> playListsPublica) {
		this.playListsPublicas = playListsPublica;
	}
	
	
}
