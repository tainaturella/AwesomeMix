import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTabbedPane;

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
		
		JLabel lblTitulo = new JLabel("Playlist");
		lblTitulo.setBounds(10, 11, 46, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNome.setBounds(48, 11, 46, 14);
		contentPane.add(lblNome);
		
		JList listMusicas = new JList();
		listMusicas.setBounds(10, 54, 180, 162);
		contentPane.add(listMusicas);
		
		JLabel lblMusicas = new JLabel("Musicas");
		lblMusicas.setBounds(20, 36, 46, 14);
		contentPane.add(lblMusicas);
		
		JButton btnAdicionarmusica = new JButton("AdicionarMusica");
		btnAdicionarmusica.setBounds(210, 57, 131, 23);
		contentPane.add(btnAdicionarmusica);
		
		JButton btnRemoverMusica = new JButton("Remover Musica");
		btnRemoverMusica.setBounds(210, 91, 131, 23);
		contentPane.add(btnRemoverMusica);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(5, 227, 89, 23);
		contentPane.add(btnVoltar);
	}
}
