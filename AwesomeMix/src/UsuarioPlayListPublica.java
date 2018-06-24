/*Classe: UsuarioPlayListPublica
 *Descricao: classe associativa para auxiliar na implementacao da relacao de * para * entre
 *Ususario e PlayListPublica*/
public class UsuarioPlayListPublica {
	
	private int id;
	private static int qtdUsuarioPlayListPublica = 0;
	private Usuario usuario;
	private PlayListPublica playListPublica;
	
	//construtor sem parametros nao adiciona id pois nao representa um novo objeto na memoria
	//serve apenas para puxar dados do banco
	public UsuarioPlayListPublica() {
		id = 0;
		usuario = null;
		playListPublica = null;
	}
	
	public UsuarioPlayListPublica(Usuario usuario){
		qtdUsuarioPlayListPublica++;
		id = qtdUsuarioPlayListPublica;
		this.usuario = usuario;
	}
	
	public UsuarioPlayListPublica(PlayListPublica playListPublica){
		qtdUsuarioPlayListPublica++;
		id = qtdUsuarioPlayListPublica;
		this.playListPublica = playListPublica;
	}
	
	public UsuarioPlayListPublica(Usuario usuario, PlayListPublica playListPublica){
		qtdUsuarioPlayListPublica++;
		id = qtdUsuarioPlayListPublica;
		this.usuario = usuario;
		this.playListPublica = playListPublica;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public PlayListPublica getPlayListPublica() {
		return playListPublica;
	}

	public void setPlayListPublica(PlayListPublica playListPublica) {
		this.playListPublica = playListPublica;
	}

	@Override
	public String toString() {
		return "UsuarioPlayListPublica [playListPublica=" + playListPublica.getId() + "]";
	}
	
}
