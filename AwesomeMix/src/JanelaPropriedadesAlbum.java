import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
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
		setTitle("Informa\u00E7\u00F5es - AwesomeMix");
		setSize(700, 500); //tamanho da janela
		setLocationRelativeTo(null); //centraliza janela
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(204, 153, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//labels
		JLabel lblTitulo = new JLabel("Informacoes do Album");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setBounds(94, 41, 304, 20);
		contentPane.add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("logop.png"));
		lblNewLabel.setBounds(10, 11, 74, 88);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(88, 91, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblArtista = new JLabel("Artista");
		lblArtista.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblArtista.setBounds(88, 134, 46, 14);
		contentPane.add(lblArtista);
		
		JLabel lblQuantidadeDeMusicas = new JLabel("Quantidade de Musicas");
		lblQuantidadeDeMusicas.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQuantidadeDeMusicas.setBounds(354, 265, 168, 14);
		contentPane.add(lblQuantidadeDeMusicas);
		
		JLabel lblAnoDeLancamento = new JLabel("Lancamento");
		lblAnoDeLancamento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAnoDeLancamento.setBounds(88, 205, 79, 20);
		contentPane.add(lblAnoDeLancamento);
		
		JLabel lblEstiloMusical = new JLabel("Estilo Musical");
		lblEstiloMusical.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstiloMusical.setBounds(88, 176, 97, 14);
		contentPane.add(lblEstiloMusical);
		
		JLabel lblAvaliacao = new JLabel("Avaliacao");
		lblAvaliacao.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAvaliacao.setBounds(88, 244, 69, 14);
		contentPane.add(lblAvaliacao);
		
		//text field
		Album album = BaseDeDados.shared.musicaAtual.getAlbum();
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setText(""+album.getNomeAlbum());
		txtNome.setBounds(194, 89, 122, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtArtista = new JTextField();
		txtArtista.setEditable(false);
		txtArtista.setText("" + album.getArtista());
		txtArtista.setBounds(194, 132, 120, 20);
		contentPane.add(txtArtista);
		txtArtista.setColumns(10);
		
		txtEstilomusical = new JTextField();
		txtEstilomusical.setEditable(false);
		txtEstilomusical.setText(""+album.getEstiloMusical());
		txtEstilomusical.setBounds(194, 174, 86, 20);
		contentPane.add(txtEstilomusical);
		txtEstilomusical.setColumns(10);
		
		txtQuantidademusicas = new JTextField();
		txtQuantidademusicas.setEditable(false);
		txtQuantidademusicas.setText("" + album.getQtdMusicas());
		txtQuantidademusicas.setBounds(517, 263, 26, 20);
		contentPane.add(txtQuantidademusicas);
		txtQuantidademusicas.setColumns(10);
		
		txtAnolancamento = new JTextField();
		txtAnolancamento.setEditable(false);
		txtAnolancamento.setText(""+ album.getAnoLancamento());
		txtAnolancamento.setBounds(194, 206, 32, 20);
		contentPane.add(txtAnolancamento);
		txtAnolancamento.setColumns(10);
		
		txtAvaliacao = new JTextField();
		txtAvaliacao.setEditable(false);
		txtAvaliacao.setBounds(194, 245, 32, 20);
		txtAvaliacao.setText("" + Double.toString(album.getAvaliacao()));
		contentPane.add(txtAvaliacao);
		txtAvaliacao.setColumns(10);
		
		JLabel lblMusicasDoAlbum = new JLabel("Musicas do Album");
		lblMusicasDoAlbum.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMusicasDoAlbum.setBounds(354, 73, 145, 14);
		contentPane.add(lblMusicasDoAlbum);
		
		DefaultListModel <String>  listaStrMusicas = new DefaultListModel<String>();
		for(int i = 0; i < album.getMusicas().size(); i++){
			listaStrMusicas.addElement(album.getMusicas().get(i).getNomeMusica());
		} 
		JList<String> listaMusicas = new JList<String>(listaStrMusicas);
		listaMusicas.setBounds(372, 90, 207, 159);
		listaMusicas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaMusicas.setLayoutOrientation(JList.VERTICAL);
		//JScrollPane listaMusicasScroll = new JScrollPane(listaMusicas);
		//contentPane.add(listaMusicasScroll);
		contentPane.add(listaMusicas);
		
		
		

		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(25, 367, 89, 23);
		contentPane.add(btnVoltar);
		
		//listeners
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JanelaPlaylist().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
	}
}
