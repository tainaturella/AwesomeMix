import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class JanelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JPasswordField pwdSenha;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCadastro frame = new JanelaCadastro();
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
	public JanelaCadastro() {
		setTitle("Cadastro - AwesomeMix");
		setSize(700, 500); //tamanho da janela
		setLocationRelativeTo(null); //centraliza janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastro = new JLabel("Cadastro de Usu\u00E1rio");
		lblCadastro.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCadastro.setBounds(10, 25, 171, 14);
		contentPane.add(lblCadastro);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(35, 71, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdade.setBounds(207, 71, 33, 14);
		contentPane.add(lblIdade);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setBounds(35, 125, 30, 14);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(207, 125, 35, 14);
		contentPane.add(lblSenha);
		
		txtNome = new JTextField();
		txtNome.setBounds(72, 68, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(248, 68, 86, 20);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(72, 122, 86, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setBounds(248, 122, 86, 20);
		contentPane.add(pwdSenha);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBounds(72, 165, 109, 23);
		contentPane.add(btnCadastrar);
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = txtNome.getText();
				int idade = Integer.parseInt(txtIdade.getText(), 10);
				String login = txtLogin.getText();
				String senha = new String(pwdSenha.getPassword());
				Usuario usuario = new Usuario(nome, idade, login, senha);
				
				BaseDeDados.shared.usuarios.add(usuario);
				BaseDeDados.shared.usuario_logado = BaseDeDados.shared.usuarios.size() - 1;
				
				new JanelaMeuPerfil().setVisible(true);
				setVisible(false);
				dispose();
				JOptionPane.showMessageDialog (null, "Usuário Cadastrado", "Sucesso!!", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(207, 165, 89, 23);
		contentPane.add(btnLimpar);
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(contentPane, "Deseja Apagar os dados fornecidos até aqui?", "Confirmação", dialogButton);
				if(dialogResult == 0) {
					txtSenha.setText(" ");
					txtIdade.setText(" ");
					txtLogin.setText(" ");
					txtNome.setText(" ");
				}
			}
		});
			
	
		JButton btnVoltar = new JButton("VOLTAR");
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
