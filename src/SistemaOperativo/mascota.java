package SistemaOperativo;
import java.io.IOException;
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

}
