import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JToolBar;

public class JanelaMeuPerfil extends JFrame {
	private JTextField txtNome;
	private JTextField txtLogin;
	private JTextField txtIdade;
	private JPasswordField pwdSenhasemedit;
	

	/**
	 * Create the frame.
	 */
	public JanelaMeuPerfil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Usuario usuario = BaseDeDados.shared.usuarios.get(BaseDeDados.shared.usuario_logado);
		
		JLabel lblTitulo = new JLabel("Perfil de");
		lblTitulo.setBounds(10, 11, 46, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblNome = new JLabel(usuario.getNome());
		lblNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNome.setBounds(52, 11, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblDadosPessoais = new JLabel("Dados Pessoais");
		lblDadosPessoais.setBounds(10, 40, 88, 14);
		contentPane.add(lblDadosPessoais);
		
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setBounds(10, 59, 46, 14);
		contentPane.add(lblNome_1);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(199, 59, 46, 14);
		contentPane.add(lblIdade);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 84, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(199, 84, 46, 14);
		contentPane.add(lblSenha);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(335, 80, 89, 23);
		contentPane.add(btnEditar);
		
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(335, 55, 89, 23);
		contentPane.add(btnSair);
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JanelaAwesomeMix().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		
		JLabel lblDadosconta = new JLabel("Dados de Conta");
		lblDadosconta.setBounds(10, 121, 88, 14);
		contentPane.add(lblDadosconta);
		
		JLabel lblPlaylistspublicas = new JLabel("Playlists P\u00FAblicas");
		lblPlaylistspublicas.setBounds(10, 146, 88, 14);
		contentPane.add(lblPlaylistspublicas);
		
		DefaultListModel<String> listPublicas = new DefaultListModel<String>();
		for(int i=0; i < usuario.getPlayListsPublicas().size(); i++) {
			listPublicas.addElement(usuario.getPlayListsPublicas().get(i).getPlayListPublica().getNome());
		}
		
		JList<String> listPlayListPublica = new JList<String>(listPublicas);
		listPlayListPublica.setBounds(96, 146, 93, 55);
		contentPane.add(listPlayListPublica);
		
		JLabel lblPlaylistsprivadas = new JLabel("Playlists Privadas");
		lblPlaylistsprivadas.setBounds(199, 146, 82, 14);
		contentPane.add(lblPlaylistsprivadas);
		
		JList<String> list = new JList<String>();
		list.setBounds(291, 145, 88, 56);
		contentPane.add(list);
		
		JButton btnAdicionarPlaylist = new JButton("Adicionar Playlist");
		btnAdicionarPlaylist.setBounds(85, 210, 121, 23);
		contentPane.add(btnAdicionarPlaylist);
		
		JButton btnRemoverPlaylist = new JButton("Remover PlayList");
		btnRemoverPlaylist.setBounds(216, 210, 121, 23);
		contentPane.add(btnRemoverPlaylist);
			
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setText(usuario.getNome());
		txtNome.setBounds(40, 56, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtLogin = new JTextField();
		txtLogin.setEditable(false);
		txtLogin.setText(usuario.getLogin());
		txtLogin.setBounds(40, 84, 86, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		txtIdade = new JTextField();
		txtIdade.setEditable(false);
		txtIdade.setText(Integer.toString(usuario.getIdade()));
		txtIdade.setBounds(239, 56, 86, 20);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);
		
		pwdSenhasemedit = new JPasswordField();
		pwdSenhasemedit.setEditable(false);
		pwdSenhasemedit.setText("SenhaSemEdit");
		pwdSenhasemedit.setBounds(239, 81, 86, 20);
		contentPane.add(pwdSenhasemedit);
		
		JButton btnBuscarPerfis = new JButton("Buscar Perfis");
		btnBuscarPerfis.setBounds(151, 243, 117, 29);
		contentPane.add(btnBuscarPerfis);
		btnBuscarPerfis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JanelaUsuarios().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnEditar.getText() == "Editar") {
					btnEditar.setText("Salvar");
					txtIdade.setEditable(true);
					txtNome.setEditable(true);
					pwdSenhasemedit.setEditable(true);
				}
				else {
					btnEditar.setText("Editar");
					txtIdade.setEditable(false);
					txtNome.setEditable(false);
					pwdSenhasemedit.setEditable(false);
					usuario.setIdade(Integer.parseInt(txtIdade.getText()));
					usuario.setNome(txtNome.getText());
					usuario.setSenha(new String(pwdSenhasemedit.getPassword()));
				}
				
			}
		});
		
	}
}
