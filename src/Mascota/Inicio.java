package Mascota;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Ajustes ajuste = new Ajustes();
	private static JTextField NombreGuardar;
	private static String NombreUsuario = "nombreUsuario.txt";
	private static String EdadUsuario = "edadUsuario.txt";
	private static Visual visual;
	private String[] Textos = {
			"¡Hola! <br> Soy Maky, tu nuevo asistente virtual <br> Por favor selecciona tu rango de edad",
			"¿Cómo te llamas?<br>(Este nombre se guardara solamente en tu computadora)" };
	private ButtonGroup grupoRadio;
	private static int edad = EdadGuardada();
	private JRadioButton Edad1;
	private JRadioButton Edad2;
	private JRadioButton Edad3;
	private int X;
	private int Y;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					if (YaInscrito() && edad > 14 && edad < 51) {
						visual = new Visual(cargarNombreUsuario());
						visual.setVisible(true);
						frame.dispose();
					} else if(YaInscrito() && edad <= 14 || edad >= 51){
						Visual2 visual;
						visual = new Visual2(cargarNombreUsuario());
						visual.setVisible(true);
						frame.dispose();
					} else {
						
						frame.setVisible(true);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/Diseño/Icono.png")));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				System.exit(0);
			}
		});
		lblNewLabel.setBounds(18, 155, 127, 143);
		lblNewLabel.setIcon(ajuste.resizableLabel(
				Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/Diseño/PandaBonito.png")),
				lblNewLabel));
		contentPane.add(lblNewLabel);

		NombreGuardar = new JTextField();
		NombreGuardar.setBounds(179, 210, 193, 20);
		contentPane.add(NombreGuardar);
		NombreGuardar.setColumns(10);
		NombreGuardar.setVisible(false);

		JLabel lblNewLabel_1 = new JLabel("<HTML><center>" + Textos[0] + "<center><HTML>");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 12));
		lblNewLabel_1.setBounds(39, 23, 225, 83);
		contentPane.add(lblNewLabel_1);

		JButton btnNombre = new JButton("ok");
		btnNombre.setBackground(Color.LIGHT_GRAY);
		btnNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!("".equals(NombreGuardar.getText()) || NombreGuardar.getText() == null
						|| " ".equals(NombreGuardar.getText()))) {
					if(edad == 30) {
						guardarNombreUsuario(NombreGuardar.getText());
						visual = new Visual(cargarNombreUsuario());
						visual.setVisible(true);
						dispose();
					} else if (edad == 14 || edad == 51){
						Visual2 visual;
						guardarNombreUsuario(NombreGuardar.getText());
						visual = new Visual2(cargarNombreUsuario());
						visual.setVisible(true);
						dispose();
					}

				} else {
					JOptionPane.showMessageDialog(null, "Ingresa un Nombre valido");
				}

			}
		});
		btnNombre.setFont(new Font("Arial", Font.BOLD, 12));
		btnNombre.setBounds(224, 241, 89, 23);
		contentPane.add(btnNombre);
		btnNombre.setVisible(false);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(18, 11, 270, 133);
		lblNewLabel_2.setIcon(ajuste.resizableLabel(
				Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/Diseño/Burbuja.png")), lblNewLabel_2));
		contentPane.add(lblNewLabel_2);

		Edad1 = new JRadioButton("0-14");
		Edad1.setBounds(179, 165, 55, 23);
		contentPane.add(Edad1);

		Edad2 = new JRadioButton("15-50");
		Edad2.setBounds(246, 165, 61, 23);
		contentPane.add(Edad2);

		Edad3 = new JRadioButton("51+");
		Edad3.setBounds(317, 165, 55, 23);
		contentPane.add(Edad3);

		RadioAGrupo();

		JButton btnRango = new JButton("ok");
		btnRango.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ValidarEdad();
				if(edad == 0) {
					JOptionPane.showMessageDialog(null, "Seleccióna un rango de edad");
				} else {
					System.out.println(edad);
					Edad1.setVisible(false);
					Edad2.setVisible(false);
					Edad3.setVisible(false);
					btnRango.setVisible(false);
					NombreGuardar.setVisible(true);
					btnNombre.setVisible(true);
				}
			}
		});
		btnRango.setFont(new Font("Arial", Font.BOLD, 11));
		btnRango.setBounds(224, 195, 89, 23);
		contentPane.add(btnRango);		

		setUndecorated(true);// Decoraciones Deshabilitadas
		setBackground(new Color(0, 0, 0, 0));
		ajuste.TamañoPantalla(this, getX(), getY());
	}

	public static boolean YaInscrito() {
		String nombreUsuario = cargarNombreUsuario();
		if (nombreUsuario != null && !nombreUsuario.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	private static String cargarNombreUsuario() {
		try (BufferedReader br = new BufferedReader(new FileReader(NombreUsuario))) {
			return br.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	private void guardarEdad(int edad) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(EdadUsuario))) {
			bw.write(String.valueOf(edad));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void guardarNombreUsuario(String nombreUsuario) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NombreUsuario))) {
			bw.write(nombreUsuario);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void RadioAGrupo() {
		grupoRadio = new ButtonGroup();
		grupoRadio.add(Edad1);
		grupoRadio.add(Edad2);
		grupoRadio.add(Edad3);
	}

	public void ValidarEdad() {
		if (Edad1.isSelected()) {
			edad = 14;
			
		} else if (Edad2.isSelected()) {
			edad = 30;
			
		} else if (Edad3.isSelected()) {
			edad = 51;
		}
		guardarEdad(edad);
	}
	
	public static int EdadGuardada() {
		try {
			File file = new File("edadUsuario.txt");
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            scanner.close();
            edad = Integer.parseInt(line);
            
		} catch (IOException e) {
			
		}
		return edad;
	}
}
