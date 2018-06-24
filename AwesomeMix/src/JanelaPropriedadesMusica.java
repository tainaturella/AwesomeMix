import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class JanelaPropriedadesMusica extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtAlbum;
	private JTextField txtArtista;
	private JTextField txtEstilo;
	private JTextField txtAno;
	private JTextField txtDuracao;
	private JTextField txtAvaliacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPropriedadesMusica frame = new JanelaPropriedadesMusica();
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
	public JanelaPropriedadesMusica() {
		Musica musica = BaseDeDados.shared.musicaAtual;
		
		//System.out.println("nome da musica ola " + musica.getNomeMusica());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//labels
		JLabel lblTitulo = new JLabel("Informa\u00E7\u00F5es da M\u00FAsica");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(10, 11, 189, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(10, 43, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lbllbum = new JLabel("\u00C1lbum");
		lbllbum.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbllbum.setBounds(10, 69, 46, 14);
		contentPane.add(lbllbum);
		
		JLabel lblAvaliao = new JLabel("Avalia\u00E7\u00E3o");
		lblAvaliao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAvaliao.setBounds(10, 163, 64, 14);
		contentPane.add(lblAvaliao);
		
		JLabel lblArtista = new JLabel("Artista");
		lblArtista.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblArtista.setBounds(10, 94, 46, 14);
		contentPane.add(lblArtista);
		
		JLabel lblEstilo = new JLabel("Estilo");
		lblEstilo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstilo.setBounds(207, 43, 46, 14);
		contentPane.add(lblEstilo);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAno.setBounds(207, 69, 46, 14);
		contentPane.add(lblAno);
		
		JLabel lblDurao = new JLabel("Dura\u00E7\u00E3o");
		lblDurao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDurao.setBounds(207, 94, 59, 14);
		contentPane.add(lblDurao);
		
		//text field
		txtNome = new JTextField();
		txtNome.setText(musica.getNomeMusica());//nome
		txtNome.setBounds(49, 40, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtAlbum = new JTextField();
		txtAlbum.setText(musica.getAlbum().getNomeAlbum());
		txtAlbum.setBounds(49, 68, 86, 20);
		contentPane.add(txtAlbum);
		txtAlbum.setColumns(10);
		
		txtArtista = new JTextField();
		txtArtista.setText(musica.getAlbum().getArtista());
		txtArtista.setBounds(49, 91, 86, 20);
		contentPane.add(txtArtista);
		txtArtista.setColumns(10);
		
		txtEstilo = new JTextField();
		txtEstilo.setText(""+musica.getAlbum().getEstiloMusical());
		txtEstilo.setBounds(241, 40, 86, 20);
		contentPane.add(txtEstilo);
		txtEstilo.setColumns(10);
		
		txtAno = new JTextField();
		String s = Integer.toString(musica.getAlbum().getAnoLancamento());//faz cast de inteiro pra String
		txtAno.setText(s);
		txtAno.setBounds(241, 66, 86, 20);
		contentPane.add(txtAno);
		txtAno.setColumns(10);
		
		txtDuracao = new JTextField();
		txtDuracao.setText(Double.toString(musica.getTempoDuracao()));//tempo de duracao
		txtDuracao.setBounds(265, 91, 86, 20);
		contentPane.add(txtDuracao);
		txtDuracao.setColumns(10);
		
		txtAvaliacao = new JTextField();
		txtAvaliacao.setText("" + musica.getAvaliacaoMusica());
		txtAvaliacao.setBounds(89, 160, 86, 20);
		contentPane.add(txtAvaliacao);
		txtAvaliacao.setColumns(10);
		
		
		//botoes
		JButton btnAvaliar = new JButton("Avaliar");
		btnAvaliar.setBounds(207, 159, 89, 23);
		contentPane.add(btnAvaliar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnIrParaAlbum = new JButton("Ir para Album");
		btnIrParaAlbum.setBounds(302, 227, 89, 23);
		contentPane.add(btnIrParaAlbum);
		
		//Listeners
		btnAvaliar.addActionListener(new ActionListener(){
			//chama a funcao avalaliar musica do usuario
			int indiceUsuario = BaseDeDados.shared.usuario_logado;
			public void actionPerformed(ActionEvent arg0){
				Usuario usuario = BaseDeDados.shared.usuarios.get(indiceUsuario);
				//le a avaliacao do text field
				Double avaliacao = Double.parseDouble(txtAvaliacao.getText());
				usuario.avaliaMusica(BaseDeDados.shared.musicaAtual, avaliacao);
			}
		});
		
		
		btnIrParaAlbum.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				//vai para a pagina de album da musica
				new JanelaPropriedadesAlbum().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JanelaPlaylist().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
	}
	

}
