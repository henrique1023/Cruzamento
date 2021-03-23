package view;
import java.util.concurrent.Semaphore;
import controller.CruzamentoCarro;
public class Farol {

	public static void main(String[] args) {
		int permissoes = 3;
		Semaphore semaforo = new Semaphore(permissoes);
		for(int idCarro=1; idCarro<=4;idCarro++) {
			Thread tCarro = new CruzamentoCarro(idCarro, semaforo);
			tCarro.start();
		}
	}

}
