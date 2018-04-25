
public class Musica extends Album{
	private final int id;
	private static int qtdMusicasTotal;
	private String nomeMusica;
	private double tempoDuracao;
	private double avaliacao;
	
	//Metodo Construtor
	//Recebe alem dos atributos da musica os atributos para criacao do album
	public Musica(String nomeAlbum, String artista, int anoLancamento, double avaliacaoAlbum, String nomeMusica, double tempoDuracao, double avaliacaoMusica){
		super(nomeAlbum, artista, anoLancamento, avaliacaoAlbum);
		this.id = qtdMusicasTotal;
		this.nomeMusica = nomeMusica;
		this.tempoDuracao = tempoDuracao;
		this.avaliacao = avaliacaoMusica;
		qtdMusicasTotal++;
	}
	
	//O album ja existe e so precisamos criar a musica que pertence ao album
	public Musica(String nomeMusica, double tempoDuracao, double avaliacaoMusica){
		super();
		this.id = qtdMusicasTotal;
		this.nomeMusica = nomeMusica;
		this.tempoDuracao = tempoDuracao;
		this.avaliacao = avaliacaoMusica;
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

	public double getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(double avaliacao) {
		this.avaliacao = avaliacao;
	}

	public int getId() {
		return id;
	}	
	
	public void atribuirNota(double avaliacao) {
		this.avaliacao = (this.avaliacao + avaliacao)/2;
	}

	@Override
	public String toString() {
		return "Musica [id=" + id + ", nomeMusica=" + nomeMusica + ", tempoDuracao=" + tempoDuracao + ", avaliacao="
				+ avaliacao + "]";
	}
	
	
}
