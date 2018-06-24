import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

public class JanelaPropriedadesAlbum extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtArtista;
	private JTextField txtEstilomusical;
	private JTextField txtQuantidademusicas;
	private JTextField txtAnolancamento;
	private JTextField txtAvaliacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPropriedadesAlbum frame = new JanelaPropriedadesAlbum();
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
	public JanelaPropriedadesAlbum() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Informa\u00E7\u00F5es do \u00C1lbum");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(10, 11, 197, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 43, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setText("Nome");
		txtNome.setBounds(66, 40, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblArtista = new JLabel("Artista");
		lblArtista.setBounds(10, 68, 46, 14);
		contentPane.add(lblArtista);
		
		txtArtista = new JTextField();
		txtArtista.setText("Artista");
		txtArtista.setBounds(66, 65, 86, 20);
		contentPane.add(txtArtista);
		txtArtista.setColumns(10);
		
		JLabel lblQuantidadeDeMusicas = new JLabel("Quantidade de Musicas");
		lblQuantidadeDeMusicas.setBounds(180, 43, 128, 14);
		contentPane.add(lblQuantidadeDeMusicas);
		
		JLabel lblAnoDeLanamento = new JLabel("Ano de Lan\u00E7amento");
		lblAnoDeLanamento.setBounds(10, 127, 104, 14);
		contentPane.add(lblAnoDeLanamento);
		
		JLabel lblEstiloMusical = new JLabel("Estilo Musical");
		lblEstiloMusical.setBounds(10, 99, 70, 14);
		contentPane.add(lblEstiloMusical);
		
		txtEstilomusical = new JTextField();
		txtEstilomusical.setText("EstiloMusical");
		txtEstilomusical.setBounds(90, 96, 86, 20);
		contentPane.add(txtEstilomusical);
		txtEstilomusical.setColumns(10);
		
		txtQuantidademusicas = new JTextField();
		txtQuantidademusicas.setText("QuantidadeMusicas");
		txtQuantidademusicas.setBounds(304, 40, 86, 20);
		contentPane.add(txtQuantidademusicas);
		txtQuantidademusicas.setColumns(10);
		
		txtAnolancamento = new JTextField();
		txtAnolancamento.setText("AnoLancamento");
		txtAnolancamento.setBounds(111, 124, 86, 20);
		contentPane.add(txtAnolancamento);
		txtAnolancamento.setColumns(10);
		
		JLabel lblAvaliacao = new JLabel("Avaliacao");
		lblAvaliacao.setBounds(10, 193, 46, 14);
		contentPane.add(lblAvaliacao);
		
		txtAvaliacao = new JTextField();
		txtAvaliacao.setText("Avaliacao");
		txtAvaliacao.setBounds(66, 187, 86, 20);
		contentPane.add(txtAvaliacao);
		txtAvaliacao.setColumns(10);
		
		JButton btnAvaliarAlbum = new JButton("Avaliar Album");
		btnAvaliarAlbum.setBounds(180, 189, 114, 23);
		contentPane.add(btnAvaliarAlbum);
		
		JLabel lblMusicasDoAlbum = new JLabel("Musicas do Album");
		lblMusicasDoAlbum.setBounds(223, 68, 85, 14);
		contentPane.add(lblMusicasDoAlbum);
		
		JList list = new JList();
		list.setBounds(223, 93, 186, 82);
		contentPane.add(list);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 227, 89, 23);
		contentPane.add(btnVoltar);
	}
}
