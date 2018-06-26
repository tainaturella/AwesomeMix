import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(204, 153, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastro = new JLabel("Cadastro de Usuario");
		lblCadastro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCadastro.setBounds(93, 35, 268, 32);
		contentPane.add(lblCadastro);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("logop.png"));
		lblNewLabel.setBounds(10, 11, 74, 88);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(101, 130, 63, 14);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIdade.setBounds(386, 130, 54, 14);
		contentPane.add(lblIdade);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLogin.setBounds(101, 182, 63, 20);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSenha.setBounds(101, 233, 83, 14);
		contentPane.add(lblSenha);
		
		txtNome = new JTextField();
		txtNome.setBounds(154, 128, 222, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(442, 128, 46, 20);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(154, 182, 109, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setBounds(157, 233, 106, 20);
		contentPane.add(pwdSenha);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBounds(136, 286, 127, 23);
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
				JOptionPane.showMessageDialog (null, "Usu�rio Cadastrado", "Sucesso!!", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(366, 286, 109, 23);
		contentPane.add(btnLimpar);
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(contentPane, "Deseja Apagar os dados fornecidos at� aqui?", "Confirma��o", dialogButton);
				if(dialogResult == 0) {
					txtSenha.setText(" ");
					txtIdade.setText(" ");
					txtLogin.setText(" ");
					txtNome.setText(" ");
				}
			}
		});
			
	
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(25, 367, 89, 23);
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
