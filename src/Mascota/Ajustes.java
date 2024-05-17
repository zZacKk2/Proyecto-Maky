package Mascota;

import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ajustes {

       public Ajustes() {

       }

       public Icon resizableIcon(String url, JButton boton) {
               ImageIcon icon1 = new ImageIcon(url);
               int anchoBoton = boton.getWidth();
               int altoBoton = boton.getHeight();
               ImageIcon finalIcon = new ImageIcon(icon1.getImage().getScaledInstance(anchoBoton, altoBoton, Image.SCALE_SMOOTH));
               return finalIcon;

       }

       //Metodo para ajustar el tamaño de una imagen con base al tamaño del JLabel
       public Icon resizableLabel(Image image, JLabel imagen) {
                       ImageIcon icon1 = new ImageIcon(image);
                       int ancho = imagen.getWidth();
                       int alto = imagen.getHeight();

                       ImageIcon finalIcon = new ImageIcon(icon1.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
                       return finalIcon;
               }

    public JFrame TamañoPantalla(JFrame frame, int x, int y){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = ge.getMaximumWindowBounds();

        // Calcula las coordenadas para la esquina inferior derecha
        x = bounds.x + bounds.width - frame.getWidth();
        y = bounds.y + bounds.height - frame.getHeight();

        // Establece la posición del JFrame en la esquina inferior derecha
        frame.setLocation(x, y);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        return frame;
    }
}
