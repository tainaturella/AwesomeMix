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
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

@SuppressWarnings("serial")
public class JanelaPerfil extends JFrame {

	private JPanel contentPane;
	
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
	public JanelaPerfil() {
		setTitle("Perfil - AwesomeMix");
		setSize(700, 500); //tamanho da janela
		setLocationRelativeTo(null); //centraliza janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(204, 153, 255));
		final Usuario usuario = BaseDeDados.shared.usuarios.get(BaseDeDados.shared.usuario);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("logop.png"));
		lblNewLabel.setBounds(10, 11, 74, 88);
		contentPane.add(lblNewLabel);
		
		JLabel lblTitulo = new JLabel("Perfil de");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setBounds(87, 15, 113, 22);
		contentPane.add(lblTitulo);
		
		JLabel lblNome = new JLabel(usuario.getNome());
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNome.setBounds(179, 11, 465, 30);
		contentPane.add(lblNome);
		
		JLabel lblNome_1 = new JLabel(usuario.getNome());
		lblNome_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNome_1.setBounds(177, 43, 331, 23);
		contentPane.add(lblNome_1);
		
		JLabel lblIdade = new JLabel(Integer.toString(usuario.getIdade()));
		lblIdade.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblIdade.setBounds(97, 43, 43, 23);
		contentPane.add(lblIdade);
		
		JLabel lblPlaylists = new JLabel("Playlists");
		lblPlaylists.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPlaylists.setBounds(94, 85, 80, 25);
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
		listPublicaScroll.setBounds(121, 109, 284, 220);
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
		btnVoltar.setBounds(25, 367, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblAnos = new JLabel("anos");
		lblAnos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAnos.setBounds(121, 48, 46, 14);
		contentPane.add(lblAnos);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JanelaUsuarios().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
	}

}
