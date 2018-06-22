import java.awt.BorderLayout;
import java.awt.EventQueue;
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
		
		ArrayList<Usuario> usuarios = BaseDeDados.shared.usuarios;
		
		ArrayList<String> listLogin = new ArrayList<String>();
		DefaultListModel<String> listUsuarios = new DefaultListModel<String>();
		for(int i=0; i < usuarios.size(); i++) {
			if(BaseDeDados.shared.usuario_logado == i) {
				continue;
			}
			listUsuarios.addElement(usuarios.get(i).getNome());
			listLogin.add(usuarios.get(i).getLogin());
		}
		
		JList<String> list = new JList<String>(listUsuarios);
		//list.setBounds(10, 45, 225, 126);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		JScrollPane listScroll = new JScrollPane(list);
		listScroll.setBounds(10, 45, 225, 126);
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
		
		JButton btnVoltar = new JButton("voltar");
		btnVoltar.setBounds(81, 196, 89, 23);
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
