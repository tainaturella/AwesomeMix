import java.util.ArrayList;

/*Classe: PlayList
 *Autora: Naomi Takemoto
 **/

public abstract class PlayList {
	
	//Atributos
	private static int geradorId = 0;
	private int id;
	private String nome;
	private int quantidadeMusicas;
	private ArrayList <UsuarioPlayList> contribuintesPlayList;
	
	//Metodos construtores
	public PlayList(){
		this.id = geradorId++;
		quantidadeMusicas = 0;
		contribuintesPlayList = new ArrayList <UsuarioPlayList>();
	}
	
	public PlayList(String nome){
		this();
		this.nome = nome;
		contribuintesPlayList = new ArrayList <UsuarioPlayList>();
	}
	
	//Getters e Setters
	public void setId(int id) {
		this.id = id;
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
	
	public void setQuantidadeMusicas(int qtd) {
		quantidadeMusicas = qtd;
	}
	
	public int getQuantidadeMusicas() {
		return this.quantidadeMusicas;
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
		String out =  "PlayList [id=" + id + ", nome=" + nome
				+ ", quantidadeMusicas=" + quantidadeMusicas  + "]";
		return out;
	}
	
	
}
