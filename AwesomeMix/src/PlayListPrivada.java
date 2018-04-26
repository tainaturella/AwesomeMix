/*Classe: PlayListPublica
 *Autora: Naomi Takemoto
 *Descricao: em um estagio futuro do projeto, PlayList publica sera um conjunto de
 *musicas criadas por determinado usuario e que sera visivel somente a ele e/ou
 *no futuro aos usuarios com autorizacao para tal.
 * */

import java.util.ArrayList;

public class PlayListPrivada  extends PlayList {
	
	private ArrayList <Musica> listaMusicasPrivadas;
	
	
	public PlayListPrivada(){
		super();
		listaMusicasPrivadas = new ArrayList<Musica>();
	}
	
	public PlayListPrivada(String nome, Usuario usuario){
		super(nome, usuario);
		listaMusicasPrivadas = new ArrayList<Musica>();
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
	
	

}
