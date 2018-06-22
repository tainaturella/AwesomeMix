import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;

public class JanelaPlaylist extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public JanelaPlaylist() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		System.out.println(BaseDeDados.shared.tipoPlaylist);
		
		JLabel lblTitulo = new JLabel("Playlist");
		lblTitulo.setBounds(10, 11, 46, 14);
		contentPane.add(lblTitulo);
		
		String nomePlaylist;
		
		if(BaseDeDados.shared.tipoPlaylist == TipoPlaylist.PUBLICA) {
			nomePlaylist = BaseDeDados.shared.usuarios.get(BaseDeDados.shared.usuario_logado).getPlayListsPublicas().get(BaseDeDados.shared.playList_atual).getPlayListPublica().getNome();
		}else {
			nomePlaylist = BaseDeDados.shared.usuarios.get(BaseDeDados.shared.usuario_logado).getPlayListsPrivadas().get(BaseDeDados.shared.playList_atual).getNome();
		}
		
		JLabel lblNome = new JLabel(nomePlaylist);
		lblNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNome.setBounds(48, 11, 46, 14);
		contentPane.add(lblNome);
		
		DefaultListModel<String> listMusicas = new DefaultListModel<String>();
		if(BaseDeDados.shared.tipoPlaylist == TipoPlaylist.PUBLICA) {
			ArrayList<MusicaPlayListPublica> listaMusica = BaseDeDados.shared.usuarios.get(BaseDeDados.shared.usuario_logado).getPlayListsPublicas().get(BaseDeDados.shared.playList_atual).getPlayListPublica().getListaMusicas();
			for(int i=0; i< listaMusica.size(); i++) {
				String nomeMusica = listaMusica.get(i).getMusica().getNomeMusica();
				String albulMusica = listaMusica.get(i).getMusica().getAlbum().getNomeAlbum();
				String artistaMusica = listaMusica.get(i).getMusica().getAlbum().getArtista();
				
				listMusicas.addElement(nomeMusica + "-" + albulMusica + "-" + artistaMusica);
			}
		}else {
			ArrayList<MusicaPlayListPrivada> listaMusica = BaseDeDados.shared.usuarios.get(BaseDeDados.shared.usuario_logado).getPlayListsPrivadas().get(BaseDeDados.shared.playList_atual).getListaMusicas();
			for(int i=0; i< listaMusica.size(); i++) {
				String nomeMusica = listaMusica.get(i).getMusica().getNomeMusica();
				String albulMusica = listaMusica.get(i).getMusica().getAlbum().getNomeAlbum();
				String artistaMusica = listaMusica.get(i).getMusica().getAlbum().getArtista();
				
				listMusicas.addElement(nomeMusica + "-" + albulMusica + "-" + artistaMusica);
			}
		}

		JList<String> listaMusicas = new JList<String>(listMusicas);
		//listaMusicas.setBounds(10, 54, 180, 162);
		listaMusicas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaMusicas.setLayoutOrientation(JList.VERTICAL);
		JScrollPane listaMusicasScroll = new JScrollPane(listaMusicas);
		listaMusicasScroll.setBounds(10, 54, 180, 162);
		contentPane.add(listaMusicasScroll);
		
		JLabel lblMusicas = new JLabel("Musicas");
		lblMusicas.setBounds(20, 36, 46, 14);
		contentPane.add(lblMusicas);
		
		JButton btnAdicionarmusica = new JButton("AdicionarMusica");
		btnAdicionarmusica.setBounds(210, 57, 131, 23);
		contentPane.add(btnAdicionarmusica);
		
		btnAdicionarmusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new JanelaAdicionarMusica().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		JButton btnRemoverMusica = new JButton("Remover Musica");
		btnRemoverMusica.setBounds(210, 91, 131, 23);
		contentPane.add(btnRemoverMusica);
		
		btnRemoverMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String string = listMusicas.get(listaMusicas.getSelectedIndex()); 
				String[] parts = string.split("-");
				String nome = parts[0];
				String album = parts[1];
				String artista = parts[2];
				
				if(BaseDeDados.shared.tipoPlaylist == TipoPlaylist.PUBLICA) {
					ArrayList<MusicaPlayListPublica> listaMusica = BaseDeDados.shared.usuarios.get(BaseDeDados.shared.usuario_logado).getPlayListsPublicas().get(BaseDeDados.shared.playList_atual).getPlayListPublica().getListaMusicas();
					PlayListPublica playList = BaseDeDados.shared.usuarios.get(BaseDeDados.shared.usuario_logado).getPlayListsPublicas().get(BaseDeDados.shared.playList_atual).getPlayListPublica();
					
					for(int i=0; i< listaMusica.size(); i++) {
						Musica musica = BaseDeDados.shared.usuarios.get(BaseDeDados.shared.usuario_logado).getPlayListsPublicas().get(BaseDeDados.shared.playList_atual).getPlayListPublica().getMusicas().get(i).getMusica();
						System.out.println(musica.getNomeMusica() + "\n");
						if(listaMusica.get(i).getMusica().getNomeMusica().equals(nome)) {
							if(listaMusica.get(i).getMusica().getAlbum().getNomeAlbum().equals(album)) {
								if(listaMusica.get(i).getMusica().getAlbum().getArtista().equals(artista)) {
									playList.removerMusica(musica);
									listMusicas.remove(listaMusicas.getSelectedIndex());
									
									
								}
							}
						}	
					}
				}else {
					ArrayList<MusicaPlayListPrivada> listaMusica = BaseDeDados.shared.usuarios.get(BaseDeDados.shared.usuario_logado).getPlayListsPrivadas().get(BaseDeDados.shared.playList_atual).getListaMusicas();
					PlayListPrivada playList = BaseDeDados.shared.usuarios.get(BaseDeDados.shared.usuario_logado).getPlayListsPrivadas().get(BaseDeDados.shared.playList_atual);
					
					for(int i=0; i< listaMusica.size(); i++) {
						Musica musica = listaMusica.get(i).getMusica();
						System.out.println(musica.getNomeMusica() + "\n");
						if(listaMusica.get(i).getMusica().getNomeMusica().equals(nome)) {
							if(listaMusica.get(i).getMusica().getAlbum().getNomeAlbum().equals(album)) {
								if(listaMusica.get(i).getMusica().getAlbum().getArtista().equals(artista)) {
									playList.removerMusica(musica);
									listMusicas.remove(listaMusicas.getSelectedIndex());
									
									
								}
							}
						}	
					}
				}
			}
		});
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(5, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new JanelaMeuPerfil().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
	}
}
