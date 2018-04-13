import java.util.ArrayList;

public class PlayList {
	private static int geradorId = 0;
	private final int id;
	private String nome;
	private Usuario autor;
	private ArrayList <Musica> musicas;
	public PlayList(){
		this.id = geradorId++;
	}
	private int quantidadeMusicas;
	private double duracao;

	public PlayList(String nome, Usuario autor){
		this();
		this.nome = nome;
		this.autor = autor;
	}
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	//Fazer toString
	public boolean adicionarMusica(Musica musica){
		boolean adiciona;
		adiciona = musicas.contains(musica);
		if(adiciona == true){
			adiciona = musicas.add(musica);
		}
		return adiciona;
	}

	@Override
	public String toString() {
		String out =  "PlayList [id=" + id + ", nome=" + nome + ", autor=" + autor
				+ ", quantidadeMusicas=" + quantidadeMusicas +  ", duracao=" + duracao;
		out += ", musicas=[ ";
		if(musicas != null){
			for(int i = 0; i < musicas.size(); i++){
				out += musicas.get(i);
			}
		}
		out +=  "]]";
		return out;
	}
	
}
