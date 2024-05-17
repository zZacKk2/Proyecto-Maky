package Mascota;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import SistemaOperativo.mascota;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JPopupMenu;
import java.awt.Component;

public class Visual extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private mascota acciones = new mascota();
	private Notificacion prueba;
	private boolean RecienAbierto = true;
	private Timer tiempo = new Timer();
	private Ajustes ajuste = new Ajustes();
	private int X;
	private int Y;
	private int i = 0;
	private List<String> programas = NombreProgramas();
	private Queue<String> ProgramasAbiertos = new LinkedList<>();
	private static String nombreUsuario;
	private static Visual frame1;
	private static JLabel Panda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visual frame = new Visual(nombreUsuario);
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
	public Visual(String nombre) {
		nombreUsuario = nombre;
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
		tiempo.schedule(tarea, 0, 60 * 1000); // cada verifique cada 10 segundos si se abre word o no

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 332, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Panda = new JLabel("");
		Panda.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {

				int xx = e.getXOnScreen();
				int yy = e.getYOnScreen();

				setLocation(xx - X - 50, yy - Y - 170);
				repaint();
			}
		});
		Panda.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == 3) {
					CrearMenuItem().show(e.getComponent(), X + 90, Y);
				}
				X = e.getX();
				Y = e.getY();
			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}
		});
		Panda.setBounds(57, 165, 160, 177);
		Panda.setIcon(ajuste.resizableLabel(
				Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/Diseño/Panda.png")), Panda));
		contentPane.add(Panda);
		System.out.println(nombreUsuario);

		JLabel Bienvenida = new JLabel("<html><center>Bienvenido<center>" + nombreUsuario
				+ " <br> <center>¿cómo puedo ayudarte el día de hoy?<center><html>");
		Bienvenida.setVerticalAlignment(SwingConstants.CENTER);
		Bienvenida.setBounds(131, 53, 116, 93);
		Bienvenida.setFont(new Font("Arial", Font.BOLD, 11));
		contentPane.add(Bienvenida);

		JLabel Burbuja = new JLabel();
		Burbuja.setBounds(88, 40, 204, 132);
		Burbuja.setIcon(ajuste.resizableLabel(
				Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/Diseño/Burbuja.png")), Burbuja));
		contentPane.add(Burbuja);
		

		setUndecorated(true);// Decoraciones Deshabilitadas
		setBackground(new Color(0, 0, 0, 0));
		ajuste.TamañoPantalla(this, getX(), getY());
	}

	public boolean ConfirmarAplicacionAbierta(String nombreAplicacion) {
		switch (nombreAplicacion) {
		case "Google Chrome":
			if (acciones.MensajeGoogle()) {
				return true;
			}
			break;
		case "Microsoft Word":
			if (acciones.MensajeWord()) {
				return true;
			}
			break;
		case "Spotify":
			if (acciones.MensajeSpoty()) {
				return true;
			}
			break;
		case "Visual Studio":
			if (acciones.MensajeVS()) {
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

	public JPopupMenu CrearMenuItem() {

		JMenuItem Calculadora = new JMenuItem("Calculadora");
		JMenuItem BlocNotas = new JMenuItem("BlocNotas");
		JMenuItem Calendario = new JMenuItem("Calendario");
		JMenuItem Configuracion = new JMenuItem("Configuración");
		JMenuItem Personalizar = new JMenuItem("Personalizar");
		JMenuItem AcercaDe = new JMenuItem("Acerca de mi computador");
		JMenuItem BurbujaChat = new JMenuItem("Burbuja de chat");
		JMenuItem Cerrar = new JMenuItem("Cerrar");

		return AgregarFuncionalidades(Calculadora, BlocNotas, Calendario, Configuracion, Personalizar, AcercaDe,
				BurbujaChat, Cerrar);

	}

	public JPopupMenu AgregarFuncionalidades(JMenuItem Calculadora, JMenuItem BlocNotas, JMenuItem Calendario,
			JMenuItem Configuracion, JMenuItem Personalizar, JMenuItem AcercaDe, JMenuItem BurbujaChat,
			JMenuItem Cerrar) {

		Calculadora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acciones.AbrirCalculadora();
			}
		});

		BlocNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acciones.AbrirBlocNotas();
			}
		});

		Calendario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acciones.mostrarCalendario();
			}
		});

		Configuracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Configuracion con = new Configuracion();
				con.setVisible(true);

			}
		});

		Personalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personalizacion per = new Personalizacion(Panda, frame1);
				per.setVisible(true);
				//frame1.setVisible(false);
			}
		});

		AcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acciones.AcercaDe();
			}
		});

		BurbujaChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acciones.AbrirBurbujaChat();
			}
		});

		Cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		});

		JPopupMenu menu = new JPopupMenu();
		menu.add(Calculadora);
		menu.add(BlocNotas);
		menu.add(Calendario);
		menu.add(Configuracion);
		menu.add(Personalizar);
		menu.add(AcercaDe);
		menu.add(BurbujaChat);
		menu.add(Cerrar);

		return menu;

	}

	public List<String> NombreProgramas() {
		List<String> lista = new LinkedList<>();
		lista.add("Google Chrome");
		lista.add("Microsoft Word");
		lista.add("Spotify");
		lista.add("Visual Studio");
		return lista;
	}
}
