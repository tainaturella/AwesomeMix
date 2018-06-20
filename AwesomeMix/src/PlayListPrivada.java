/*Classe: PlayListPublica
 *Autora: Naomi Takemoto
 *Descricao: em um estagio futuro do projeto, PlayList publica sera um conjunto de
 *musicas criadas por determinado usuario e que sera visivel somente a ele e/ou
 *no futuro aos usuarios com autorizacao para tal.
 * */


public class PlayListPrivada  extends PlayList {
	private static int geradorId = 0;
	private int id;
	private Usuario dono;
	
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

	@Override
	public String toString() {
		String out = "";
		out += "PlayListPrivada [ Nome= " + super.getNome() + " Id= " +id + "]";
		return out;
	}
	
	

}
