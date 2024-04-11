package Mascota;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
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
import java.awt.Font;

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
		
		JButton btnCalculadora = new JButton("Calculadora");
		btnCalculadora.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCalculadora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acciones.AbrirCalculadora();
			}
		});
		btnCalculadora.setBounds(25, 31, 105, 34);
		contentPane.add(btnCalculadora);
		btnCalculadora.setVisible(false);
		
		
		JButton btnBloc = new JButton("Bloc de Notas");
		btnBloc.setFont(new Font("Arial", Font.PLAIN, 11));
		btnBloc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				acciones.AbrirBlocNotas();
			}
		});
		btnBloc.setBounds(25, 103, 105, 34);
		contentPane.add(btnBloc);
		btnBloc.setVisible(false);
		
		JButton btnHora = new JButton("Hora Actual");
		btnHora.setFont(new Font("Arial", Font.PLAIN, 11));
		btnHora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				acciones = new mascota();
				acciones.MostrarHora();
				
			}
		});
		btnHora.setBounds(25, 174, 105, 34);
		contentPane.add(btnHora);	
		btnHora.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Visual.class.getResource("/Diseño/pandaf.jpg")));
		lblNewLabel.setBounds(242, 115, 129, 140);
		contentPane.add(lblNewLabel);
		
		JLabel Bienvenida = new JLabel("<html><center>Bienvenido<center> <br> <center>¿cómo puedo ayudarte el día de hoy?<center><html>");
		Bienvenida.setVerticalAlignment(SwingConstants.CENTER);
		Bienvenida.setBounds(242, 11, 116, 93);
		Bienvenida.setFont(new Font("Arial", Font.PLAIN, 11));
		contentPane.add(Bienvenida);
		
		JButton btnBurbujaDeChat = new JButton("<html>Burbuja <br>de chat<html>");
		btnBurbujaDeChat.setFont(new Font("Arial", Font.PLAIN, 11));
		btnBurbujaDeChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBurbujaDeChat.setBounds(350, 282, 105, 49);
		contentPane.add(btnBurbujaDeChat);
		
		JButton btnfuncionalidades = new JButton("<html><div style='text-align:left;'>Funcionalidades</div></html>");
		btnfuncionalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCalculadora.setVisible(true);
				btnBloc.setVisible(true);
				btnHora.setVisible(true);
			}
		});
		btnfuncionalidades.setFont(new Font("Arial", Font.PLAIN, 11));
		btnfuncionalidades.setBounds(142, 282, 116, 49);
		contentPane.add(btnfuncionalidades);
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
