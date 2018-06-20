/*Classe: PlayListPublica
 *Autora: Naomi Takemoto
 *Descricao: em um estagio futuro do projeto, PlayList publica sera um conjunto de
 *musicas criadas por determinado usuario e que sera visivel a todos demais.
 * */
import java.util.ArrayList;

public class PlayListPublica  extends PlayList {
	private static int geradorId = 0;
	private int id;
	private ArrayList <UsuarioPlayList> contribuintesPlayList;
	
	//metodos construtores
	public PlayListPublica(){
		super();
		contribuintesPlayList = new ArrayList <UsuarioPlayList>();
	}
	
	public PlayListPublica(String nome){
		super(nome);
		id = geradorId++;
		contribuintesPlayList = new ArrayList <UsuarioPlayList>();
	}
	
	//getters e setters
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}

	@Override 
	public String toString() {
		int i;
		String out = "";
		out += "PlayListPublica [ Nome= " + super.getNome() + " Id= " + id + "]";
		out += "\nLista de contribuintes da playList[ ";
		for(i = 0; i < contribuintesPlayList.size(); i++){
			out += contribuintesPlayList.get(i).getUsuario().getNome() + ", ";
		}
		out += "]";
		return out;
	}

	/*Metodo: adicionarContribuinte
	 *Parametros:o usuario que deve ser adicionado na lista contribuintes da PlayList
	 *O que faz: cria um objeto da classe associativa UsuarioPlayList e adiciona o objeto
	 *do tipo Playlist aa lista de PlayLists do usuario contribuinte e adiciona o usuario
	 *na lista de contribuintes do objeto de tipo PlayList.
	 *Retorno: true se adicionou o objeto com sucesso */
	public boolean adicionarContribuinte(Usuario usuario) {
		boolean adicionou = true;
		
		/*se o usuario ja estiver na lista de contribuintes*/
		for (int i = 0; i < contribuintesPlayList.size(); i++){
			if(contribuintesPlayList.get(i).getUsuario() == usuario){
				adicionou = false;
			}
		}
		if(adicionou == true) {
			UsuarioPlayList associativo = new UsuarioPlayList(usuario,this);
			contribuintesPlayList.add(associativo);
			usuario.getPlaylistsPublicas().add(associativo);
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
		for(int i = 0; i < usuario.getPlaylistsPublicas().size(); i++){
			if(usuario.getPlaylistsPublicas().get(i).getPlayList() == this){
				usuario.getPlaylistsPublicas().remove(i);
				removeu = true;
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
	
}
