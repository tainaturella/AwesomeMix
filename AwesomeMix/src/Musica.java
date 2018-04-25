
public class Musica{
	private final int id;
	private static int qtdMusicasTotal;
	private String nomeMusica;
	private double tempoDuracao;
	private static double avaliacaoMusica;
	private Album album;
	
	//Metodo Construtor
	//O album ja existe e so precisamos criar a musica que pertence ao album
	public Musica(String nomeMusica, double tempoDuracao, Album album){
		this.id = qtdMusicasTotal;
		this.nomeMusica = nomeMusica;
		this.tempoDuracao = tempoDuracao;
		this.album = album;
		qtdMusicasTotal++;
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

	public static double getAvaliacao() {
		return avaliacaoMusica;
	}

	public int getId() {
		return id;
	}	
	
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public void atribuirNota(double avaliacao) {
		avaliacaoMusica = (avaliacaoMusica + avaliacao)/2;
	}
	
	

	@Override
	public String toString() {
		return "Musica [id=" + id + ", nomeMusica=" + nomeMusica + ", tempoDuracao=" + tempoDuracao + ", avaliacao="
				+ avaliacaoMusica + "]";
	}
	
	
}
