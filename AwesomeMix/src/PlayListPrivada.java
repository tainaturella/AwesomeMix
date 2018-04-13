
public class PlayListPrivada  extends PlayList {
	public PlayListPrivada(){
		super();
	}

	@Override
	public String toString() {
		return "PlayListPrivada [getId()=" + getId() + ", getNome()="
				+ getNome() + ", getAutor()=" + getAutor() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
	
}
