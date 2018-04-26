import java.util.ArrayList;

/*Classe: PlayList
 *Autora: Naomi Takemoto
 **/

public abstract class PlayList {
	
	//Atributos
	private static int geradorId = 0;
	private final int id;
	private String nome;
	private Usuario autor;
	private int quantidadeMusicas;
	private ArrayList <UsuarioPlayList> contribuintesPlayList;
	
	//Metodos construtores
	public PlayList(){
		this.id = geradorId++;
		quantidadeMusicas = 0;
		contribuintesPlayList = new ArrayList <UsuarioPlayList>();
	}
	
	public PlayList(String nome, Usuario autor){
		this();
		this.nome = nome;
		this.autor = autor;
		contribuintesPlayList = new ArrayList <UsuarioPlayList>();
	}
	
	//Getters e Setters
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
	
	public ArrayList<UsuarioPlayList> getContribuintesPlayList() {
		return contribuintesPlayList;
	}

	public void setContribuintesPlayList(ArrayList<UsuarioPlayList> contribuintesPlayList) {
		this.contribuintesPlayList = contribuintesPlayList;
	}
	
	public abstract boolean adicionarMusica(Musica musica);
	public abstract boolean removerMusica(Musica musica);
	
	@Override
	public String toString() {
		String out =  "PlayList [id=" + id + ", nome=" + nome + ", autor=" + autor
				+ ", quantidadeMusicas=" + quantidadeMusicas  + "]";
		return out;
	}
	
	
}
