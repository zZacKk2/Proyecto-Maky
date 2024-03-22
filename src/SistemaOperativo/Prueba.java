package SistemaOperativo;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Prueba {

	public static void main(String[] args) {
		Timer tiempo = new Timer();
		
		TimerTask tarea = new TimerTask() {

			@Override
			public void run() {
				System.out.println("Tarea cumplida el: " + new Date());
				
			}
		};
		
		tiempo.schedule(tarea, 0, 2000);
		
		System.out.println("Hola");
		tarea.cancel();
		

	}

}
