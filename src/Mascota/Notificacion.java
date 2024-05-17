package Mascota;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SistemaOperativo.mascota;

import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.Font;

public class Notificacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean EstaAbierto = true;
	private String [] ConsejosGoogle = {"No ingreses tus datos en paginas desconocidas", "Crea un acceso directo de tus páginas más buscadas",
			"Asegurate de no ingresar a páginas pirata", "Siempre cierra tus cuentas bancarias", "No des datos de tus cuentas <br>bancarias a páginas no oficiales"};
	private String [] ConsejosWord = {"Recuerda Guardar tus documentos", "Hay un monton de tipografias <br> nuevas por descubrir"};
	private String [] ConsejosSpotify = {"Disfruta de tu música favorita", "Sin música, la vida sería un error", "La música es para el alma lo que la gimnasia para el cuerpo"};
	private Ajustes ajuste = new Ajustes();
	private int X = getX();
	private int Y = getY();
	private Clip clip;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notificacion frame = new Notificacion("Microsoft Word");
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
	public Notificacion(String programa) {
		ReproducirSonido();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Notificacion.class.getResource("/Diseño/Icono.png")));
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Panda = new JLabel("New label");
		Panda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		Panda.setBounds(138, 132, 141, 135);
		Panda.setIcon(ajuste.resizableLabel(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/Diseño/pandaConsejo.png")), Panda));
		contentPane.add(Panda);
		
		JLabel lblNewLabel_1 = new JLabel("<html><center>" + Consejos(programa)[NumeroRandom(Consejos(programa))] + "<center><html>");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_1.setBounds(140, 34, 169, 95);
		contentPane.add(lblNewLabel_1);
		
		JLabel Burbuja = new JLabel();
		Burbuja.setBounds(115, 34, 230, 95);
		Burbuja.setIcon(ajuste.resizableLabel(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/Diseño/Burbuja.png")), Burbuja));
		contentPane.add(Burbuja);
		
		
		setUndecorated(true);// Decoraciones Deshabilitadas
		setBackground(new Color(0, 0, 0, 0));
		ajuste.TamañoPantalla(this, X, Y);
	}
	
	public void confirmar() {
		if(EstaAbierto) {
			setVisible(true);
		}
	}
	
	
	public static int NumeroRandom(String [] Consejos) {
		int numeroR = (int) (Math.random()*100);
		while(numeroR > Consejos.length-1) {
			numeroR = (int) (Math.random()*100);
		}
		return numeroR;
	}
	
	public void ReproducirSonido() {
		try {
			File sonido = new File("src/Sonido/Notificacion.wav");
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(sonido);
			clip = AudioSystem.getClip();
			clip.open(audioInput);
			clip.setFramePosition(0);
			clip.start();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String [] Consejos (String programa) {
		if(programa.equals("Google Chrome")) return ConsejosGoogle;
		else if (programa.equals("Microsoft Word")) return ConsejosWord;
		else if (programa.equals("Spotify")) return ConsejosSpotify;
		else return null;
	}
}
