import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;

public class JanelaUsuarios extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JanelaUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Usu\u00E1rios");
		lblTitulo.setBounds(10, 11, 46, 14);
		contentPane.add(lblTitulo);
		
		JList list = new JList();
		list.setBounds(10, 45, 225, 126);
		contentPane.add(list);
		
		JButton btnVoltar = new JButton("voltar");
		btnVoltar.setBounds(81, 196, 89, 23);
		contentPane.add(btnVoltar);
	}

}
