import java.util.ArrayList;

public class BaseDeDados {
	
	static BaseDeDados shared = new BaseDeDados();
	
	//arrays do programa que ficam no banco de dados
	public ArrayList<Usuario> usuarios;
	public ArrayList<Album> albuns;
	public ArrayList<Musica> musicas;
	public ArrayList<PlayListPrivada> playListsPrivadas;
	public ArrayList<PlayListPublica> playListsPublicas;
	public ArrayList<UsuarioPlayListPublica> usuariosPlayListPublicas;
	public ArrayList<UsuarioMusica> usuariosMusica;
	public ArrayList<MusicaPlayListPublica> musicasPlayListPublica;
	public ArrayList<MusicaPlayListPrivada> musicasPlayListPrivada;
	
	public int usuario_logado;
	public int usuario;
	public int playList_atual;
	public TipoPlaylist tipoPlaylist; //vamos substituir isso por polimorfismo
	public PlayList playListAtual;
	public Musica musicaAtual;
	
	private BaseDeDados() {
		usuarios = new ArrayList<Usuario>();
		albuns = new ArrayList<Album>();
		musicas = new ArrayList<Musica>();
		playListsPrivadas = new ArrayList<PlayListPrivada>();
		playListsPublicas = new ArrayList<PlayListPublica>();
		usuariosPlayListPublicas = new ArrayList<UsuarioPlayListPublica>();
		usuariosMusica = new ArrayList<UsuarioMusica>();
		musicasPlayListPublica = new ArrayList<MusicaPlayListPublica>();
		musicasPlayListPrivada = new ArrayList<MusicaPlayListPrivada>();
	}
}
