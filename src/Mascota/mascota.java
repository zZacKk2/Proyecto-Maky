/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mascota;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author HP
 */
public class mascota implements Acciones{

   public void AbrirCalculadora() {
		try{
			Runtime.getRuntime().exec("calc");
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void AbrirBlocNotas() {
		try{
			Runtime.getRuntime().exec("notepad");
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public void MostrarFecha() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void MostrarHora() {  
        
		try {
		    Runtime.getRuntime().exec("cmd /c start ms-clock:");
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

	@Override
	public void MostrarClima() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean MensajeGoogle() {
		try {
            Process process = Runtime.getRuntime().exec("Tasklist");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            boolean chromeRunning = false;
            while ((line = reader.readLine()) != null) {
                
                if (line.contains("chrome.exe")) {
                    chromeRunning = true;
                    break;
                }
            }
            if (chromeRunning) {  
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();     
        }
		return false;
	}

	@Override
	public void MensajeWord() {
		try {
            // Obtiene la lista de procesos en ejecución
            Process process = Runtime.getRuntime().exec("Tasklist");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            boolean WordAbierto = false;
            while ((line = reader.readLine()) != null) {
                
                if (line.contains("WINWORD.exe")) {
                	WordAbierto = true;
                    break;
                }
            }
            // Si Word está corriendo, muestra el mensaje
            if (WordAbierto) {
                System.out.println("word abierto");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void mostrarCalendario() {
		try {
		    Runtime.getRuntime().exec("cmd /c start outlookcal:");
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}
}
