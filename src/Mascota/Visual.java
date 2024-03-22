package Mascota;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import SistemaOperativo.mascota;

public class Visual extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private mascota acciones = new mascota();
	private boolean GoogleAbierto = false;
	private Google prueba;
	private boolean RecienAbierto = true;
	private Timer tiempo = new Timer();
	//private Thread hilo = new Thread();

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
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {
				GoogleAbierto = ConfirmarGoogleAbierto();
				if(GoogleAbierto && RecienAbierto) {
					prueba = new Google();
					prueba.confirmar();
					RecienAbierto = false;
				}
			}
		};
		
					
		tiempo.schedule(tarea, 0, 8000); // cada verifique cada x segundos si se abre word o no		
		
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Hora = new JLabel(" ");
		Hora.setBounds(379, 51, 146, 14);
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
				Hora.setText("Son las: " + acciones.MostrarHora());
				Hora.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(25, 174, 105, 34);
		contentPane.add(btnNewButton_2);		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Visual.class.getResource("/Diseño/pandaf.jpg")));
		lblNewLabel.setBounds(242, 115, 129, 140);
		contentPane.add(lblNewLabel);
		
		JLabel Bienvenida = new JLabel("<html><center>Bienvenido<center> <br> <center>¿cómo puedo ayudarte el día de hoy?<center><html>");
		Bienvenida.setVerticalAlignment(SwingConstants.CENTER);
		Bienvenida.setBounds(242, 11, 116, 93);
		contentPane.add(Bienvenida);
		
		JButton btnBurbujaDeChat = new JButton("<html>Burbuja <br>de chat<html>");
		btnBurbujaDeChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBurbujaDeChat.setBounds(491, 31, 105, 49);
		contentPane.add(btnBurbujaDeChat);
	}
	
	
	public boolean ConfirmarGoogleAbierto() {
		if(acciones.MensajeGoogle()) {
			return true;
		} else {
			RecienAbierto = true;
			return false;
		}
		
	}
	public void imprimirHora() {
		acciones = new mascota();
		
		Timer temp1 = new Timer();
	}
}
