/*Classe: UsuarioPlayList
 *Descricao: classe associativa para auxiliar na implementacao da relacao de * para * entre
 *Ususario e PlayListPrivada*/
public class UsuarioPlayList {
	
	private Usuario usuario;
	private PlayList playList;
	
	public UsuarioPlayList(Usuario usuario){
		this.setUsuario(usuario);
	}
	
	public UsuarioPlayList(PlayList playList){
		this.setPlayList(playList);
	}
	
	public UsuarioPlayList(Usuario usuario, PlayList playList){
		this.setUsuario(usuario);
		this.setPlayList(playList);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public PlayList getPlayList() {
		return playList;
	}

	public void setPlayList(PlayList playList) {
		this.playList = playList;
	}
	
	
}