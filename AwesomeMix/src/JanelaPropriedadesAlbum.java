import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//labels
		JLabel lblTitulo = new JLabel("Informa\u00E7\u00F5es do \u00C1lbum");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(10, 11, 197, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(27, 58, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblArtista = new JLabel("Artista");
		lblArtista.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblArtista.setBounds(27, 83, 46, 14);
		contentPane.add(lblArtista);
		
		JLabel lblQuantidadeDeMusicas = new JLabel("Quantidade de M\u00FAsicas");
		lblQuantidadeDeMusicas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuantidadeDeMusicas.setBounds(220, 187, 135, 14);
		contentPane.add(lblQuantidadeDeMusicas);
		
		JLabel lblAnoDeLancamento = new JLabel("Lan\u00E7amento");
		lblAnoDeLancamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAnoDeLancamento.setBounds(27, 130, 79, 20);
		contentPane.add(lblAnoDeLancamento);
		
		JLabel lblEstiloMusical = new JLabel("Estilo Musical");
		lblEstiloMusical.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstiloMusical.setBounds(27, 108, 79, 14);
		contentPane.add(lblEstiloMusical);
		
		JLabel lblAvaliacao = new JLabel("Avalia\u00E7\u00E3o");
		lblAvaliacao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAvaliacao.setBounds(27, 161, 69, 14);
		contentPane.add(lblAvaliacao);
		
		//text field
		Album album = BaseDeDados.shared.musicaAtual.getAlbum();
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setText(""+album.getNomeAlbum());
		txtNome.setBounds(70, 51, 122, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtArtista = new JTextField();
		txtArtista.setEditable(false);
		txtArtista.setText("" + album.getArtista());
		txtArtista.setBounds(70, 80, 120, 20);
		contentPane.add(txtArtista);
		txtArtista.setColumns(10);
		
		txtEstilomusical = new JTextField();
		txtEstilomusical.setEditable(false);
		txtEstilomusical.setText(""+album.getEstiloMusical());
		txtEstilomusical.setBounds(106, 105, 86, 20);
		contentPane.add(txtEstilomusical);
		txtEstilomusical.setColumns(10);
		
		txtQuantidademusicas = new JTextField();
		txtQuantidademusicas.setEditable(false);
		txtQuantidademusicas.setText("" + album.getQtdMusicas());
		txtQuantidademusicas.setBounds(358, 184, 26, 20);
		contentPane.add(txtQuantidademusicas);
		txtQuantidademusicas.setColumns(10);
		
		txtAnolancamento = new JTextField();
		txtAnolancamento.setEditable(false);
		txtAnolancamento.setText(""+ album.getAnoLancamento());
		txtAnolancamento.setBounds(106, 130, 32, 20);
		contentPane.add(txtAnolancamento);
		txtAnolancamento.setColumns(10);
		
		txtAvaliacao = new JTextField();
		txtAvaliacao.setEditable(false);
		txtAvaliacao.setBounds(106, 158, 32, 20);
		txtAvaliacao.setText("" + Double.toString(album.getAvaliacao()));
		contentPane.add(txtAvaliacao);
		txtAvaliacao.setColumns(10);
		
		JLabel lblMusicasDoAlbum = new JLabel("M\u00FAsicas do \u00C1lbum");
		lblMusicasDoAlbum.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMusicasDoAlbum.setBounds(220, 51, 107, 14);
		contentPane.add(lblMusicasDoAlbum);
		
		DefaultListModel <String>  listaStrMusicas = new DefaultListModel<String>();
		for(int i = 0; i < album.getMusicas().size(); i++){
			listaStrMusicas.addElement(album.getMusicas().get(i).getNomeMusica());
		} 
		JList<String> listaMusicas = new JList<String>(listaStrMusicas);
		listaMusicas.setBounds(238, 68, 186, 112);
		listaMusicas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaMusicas.setLayoutOrientation(JList.VERTICAL);
		//JScrollPane listaMusicasScroll = new JScrollPane(listaMusicas);
		//contentPane.add(listaMusicasScroll);
		contentPane.add(listaMusicas);
		
		
		

		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(10, 227, 89, 23);
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
