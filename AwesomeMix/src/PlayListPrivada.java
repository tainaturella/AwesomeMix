/*Classe: PlayListPublica
 *Autora: Naomi Takemoto
 *Descricao: em um estagio futuro do projeto, PlayList publica sera um conjunto de
 *musicas criadas por determinado usuario e que sera visivel somente a ele e/ou
 *no futuro aos usuarios com autorizacao para tal.
 * */

import java.util.ArrayList;

public class PlayListPrivada  extends PlayList {
	
	//Atibutos
	private ArrayList <Musica> listaMusicasPrivadas;
	
	//Construtores
	public PlayListPrivada(){
		super();
		listaMusicasPrivadas = new ArrayList<Musica>();
	}
	
	public PlayListPrivada(String nome, Usuario usuario){
		super(nome, usuario);
		listaMusicasPrivadas = new ArrayList<Musica>();
		this.adicionarContribuinte(usuario);
	}
	
	//Getters e Setters
	public ArrayList<Musica> getListaMusicasPrivadas() {
		return listaMusicasPrivadas;
	}

	public void setListaMusicasPrivadas(ArrayList<Musica> listaMusicasPrivadas) {
		this.listaMusicasPrivadas = listaMusicasPrivadas;
	}

	

	@Override
	public String toString() {
		int i;
		String out = "";
		out += "PlayListPrivada [ Nome= " + super.getNome() + " Id= " + super.getId() + " Autor= " + super.getAutor().getNome() +"]";
		out += "\nLista de Musicas da PlayListPrivada [";
		if(listaMusicasPrivadas.size() == 1) {
			out += listaMusicasPrivadas.get(0).getNomeMusica() + "]";
		}
		else {
			for(i = 0; i < listaMusicasPrivadas.size(); i++) {
				out += listaMusicasPrivadas.get(i).getNomeMusica() + ", ";
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
		if (listaMusicasPrivadas.contains(musica) == false) {
			listaMusicasPrivadas.add(musica);
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
		removeu = listaMusicasPrivadas.remove(musica);
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
			usuario.getPlaylistsPrivadas().add(associativo);
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
		for(int i = 0; i < usuario.getPlaylistsPrivadas().size(); i++){
			if(usuario.getPlaylistsPrivadas().get(i).getPlayList() == this){
				usuario.getPlaylistsPrivadas().remove(i);
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
