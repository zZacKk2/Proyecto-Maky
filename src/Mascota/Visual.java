package Mascota;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import SistemaOperativo.mascota;

public class Visual extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private mascota acciones = new mascota();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visual frame = new Visual();
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
	public Visual() {
		
			
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Hora = new JLabel(" ");
		Hora.setBounds(164, 184, 68, 14);
		contentPane.add(Hora);
		Hora.setVisible(false);
		
		JButton btnNewButton = new JButton("Calculadora");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acciones.AbrirCalculadora();
			}
		});
		btnNewButton.setBounds(25, 31, 105, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Bloc de Notas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				acciones.AbrirBlocNotas();
			}
		});
		btnNewButton_1.setBounds(25, 103, 105, 34);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Hora Actual");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acciones = new mascota();
				Hora.setText(acciones.MostrarHora());
				contentPane.add(Hora);
				Hora.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(25, 174, 105, 34);
		contentPane.add(btnNewButton_2);
		
		
		

	}
}
