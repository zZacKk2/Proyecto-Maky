/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Extras;

import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author HP
 */
public class Ajustes {
   
    public Ajustes(){
        
    }
    
    public JLabel resizableLabel(JLabel label, String imagen) {
	ImageIcon icon1 = new ImageIcon(imagen);
	Icon nuevoIcon = new ImageIcon(icon1.getImage().getScaledInstance(label.getHeight(), label.getWidth(), Image.SCALE_DEFAULT));
	label.setIcon(nuevoIcon);
	return label;
    }
    
    public JButton resizableButton(JButton boton, String imagen){
        ImageIcon icon1 = new ImageIcon(imagen);
	Icon nuevoIcon = new ImageIcon(icon1.getImage().getScaledInstance(boton.getHeight(), boton.getWidth(), Image.SCALE_DEFAULT));
        boton.setIcon(nuevoIcon);
        return boton;
    }
    
    public void TamañoPantalla(JFrame frame, int x, int y){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = ge.getMaximumWindowBounds();
        
        // Calcula las coordenadas para la esquina inferior derecha
        x = bounds.x + bounds.width - frame.getWidth();
        y = bounds.y + bounds.height - frame.getHeight();

        // Establece la posición del JFrame en la esquina inferior derecha
        frame.setLocation(x, y);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
