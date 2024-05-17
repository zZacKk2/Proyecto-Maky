package Mascota;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import SistemaOperativo.mascota;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Visual2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String NombreUsuario;
	private int X;
	private int Y;
	private boolean RecienAbierto = true;
	private Timer tiempo = new Timer();
	private Ajustes ajuste = new Ajustes();
	private mascota accion = new mascota();
	private int i = 0;
	private List<String> programas = NombreProgramas();
	private Queue<String> ProgramasAbiertos = new LinkedList<>();
	private static Visual2 frame;
	public JLabel JLabelPanda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Visual2("");
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
	public Visual2(String nombre) {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Visual.class.getResource("/Diseño/Icono.png")));
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {
				for (int i = 0; i < programas.size(); i++) {
		            if (ConfirmarAplicacionAbierta(programas.get(i)) && RecienAbierto) {
		                ProgramasAbiertos.offer(programas.get(i));
		            }
		        }
		        if (!ProgramasAbiertos.isEmpty()) {
		            Notificacion prueba = new Notificacion(ProgramasAbiertos.peek());
		            prueba.confirmar();
		            tiempo.schedule(new TimerTask() {
		                @Override
		                public void run() {
		                    ProgramasAbiertos.poll();
		                    if (!ProgramasAbiertos.isEmpty() && RecienAbierto) {
		                        String siguientePrograma = ProgramasAbiertos.peek();
		                        Notificacion siguientePrueba = new Notificacion(siguientePrograma);
		                        siguientePrueba.confirmar();
		                    }
		                }
		            }, 3000); // Esperar 3 segundos
		        }

		        RecienAbierto = ProgramasAbiertos.isEmpty();
		    }
		};
		tiempo.schedule(tarea, 0, 60 * 1000);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Visual2.class.getResource("/Diseño/Icono.png")));
		
		NombreUsuario = nombre;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabelPanda = new JLabel("");
		JLabelPanda.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
				int xx = e.getXOnScreen();
		        int yy = e.getYOnScreen();

		        setLocation(xx - X -50, yy - Y -170);
		        repaint();
			}
		});
		JLabelPanda.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				X = e.getX();
		        Y = e.getY();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
                
			}
		});
		
		JLabelPanda.setBounds(71, 226, 129, 140);
		JLabelPanda.setIcon(ajuste.resizableLabel(Toolkit.getDefaultToolkit().getImage(Visual2.class.getResource("/Diseño/PandaFeliz.png")), JLabelPanda));
		contentPane.add(JLabelPanda);
		
		JLabel Bienvenida = new JLabel("<html><center>Bienvenido <center>" + NombreUsuario + "<br> <center>¿cómo puedo ayudarte el día de hoy?<center><html>");
		Bienvenida.setVerticalAlignment(SwingConstants.CENTER);
		Bienvenida.setBounds(53, 39, 147, 93);
		Bienvenida.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(Bienvenida);
		
		JLabel LabelBurbuja = new JLabel("New label");
		LabelBurbuja.setIcon(new ImageIcon(Visual.class.getResource("/Diseño/Burbuja dialogo.png")));
		LabelBurbuja.setBounds(10, 11, 234, 225);
		ImageIcon foto4 = new ImageIcon(getClass().getResource("/Diseño/Burbuja dialogo.png"));
		ImageIcon img4 = new ImageIcon(foto4.getImage().getScaledInstance(LabelBurbuja.getWidth(), LabelBurbuja.getHeight(), Image.SCALE_SMOOTH)); //Escalar imagen al label
		LabelBurbuja.setIcon(img4);
		contentPane.add(LabelBurbuja);
		
		JButton btnCalculadora = new JButton("");
		btnCalculadora.setIcon(new ImageIcon(Visual.class.getResource("/Diseño/calculadora.png")));
		btnCalculadora.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCalculadora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accion.AbrirCalculadora();
			}
		});
		btnCalculadora.setBounds(301, 11, 191, 34);
		ImageIcon foto2 = new ImageIcon(getClass().getResource("/Diseño/calculadora.png"));
		ImageIcon img2 = new ImageIcon(foto2.getImage().getScaledInstance(btnCalculadora.getWidth(), btnCalculadora.getHeight(), Image.SCALE_SMOOTH)); //Escalar imagen al label
		btnCalculadora.setIcon(img2);
		contentPane.add(btnCalculadora);
		
		
		JButton btnBloc = new JButton("");
		btnBloc.setIcon(new ImageIcon(Visual.class.getResource("/Diseño/blocdeNotas.png")));
		btnBloc.setFont(new Font("Arial", Font.PLAIN, 11));
		btnBloc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				accion.AbrirBlocNotas();
			}
		});
		btnBloc.setBounds(301, 56, 191, 34);
		ImageIcon foto3 = new ImageIcon(getClass().getResource("/Diseño/blocdeNotas.png"));
		ImageIcon img3 = new ImageIcon(foto3.getImage().getScaledInstance(btnBloc.getWidth(), btnBloc.getHeight(), Image.SCALE_SMOOTH)); //Escalar imagen al label
		btnBloc.setIcon(img3);
		contentPane.add(btnBloc);
		
		JButton btnCalendario = new JButton("Calendario");
		btnCalendario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accion.mostrarCalendario();
			}
		});
		btnCalendario.setBounds(301, 97, 191, 32);
		contentPane.add(btnCalendario);
		
		JButton btnBurbujaDeChat = new JButton("Preguntame algo...");
		btnBurbujaDeChat.setIcon(new ImageIcon(Visual.class.getResource("/Diseño/busqueda.png")));
		btnBurbujaDeChat.setBackground(new Color(255, 255, 255));
		btnBurbujaDeChat.setForeground(new Color(255, 229, 210));
		btnBurbujaDeChat.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		btnBurbujaDeChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accion.AbrirBurbujaChat();
			}
		});
		btnBurbujaDeChat.setBounds(301, 269, 191, 28);
		ImageIcon foto7 = new ImageIcon(getClass().getResource("/Diseño/busqueda.png"));
		ImageIcon img7 = new ImageIcon(foto7.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH)); //Escalar imagen al label
		btnBurbujaDeChat.setIcon(img7);
		contentPane.add(btnBurbujaDeChat);
		JButton btnAcercaDe = new JButton("Acerca de mi computador");
		btnAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accion.AcercaDe();
			}
		});
		btnAcercaDe.setBounds(301, 226, 191, 32);
		contentPane.add(btnAcercaDe);
		
		JButton btnPersonalizar = new JButton("Personalizar");
		btnPersonalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Configuracion con = new Configuracion();
				con.setVisible(true);
			}
		});
		btnPersonalizar.setBounds(301, 183, 191, 32);
		contentPane.add(btnPersonalizar);

		JButton btnCerrar = new JButton("");
		btnCerrar.setBackground(new Color(255, 250, 250));
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnCerrar.setIcon(new ImageIcon(Visual.class.getResource("/Diseño/cerrar.png")));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		});
		btnCerrar.setBounds(304, 352, 48, 45);
		ImageIcon foto5 = new ImageIcon(getClass().getResource("/Diseño/cerrar.png"));
		ImageIcon img5 = new ImageIcon(foto5.getImage().getScaledInstance(btnCerrar.getWidth(), btnCerrar.getHeight(), Image.SCALE_SMOOTH)); //Escalar imagen al label
		btnCerrar.setIcon(img5);
		contentPane.add(btnCerrar);
		
		JButton btnConfiguracion = new JButton("");
		btnConfiguracion.setIcon(new ImageIcon(Visual.class.getResource("/Diseño/configuracion.png")));
		btnConfiguracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personalizacion cambioframe = new Personalizacion(JLabelPanda, frame);
				cambioframe.setVisible(true);
				//setVisible(false);
			}
			});
		btnConfiguracion.setBounds(301, 140, 191, 34);
		ImageIcon foto8 = new ImageIcon(getClass().getResource("/Diseño/configuracion.png"));
		ImageIcon img8 = new ImageIcon(foto8.getImage().getScaledInstance(btnConfiguracion.getWidth(), btnConfiguracion.getHeight(), Image.SCALE_SMOOTH)); //Escalar imagen al label
		btnConfiguracion.setIcon(img8);
		contentPane.add(btnConfiguracion);
		
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		ajuste.TamañoPantalla(this, X, Y);
	}
	

	public List<String> NombreProgramas() {
		List<String> lista = new LinkedList<>();
		lista.add("Google Chrome");
		lista.add("Microsoft Word");
		lista.add("Spotify");
		lista.add("Visual Studio");
		return lista;
	}
	
	public boolean ConfirmarAplicacionAbierta(String nombreAplicacion) {
		switch (nombreAplicacion) {
		case "Google Chrome":
			if (accion.MensajeGoogle()) {
				return true;
			}
			break;
		case "Microsoft Word":
			if (accion.MensajeWord()) {
				return true;
			}
			break;
		case "Spotify":
			if (accion.MensajeSpoty()) {
				return true;
			}
			break;
		case "Visual Studio":
			if (accion.MensajeVS()) {
				return true;
			}
			break;
		default:
			break;
		}
		// Si la aplicación no está abierta, establecer RecienAbierto como true
		RecienAbierto = true;
		return false;
	}

}
