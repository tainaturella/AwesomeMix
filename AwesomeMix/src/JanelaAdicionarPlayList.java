import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ItemEvent;
import java.awt.Font;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//botao voltar
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(20, 225, 98, 25);
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
		textField.setBounds(74, 71, 134, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//label
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(30, 76, 34, 15);
		contentPane.add(lblNome);
		
		//criando radio button menu
		JRadioButton rdbtnNewRadioButton = new JRadioButton("P\u00FAblica");
		rdbtnNewRadioButton.setBounds(74, 107, 59, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnPrivada = new JRadioButton("Privada");
		rdbtnPrivada.setBounds(74, 134, 70, 23);
		contentPane.add(rdbtnPrivada);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnPrivada);
		
		//botao pra criar uma nova playlist
		JButton btnCriar = new JButton("CRIAR PLAYLIST");
		btnCriar.setBounds(266, 85, 113, 25);
		contentPane.add(btnCriar);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus.setBounds(30, 107, 46, 14);
		contentPane.add(lblStatus);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(266, 123, 113, 23);
		contentPane.add(btnLimpar);
		
		JLabel lblNovaPlaylist = new JLabel("Nova Playlist");
		lblNovaPlaylist.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNovaPlaylist.setBounds(20, 23, 108, 14);
		contentPane.add(lblNovaPlaylist);
		Usuario usuario = BaseDeDados.shared.usuarios.get(BaseDeDados.shared.usuario_logado);
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnNewRadioButton.isSelected()) {
					usuario.criaPlayListPublica(textField.getText());
					new JanelaMeuPerfil().setVisible(true);
					setVisible(false);
					dispose();
				}else if(rdbtnPrivada.isSelected()) {
					usuario.criaPlayListPrivada(textField.getText());
					new JanelaMeuPerfil().setVisible(true);
					setVisible(false);
					dispose();
				}else {
					System.out.println("Você deve inserir escolher um tipo");
				}
			}
		});
	}
}
