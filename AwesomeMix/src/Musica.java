import java.util.ArrayList;

public class Musica{
	private int id;
	private static int qtdMusicasTotal = 0;
	private String nomeMusica;
	private double tempoDuracao;
	private double avaliacaoMusica;
	private Album album;
	private final ArrayList <MusicaPlayListPrivada> playListsPrivadas;
	private final ArrayList <MusicaPlayListPublica> playListsPublicas;
	private final ArrayList <UsuarioMusica> avaliacoesRecebidas;
	
	//Metodos Construtores
	public Musica(){
		this.playListsPrivadas = new ArrayList <MusicaPlayListPrivada>();
		this.playListsPublicas = new ArrayList <MusicaPlayListPublica>();
		this.avaliacoesRecebidas = new ArrayList <UsuarioMusica>();
	}
	
	public Musica(String nomeMusica, double tempoDuracao){
		this();
		this.id = qtdMusicasTotal++;
		this.nomeMusica = nomeMusica;
		this.tempoDuracao = tempoDuracao;
	}
	
	public Musica(String nomeMusica, double tempoDuracao, Album album){
		this();
		this.id = qtdMusicasTotal++;
		this.nomeMusica = nomeMusica;
		this.tempoDuracao = tempoDuracao;
		this.album = album;
		album.adicionarMusica(this);
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

	public void setId(int id) {
		this.id = id;
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
	
	//metodo toString
	@Override
	public String toString() {
		return "Musica [id=" + id + ", nomeMusica=" + nomeMusica + ", tempoDuracao=" + tempoDuracao + ", avaliacao="
				+ avaliacaoMusica + "]";
	}

	public ArrayList <MusicaPlayListPrivada> getPlayListsPrivadas() {
		return playListsPrivadas;
	}

	public ArrayList <MusicaPlayListPublica> getPlayListsPublicas() {
		return playListsPublicas;
	}
	
}
