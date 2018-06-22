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

public class JanelaPerfil extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JanelaPerfil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Usuario usuario = BaseDeDados.shared.usuarios.get(BaseDeDados.shared.usuario);
		
		JLabel lblTitulo = new JLabel("Perfil de");
		lblTitulo.setBounds(10, 11, 46, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblNome = new JLabel(usuario.getNome());
		lblNome.setBounds(51, 11, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblNome_1 = new JLabel(usuario.getNome());
		lblNome_1.setBounds(10, 36, 46, 14);
		contentPane.add(lblNome_1);
		
		JLabel lblIdade = new JLabel(Integer.toString(usuario.getIdade()));
		lblIdade.setBounds(61, 36, 46, 14);
		contentPane.add(lblIdade);
		
		JLabel lblPlaylists = new JLabel("Playlists");
		lblPlaylists.setBounds(10, 61, 46, 14);
		contentPane.add(lblPlaylists);
		
		
		DefaultListModel<String> listPublicas = new DefaultListModel<String>();
		for(int i=0; i < usuario.getPlayListsPublicas().size(); i++) {
			listPublicas.addElement(usuario.getPlayListsPublicas().get(i).getPlayListPublica().getNome());
		}
		
		JList<String> listPlayListPublica = new JList<String>(listPublicas);
		//listPlayListPublica.setBounds(96, 146, 93, 55);
		listPlayListPublica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPlayListPublica.setLayoutOrientation(JList.VERTICAL);
		JScrollPane listPublicaScroll = new JScrollPane(listPlayListPublica);
		listPublicaScroll.setBounds(10, 86, 161, 77);
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
		
		JButton btnVoltar = new JButton("Voltar");
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
