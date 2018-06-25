import java.util.ArrayList;

public class Album {
	
	private int id;
	private static int qtdAlbuns = 0;
	private String nomeAlbum;
	private String artista;
	private int anoLancamento;
	private int qtdMusicas;
	private EstilosMusicais estiloMusical;
	private final ArrayList<Musica> musicas;
	
	//Metodo Construtor
	public Album() {
		musicas = new ArrayList<Musica>();
		this.nomeAlbum=" ";
		this.artista=" ";
		this.anoLancamento=0;
		qtdMusicas=0;
		this.estiloMusical = null;
		this.id = 0;
	}
	
	public Album(String nomeAlbum, String artista, int anoLancamento, EstilosMusicais estiloMusical) {
		musicas = new ArrayList<Musica>();
		id = ++qtdAlbuns;
		this.nomeAlbum = nomeAlbum;
		this.artista = artista;
		this.anoLancamento = anoLancamento;
		qtdMusicas = 0;
		this.estiloMusical = estiloMusical;
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

	public void setQtdMusicas(int qtdMusicas) {
		this.qtdMusicas = qtdMusicas;
	}
	
	public int getQtdMusicas() {
		return qtdMusicas;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public double getAvaliacao(){
		double avaliacao = 0;
		for (int i = 0; i < musicas.size(); i++){
			avaliacao += musicas.get(i).getAvaliacaoMusica();
		}
		if(musicas.size() != 0) avaliacao = avaliacao/musicas.size();
		return (avaliacao);
	}
	
	public boolean adicionarMusica(Musica musica) {
		if(musicas.contains(musica)) {
			return false;
		}else {
			musicas.add(musica);
			qtdMusicas++;
			return true;
		}
	}
	
	public boolean removerMusica(Musica musica) {
		if(musicas.contains(musica)) {
			return false;
		}else {
			for(int i = 0; i < musicas.size(); i++) {
				if(musicas.get(i).getId() == musica.getId()) {
					musicas.remove(i);
					break;
				}
			}
			qtdMusicas--;
			return true;
		}
	}
	
	@Override
	public String toString() {
		return "Album [id=" + id + ", nomeAlbum=" + nomeAlbum + ", artista=" + artista + ", anoLancamento="
				+ anoLancamento + ", estiloMusical=" + estiloMusical + ",quantidadeMusicas=" + qtdMusicas + ", musicas=" + musicas + "]";
	}
}
