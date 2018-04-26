/*Classe: PlayList
 *Autora: Naomi Takemoto
 *Atualizacao: corrigindo bug em adiconarMusica, atualizando
 *atributo duracao da Playlist. Inicializando quantidadeMusicas e duracao
 *no construtor.
 **/
import java.util.ArrayList;

public class PlayList {
	
	private static int geradorId = 0;
	private final int id;
	private String nome;
	private Usuario autor;
	private ArrayList <Musica> musicas;
	private int quantidadeMusicas;
	private double duracao;			
	
	public PlayList(){
		this.id = geradorId++;
		duracao = 0;
		quantidadeMusicas = 0;
		musicas = new ArrayList<Musica>();
	}
	
	public PlayList(String nome, Usuario autor){
		this();
		this.nome = nome;
		this.autor = autor;
	}
	
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

	/*Metodo adicionarMusica
	 *Parametro: musica a ser incluida na playlist
	 *Verifica se musica ja esta na playlist, se nao adiciona, caso contrario,
	 *nao.
	 *Retorno: boolean, true se a musica foi colocada com sucesso, false se nao.
	 **/
	public boolean adicionarMusica(Musica musica){
		boolean adiciona ;
		adiciona = musicas.contains(musica);
		if(adiciona == false){
			adiciona = musicas.add(musica);
			this.duracao += musica.getTempoDuracao();
		}
		return adiciona;
	}

	@Override
	public String toString() {
		String out =  "PlayList [id=" + id + ", nome=" + nome
				+ ", quantidadeMusicas=" + quantidadeMusicas +  ", duracao=" + duracao;
		out += ", musicas=[ ";
		if(musicas != null){
			for(int i = 0; i < musicas.size(); i++){
				out += musicas.get(i);
			}
		}
		out +=  "]";
		return out;
	}
	
}
