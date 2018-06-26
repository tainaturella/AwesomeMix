import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class JanelaMeuPerfil extends JFrame {
	private JTextField txtNome;
	private JTextField txtLogin;
	private JTextField txtIdade;
	private JPasswordField pwdSenhasemedit;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaMeuPerfil frame = new JanelaMeuPerfil();
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
	public JanelaMeuPerfil() {
		setTitle("Meu Perfil - AwesomeMix");
		setSize(700, 500); //tamanho da janela
		setLocationRelativeTo(null); //centraliza janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 325);
		final JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		final Usuario usuario = BaseDeDados.shared.usuarios.get(BaseDeDados.shared.usuario_logado);
		
		JLabel lblTitulo = new JLabel("Perfil de");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(10, 11, 64, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblNome = new JLabel(usuario.getNome());
		lblNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNome.setBounds(77, 11, 315, 14);
		contentPane.add(lblNome);
		
		JLabel lblDadosPessoais = new JLabel("Dados Pessoais");
		lblDadosPessoais.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDadosPessoais.setBounds(20, 40, 101, 14);
		contentPane.add(lblDadosPessoais);
		
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome_1.setBounds(28, 62, 46, 14);
		contentPane.add(lblNome_1);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdade.setBounds(199, 62, 46, 14);
		contentPane.add(lblIdade);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setBounds(30, 87, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(199, 87, 46, 14);
		contentPane.add(lblSenha);
		
		final JButton btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(335, 80, 89, 23);
		contentPane.add(btnEditar);
		
		
		JButton btnSair = new JButton("SAIR");
		btnSair.setBounds(335, 55, 89, 23);
		contentPane.add(btnSair);
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(contentPane, "Deseja sair?", "Confirma��o", dialogButton);
				if(dialogResult == 0) {
					new JanelaAwesomeMix().setVisible(true);
					setVisible(false);
					dispose();
				}
			}
		});
		
		JLabel lblPlaylistspublicas = new JLabel("Playlists P\u00FAblicas");
		lblPlaylistspublicas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblPlaylistspublicas.setBounds(23, 119, 118, 14);
		contentPane.add(lblPlaylistspublicas);
		
		final DefaultListModel<String> listPublicas = new DefaultListModel<String>();
		for(int i=0; i < usuario.getPlayListsPublicas().size(); i++) {
			listPublicas.addElement(usuario.getPlayListsPublicas().get(i).getPlayListPublica().getNome());
		}
		
		final JList<String> listPlayListPublica = new JList<String>(listPublicas);
		//listPlayListPublica.setBounds(96, 146, 93, 55);
		listPlayListPublica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPlayListPublica.setLayoutOrientation(JList.VERTICAL);
		JScrollPane listPublicaScroll = new JScrollPane(listPlayListPublica);
		listPublicaScroll.setBounds(20, 144, 190, 56);
		contentPane.add(listPublicaScroll);
		
		listPlayListPublica.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = listPlayListPublica.getSelectedIndex();
			    if (evt.getClickCount() == 2) {
			         for(int i=0; i < usuario.getPlayListsPublicas().size(); i++) {
			        	 	if(usuario.getPlayListsPublicas().get(i).getPlayListPublica().getNome().equals(listPublicas.get(index))) {
				        	 	BaseDeDados.shared.playList_atual = i;
				        	 	BaseDeDados.shared.tipoPlaylist = TipoPlaylist.PUBLICA;
				        	 	new JanelaPlaylist().setVisible(true);
				        	 	setVisible(false);
				        	 	dispose();
			        	 	}
			         }
			    }
			  }
			});
		
		JLabel lblPlaylistsprivadas = new JLabel("Playlists Privadas");
		lblPlaylistsprivadas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblPlaylistsprivadas.setBounds(222, 121, 110, 14);
		contentPane.add(lblPlaylistsprivadas);
		
		final DefaultListModel<String> listPrivadas = new DefaultListModel<String>();
		for(int i=0; i < usuario.getPlayListsPrivadas().size(); i++) {
			listPrivadas.addElement(usuario.getPlayListsPrivadas().get(i).getNome());
		}
		
		final JList<String> listPlayListPrivada = new JList<String>(listPrivadas);
		listPlayListPrivada.setLocation(236, 0);
		listPlayListPrivada.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPlayListPrivada.setLayoutOrientation(JList.VERTICAL);
		JScrollPane listPrivadaScroll = new JScrollPane(listPlayListPrivada);
		listPrivadaScroll.setBounds(239, 144, 185, 56);
		contentPane.add(listPrivadaScroll);

		listPlayListPrivada.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = listPlayListPrivada.getSelectedIndex();
			    if (evt.getClickCount() == 2) {
			         for(int i=0; i < usuario.getPlayListsPrivadas().size(); i++) {
			        	 	if(usuario.getPlayListsPrivadas().get(i).getNome().equals(listPrivadas.get(index))) {
				        	 	BaseDeDados.shared.playList_atual = i;
				        	 	BaseDeDados.shared.tipoPlaylist = TipoPlaylist.PRIVADA;
				        	 	new JanelaPlaylist().setVisible(true);
				        	 	setVisible(false);
				        	 	dispose();
			        	 	}
			         }
			    }
			  }
			});
		
		JButton btnAdicionarPlaylist = new JButton("ADICIONAR PLAYLIST");
		btnAdicionarPlaylist.setBounds(49, 249, 139, 26);
		contentPane.add(btnAdicionarPlaylist);
		
		btnAdicionarPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JanelaAdicionarPlayList().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		
		JButton btnRemoverPlaylistPublica = new JButton("REMOVER PLAYLIST P�BLICA");
		btnRemoverPlaylistPublica.setBounds(28, 211, 177, 29);
		contentPane.add(btnRemoverPlaylistPublica);
		
		btnRemoverPlaylistPublica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(contentPane, "Deseja remover a playlist?", "Confirma��o", dialogButton);
				if(dialogResult == 0) {
					int index = listPlayListPublica.getSelectedIndex();
					for(int i=0; i < usuario.getPlayListsPublicas().size(); i++) {
						if(usuario.getPlayListsPublicas().get(i).getPlayListPublica().getNome().equals(listPublicas.get(index))) {
							usuario.removePlayListPublica(usuario.getPlayListsPublicas().get(i).getPlayListPublica());
							listPublicas.remove(index);
							break;
							}
						}
				
					}
			}
		});
	
		
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setText(usuario.getNome());
		txtNome.setBounds(65, 59, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtLogin = new JTextField();
		txtLogin.setEditable(false);
		txtLogin.setText(usuario.getLogin());
		txtLogin.setBounds(65, 87, 86, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		txtIdade = new JTextField();
		txtIdade.setEditable(false);
		txtIdade.setText(Integer.toString(usuario.getIdade()));
		txtIdade.setBounds(239, 59, 86, 20);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);
		
		pwdSenhasemedit = new JPasswordField();
		pwdSenhasemedit.setEditable(false);
		pwdSenhasemedit.setText(BaseDeDados.shared.usuarios.get(BaseDeDados.shared.usuario_logado).getSenha());
		pwdSenhasemedit.setBounds(239, 87, 86, 20);
		contentPane.add(pwdSenhasemedit);
		
		JButton btnBuscarPerfis = new JButton("BUSCAR PERFIS");
		btnBuscarPerfis.setBounds(275, 246, 117, 29);
		contentPane.add(btnBuscarPerfis);
		
		btnBuscarPerfis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JanelaUsuarios().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		
		JButton btnRemoverPlaylistPrivada = new JButton("REMOVER PLAYLIST PRIVADA");
		btnRemoverPlaylistPrivada.setBounds(243, 209, 177, 29);
		contentPane.add(btnRemoverPlaylistPrivada);
		
		btnRemoverPlaylistPrivada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(contentPane, "Deseja remover a playlist?", "Confirma��o", dialogButton);
				if(dialogResult == 0) {
					int indexPrivada = listPlayListPrivada.getSelectedIndex();
					for(int i=0; i < usuario.getPlayListsPrivadas().size(); i++) {
						if(usuario.getPlayListsPrivadas().get(i).getNome().equals(listPrivadas.get(indexPrivada))) {
							usuario.removePlayListPrivada(usuario.getPlayListsPrivadas().get(i));
							listPrivadas.remove(indexPrivada);
							break;
						}
					}
				}
			}
		});
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnEditar.getText() == "EDITAR") {
					btnEditar.setText("SALVAR");
					txtIdade.setEditable(true);
					txtNome.setEditable(true);
					pwdSenhasemedit.setEditable(true);
				}
				else {
					btnEditar.setText("EDITAR");
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
