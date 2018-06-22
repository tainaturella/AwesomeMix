import java.util.ArrayList;

public class BaseDeDados {
	static BaseDeDados shared = new BaseDeDados();
	public  ArrayList<Usuario> usuarios;
	public int usuario_logado;
	public int usuario;
	public int playList_atual;
	public TipoPlaylist tipoPlaylist;
	
	private BaseDeDados() {
		usuarios = new ArrayList<Usuario>();
	}
	
	
}
