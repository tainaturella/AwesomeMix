import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Font;

public class JanelaAdicionarMusica extends JFrame {
	private JTextField txtNomeMusica;
	private JTextField txtArtista;
	private JTextField txtAlbum;
	private JPanel contentPane;;
	
	public JanelaAdicionarMusica() {
		setTitle("M\u00FAsica - AwesomeMix");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDaMusica = new JLabel("Nome da M\u00FAsica");
		lblNomeDaMusica.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomeDaMusica.setBounds(22, 70, 96, 16);
		getContentPane().add(lblNomeDaMusica);
		
		JLabel lblAlbum = new JLabel("\u00C1lbum");
		lblAlbum.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAlbum.setBounds(22, 156, 61, 16);
		getContentPane().add(lblAlbum);
		
		JLabel lblArtista = new JLabel("Artista");
		lblArtista.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblArtista.setBounds(22, 111, 61, 16);
		getContentPane().add(lblArtista);
		
		txtNomeMusica = new JTextField();
		txtNomeMusica.setBounds(117, 64, 134, 28);
		getContentPane().add(txtNomeMusica);
		txtNomeMusica.setColumns(10);
		
		txtArtista = new JTextField();
		txtArtista.setBounds(117, 105, 134, 28);
		getContentPane().add(txtArtista);
		txtArtista.setColumns(10);
		
		txtAlbum = new JTextField();
		txtAlbum.setBounds(117, 150, 134, 28);
		getContentPane().add(txtAlbum);
		txtAlbum.setColumns(10);
		
		JButton btnAdicionarMusica = new JButton("ADICIONAR M\u00DASICA");
		btnAdicionarMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionarMusica.setBounds(272, 70, 139, 29);
		getContentPane().add(btnAdicionarMusica);
		
		JButton btnAdicionarAlbum = new JButton("ADICIONAR \u00C1LBUM");
		btnAdicionarAlbum.setBounds(272, 105, 139, 29);
		getContentPane().add(btnAdicionarAlbum);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(10, 221, 90, 29);
		getContentPane().add(btnVoltar);
		
		JLabel lblMusica = new JLabel("M\u00FAsica");
		lblMusica.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMusica.setBounds(10, 24, 68, 14);
		contentPane.add(lblMusica);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(272, 141, 139, 29);
		contentPane.add(btnLimpar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JanelaPlaylist().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
	}
}
