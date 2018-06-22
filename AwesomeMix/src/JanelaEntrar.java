import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(102, 95, 46, 14);
		contentPane.add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setText("Login");
		txtLogin.setBounds(158, 92, 86, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(102, 137, 46, 14);
		contentPane.add(lblSenha);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setText("Senha");
		pwdSenha.setBounds(164, 134, 79, 20);
		contentPane.add(pwdSenha);
		
		JLabel lblEntrar = new JLabel("Entrar");
		lblEntrar.setBounds(151, 53, 46, 14);
		contentPane.add(lblEntrar);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(127, 171, 89, 23);
		contentPane.add(btnEntrar);
	}
}
