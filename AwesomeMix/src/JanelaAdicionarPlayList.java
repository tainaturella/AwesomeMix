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
		setTitle("Adicionar Nova Playlist");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//botao voltar
		JButton btnVoltar = new JButton("voltar");
		btnVoltar.setBounds(30, 217, 98, 25);
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
		textField.setBounds(30, 69, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//label
		JLabel lblNome = new JLabel("nome");
		lblNome.setBounds(33, 41, 55, 15);
		contentPane.add(lblNome);
		
		//criando radio button menu
		JRadioButton rdbtnNewRadioButton = new JRadioButton("pública");
		rdbtnNewRadioButton.setBounds(218, 67, 121, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnPrivada = new JRadioButton("privada");
		rdbtnPrivada.setBounds(218, 94, 121, 23);
		contentPane.add(rdbtnPrivada);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnPrivada);
		
		//botao pra criar uma nova playlist
		JButton btnCriar = new JButton("criar");
		btnCriar.setBounds(30, 131, 98, 25);
		contentPane.add(btnCriar);
		Usuario usuario = BaseDeDados.shared.usuarios.get(BaseDeDados.shared.usuario_logado);
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnNewRadioButton.isSelected()) {
					usuario.criaPlayListPublica(textField.getText());
					new JanelaMeuPerfil().setVisible(true);;
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
