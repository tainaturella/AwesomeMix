import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class JanelaPlaylist extends JFrame {

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
	public JanelaPlaylist() {
		setTitle("Playlist - AwesomeMix");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Playlist");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(10, 11, 73, 14);
		contentPane.add(lblTitulo);
		
		String nomePlaylist;
		
		if(BaseDeDados.shared.tipoPlaylist == TipoPlaylist.PUBLICA) {
			nomePlaylist = BaseDeDados.shared.usuarios.get(BaseDeDados.shared.usuario_logado).getPlayListsPublicas().get(BaseDeDados.shared.playList_atual).getPlayListPublica().getNome();
		}else {
			nomePlaylist = BaseDeDados.shared.usuarios.get(BaseDeDados.shared.usuario_logado).getPlayListsPrivadas().get(BaseDeDados.shared.playList_atual).getNome();
		}
		
		JLabel lblNome = new JLabel(nomePlaylist);
		lblNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNome.setBounds(73, 11, 302, 14);
		contentPane.add(lblNome);
		
		final DefaultListModel<String> listMusicas = new DefaultListModel<String>();
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

		final JList<String> listaMusicas = new JList<String>(listMusicas);
		//listaMusicas.setBounds(10, 54, 180, 162);
		listaMusicas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaMusicas.setLayoutOrientation(JList.VERTICAL);
		JScrollPane listaMusicasScroll = new JScrollPane(listaMusicas);
		listaMusicasScroll.setBounds(39, 54, 180, 162);
		contentPane.add(listaMusicasScroll);
		
		JLabel lblMusicas = new JLabel("M\u00FAsicas");
		lblMusicas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMusicas.setBounds(39, 36, 55, 14);
		contentPane.add(lblMusicas);
		
		JButton btnAdicionarmusica = new JButton("ADICIONAR M\u00DASICA");
		btnAdicionarmusica.setBounds(239, 57, 136, 23);
		contentPane.add(btnAdicionarmusica);
		
		btnAdicionarmusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new JanelaAdicionarMusica().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		JButton btnRemoverMusica = new JButton("REMOVER M\u00DASICA");
		btnRemoverMusica.setBounds(239, 91, 136, 23);
		contentPane.add(btnRemoverMusica);
		
		btnRemoverMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(contentPane, "Deseja remover esta música?", "Confirmação", dialogButton);
				if(dialogResult == 0) {
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
										JOptionPane.showMessageDialog (null, "Música excluída com sucesso!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
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
										JOptionPane.showMessageDialog (null, "Música excluída com sucesso!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
									
									}
								}
							}	
						}
					}
				}
			}
		});
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(5, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		
		
		listaMusicas.addMouseListener(new MouseAdapter() {
			ArrayList<MusicaPlayListPublica> listaMusica = BaseDeDados.shared.usuarios.get(BaseDeDados.shared.usuario_logado).getPlayListsPublicas().get(BaseDeDados.shared.playList_atual).getPlayListPublica().getListaMusicas();
			public void mouseClicked(MouseEvent evt) {
				int index = listaMusicas.getSelectedIndex();
			    if (evt.getClickCount() == 2) {
				      BaseDeDados.shared.musicaAtual = listaMusica.get(index).getMusica();
				      //System.out.println("nome da musica " + listaMusica.get(index).getMusica().getNomeMusica());
				      new JanelaPropriedadesMusica().setVisible(true);
				      setVisible(false);
				      dispose();
			    }
			  }
			});
	
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JanelaMeuPerfil().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
	}
}
