import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class JanelaAwesomeMix extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCadastro frame = new JanelaCadastro();
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
	public JanelaAwesomeMix() {
		setTitle("Home - AwesomeMix");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fecha o programa ao fechar a janela
		setSize(700, 500); //tamanho da janela
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setBackground(new Color(204, 153, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBackground(UIManager.getColor("Button.background"));
		btnEntrar.setBounds(85, 373, 179, 37);
		btnEntrar.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15)); //fonte do botao
		contentPane.add(btnEntrar);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JanelaEntrar().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBounds(379, 373, 179, 37);
		btnCadastrar.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15)); //fonte do botao
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JanelaCadastro().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		
		JLabel lblAwesomemix = new JLabel(new ImageIcon("logog.png"),JLabel.CENTER);
		lblAwesomemix.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 60));
		lblAwesomemix.setBounds(137, 25, 347, 311);
		contentPane.add(lblAwesomemix);
		
		setLocationRelativeTo(null); //centraliza janela
	}
}
