import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class JanelaAdicionarMusica extends JFrame {
	/**
	 * 
	 */
	private JTextField txtNomeMusica;
	private JTextField txtArtista;
	private JTextField txtAlbum;
	private JPanel contentPane;
	private JTextField txtAno;
	private JTextField txtDuracao;;

	public JanelaAdicionarMusica() {
		setTitle("M\u00FAsica - AwesomeMix");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Usuario usuario = BaseDeDados.shared.usuarios.get(BaseDeDados.shared.usuario_logado);

		TipoPlaylist tipoPlaylist;
		if(BaseDeDados.shared.tipoPlaylist == TipoPlaylist.PUBLICA) {
			tipoPlaylist = TipoPlaylist.PUBLICA;
		}else {
			tipoPlaylist = TipoPlaylist.PRIVADA;
		}

		JLabel lblNomeDaMusica = new JLabel("Nome da Música");
		lblNomeDaMusica.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomeDaMusica.setBounds(22, 71, 96, 16);
		getContentPane().add(lblNomeDaMusica);

		JLabel lblAlbum = new JLabel("Álbum");
		lblAlbum.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAlbum.setBounds(22, 138, 61, 16);
		getContentPane().add(lblAlbum);

		JLabel lblArtista = new JLabel("Artista");
		lblArtista.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblArtista.setBounds(22, 104, 61, 16);
		getContentPane().add(lblArtista);

		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAno.setBounds(270, 104, 30, 16);
		contentPane.add(lblAno);

		JLabel lblEstiloMusical = new JLabel("Estilo Musical");
		lblEstiloMusical.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstiloMusical.setBounds(270, 71, 90, 16);
		contentPane.add(lblEstiloMusical);

		txtNomeMusica = new JTextField();
		txtNomeMusica.setBounds(117, 65, 134, 28);
		getContentPane().add(txtNomeMusica);
		txtNomeMusica.setColumns(10);

		txtArtista = new JTextField();
		txtArtista.setBounds(117, 98, 134, 28);
		getContentPane().add(txtArtista);
		txtArtista.setColumns(10);

		txtAlbum = new JTextField();
		txtAlbum.setBounds(117, 131, 134, 28);
		getContentPane().add(txtAlbum);
		txtAlbum.setColumns(10);		
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(10, 250, 90, 29);
		getContentPane().add(btnVoltar);
		
		JLabel lblMusica = new JLabel("Música");
		lblMusica.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMusica.setBounds(10, 11, 68, 14);
		contentPane.add(lblMusica);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(328, 250, 105, 29);
		contentPane.add(btnLimpar);
		
		

		txtAno = new JTextField();
		txtAno.setBounds(354, 98, 79, 28);
		contentPane.add(txtAno);
		txtAno.setColumns(10);

		String[] estilosMusicais = { "Jazz", "Folk", "Gospel", "Samba", "Rap", "Reggae", "Rock", "MPB", "Funk", "Sertanejo", "Axe", "Forro", "Frevo", "Pagode", "Soul", "POP", "Classico", "Blues", "Indie", "Eletronico" };

		JComboBox comboBox = new JComboBox(estilosMusicais);
		comboBox.setBounds(354, 66, 79, 27);
		contentPane.add(comboBox);

		JLabel lblDurao = new JLabel("Duração");
		lblDurao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDurao.setBounds(270, 138, 61, 16);
		contentPane.add(lblDurao);

		txtDuracao = new JTextField();
		txtDuracao.setBounds(354, 132, 79, 28);
		contentPane.add(txtDuracao);
		txtDuracao.setColumns(10);

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JanelaPlaylist().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNomeMusica.setText("");
				txtAlbum.setText("");
				txtArtista.setText("");
				txtDuracao.setText("");
				txtAno.setText("");
				comboBox.setSelectedIndex(0);
			}
		});

		JButton btnAdicionarMusica = new JButton("ADICIONAR MÚSICA");
		btnAdicionarMusica.setBounds(72, 188, 139, 29);
		getContentPane().add(btnAdicionarMusica);

		btnAdicionarMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				String nome = txtNomeMusica.getText();
				String album = txtAlbum.getText();
				String artista = txtArtista.getText();
				double tempoDuracao = Double.parseDouble(txtDuracao.getText());
				int ano = Integer.parseInt(txtAno.getText());
				EstilosMusicais estiloMusical = EstilosMusicais.values()[comboBox.getSelectedIndex()];

				if(nome.equals("") || album.equals("") || artista.equals("")) {
					System.out.println("Voce deve preencher todos os campos");
					return;
				}

				ArrayList<Album> albums = BaseDeDados.shared.albums;
				for(int i=0; i < albums.size(); i++) {
					if(albums.get(i).getNomeAlbum().equals(album) && albums.get(i).getArtista().equals(artista)) {
						Musica musica = new Musica(nome, tempoDuracao, albums.get(i));
						if(!BaseDeDados.shared.musicas.contains(musica)) {
							BaseDeDados.shared.musicas.add(musica);
						}
						if(tipoPlaylist == TipoPlaylist.PUBLICA) {
							usuario.adicionaMusicaPlayList(musica, usuario.getPlayListsPublicas().get(BaseDeDados.shared.playList_atual).getPlayListPublica());
							new JanelaPlaylist().setVisible(true);
							setVisible(false);
							dispose();
							return;
						}else {
							usuario.adicionaMusicaPlayList(musica, usuario.getPlayListsPrivadas().get(BaseDeDados.shared.playList_atual));
							new JanelaPlaylist().setVisible(true);
							setVisible(false);
							dispose();
							return;
						}
					}
				}

				Album album1 = new Album(album, artista, ano, estiloMusical);
				Musica musica = new Musica(nome, tempoDuracao, album1);
				BaseDeDados.shared.albums.add(album1);
				BaseDeDados.shared.musicas.add(musica);
				if(tipoPlaylist == TipoPlaylist.PUBLICA) {
					usuario.adicionaMusicaPlayList(musica, usuario.getPlayListsPublicas().get(BaseDeDados.shared.playList_atual).getPlayListPublica());
					new JanelaPlaylist().setVisible(true);
					setVisible(false);
					dispose();
					return;
				}else {
					usuario.adicionaMusicaPlayList(musica, usuario.getPlayListsPrivadas().get(BaseDeDados.shared.playList_atual));
					new JanelaPlaylist().setVisible(true);
					setVisible(false);
					dispose();
					return;
				}
				JOptionPane.showMessageDialog (null, "Música foi adicionada com sucesso!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);

			}
		});


		JButton btnAdicionarAlbum = new JButton("ADICIONAR ÁLBUM");
		btnAdicionarAlbum.setBounds(236, 188, 139, 29);
		getContentPane().add(btnAdicionarAlbum);

		btnAdicionarAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String album = txtAlbum.getText();
				String artista = txtArtista.getText();
				if(album.equals("") || artista.equals("")) {
					System.out.println("VocÃª Deve Preencher corretamente os capos");
					return;
				}

				ArrayList<Album> albums = BaseDeDados.shared.albums;
				for(int i=0; i < albums.size(); i++) {
					if(albums.get(i).getNomeAlbum().equals(album) && albums.get(i).getArtista().equals(artista)) {
						if(tipoPlaylist == TipoPlaylist.PUBLICA) {
							usuario.adicionaAlbumPlaylist(albums.get(i), usuario.getPlayListsPublicas().get(BaseDeDados.shared.playList_atual).getPlayListPublica());
							new JanelaPlaylist().setVisible(true);
							setVisible(false);
							dispose();
							return;
						}else {
							usuario.adicionaAlbumPlaylist(albums.get(i), usuario.getPlayListsPrivadas().get(BaseDeDados.shared.playList_atual));
							new JanelaPlaylist().setVisible(true);
							setVisible(false);
							dispose();
							return;

						}
					}
				}
				JOptionPane.showMessageDialog (null, "Álbum foi criado com sucesso!!Adicione músicas!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				System.out.println("Esse album não contém nenhuma música");		
			}
		});



	}
}
