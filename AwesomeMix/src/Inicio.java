import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnLogin, btnCadastrar;
	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); //deixa centralizado
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(86, 200, 89, 23);
		
		//aqui que adiciona uma funcao pro button
		btnLogin.addActionListener(new java.awt.event.ActionListener() {
			    public void actionPerformed(java.awt.event.ActionEvent evt) {
	               buttonLoginActionPerformed(evt);
	               //aqui, quando o botao for pressionado, ele manda pra esse metodo, mas eu poderia ter feito diferente
	               //podemos deixar um metodo pra cuidar de todos os botoes da janela se quiserem, ou fazer um pra cada
	               //botao
	            }
	        });
		
		panel.add(btnLogin);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(254, 200, 89, 23);
		panel.add(btnCadastrar);
	}
	
	public void buttonLoginActionPerformed(ActionEvent e){
			System.out.println("Foi!\n");
			//NovaJanela nova = new novaJanela();
			//nova.setVisible(true);
			//setVisible(false); <- deixa janela atual invisivel
			//ou podemos usar dispose(), preciso dar uma pesquisada nisso
	}
}
