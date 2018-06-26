import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Font;

@SuppressWarnings("serial")
public class JanelaAdicionarPlayList extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaAdicionarPlayList frame = new JanelaAdicionarPlayList();
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
	public JanelaAdicionarPlayList() {
		setTitle("Nova Playlist - AwesomeMix");
		setSize(700, 500); //tamanho da janela
		setLocationRelativeTo(null); //centraliza janela
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//botao voltar
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(28, 362, 98, 25);
		contentPane.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new JanelaMeuPerfil().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		
		//text field para tratar nome da nova playlist
		textField = new JTextField();
		textField.setBounds(164, 109, 287, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//label
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(100, 114, 68, 15);
		contentPane.add(lblNome);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("logop.png"));
		lblNewLabel.setBounds(10, 11, 74, 88);
		contentPane.add(lblNewLabel);
		
		//criando radio button menu
		final JRadioButton rdbtnNewRadioButton = new JRadioButton("Publica");
		rdbtnNewRadioButton.setFont(new Font("Dialog", Font.PLAIN, 13));

		rdbtnNewRadioButton.setBackground(new Color(204, 153, 255));
		rdbtnNewRadioButton.setBounds(164, 146, 69, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		final JRadioButton rdbtnPrivada = new JRadioButton("Privada");
		rdbtnPrivada.setFont(new Font("Dialog", Font.PLAIN, 13));
		rdbtnPrivada.setBackground(new Color(204, 153, 255));
		rdbtnPrivada.setBounds(164, 172, 69, 23);
		contentPane.add(rdbtnPrivada);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnPrivada);
		
		//botao pra criar uma nova playlist
		JButton btnCriar = new JButton("CRIAR PLAYLIST");
		btnCriar.setBounds(120, 234, 113, 25);
		contentPane.add(btnCriar);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStatus.setBounds(100, 145, 68, 14);
		contentPane.add(lblStatus);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(338, 235, 113, 23);
		contentPane.add(btnLimpar);
		
		JLabel lblNovaPlaylist = new JLabel("Nova Playlist");
		lblNovaPlaylist.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNovaPlaylist.setBounds(97, 39, 167, 25);
		contentPane.add(lblNovaPlaylist);
		final Usuario usuario = BaseDeDados.shared.usuarios.get(BaseDeDados.shared.usuario_logado);
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnNewRadioButton.isSelected()) {
					usuario.criaPlayListPublica(textField.getText());
					new JanelaMeuPerfil().setVisible(true);
					setVisible(false);
					JOptionPane.showMessageDialog (null, "Playlist foi criada com sucesso!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}else if(rdbtnPrivada.isSelected()) {
					usuario.criaPlayListPrivada(textField.getText());
					new JanelaMeuPerfil().setVisible(true);
					setVisible(false);
					JOptionPane.showMessageDialog (null, "Playlist foi criada com sucesso!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}else {
					JOptionPane.showMessageDialog (null, "Voc� precisa escolher o tipo de Playlist", "Aviso", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
