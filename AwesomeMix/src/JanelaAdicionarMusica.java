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

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.ImageIcon;

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
	private JTextField txtDuracao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCadastro frame = new JanelaCadastro();
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

	public JanelaAdicionarMusica() {
		setResizable(false);
		this.setSize(700, 500); //tamanho da janela
		setLocationRelativeTo(null); //centraliza janela
		setTitle("Musica - AwesomeMix");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 459, 329);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final Usuario usuario = BaseDeDados.shared.usuarios.get(BaseDeDados.shared.usuario_logado);

		final TipoPlaylist tipoPlaylist;
		if(BaseDeDados.shared.tipoPlaylist == TipoPlaylist.PUBLICA) {
			tipoPlaylist = TipoPlaylist.PUBLICA;
		}else {
			tipoPlaylist = TipoPlaylist.PRIVADA;
		}

		JLabel lblNomeDaMusica = new JLabel("Nome da Musica");
		lblNomeDaMusica.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomeDaMusica.setBounds(53, 125, 114, 16);
		getContentPane().add(lblNomeDaMusica);

		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAlbum.setBounds(53, 192, 61, 16);
		getContentPane().add(lblAlbum);

		JLabel lblArtista = new JLabel("Artista");
		lblArtista.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblArtista.setBounds(53, 158, 61, 16);
		getContentPane().add(lblArtista);

		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAno.setBounds(399, 157, 30, 16);
		contentPane.add(lblAno);

		JLabel lblEstiloMusical = new JLabel("Estilo Musical");
		lblEstiloMusical.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstiloMusical.setBounds(399, 124, 90, 16);
		contentPane.add(lblEstiloMusical);

		txtNomeMusica = new JTextField();
		txtNomeMusica.setBounds(164, 120, 201, 28);
		getContentPane().add(txtNomeMusica);
		txtNomeMusica.setColumns(10);

		txtArtista = new JTextField();
		txtArtista.setBounds(164, 152, 201, 28);
		getContentPane().add(txtArtista);
		txtArtista.setColumns(10);

		txtAlbum = new JTextField();
		txtAlbum.setBounds(164, 186, 201, 28);
		getContentPane().add(txtAlbum);
		txtAlbum.setColumns(10);		
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(28, 362, 90, 29);
		getContentPane().add(btnVoltar);
		
		JLabel lblMusica = new JLabel("Musica");
		lblMusica.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMusica.setBounds(94, 34, 125, 27);
		contentPane.add(lblMusica);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(540, 362, 105, 29);
		contentPane.add(btnLimpar);
		
		

		txtAno = new JTextField();
		txtAno.setBounds(497, 151, 79, 28);
		contentPane.add(txtAno);
		txtAno.setColumns(10);

		String[] estilosMusicais = { "Jazz", "Folk", "Gospel", "Samba", "Rap", "Reggae", "Rock", "MPB", "Funk", "Sertanejo", "Axe", "Forro", "Frevo", "Pagode", "Soul", "POP", "Classico", "Blues", "Indie", "Eletronico" };

		JComboBox<?> comboBox = new JComboBox<Object>(estilosMusicais);
		comboBox.setBounds(497, 120, 79, 27);
		contentPane.add(comboBox);

		JLabel lblDurao = new JLabel("Duracao");
		lblDurao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDurao.setBounds(399, 191, 61, 16);
		contentPane.add(lblDurao);

		txtDuracao = new JTextField();
		txtDuracao.setBounds(497, 185, 79, 28);
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

		JButton btnAdicionarMusica = new JButton("ADICIONAR MUSICA");
		btnAdicionarMusica.setBounds(108, 259, 139, 29);
		getContentPane().add(btnAdicionarMusica);

		btnAdicionarMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				String nome = txtNomeMusica.getText();
				String album = txtAlbum.getText();
				String artista = txtArtista.getText();
				double tempoDuracao = Double.parseDouble(txtDuracao.getText());
				int ano = Integer.parseInt(txtAno.getText());
				EstilosMusicais estiloMusical = EstilosMusicais.values()[comboBox.getSelectedIndex()];

				if(nome.equals("") || album.equals("") || artista.equals("") || txtDuracao.getText().equals("") ||txtAno.getText().equals("")) {
					System.out.println("Voce deve preencher todos os campos");
					return;
				}

				ArrayList<Album> albums = BaseDeDados.shared.albuns;
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
				BaseDeDados.shared.albuns.add(album1);
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


		JButton btnAdicionarAlbum = new JButton("ADICIONAR ALBUM");
		btnAdicionarAlbum.setBounds(399, 259, 139, 29);
		getContentPane().add(btnAdicionarAlbum);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("logop.png"));
		lblNewLabel.setBounds(10, 11, 74, 88);
		contentPane.add(lblNewLabel);

		btnAdicionarAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String album = txtAlbum.getText();
				String artista = txtArtista.getText();
				if(album.equals("") || artista.equals("") ) {
					System.out.println("Voce Deve Preencher corretamente os campos");
					return;
				}

				ArrayList<Album> albums = BaseDeDados.shared.albuns;
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
				JOptionPane.showMessageDialog (null, "Album foi criado com sucesso!!Adicione musicas!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				System.out.println("Esse album nao contwm nenhuma musica");		
			}
		});



	}
}
