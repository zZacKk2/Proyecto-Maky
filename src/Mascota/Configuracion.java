package Mascota;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import SistemaOperativo.mascota;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Configuracion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Ajustes ajuste = new Ajustes();
	private ButtonGroup grupoRadio;
	private static String NombreUsuario = "nombreUsuario.txt";
	private static String EdadUsuario = "edadUsuario.txt";
	private static int edad = EdadGuardada();
	private JRadioButton Edad1;
	private JRadioButton Edad2;
	private JRadioButton Edad3;
	private JTextField NombreGuardar;
	private int X;
	private int Y;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Configuracion frame = new Configuracion();
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
	public Configuracion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Visual.class.getResource("/Diseño/Icono.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Bienvenida = new JLabel(
				"<html><center>Bienvenido<center> <br> <center>Vamos a realizar la configuración<center><html>");
		Bienvenida.setVerticalAlignment(SwingConstants.CENTER);
		Bienvenida.setBounds(69, 25, 116, 93);
		Bienvenida.setFont(new Font("Arial", Font.BOLD, 11));
		contentPane.add(Bienvenida);

		JLabel Panda = new JLabel("New label");
		Panda.setBounds(32, 122, 161, 128);
		Panda.setIcon(ajuste.resizableLabel(
				Toolkit.getDefaultToolkit().getImage(Configuracion.class.getResource("/Diseño/pandaConsejo.png")),
				Panda));
		contentPane.add(Panda);

		JLabel Burbuja = new JLabel();
		Burbuja.setBounds(32, 25, 190, 107);
		Burbuja.setIcon(ajuste.resizableLabel(
				Toolkit.getDefaultToolkit().getImage(Configuracion.class.getResource("/Diseño/Burbuja.png")), Burbuja));
		contentPane.add(Burbuja);

		Edad1 = new JRadioButton("0-14");
		Edad1.setBounds(201, 122, 55, 23);
		contentPane.add(Edad1);

		Edad2 = new JRadioButton("15-50");
		Edad2.setBounds(268, 122, 61, 23);
		contentPane.add(Edad2);

		Edad3 = new JRadioButton("51+");
		Edad3.setBounds(342, 122, 55, 23);
		contentPane.add(Edad3);

		RadioAGrupo();

		JButton btnRango = new JButton("ok");
		btnRango.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarArchivoEdad(EdadUsuario);
				ValidarEdad();
				if (edad == 0) {
					JOptionPane.showMessageDialog(null, "Seleccióna un rango de edad");
				} else {
					guardarEdad(edad);
				}
			}
		});
		btnRango.setFont(new Font("Arial", Font.BOLD, 11));
		btnRango.setBounds(258, 152, 89, 23);
		contentPane.add(btnRango);

		NombreGuardar = new JTextField();
		NombreGuardar.setBounds(203, 186, 193, 20);
		contentPane.add(NombreGuardar);
		NombreGuardar.setColumns(10);
		NombreGuardar.setVisible(true);

		JButton btnNombre = new JButton("ok");
		btnNombre.setBackground(Color.LIGHT_GRAY);
		btnNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!("".equals(NombreGuardar.getText()) || NombreGuardar.getText() == null
						|| " ".equals(NombreGuardar.getText()))) {
					borrarArchivoEdad(NombreUsuario);
					guardarNombreUsuario(NombreGuardar.getText());

				} else {
					JOptionPane.showMessageDialog(null, "Ingresa un Nombre valido");
				}

			}
		});
		btnNombre.setFont(new Font("Arial", Font.BOLD, 12));
		btnNombre.setBounds(258, 217, 89, 23);
		contentPane.add(btnNombre);
		
		JButton Finalizado = new JButton("Hecho!");
		Finalizado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Finalizado.setBounds(258, 266, 89, 23);
		contentPane.add(Finalizado);

		setUndecorated(true);// Decoraciones Deshabilitadas
		setBackground(new Color(0, 0, 0, 0));
		ajuste.TamañoPantalla(this, getX(), getY());

	}

	private static String cargarNombreUsuario() {
		try (BufferedReader br = new BufferedReader(new FileReader(NombreUsuario))) {
			return br.readLine();
		} catch (IOException e) {
			return null;
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

	private void guardarEdad(int edad) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(EdadUsuario))) {
			bw.write(String.valueOf(edad));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void borrarArchivoEdad(String nombreArchivo) {
		File archivo = new File(nombreArchivo);
		if (archivo.exists()) {
			archivo.delete();
			System.out.println("El archivo " + nombreArchivo + " ha sido borrado.");
		} else {
			System.out.println("El archivo " + nombreArchivo + " no existe.");
		}
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
