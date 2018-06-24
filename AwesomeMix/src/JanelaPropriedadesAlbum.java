import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

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
		lblNome.setBounds(10, 43, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblArtista = new JLabel("Artista");
		lblArtista.setBounds(10, 68, 46, 14);
		contentPane.add(lblArtista);
		
		JLabel lblQuantidadeDeMusicas = new JLabel("Quantidade de Musicas");
		lblQuantidadeDeMusicas.setBounds(180, 43, 128, 14);
		contentPane.add(lblQuantidadeDeMusicas);
		
		JLabel lblAnoDeLanamento = new JLabel("Ano de Lan\u00E7amento");
		lblAnoDeLanamento.setBounds(10, 127, 104, 14);
		contentPane.add(lblAnoDeLanamento);
		
		JLabel lblEstiloMusical = new JLabel("Estilo Musical");
		lblEstiloMusical.setBounds(10, 99, 70, 14);
		contentPane.add(lblEstiloMusical);
		
		JLabel lblAvaliacao = new JLabel("Avaliacao");
		lblAvaliacao.setBounds(10, 193, 46, 14);
		contentPane.add(lblAvaliacao);
		
		//text field
		Album album = BaseDeDados.shared.musicaAtual.getAlbum();
		
		txtNome = new JTextField();
		txtNome.setText(""+album.getNomeAlbum());
		txtNome.setBounds(66, 40, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtArtista = new JTextField();
		txtArtista.setText("" + album.getArtista());
		txtArtista.setBounds(66, 65, 86, 20);
		contentPane.add(txtArtista);
		txtArtista.setColumns(10);
		
		txtEstilomusical = new JTextField();
		txtEstilomusical.setText(""+album.getEstiloMusical());
		txtEstilomusical.setBounds(90, 96, 86, 20);
		contentPane.add(txtEstilomusical);
		txtEstilomusical.setColumns(10);
		
		txtQuantidademusicas = new JTextField();
		txtQuantidademusicas.setText("" + album.getQtdMusicas());
		txtQuantidademusicas.setBounds(304, 40, 86, 20);
		contentPane.add(txtQuantidademusicas);
		txtQuantidademusicas.setColumns(10);
		
		txtAnolancamento = new JTextField();
		txtAnolancamento.setText(""+ album.getAnoLancamento());
		txtAnolancamento.setBounds(111, 124, 86, 20);
		contentPane.add(txtAnolancamento);
		txtAnolancamento.setColumns(10);
		
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
		
		DefaultListModel <String>  listaStrMusicas = new DefaultListModel<String>();
		for(int i = 0; i < album.getMusicas().size(); i++){
			listaStrMusicas.addElement(album.getMusicas().get(i).getNomeMusica());
		} 
		JList<String> listaMusicas = new JList<String>(listaStrMusicas);
		listaMusicas.setBounds(223, 93, 186, 82);
		listaMusicas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaMusicas.setLayoutOrientation(JList.VERTICAL);
		//JScrollPane listaMusicasScroll = new JScrollPane(listaMusicas);
		//contentPane.add(listaMusicasScroll);
		contentPane.add(listaMusicas);
		
		
		

		
		JButton btnVoltar = new JButton("Voltar");
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
