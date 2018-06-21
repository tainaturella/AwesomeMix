
public class UsuarioMusica {
	
	private int id;
	private Usuario usuario;
	private Musica musica;
	private double avaliacao;
	private static int geradorId = 0;
	
	public UsuarioMusica(){
		usuario = null;
		musica = null;
		id = 0;
	}
	
	public UsuarioMusica(Usuario usuario){
		id = geradorId++;
		this.usuario = usuario;
		musica = null;
	}

	public UsuarioMusica(Musica musica){
		id = geradorId++;
		this.musica = musica;
		usuario = null;
	}
	
	public UsuarioMusica(Usuario usuario, Musica musica){
		id = geradorId++;
		this.musica = musica;
		musica = null;
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

	public Musica getMusica() {
		return musica;
	}

	public void setMusica(Musica musica) {
		this.musica = musica;
	}

	public double getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(double avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	
}
