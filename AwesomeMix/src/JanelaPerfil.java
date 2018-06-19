import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;

public class JanelaPerfil extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JanelaPerfil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Perfil de");
		lblTitulo.setBounds(10, 11, 46, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(51, 11, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setBounds(10, 36, 46, 14);
		contentPane.add(lblNome_1);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(61, 36, 46, 14);
		contentPane.add(lblIdade);
		
		JLabel lblPlaylists = new JLabel("Playlists");
		lblPlaylists.setBounds(10, 61, 46, 14);
		contentPane.add(lblPlaylists);
		
		JList list = new JList();
		list.setBounds(10, 86, 161, 77);
		contentPane.add(list);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 227, 89, 23);
		contentPane.add(btnVoltar);
	}

}
