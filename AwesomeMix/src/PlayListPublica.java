/*Classe: PlayListPublica
 *Autora: Naomi Takemoto
 *Descricao: em um estagio futuro do projeto, PlayList publica sera um conjunto de
 *musicas criadas por determinado usuario e que sera visivel a todos demais.
 * */
import java.util.ArrayList;

public class PlayListPublica  extends PlayList {
	
	private ArrayList<Musica> listaMusicasPublicas;
	
	//metodos construtores
	public PlayListPublica(){
		super();
		listaMusicasPublicas = new ArrayList<Musica>();
	}
	public PlayListPublica(String nome){
		super(nome);
		listaMusicasPublicas = new ArrayList<Musica>();
	}

	@Override 
	public String toString() {
		int i;
		String out = "";
		out += "PlayListPublica [ Nome= " + super.getNome() + " Id= " + super.getId() + "]";
		out += "\nLista de Musicas da PlayListPublica [";
		if(listaMusicasPublicas.size() == 1) {
			out += listaMusicasPublicas.get(0).getNomeMusica() + "]";
		}
		else {
			for(i = 0; i < listaMusicasPublicas.size(); i++) {
				out += listaMusicasPublicas.get(i).getNomeMusica() + ", ";
			}
			out += " ]";
		}
		out += "\nLista de contribuintes da playList[ ";
		for(i = 0; i < super.getContribuintesPlayList().size(); i++){
			out += super.getContribuintesPlayList().get(i).getUsuario().getNome() + ", ";
		}
		out += "]";
		return out;
	}
	
	/*Metodo: adicionarMusica
	 *Parametros: a musica que devera ser adicionada
	 *O que faz: se a musica nao estiver na playlist, adiciona, caso contrario nao
	 *Retorno: true se adicionou com sucesso, false caso contrario.
	 * */
	public boolean adicionarMusica(Musica musica) {
		boolean adicionou = false;
		if (listaMusicasPublicas.contains(musica) == false) {
			listaMusicasPublicas.add(musica);
			adicionou = true;
		}
		return adicionou;
	}
	
	/*Metodo: removerMusica
	 *Parametros: a musica (objeto de tipo Musica) que devera ser removida
	 *O que faz: se a musica nao estiver na playlist, remove, caso contrario nao
	 *Retorno: true se removeu com sucesso, false caso contrario.
	 * */
	public boolean removerMusica(Musica musica) {
		boolean removeu = false;
		removeu = listaMusicasPublicas.remove(musica);
		return removeu;
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
		for (int i = 0; i < getContribuintesPlayList().size(); i++){
			if(getContribuintesPlayList().get(i).getUsuario() == usuario){
				adicionou = false;
			}
		}
		if(adicionou == true) {
			UsuarioPlayList associativo = new UsuarioPlayList(usuario,this);
			getContribuintesPlayList().add(associativo);
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
		for(int i = 0; i < getContribuintesPlayList().size(); i++){
			/*se achou o usuario na lista de contribuintes*/
			if(getContribuintesPlayList().get(i).getUsuario() == usuario){
				getContribuintesPlayList().remove(i);
			}
		}
		return removeu;
	}
	
}
