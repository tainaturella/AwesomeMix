import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;

@SuppressWarnings("serial")
public class JanelaEntrar extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField pwdSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaEntrar frame = new JanelaEntrar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaEntrar() {
		setTitle("Login -AwesomeMix");
		setSize(700, 500); //tamanho da janela
		setLocationRelativeTo(null); //centraliza janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setBounds(141, 94, 46, 14);
		contentPane.add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(197, 91, 86, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(141, 137, 46, 14);
		contentPane.add(lblSenha);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setBounds(197, 134, 86, 20);
		contentPane.add(pwdSenha);
		
		JLabel lblEntrar = new JLabel("Entrar na Conta");
		lblEntrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEntrar.setBounds(156, 37, 116, 14);
		contentPane.add(lblEntrar);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBounds(168, 182, 89, 24);
		contentPane.add(btnEntrar);
		
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					logar();
				} catch (Exception e) {
					System.err.println("Erro de login");
				}
			}
		});
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(10, 224, 89, 26);
		contentPane.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JanelaAwesomeMix().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		
	}
	
	private void logar() throws AwesomeException{
		for(int i=0; i < BaseDeDados.shared.usuarios.size(); i++) {
			if(BaseDeDados.shared.usuarios.get(i).getLogin().equals(txtLogin.getText())) {
				if(BaseDeDados.shared.usuarios.get(i).getSenha().equals(new String(pwdSenha.getPassword()))) {
					BaseDeDados.shared.usuario_logado = i;
					new JanelaMeuPerfil().setVisible(true);
					setVisible(false);
					dispose();
					return;
				}
			}
		}
		throw new AwesomeException("Usuario ou senha incorreto!");
		
	}
}
