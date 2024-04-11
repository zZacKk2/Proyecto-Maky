package Mascota;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SistemaOperativo.mascota;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Google extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean EstaAbierto = true;
	//private List <String> comentarios = new ArrayList<>();
	private String [] comentarios = {"No ingreses tus datos en paginas desconocidas", "Crea un acceso directo de tus páginas más buscadas",
			"Asegurate de no ingresar a páginas pirata", "Siempre cierra tus cuentas bancarias", "No des datos de tus cuentas bancarias a páginas no oficiales"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Google frame = new Google();
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
	public Google() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Google.class.getResource("/Diseño/pandaConsejo.jpg")));
		lblNewLabel.setBounds(146, 63, 141, 135);
		contentPane.add(lblNewLabel);
		
		int numeroR = (int) (Math.random()*100);
		while(numeroR > comentarios.length-1) {
			numeroR = (int) (Math.random()*100);
		}
		
		JLabel lblNewLabel_1 = new JLabel(comentarios[numeroR]);
		lblNewLabel_1.setBounds(77, 23, 319, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(157, 227, 89, 23);
		contentPane.add(btnNewButton);
	}
	
	public void confirmar() {
		if(EstaAbierto) {
			setVisible(true);
		}
		
	}
}
