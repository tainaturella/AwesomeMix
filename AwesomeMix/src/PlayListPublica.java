/*Classe: PlayListPublica
 *Autora: Naomi Takemoto
 *Descricao: em um estagio futuro do projeto, PlayList publica sera um conjunto de
 *musicas criadas por determinado usuario e que sera visivel a todos demais.
 * */
import java.util.ArrayList;

public class PlayListPublica  extends PlayList {
	
	private ArrayList <Musica> listaMusicasPublicas;
	
	//metodos construtores
	public PlayListPublica(){
		super();
		listaMusicasPublicas = new ArrayList<Musica>();
	}
	public PlayListPublica(String nome, Usuario usuario){
		super(nome, usuario);
		listaMusicasPublicas = new ArrayList<Musica>();
	}

	@Override 
	public String toString() {
		int i;
		String out = "";
		out += "PlayListPublica [ Nome= " + super.getNome() + " Id= " + super.getId() + " Autor= " + super.getAutor().getNome() +"]";
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
	
}
