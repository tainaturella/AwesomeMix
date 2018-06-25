
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
		setTitle("Usu\u00E1rios - AwesomeMix");
		setSize(700, 500); //tamanho da janela
		setLocationRelativeTo(null); //centraliza janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Usu\u00E1rios");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(10, 23, 89, 14);
		contentPane.add(lblTitulo);
		
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
		listScroll.setBounds(28, 57, 227, 138);
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
		btnVoltar.setBounds(10, 227, 89, 23);
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
