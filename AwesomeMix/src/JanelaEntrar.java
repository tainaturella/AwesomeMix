import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JanelaEntrar extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JanelaEntrar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //fecha apenas a janela se apertar 'x'
		setSize(700, 500); //tamanho da janela
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		setLocationRelativeTo(null); //centraliza janela
	}

}
