import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class JanelaAdicionarMusica extends JFrame {
	private JTextField txtNomeMusica;
	private JTextField txtArtista;
	private JTextField txtAlbum;
	private JPanel contentPane;
	private JTextField txtAno;
	private JTextField txtDuracao;;

	public JanelaAdicionarMusica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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

		JLabel lblNomeDaMusica = new JLabel("Nome da Musica");
		lblNomeDaMusica.setBounds(24, 26, 104, 16);
		getContentPane().add(lblNomeDaMusica);

		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setBounds(24, 95, 61, 16);
		getContentPane().add(lblAlbum);

		JLabel lblArtista = new JLabel("Artista");
		lblArtista.setBounds(24, 60, 61, 16);
		getContentPane().add(lblArtista);

		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(24, 131, 61, 16);
		contentPane.add(lblAno);

		JLabel lblEstiloMusical = new JLabel("Estilo Musical");
		lblEstiloMusical.setBounds(24, 174, 90, 16);
		contentPane.add(lblEstiloMusical);

		txtNomeMusica = new JTextField();
		txtNomeMusica.setBounds(140, 20, 134, 28);
		getContentPane().add(txtNomeMusica);
		txtNomeMusica.setColumns(10);

		txtArtista = new JTextField();
		txtArtista.setBounds(140, 54, 134, 28);
		getContentPane().add(txtArtista);
		txtArtista.setColumns(10);

		txtAlbum = new JTextField();
		txtAlbum.setBounds(140, 89, 134, 28);
		getContentPane().add(txtAlbum);
		txtAlbum.setColumns(10);

		txtAno = new JTextField();
		txtAno.setBounds(140, 125, 134, 28);
		contentPane.add(txtAno);
		txtAno.setColumns(10);

		String[] estilosMusicais = { "Jazz", "Folk", "Gospel", "Samba", "Rap", "Reggae", "Rock", "MPB", "Funk", "Sertanejo", "Axe", "Forro", "Frevo", "Pagode", "Soul", "POP", "Classico", "Blues", "Indie", "Eletronico" };

		JComboBox comboBox = new JComboBox(estilosMusicais);
		comboBox.setBounds(140, 170, 134, 27);
		contentPane.add(comboBox);

		JLabel lblDurao = new JLabel("Duração");
		lblDurao.setBounds(296, 26, 61, 16);
		contentPane.add(lblDurao);

		txtDuracao = new JTextField();
		txtDuracao.setBounds(370, 20, 61, 28);
		contentPane.add(txtDuracao);
		txtDuracao.setColumns(10);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(171, 243, 90, 29);
		getContentPane().add(btnVoltar);



		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JanelaPlaylist().setVisible(true);
				setVisible(false);
				dispose();
			}
		});

		JButton btnAdicionarMusica = new JButton("Adicionar Musica");
		btnAdicionarMusica.setBounds(54, 202, 139, 29);
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

			}
		});


		JButton btnAdicionarAlbum = new JButton("Adicionar Album");
		btnAdicionarAlbum.setBounds(248, 202, 134, 29);
		getContentPane().add(btnAdicionarAlbum);

		btnAdicionarAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String album = txtAlbum.getText();
				String artista = txtArtista.getText();
				if(album.equals("") || artista.equals("")) {
					System.out.println("Você Deve Preencher corretamente os capos");
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

				System.out.println("Esse album não contem nenhuma musica");		
			}
		});



	}
}
