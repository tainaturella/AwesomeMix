
public class Album {
	private final int id;
	private static int qtdAlbuns=0;
	private String nomeAlbum;
	private String artista;
	private int anoLancamento;
	private int qtdMusicas;
	private double avaliacaoAlmbum;
	
	//Metodo Construtor
	public Album() {
		this.id=qtdAlbuns;
		this.nomeAlbum=" ";
		this.artista=" ";
		this.anoLancamento=0;
		this.qtdMusicas=0;
		this.avaliacaoAlmbum=0.0;
		qtdAlbuns++;
	}

	//Metodos Getters e Setters da classe Album
	public static int getQtdAlbuns() {
		return qtdAlbuns;
	}

	public static void setQtdAlbuns(int qtdAlbuns) {
		Album.qtdAlbuns = qtdAlbuns;
	}

	public String getNomeAlbum() {
		return nomeAlbum;
	}

	public void setNomeAlbum(String nomeAlbum) {
		this.nomeAlbum = nomeAlbum;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public int getQtdMusicas() {
		return qtdMusicas;
	}

	public void setQtdMusicas(int qtdMusicas) {
		this.qtdMusicas = qtdMusicas;
	}

	public double getAvaliacaoAlmbum() {
		return avaliacaoAlmbum;
	}

	public void setAvaliacaoAlmbum(double avaliacaoAlmbum) {
		this.avaliacaoAlmbum = avaliacaoAlmbum;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", nomeAlbum=" + nomeAlbum + ", artista=" + artista + ", anoLancamento="
				+ anoLancamento + ", qtdMusicas=" + qtdMusicas + ", avaliacaoAlmbum=" + avaliacaoAlmbum + "]";
	}
	
	
}
