
public class Musica extends Album{
	private final int id;
	private static int qtdMusicasTotal;
	private String nomeMusica;
	private double tempoDuracao;
	private double avaliacao;
	private EstiloMusical estiloMusical;
	
	//Metodo Construtor
	public Musica(){
		super();
		this.id=qtdMusicasTotal;
		this.nomeMusica=" ";
		this.tempoDuracao=0.0;
		this.avaliacao=0.0;
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
	public EstiloMusical getEstiloMusical() {
		return estiloMusical;
	}
	public void setEstiloMusical(EstiloMusical estiloMusical) {
		this.estiloMusical = estiloMusical;
	}	
	
}
