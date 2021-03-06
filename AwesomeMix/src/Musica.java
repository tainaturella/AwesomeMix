import java.util.ArrayList;

public class Musica{
	private int id;
	private static int qtdMusicasTotal = (int) (Math.random()*2147483647);
	private String nomeMusica;
	private double tempoDuracao;
	private Album album;
	private final ArrayList <MusicaPlayListPrivada> playListsPrivadas;
	private final ArrayList <MusicaPlayListPublica> playListsPublicas;
	private final ArrayList <UsuarioMusica> avaliacoesRecebidas;
	private double avaliacaoMusica;
	
	//Metodos Construtores
	public Musica(){
		this.playListsPrivadas = new ArrayList <MusicaPlayListPrivada>();
		this.playListsPublicas = new ArrayList <MusicaPlayListPublica>();
		this.avaliacoesRecebidas = new ArrayList <UsuarioMusica>();
	}
	
	public Musica(String nomeMusica, double tempoDuracao){
		this();
		this.id = ++qtdMusicasTotal;
		this.nomeMusica = nomeMusica;
		this.tempoDuracao = tempoDuracao;
	}
	
	public Musica(String nomeMusica, double tempoDuracao, Album album){
		this();
		this.id = ++qtdMusicasTotal;
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
		double avaliacaoMusica = 0;
		int tam = avaliacoesRecebidas.size();
		if(tam == 0){
			return 0;
		}
		for(int i = 0; i < tam; i++){
			avaliacaoMusica += avaliacoesRecebidas.get(i).getAvaliacao();
		}
		avaliacaoMusica = avaliacaoMusica/tam;
		this.avaliacaoMusica = avaliacaoMusica;
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
	
	public ArrayList <MusicaPlayListPrivada> getPlayListsPrivadas() {
		return playListsPrivadas;
	}

	public ArrayList <MusicaPlayListPublica> getPlayListsPublicas() {
		return playListsPublicas;
	}

	public ArrayList <UsuarioMusica> getAvaliacoesRecebidas() {
		
		return avaliacoesRecebidas;
	}
	
	
	//metodo toString
	@Override
	public String toString() {
		return "Musica [id=" + id + ", nomeMusica=" + nomeMusica + ", tempoDuracao=" + tempoDuracao + ", avaliacao="
				+ getAvaliacaoMusica() + "]";
	}

	
	
}
