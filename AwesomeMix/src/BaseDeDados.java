import java.util.ArrayList;

public class BaseDeDados {
	static BaseDeDados shared = new BaseDeDados();
	public  ArrayList<Usuario> usuarios;
	
	public ArrayList<Album> albums;
	public ArrayList<Musica> musicas;
	public ArrayList<PlayListPrivada> playListPrivadas;
	public ArrayList<PlayListPublica> playListPublicas;
	public ArrayList<UsuarioPlayListPublica> usuarioPlayListPublicas;
	
	public int usuario_logado;
	public int usuario;
	public int playList_atual;
	public TipoPlaylist tipoPlaylist;
	
	private BaseDeDados() {
		usuarios = new ArrayList<Usuario>();
		albums = new ArrayList<Album>();
		musicas = new ArrayList<Musica>();
		playListPrivadas = new ArrayList<PlayListPrivada>();
		playListPublicas = new ArrayList<PlayListPublica>();
		usuarioPlayListPublicas = new ArrayList<UsuarioPlayListPublica>();
	}
}
