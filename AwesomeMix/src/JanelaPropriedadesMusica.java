import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
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
		setTitle("Informa\u00E7\u00F5es- AwesomeMix");
		setSize(700, 500); //tamanho da janela
		setLocationRelativeTo(null); //centraliza janela
		final Musica musica = BaseDeDados.shared.musicaAtual;
		
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
		lblNome.setBounds(30, 70, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lbllbum = new JLabel("\u00C1lbum");
		lbllbum.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbllbum.setBounds(30, 96, 46, 14);
		contentPane.add(lbllbum);
		
		JLabel lblAvaliao = new JLabel("Avalia\u00E7\u00E3o");
		lblAvaliao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAvaliao.setBounds(30, 159, 64, 14);
		contentPane.add(lblAvaliao);
		
		JLabel lblArtista = new JLabel("Artista");
		lblArtista.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblArtista.setBounds(30, 121, 46, 14);
		contentPane.add(lblArtista);
		
		JLabel lblEstilo = new JLabel("Estilo");
		lblEstilo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstilo.setBounds(280, 118, 46, 14);
		contentPane.add(lblEstilo);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAno.setBounds(280, 67, 46, 14);
		contentPane.add(lblAno);
		
		JLabel lblDurao = new JLabel("Dura\u00E7\u00E3o");
		lblDurao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDurao.setBounds(280, 93, 59, 14);
		contentPane.add(lblDurao);
		
		//text field
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setText(musica.getNomeMusica());//nome
		txtNome.setBounds(89, 67, 164, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtAlbum = new JTextField();
		txtAlbum.setEditable(false);
		txtAlbum.setText(musica.getAlbum().getNomeAlbum());
		txtAlbum.setBounds(89, 93, 164, 20);
		contentPane.add(txtAlbum);
		txtAlbum.setColumns(10);
		
		txtArtista = new JTextField();
		txtArtista.setEditable(false);
		txtArtista.setText(musica.getAlbum().getArtista());
		txtArtista.setBounds(89, 118, 164, 20);
		contentPane.add(txtArtista);
		txtArtista.setColumns(10);
		
		txtEstilo = new JTextField();
		txtEstilo.setEditable(false);
		txtEstilo.setText(""+musica.getAlbum().getEstiloMusical());
		txtEstilo.setBounds(342, 115, 59, 20);
		contentPane.add(txtEstilo);
		txtEstilo.setColumns(10);
		
		txtAno = new JTextField();
		txtAno.setEditable(false);
		String s = Integer.toString(musica.getAlbum().getAnoLancamento());//faz cast de inteiro pra String
		txtAno.setText(s);
		txtAno.setBounds(342, 64, 33, 20);
		contentPane.add(txtAno);
		txtAno.setColumns(10);
		
		txtDuracao = new JTextField();
		txtDuracao.setEditable(false);
		txtDuracao.setText(Double.toString(musica.getTempoDuracao()));//tempo de duracao
		txtDuracao.setBounds(342, 90, 35, 20);
		contentPane.add(txtDuracao);
		txtDuracao.setColumns(10);
		
		txtAvaliacao = new JTextField();
		txtAvaliacao.setEditable(false);
		txtAvaliacao.setText("" + Double.toString(musica.getAvaliacaoMusica()).substring(0, 3));
		txtAvaliacao.setBounds(104, 156, 33, 20);
		contentPane.add(txtAvaliacao);
		txtAvaliacao.setColumns(10);
		
		
		//botoes
		JButton btnAvaliar = new JButton("AVALIAR");
		btnAvaliar.setBounds(147, 155, 89, 23);
		contentPane.add(btnAvaliar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(10, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnIrParaAlbum = new JButton("IR PARA \u00C1LBUM");
		btnIrParaAlbum.setBounds(253, 227, 138, 23);
		contentPane.add(btnIrParaAlbum);
		
		//Listeners
		btnAvaliar.addActionListener(new ActionListener(){
			//chama a funcao avalaliar musica do usuario
			int indiceUsuario = BaseDeDados.shared.usuario_logado;
			public void actionPerformed(ActionEvent arg0){
				Object[] opcoes = {"0","1","2","3","4","5","6","7","8","9","10"};
				JOptionPane pane = new JOptionPane();
				pane.setSelectionValues(opcoes);
				String res = (String)JOptionPane.showInputDialog(
						pane,
						"Atribua sua nota para a m�sica","Avalia��o" ,
						JOptionPane.QUESTION_MESSAGE ,
						null ,opcoes,
						opcoes[0]);
				//String avaliacao = (String )pane.getValue();
				//System.out.println("resposta" + res);
				Usuario usuario = BaseDeDados.shared.usuarios.get(indiceUsuario);
				//le a avaliacao do text field
				Double avaliacao = Double.parseDouble(res);
				System.out.println("avaliacao anterior " + BaseDeDados.shared.musicaAtual.getAvaliacaoMusica());
				System.out.println("avaliacao do usuario" + avaliacao);
				usuario.avaliaMusica(BaseDeDados.shared.musicaAtual, avaliacao);
				System.out.println("avaliacao atual" + BaseDeDados.shared.musicaAtual.getAvaliacaoMusica());
				txtAvaliacao.setText("" + Double.toString(musica.getAvaliacaoMusica()).substring(0, 3));
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
