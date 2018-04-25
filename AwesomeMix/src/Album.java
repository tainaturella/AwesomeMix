import java.util.ArrayList;

public class Album {
	
	private final int id;
	private static int qtdAlbuns = 0;
	private String nomeAlbum;
	private String artista;
	private int anoLancamento;
	private static int qtdMusicas;
	private double avaliacaoAlbum;
	private EstilosMusicais estiloMusical;
	private ArrayList<Musica> musicas;
	
	//Metodo Construtor
	public Album() {
		musicas = new ArrayList<Musica>();
		this.id=qtdAlbuns;
		this.nomeAlbum=" ";
		this.artista=" ";
		this.anoLancamento=0;
		qtdMusicas=0;
		this.estiloMusical = null;
		qtdAlbuns++;
	}
	
	public Album(String nomeAlbum, String artista, int anoLancamento, EstilosMusicais estiloMusical) {
		musicas = new ArrayList<Musica>();
		this.id = qtdAlbuns;
		this.nomeAlbum = nomeAlbum;
		this.artista = artista;
		this.anoLancamento = anoLancamento;
		qtdMusicas = 0;
		this.estiloMusical = estiloMusical;
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

	public double getAvaliacaoAlbum() {
		return avaliacaoAlbum;
	}

	public int getId() {
		return id;
	}
	
	public EstilosMusicais getEstiloMusical() {
		return estiloMusical;
	}

	public void setEstiloMusical(EstilosMusicais estiloMusical) {
		this.estiloMusical = estiloMusical;
	}

	public ArrayList<Musica> getMusicas() {
		return musicas;
	}
	
	public boolean adicionarMusica(Musica musica) {
		if(musicas.contains(musica)) {
			return false;
		}else {
			musicas.add(musica);
			qtdMusicas++;
			musica.atribuirNota(avaliacaoAlbum);
			return true;
		}
	}

	public void atribuirNota(double avaliacao) {	
		if(this.avaliacaoAlbum > 0) {
			this.avaliacaoAlbum = (this.avaliacaoAlbum + avaliacao)/2;
		}else {
			this.avaliacaoAlbum = avaliacao;
		}
		for(int i=0; i<musicas.size(); i++) {
			musicas.get(i).atribuirNota(avaliacao);
		}
	}
	
	@Override
	public String toString() {
		return "Album [id=" + id + ", nomeAlbum=" + nomeAlbum + ", artista=" + artista + ", anoLancamento="
				+ anoLancamento + ", estiloMusical=" + estiloMusical + ", musicas=" + musicas + "]";
	}
}
