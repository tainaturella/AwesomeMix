/*Classe PlayListPrivada
 *Descricao: uma playlist privada possui um dono que eh o unico usuario que pode ve-la
 *e  modifica-la.
 **/

import java.util.ArrayList;
public class PlayListPrivada extends PlayList {
	
	//atributos e variaveis de classe.
	private static int geradorId = 0;
	private int id;
	private Usuario dono;
	private ArrayList<MusicaPlayListPrivada> listaMusicas;
	
	//Construtores
	public PlayListPrivada(){
		super();
	}
	
	public PlayListPrivada(String nome, Usuario dono){
		super(nome);
		this.dono = dono;
		id = geradorId++;
	}
	
	//Getters e Setters
	public Usuario getDono() {
		return dono;
	}

	public void setDono(Usuario dono) {
		this.dono = dono;
	}
	
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public ArrayList<MusicaPlayListPrivada> getListaMusicas(){
		return listaMusicas;
	}

	public void setListaMusicas(ArrayList<MusicaPlayListPrivada> listaMusicas){
		this.listaMusicas = listaMusicas;
	}
	
	@Override
	public String toString() {
		String out = "";
		out += "PlayListPrivada [ Nome= " + super.getNome() + " Id= " +id + "]";
		return out;
	}
	
	/*Metodo: adicionarMusica
	 *Parametros: um objetdo de tipo musica 
	 *O que:adiciona uma nova musica na playlist, caso ela ja nao esteja presente*/
	public boolean adicionarMusica(Musica musica) {
		boolean adicionou = true;
		for(int i = 0; i < listaMusicas.size(); i++){
			if(listaMusicas.get(i).getMusica() == musica){
				adicionou = false;
				break; //neste caso a musica ja esta playlist
			}
		}
		//Caso nao tenha achado a musica, adiciona
		if(adicionou == true){
			MusicaPlayListPrivada associativo = new MusicaPlayListPrivada(this, musica);
			listaMusicas.add(associativo);
			musica.getPlayListsPrivadas().add(associativo);
		}
		
		return adicionou;
	}
	
	/*Metodo: removerMusica
	 *Parametros: uma referencia para a musica que deve ser removida
	 *O que faz: percorre a lista de musicas da playList, se achar, entao deleta
	 *a musica da playList e retira a referencia de para esta playlist da lista de
	 *playlists do objeto musica
	 **/
	public boolean removerMusica(Musica musica) {
		boolean removeu = false;
		for(int i = 0; i < listaMusicas.size(); i++){
			//se achou a musica na playlist
			if(listaMusicas.get(i).getMusica() == musica){
				removeu = true;
				int tam = musica.getPlayListsPrivadas().size();
				for(int j = 0; j < tam; j++){
					if(musica.getPlayListsPrivadas().get(j).getPlaylist() == this){
						//retirar a playlist atual da lista de playlists de musica
						musica.getPlayListsPrivadas().remove(j);
						//retira musica da playlist
						listaMusicas.remove(i);
						break;
					}
				}
				
			}
		}
		return removeu;
	}
}
