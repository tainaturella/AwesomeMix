/*Classe: PlayListPublica
 *Autora: Naomi Takemoto
 *Descricao: em um estagio futuro do projeto, PlayList publica sera um conjunto de
 *musicas criadas por determinado usuario e que sera visivel a todos demais.
 * */
import java.util.ArrayList;

public class PlayListPublica  extends PlayList {
	
	private static int geradorId = 0;
	private int id;
	private final ArrayList <UsuarioPlayListPublica> contribuintesPlayList;
	
	//metodos construtores
	public PlayListPublica(){
		super();
		contribuintesPlayList = new ArrayList <UsuarioPlayListPublica>();
	}
	
	public PlayListPublica(String nome){
		super(nome);
		id = geradorId++;
		contribuintesPlayList = new ArrayList <UsuarioPlayListPublica>();
	}
	
	//getters e setters
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public ArrayList<UsuarioPlayListPublica> getContribuintesPlayList() {
		return contribuintesPlayList;
	}

	/*Metodo: adicionarContribuinte
	 *Parametros:o usuario que deve ser adicionado na lista contribuintes da PlayList
	 *O que faz: cria um objeto da classe associativa UsuarioPlayList e adiciona o objeto
	 *do tipo Playlist a lista de PlayLists do usuario contribuinte e adiciona o usuario
	 *na lista de contribuintes do objeto de tipo PlayList.
	 *Retorno: true se adicionou o objeto com sucesso */
	public boolean adicionarContribuinte(Usuario usuario) {
		boolean adicionou = true;
		
		/*se o usuario ja estiver na lista de contribuintes*/
		for (int i = 0; i < contribuintesPlayList.size(); i++){
			if(contribuintesPlayList.get(i).getUsuario().getId() == usuario.getId()){
				adicionou = false;
			}
		}
		if(adicionou == true) {
			UsuarioPlayListPublica associativo = new UsuarioPlayListPublica(usuario,this);
			contribuintesPlayList.add(associativo);
			usuario.getPlayListsPublicas().add(associativo);
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
		
		//remove o usuario da lista de contribuintes da playList
		for(int i = 0; i < contribuintesPlayList.size(); i++){
			/*se achou o usuario na lista de contribuintes*/
			if(contribuintesPlayList.get(i).getUsuario().getId() == usuario.getId()){
				contribuintesPlayList.remove(i);
			}
		}
		//remove a playList da lista de playLists do usuario
		for(int i = 0; i < usuario.getPlayListsPublicas().size(); i++){
			if(usuario.getPlayListsPublicas().get(i).getPlayListPublica().getId() == this.getId()){
				usuario.getPlayListsPublicas().remove(i);
				removeu = true;
			}
		}
		return removeu;
	}
	
	//falta implementar
	public boolean adicionarMusica() {
		return false;
	}
	
	public boolean removerMusica() {
		return false;
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
}
