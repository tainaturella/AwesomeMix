
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

@SuppressWarnings("serial")
public class JanelaUsuarios extends JFrame {

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
	public JanelaUsuarios() {
		setTitle("Usuarios - AwesomeMix");
		setSize(700, 500); //tamanho da janela
		setLocationRelativeTo(null); //centraliza janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();

		contentPane.setBackground(new Color(204, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Usuarios");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setBounds(94, 40, 176, 23);
		contentPane.add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("logop.png"));
		lblNewLabel.setBounds(10, 11, 74, 88);
		contentPane.add(lblNewLabel);
		
		final ArrayList<Usuario> usuarios = BaseDeDados.shared.usuarios;
		
		final ArrayList<String> listLogin = new ArrayList<String>();
		final DefaultListModel<String> listUsuarios = new DefaultListModel<String>();
		for(int i=0; i < usuarios.size(); i++) {
			if(BaseDeDados.shared.usuario_logado == i) {
				continue;
			}
			listUsuarios.addElement(usuarios.get(i).getNome());
			listLogin.add(usuarios.get(i).getLogin());
		}
		
		final JList<String> list = new JList<String>(listUsuarios);
		//list.setBounds(10, 45, 225, 126);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		JScrollPane listScroll = new JScrollPane(list);
		listScroll.setBounds(109, 92, 280, 223);
		contentPane.add(listScroll);
		
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = list.getSelectedIndex();
			    if (evt.getClickCount() == 2) {
			    		for(int i=0; i < usuarios.size(); i++){
			    			if(usuarios.get(i).getNome().equals(listUsuarios.get(index))) {
			    				if(usuarios.get(i).getLogin().equals(listLogin.get(index))) {
			    					BaseDeDados.shared.usuario = i;
			    					new JanelaPerfil().setVisible(true);
			    					setVisible(false);
			    					dispose();
			    				}
			    			}
			    		}
			    }
			  }
			});
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(25, 367, 89, 23);
		contentPane.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JanelaMeuPerfil().setVisible(true);
				setVisible(false);
				dispose();
			}
		});
	}
	
}
