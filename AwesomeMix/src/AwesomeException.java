import javax.swing.JOptionPane;

public class AwesomeException extends Exception {

	private static final long serialVersionUID = 6615032207360499213L;

	public AwesomeException(String erro) {
		// TODO Auto-generated constructor stub
		JOptionPane.showMessageDialog (null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
	}
}
