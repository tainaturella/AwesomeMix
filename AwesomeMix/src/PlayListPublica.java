
import java.util.ArrayList;

public class PlayListPublica  extends PlayList {
	
	private static int geradorId = 0;
	private int id;
	private final ArrayList <UsuarioPlayListPublica> contribuintesPlayList;
	private final ArrayList<MusicaPlayListPublica> listaMusicas;
	
	//metodos construtores
	public PlayListPublica(){
		super();
		contribuintesPlayList = new ArrayList <UsuarioPlayListPublica>();
		listaMusicas = new ArrayList<MusicaPlayListPublica>();
	}
	
	public PlayListPublica(String nome){
		super(nome);
		geradorId++;
		id = geradorId;
		contribuintesPlayList = new ArrayList <UsuarioPlayListPublica>();
		listaMusicas = new ArrayList<MusicaPlayListPublica>();
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
	
	public ArrayList<MusicaPlayListPublica> getMusicas(){
		return listaMusicas;
	}
	
	public ArrayList<MusicaPlayListPublica> getListaMusicas(){
		return listaMusicas;
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
	
	/*Metodo: adicionarMusica
	 *Parametros: um objetdo de tipo musica 
	 *O que:adiciona uma nova musica na playlist, caso ela ja nao esteja presente*/
	public boolean adicionarMusica(Musica musica) {
		boolean adicionou = true;
		for(int i = 0; i < listaMusicas.size(); i++){
			if(listaMusicas.get(i).getMusica().getId() == musica.getId()){
				adicionou = false;
				break; //neste caso a musica ja esta playlist
			}
		}
		//Caso nao tenha achado a musica, adiciona
		if(adicionou == true){
			MusicaPlayListPublica associativo = new MusicaPlayListPublica(this, musica);
			listaMusicas.add(associativo);
			musica.getPlayListsPublicas().add(associativo);
			setQuantidadeMusicas(getQuantidadeMusicas()+1);
		}
		
		return adicionou;
	}
	
	/*Metodo: removerMusica
	 *Parametros: uma referencia para a musica que deve ser removida
	 *O que faz: percorre a lista de musicas da playList, se achar, entao deleta
	 *a musica da playList e retira a referencia para esta playlist da lista de
	 *playlists do objeto musica
	 **/
	public boolean removerMusica(Musica musica) {
		boolean removeu = false;
		for(int i = 0; i < listaMusicas.size(); i++){
			//se achou a musica na playlist
			if(listaMusicas.get(i).getMusica().getId() == musica.getId()){
				removeu = true;
				int tam = musica.getPlayListsPublicas().size();
				for(int j = 0; j < tam; j++){
					if(musica.getPlayListsPublicas().get(j).getPlayList().getId() == this.getId()){
						removeu = true;
						//retirar a playlist atual da lista de playlists de musica
						musica.getPlayListsPublicas().remove(j);
						//retira musica da playlist
						listaMusicas.remove(i);
						setQuantidadeMusicas(getQuantidadeMusicas()-1);
						break;
					}
				}
				break;
			}
		}
		return removeu;
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
