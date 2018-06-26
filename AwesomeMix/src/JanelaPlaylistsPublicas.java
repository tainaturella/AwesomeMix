import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import java.awt.Font;

@SuppressWarnings("serial")
public class JanelaPlaylistsPublicas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPlaylistsPublicas frame = new JanelaPlaylistsPublicas();
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
	public JanelaPlaylistsPublicas() {
		setTitle("Playlists - AwesomeMix");
		setSize(700, 500); //tamanho da janela
		setLocationRelativeTo(null); //centraliza janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(204, 153, 255));
		
		Usuario usuario = BaseDeDados.shared.usuarios.get(BaseDeDados.shared.usuario);
		
		JLabel lblTitulo = new JLabel("Playlists Publicas");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setBounds(94, 40, 281, 23);
		contentPane.add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Tai\\Documents\\vai carai\\AwesomeMix\\AwesomeMix\\src\\logop.png"));
		lblNewLabel.setBounds(10, 11, 74, 88);
		contentPane.add(lblNewLabel);
		
		
		DefaultListModel<String> listMusicas = new DefaultListModel<String>();
	
		ArrayList<MusicaPlayListPublica> listaMusica = usuario.getPlayListsPublicas().get(BaseDeDados.shared.playList_atual).getPlayListPublica().getListaMusicas();
		for(int i=0; i< listaMusica.size(); i++) {
			String nomeMusica = listaMusica.get(i).getMusica().getNomeMusica();
			String albulMusica = listaMusica.get(i).getMusica().getAlbum().getNomeAlbum();
			String artistaMusica = listaMusica.get(i).getMusica().getAlbum().getArtista();

			listMusicas.addElement(nomeMusica + "-" + albulMusica + "-" + artistaMusica);
		}
		
		JList<String> listaMusicas = new JList<String>(listMusicas);
		//listaMusicas.setBounds(10, 54, 180, 162);
		listaMusicas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaMusicas.setLayoutOrientation(JList.VERTICAL);
		JScrollPane listaMusicasScroll = new JScrollPane(listaMusicas);
		listaMusicasScroll.setBounds(107, 91, 268, 232);
		contentPane.add(listaMusicasScroll);
		
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(25, 367, 89, 23);
		contentPane.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JanelaPerfil().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		
		
	}
}
