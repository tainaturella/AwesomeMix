import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class JanelaAdicionarMusica extends JFrame {
	private JTextField txtNomeMusica;
	private JTextField txtArtista;
	private JTextField txtAlbum;
	private JPanel contentPane;;
	
	public JanelaAdicionarMusica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDaMusica = new JLabel("Nome da Musica");
		lblNomeDaMusica.setBounds(24, 26, 104, 16);
		getContentPane().add(lblNomeDaMusica);
		
		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setBounds(24, 95, 61, 16);
		getContentPane().add(lblAlbum);
		
		JLabel lblArtista = new JLabel("Artista");
		lblArtista.setBounds(24, 60, 61, 16);
		getContentPane().add(lblArtista);
		
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
		
		JButton btnAdicionarMusica = new JButton("Adicionar Musica");
		btnAdicionarMusica.setBounds(57, 159, 139, 29);
		getContentPane().add(btnAdicionarMusica);
		
		JButton btnAdicionarAlbum = new JButton("Adicionar Album");
		btnAdicionarAlbum.setBounds(249, 159, 134, 29);
		getContentPane().add(btnAdicionarAlbum);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(171, 217, 90, 29);
		getContentPane().add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JanelaPlaylist().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
	}
}
