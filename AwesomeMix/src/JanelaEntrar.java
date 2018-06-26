import java.awt.Color;
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
import javax.swing.ImageIcon;
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
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("logop.png"));
		lblNewLabel.setBounds(188, 28, 74, 88);
		contentPane.add(lblNewLabel);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLogin.setBounds(286, 132, 46, 14);
		contentPane.add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(342, 129, 86, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSenha.setBounds(286, 188, 46, 14);
		contentPane.add(lblSenha);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setBounds(342, 185, 86, 20);
		contentPane.add(pwdSenha);
		
		JLabel lblEntrar = new JLabel("Entrar na Conta");
		lblEntrar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEntrar.setBounds(279, 56, 170, 24);
		contentPane.add(lblEntrar);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBounds(313, 247, 89, 24);
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
		btnVoltar.setBounds(25, 367, 89, 26);
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
