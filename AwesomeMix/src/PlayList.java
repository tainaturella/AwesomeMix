import java.util.ArrayList;

/*Classe: PlayList
 *Autora: Naomi Takemoto
 **/

public abstract class PlayList {
	
	//Atributos
	private String nome;
	private int quantidadeMusicas;
	private ArrayList<PlayListMusica> listaMusicas;
	
	//Metodos construtores
	public PlayList(){
		quantidadeMusicas = 0;
	}
	public PlayList(String nome){
		this();
		this.nome = nome;
	}
	

	//gettter e setters
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
	
	@Override
	public String toString() {
		String out =  "PlayList [ " + ", nome=" + nome
				+ ", quantidadeMusicas=" + quantidadeMusicas  + "]";
		int i;
		out += "\nLista de Musicas da PlayList [";
		if(listaMusicas.size() == 1) {
			out += listaMusicas.get(0).getMusica().getNomeMusica() + "]";
		}
		else {
			for(i = 0; i < listaMusicas.size(); i++) {
				out += listaMusicas.get(i).getMusica().getNomeMusica() + ", ";
			}
			out += " ]";
		}
		return out;
	}
	
	
	
	/*Metodo: adicionarMusica
	 *Parametros: a musica que devera ser adicionada
	 *O que faz: se a musica nao estiver na playlist, adiciona, caso contrario nao
	 *Retorno: true se adicionou com sucesso, false caso contrario.
	 * */
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
			PlayListMusica associativo = new PlayListMusica(this, musica);
			listaMusicas.add(associativo);
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
		for(int i = 0; i < listaMusicas.size(); i++){
			//se achou a musica na playlist
			if(listaMusicas.get(i).getMusica() == musica){
				removeu = true;
				int tam = musica.getPlaylists().size();
				for(int j = 0; j < tam; j++){
					if(musica.getPlaylists().get(j).getPlaylist() == this){
						removeu = true;
						//retirar a playlist atual da lista de playlists de musica
						musica.getPlaylists().remove(j);
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
