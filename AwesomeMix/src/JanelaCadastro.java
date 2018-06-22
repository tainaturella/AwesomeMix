import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JanelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtLogin;
	private JTextField txtSenha;

	/**
	 * Create the frame.
	 */
	public JanelaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setBounds(10, 11, 46, 14);
		contentPane.add(lblCadastro);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 35, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(137, 35, 46, 14);
		contentPane.add(lblIdade);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 89, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(137, 89, 46, 14);
		contentPane.add(lblSenha);
		
		txtNome = new JTextField();
		txtNome.setText("nome");
		txtNome.setBounds(41, 32, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtIdade = new JTextField();
		txtIdade.setText("idade");
		txtIdade.setBounds(178, 32, 86, 20);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);
		
		txtLogin = new JTextField();
		txtLogin.setText("login");
		txtLogin.setBounds(41, 86, 86, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setText("senha");
		txtSenha.setBounds(178, 86, 86, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(68, 154, 89, 23);
		contentPane.add(btnCadastrar);
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = txtNome.getText();
				int idade = Integer.parseInt(txtIdade.getText(), 10);
				String login = txtLogin.getText();
				String senha = txtSenha.getText();
				
				Usuario usuario = new Usuario(nome, idade, login, senha);
				
				BaseDeDados.shared.usuarios.add(usuario);
				BaseDeDados.shared.usuario_logado = BaseDeDados.shared.usuarios.size() - 1;
				
				new JanelaMeuPerfil().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(175, 154, 89, 23);
		contentPane.add(btnLimpar);
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtSenha.setText(" ");
				txtIdade.setText(" ");
				txtLogin.setText(" ");
				txtNome.setText(" ");
				
			}
		});
			
	
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JanelaAwesomeMix().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
	}
}
