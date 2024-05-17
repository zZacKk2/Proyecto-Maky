package SistemaOperativo;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class mascota implements Acciones {


	@Override
	public void AbrirCalculadora() {
		try {
			Runtime.getRuntime().exec("calc");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void AbrirBlocNotas() {
		try {
			Runtime.getRuntime().exec("notepad");
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	public boolean MensajeWord() {
		try {
			// Obtiene la lista de procesos en ejecución
			Process process = Runtime.getRuntime().exec("Tasklist");
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			boolean WordAbierto = false;
			while ((line = reader.readLine()) != null) {

				if (line.contains("WINWORD.EXE")) {
					WordAbierto = true;
					break;
				}
			}
			// Si Word está corriendo, muestra el mensaje
			if (WordAbierto) {
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
		return false;

	}

	@Override
	public void AbrirNavegador() {
		try {
			// URL de Google
			URI googleURI = new URI("https://www.google.com");

			// Abrir Google en el navegador predeterminado
			Desktop.getDesktop().browse(googleURI);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void mostrarCalendario() {
		try {
			ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "start", "outlookcal:");
            pb.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void AcercaDe() {
		try {
			Runtime.getRuntime().exec("msinfo32");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void AbrirBurbujaChat() {

        try {

            
            Process proceso = Runtime.getRuntime().exec("python src/Chat.py");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean MensajeVS() {
		try {
			// Obtiene la lista de procesos en ejecución
			Process process = Runtime.getRuntime().exec("Tasklist");
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			boolean VSAbierto = false;
			while ((line = reader.readLine()) != null) {

				if (line.contains("devenv.exe")) {
					VSAbierto = true;
					break;
				}
			}
			// Si Word está corriendo, muestra el mensaje
			if (VSAbierto) {
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public boolean MensajeSpoty() {
		try {
			// Obtiene la lista de procesos en ejecución
			Process process = Runtime.getRuntime().exec("Tasklist");
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			boolean SpotifyAbierto = false;
			while ((line = reader.readLine()) != null) {

				if (line.contains("Spotify.exe")) {
					SpotifyAbierto = true;
					break;
				}
			}
			// Si Word está corriendo, muestra el mensaje
			if (SpotifyAbierto) {
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
		return false;
	}


}
