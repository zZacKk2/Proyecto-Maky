package SistemaOperativo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class mascota implements Acciones{
	
	private LocalDateTime FechaYHora = LocalDateTime.now();

	@Override
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
	public String MostrarHora() {  
        
        LocalTime HoraActual = FechaYHora.toLocalTime();
        DateTimeFormatter Formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        String Hora = HoraActual.format(Formato);
		return Hora;
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
            boolean chromeRunning = false;
            while ((line = reader.readLine()) != null) {
                // Verifica si el proceso de Chrome está en la lista de procesos
                if (line.contains("WINWORD.exe")) {
                    chromeRunning = true;
                    break;
                }
            }
            // Si Chrome está corriendo, muestra el mensaje
            if (chromeRunning) {
                System.out.println("word abierto");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	

}
