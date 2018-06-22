import java.util.ArrayList;

public class BaseDeDados {
	static BaseDeDados shared = new BaseDeDados();
	public  ArrayList<Usuario> usuarios;
	public int usuario_logado;
	
	private BaseDeDados() {
		usuarios = new ArrayList<Usuario>();
	}
	
	
}
