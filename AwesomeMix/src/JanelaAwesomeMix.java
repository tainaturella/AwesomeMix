import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fecha o programa ao fechar a janela
		setSize(700, 500); //tamanho da janela
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(UIManager.getColor("Button.background"));
		btnEntrar.setBounds(85, 373, 179, 37);
		btnEntrar.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15)); //fonte do botao
		contentPane.add(btnEntrar);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JanelaEntrar().setVisible(true);
			}
		});
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(379, 373, 179, 37);
		btnCadastrar.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15)); //fonte do botao
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblAwesomemix = new JLabel("AwesomeMix");
		lblAwesomemix.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 60));
		lblAwesomemix.setBounds(127, 58, 415, 130);
		contentPane.add(lblAwesomemix);
		
		setLocationRelativeTo(null); //centraliza janela
	}
}
