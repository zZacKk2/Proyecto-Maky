package Mascota;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Personalizacion extends JFrame {
	private String ruta = "/Diseño/Panda.png";

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JLabel Repuesto;
	private static JFrame repuesto2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Personalizacion frame = new Personalizacion(Repuesto, repuesto2);
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
	public Personalizacion(JLabel label, JFrame frame) {
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Personalizacion.class.getResource("/Diseño/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPersonaje = new JLabel("");
		lblPersonaje.setIcon(new ImageIcon(Personalizacion.class.getResource(ruta)));
		lblPersonaje.setBounds(151, 318, 146, 146);
		ImageIcon foto = new ImageIcon(getClass().getResource(ruta));
		ImageIcon img = new ImageIcon(foto.getImage().getScaledInstance(lblPersonaje.getWidth(), lblPersonaje.getHeight(), Image.SCALE_SMOOTH)); //Escalar imagen al label
		lblPersonaje.setIcon(img);
		contentPane.add(lblPersonaje);
		
		////////////////// CAMBIO DE FRAME!!!!!!!!!!
		JButton btnFuncion = new JButton("");
		btnFuncion.setBackground(new Color(255, 255, 255));
		btnFuncion.setIcon(new ImageIcon(Personalizacion.class.getResource("/Diseño/menutra.png")));
		btnFuncion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//label.setIcon((Icon) actualizarIcono(label, ruta));
				//frame.setVisible(true);
				dispose();
			}
			});
		btnFuncion.setBounds(307, 313, 31, 28);
		ImageIcon foto0 = new ImageIcon(getClass().getResource("/Diseño/menutra.png"));
		ImageIcon img0 = new ImageIcon(foto0.getImage().getScaledInstance(btnFuncion.getWidth(), btnFuncion.getHeight(), Image.SCALE_SMOOTH)); //Escalar imagen al label
		btnFuncion.setIcon(img0);
		contentPane.add(btnFuncion);
		ImageIcon foto1 = new ImageIcon(getClass().getResource("/Diseño/cuadroazul.png"));
		
		
		//Boton personajes =====================================================================
		
		JButton btnPerPanda = new JButton("");
		btnPerPanda.setForeground(new Color(255, 255, 255));
		btnPerPanda.setBackground(new Color(255, 255, 255));
		btnPerPanda.setIcon(new ImageIcon(Personalizacion.class.getResource("/Diseño/Panda.png")));
		
		btnPerPanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ruta = "/Diseño/Panda.png";
				actualizarIcono(lblPersonaje, ruta);
			}
		});
		btnPerPanda.setBounds(279, 98, 89, 89);
		ImageIcon foto4 = new ImageIcon(getClass().getResource("/Diseño/Panda.png"));
		ImageIcon img4 = new ImageIcon(foto4.getImage().getScaledInstance(btnPerPanda.getWidth(), btnPerPanda.getHeight(), Image.SCALE_SMOOTH)); //Escalar imagen al label
		btnPerPanda.setIcon(img4);
		contentPane.add(btnPerPanda);
		
		JButton btnPerConejo = new JButton("");
		btnPerConejo.setForeground(new Color(255, 255, 255));
		btnPerConejo.setBackground(new Color(255, 255, 255));
		btnPerConejo.setIcon(new ImageIcon(Personalizacion.class.getResource("/Diseño/Conejo.png")));
		btnPerConejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ruta = "/Diseño/Conejo.png";
				actualizarIcono(lblPersonaje, ruta);
			}
		});
		btnPerConejo.setBounds(378, 98, 89, 89);
		ImageIcon foto2 = new ImageIcon(getClass().getResource("/Diseño/Conejo.png"));
		ImageIcon img2 = new ImageIcon(foto2.getImage().getScaledInstance(btnPerConejo.getWidth(), btnPerConejo.getHeight(), Image.SCALE_SMOOTH)); //Escalar imagen al label
		btnPerConejo.setIcon(img2);
		contentPane.add(btnPerConejo);
		
		JButton btnPerPerro = new JButton("");
		btnPerPerro.setForeground(new Color(255, 255, 255));
		btnPerPerro.setBackground(new Color(255, 255, 255));
		btnPerPerro.setIcon(new ImageIcon(Personalizacion.class.getResource("/Diseño/Perro.png")));
		btnPerPerro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ruta = "/Diseño/Perro.png";
				actualizarIcono(lblPersonaje, ruta);
			}
		});
		btnPerPerro.setBounds(478, 98, 89, 89);
		ImageIcon foto3 = new ImageIcon(getClass().getResource("/Diseño/Perro.png"));
		ImageIcon img3 = new ImageIcon(foto3.getImage().getScaledInstance(btnPerPerro.getWidth(), btnPerPerro.getHeight(), Image.SCALE_SMOOTH)); //Escalar imagen al label
		btnPerPerro.setIcon(img3);
		contentPane.add(btnPerPerro);
		
		JButton btnPerGato = new JButton("");
		btnPerGato.setForeground(new Color(255, 255, 255));
		btnPerGato.setBackground(new Color(255, 255, 255));
		btnPerGato.setIcon(new ImageIcon(Personalizacion.class.getResource("/Diseño/Gato.png")));
		btnPerGato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ruta = "/Diseño/Gato.png";
				actualizarIcono(lblPersonaje, ruta);
			}
		});
		btnPerGato.setBounds(378, 198, 89, 89);
		ImageIcon foto5 = new ImageIcon(getClass().getResource("/Diseño/Gato.png"));
		ImageIcon img5 = new ImageIcon(foto5.getImage().getScaledInstance(btnPerGato.getWidth(), btnPerGato.getHeight(), Image.SCALE_SMOOTH)); //Escalar imagen al label
		btnPerGato.setIcon(img5);
		contentPane.add(btnPerGato);
		
		JButton btnPerGallina = new JButton("");
		btnPerGallina.setForeground(new Color(255, 255, 255));
		btnPerGallina.setBackground(new Color(255, 255, 255));
		btnPerGallina.setIcon(new ImageIcon(Personalizacion.class.getResource("/Diseño/Gallina.png")));
		btnPerGallina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ruta = "/Diseño/Gallina.png";
				actualizarIcono(lblPersonaje, ruta);
			}
		});
		btnPerGallina.setBounds(478, 198, 89, 89);
		ImageIcon foto6 = new ImageIcon(getClass().getResource("/Diseño/Gallina.png"));
		ImageIcon img6 = new ImageIcon(foto6.getImage().getScaledInstance(btnPerGallina.getWidth(), btnPerGallina.getHeight(), Image.SCALE_SMOOTH)); //Escalar imagen al label
		btnPerGallina.setIcon(img6);
		contentPane.add(btnPerGallina);
		
		JButton btnPerKoala = new JButton("");
		btnPerKoala.setForeground(new Color(255, 255, 255));
		btnPerKoala.setBackground(new Color(255, 255, 255));
		btnPerKoala.setIcon(new ImageIcon(Personalizacion.class.getResource("/Diseño/Koala.png")));
		btnPerKoala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ruta = "/Diseño/Koala.png";
				actualizarIcono(lblPersonaje, ruta);
			}
		});
		btnPerKoala.setBounds(279, 198, 89, 89);
		ImageIcon foto7 = new ImageIcon(getClass().getResource("/Diseño/Koala.png"));
		ImageIcon img7 = new ImageIcon(foto7.getImage().getScaledInstance(btnPerKoala.getWidth(), btnPerKoala.getHeight(), Image.SCALE_SMOOTH)); //Escalar imagen al label
		btnPerKoala.setIcon(img7);
		contentPane.add(btnPerKoala);
		
		//=====================================================================================================
		
		JLabel lblCuadro = new JLabel("");
		lblCuadro.setIcon(new ImageIcon(Personalizacion.class.getResource("/Diseño/cuadroazul.png")));
		lblCuadro.setBounds(255, 81, 336, 218);
		ImageIcon img1 = new ImageIcon(foto1.getImage().getScaledInstance(lblCuadro.getWidth(), lblCuadro.getHeight(), Image.SCALE_SMOOTH)); //Escalar imagen al label
		lblCuadro.setIcon(img1);
		contentPane.add(lblCuadro);
		
		JButton btnPersonaliza = new JButton("");
		btnPersonaliza.setIcon(new ImageIcon(Personalizacion.class.getResource("/Diseño/personali.png")));
		btnPersonaliza.setBounds(345, 41, 234, 34);
		ImageIcon foto8 = new ImageIcon(getClass().getResource("/Diseño/personali.png"));
		ImageIcon img8 = new ImageIcon(foto8.getImage().getScaledInstance(btnPersonaliza.getWidth(), btnPersonaliza.getHeight(), Image.SCALE_SMOOTH)); //Escalar imagen al label
		btnPersonaliza.setIcon(img8);
		contentPane.add(btnPersonaliza);
		
	}
	
    private JLabel actualizarIcono(JLabel label, String rutaImagen) {
        ImageIcon foto = new ImageIcon(getClass().getResource(rutaImagen));
        ImageIcon img = new ImageIcon(foto.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
        label.setIcon(img);
        return label;
	}
}

