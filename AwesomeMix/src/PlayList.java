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
	
	/*Metodo: adicionarContribuinte
	 *Parametros:o usuario que deve ser adicionado na lista contribuintes da PlayList
	 *O que faz: cria um objeto da classe associativa UsuarioPlayList e adiciona o objeto
	 *do tipo Playlist aa lista de PlayLists do usuario contribuinte e adiciona o usuario
	 *na lista de contribuintes do objeto de tipo PlayList.
	 *Retorno: true se adicionou o objeto com sucesso */
	public boolean adicionarContribuinte(Usuario usuario) {
		boolean adicionou = false;
		if(contribuintesPlayList.contains(usuario) == false) {
			UsuarioPlayList associativo = new UsuarioPlayList(usuario,this);
			contribuintesPlayList.add(associativo);
			usuario.getPlayLists().add(associativo);
			adicionou = true;
		}
		return adicionou;
	}
	
	/*Metodo: removerContribuinte
	 *Parametros: o usuario 
	 *O que faz: remove um usuario da lista de contribuintes de uma playLis
	 *e retira a playList da lista de playLists do usuario
	 *Saida: true se achou e romoveu com sucesso o usuario da playList, false caso
	 *contrario.*/
	public boolean removerContribuinte(Usuario usuario){
		boolean removeu = false;
		//remove a playList da lista de playLists do usuario
		for(int i = 0; i < usuario.getPlayLists().size(); i++){
			if(usuario.getPlayLists().get(i).getPlayList() == this){
				usuario.getPlayLists().remove(i);
			}
		}
		//remove o usuario da lista de contribuintes de uma playList
		for(int i = 0; i < contribuintesPlayList.size(); i++){
			/*se achou o usuario na lista de contribuintes*/
			if(contribuintesPlayList.get(i).getUsuario() == usuario){
				contribuintesPlayList.remove(i);
			}
		}
		return removeu;
	}
	
	@Override
	public String toString() {
		String out =  "PlayList [id=" + id + ", nome=" + nome + ", autor=" + autor
				+ ", quantidadeMusicas=" + quantidadeMusicas  + "]";
		return out;
	}
	
}
