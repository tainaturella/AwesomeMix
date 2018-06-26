import java.awt.Color;
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
import javax.swing.ImageIcon;
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
		contentPane = new JPanel();

		contentPane.setBackground(new Color(204, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//labels
		JLabel lblTitulo = new JLabel("Informacoes da Musica");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setBounds(102, 30, 269, 23);
		contentPane.add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Tai\\Documents\\vai carai\\AwesomeMix\\AwesomeMix\\src\\logop.png"));
		lblNewLabel.setBounds(10, 11, 74, 88);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(86, 101, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lbllbum = new JLabel("Album");
		lbllbum.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllbum.setBounds(84, 143, 46, 14);
		contentPane.add(lbllbum);
		
		JLabel lblAvaliao = new JLabel("Avaliacao");
		lblAvaliao.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAvaliao.setBounds(84, 213, 64, 14);
		contentPane.add(lblAvaliao);
		
		JLabel lblArtista = new JLabel("Artista");
		lblArtista.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblArtista.setBounds(85, 185, 46, 14);
		contentPane.add(lblArtista);
		
		JLabel lblEstilo = new JLabel("Estilo");
		lblEstilo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstilo.setBounds(364, 182, 46, 14);
		contentPane.add(lblEstilo);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAno.setBounds(365, 98, 46, 14);
		contentPane.add(lblAno);
		
		JLabel lblDurao = new JLabel("Duracao");
		lblDurao.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDurao.setBounds(363, 140, 59, 14);
		contentPane.add(lblDurao);
		
		//text field
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setText(musica.getNomeMusica());//nome
		txtNome.setBounds(145, 98, 164, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtAlbum = new JTextField();
		txtAlbum.setEditable(false);
		txtAlbum.setText(musica.getAlbum().getNomeAlbum());
		txtAlbum.setBounds(143, 140, 164, 20);
		contentPane.add(txtAlbum);
		txtAlbum.setColumns(10);
		
		txtArtista = new JTextField();
		txtArtista.setEditable(false);
		txtArtista.setText(musica.getAlbum().getArtista());
		txtArtista.setBounds(144, 182, 164, 20);
		contentPane.add(txtArtista);
		txtArtista.setColumns(10);
		
		txtEstilo = new JTextField();
		txtEstilo.setEditable(false);
		txtEstilo.setText(""+musica.getAlbum().getEstiloMusical());
		txtEstilo.setBounds(426, 179, 59, 20);
		contentPane.add(txtEstilo);
		txtEstilo.setColumns(10);
		
		txtAno = new JTextField();
		txtAno.setEditable(false);
		String s = Integer.toString(musica.getAlbum().getAnoLancamento());//faz cast de inteiro pra String
		txtAno.setText(s);
		txtAno.setBounds(427, 95, 33, 20);
		contentPane.add(txtAno);
		txtAno.setColumns(10);
		
		txtDuracao = new JTextField();
		txtDuracao.setEditable(false);
		txtDuracao.setText(Double.toString(musica.getTempoDuracao()));//tempo de duracao
		txtDuracao.setBounds(425, 137, 35, 20);
		contentPane.add(txtDuracao);
		txtDuracao.setColumns(10);
		
		txtAvaliacao = new JTextField();
		txtAvaliacao.setEditable(false);
		txtAvaliacao.setText("" + Double.toString(musica.getAvaliacaoMusica()).substring(0, 3));
		txtAvaliacao.setBounds(158, 210, 33, 20);
		contentPane.add(txtAvaliacao);
		txtAvaliacao.setColumns(10);
		
		
		//botoes
		JButton btnAvaliar = new JButton("AVALIAR");
		btnAvaliar.setBounds(201, 210, 89, 23);
		contentPane.add(btnAvaliar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(25, 367, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnIrParaAlbum = new JButton("IR PARA ALBUM");
		btnIrParaAlbum.setBounds(347, 254, 138, 23);
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
