import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;

public class JanelaPerfil extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JanelaPerfil() {
		setTitle("Perfil - AwesomeMix");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final Usuario usuario = BaseDeDados.shared.usuarios.get(BaseDeDados.shared.usuario);
		
		JLabel lblTitulo = new JLabel("Perfil de");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(10, 11, 70, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblNome = new JLabel(usuario.getNome());
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNome.setBounds(79, 11, 290, 14);
		contentPane.add(lblNome);
		
		JLabel lblNome_1 = new JLabel(usuario.getNome());
		lblNome_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNome_1.setBounds(29, 36, 70, 14);
		contentPane.add(lblNome_1);
		
		JLabel lblIdade = new JLabel(Integer.toString(usuario.getIdade()));
		lblIdade.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblIdade.setBounds(105, 36, 46, 14);
		contentPane.add(lblIdade);
		
		JLabel lblPlaylists = new JLabel("Playlists");
		lblPlaylists.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlaylists.setBounds(54, 61, 70, 14);
		contentPane.add(lblPlaylists);
		
		
		final DefaultListModel<String> listPublicas = new DefaultListModel<String>();
		for(int i=0; i < usuario.getPlayListsPublicas().size(); i++) {
			listPublicas.addElement(usuario.getPlayListsPublicas().get(i).getPlayListPublica().getNome());
		}
		
		final JList<String> listPlayListPublica = new JList<String>(listPublicas);
		//listPlayListPublica.setBounds(96, 146, 93, 55);
		listPlayListPublica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPlayListPublica.setLayoutOrientation(JList.VERTICAL);
		JScrollPane listPublicaScroll = new JScrollPane(listPlayListPublica);
		listPublicaScroll.setBounds(54, 87, 220, 116);
		contentPane.add(listPublicaScroll);
		
		listPlayListPublica.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = listPlayListPublica.getSelectedIndex();
			    if (evt.getClickCount() == 2) {
			         for(int i=0; i < usuario.getPlayListsPublicas().size(); i++) {
			        	 	if(usuario.getPlayListsPublicas().get(i).getPlayListPublica().getNome().equals(listPublicas.get(index))) {
				        	 	BaseDeDados.shared.playList_atual = i;
				        	 	BaseDeDados.shared.tipoPlaylist = TipoPlaylist.PUBLICA;
				        	 	new JanelaPlaylistsPublicas().setVisible(true);
				        	 	setVisible(false);
				        	 	dispose();
			        	 	}
			         }
			    }
			  }
			});
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(10, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JanelaUsuarios().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
	}

}
