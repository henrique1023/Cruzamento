package controller;

import java.util.concurrent.Semaphore;

public class CruzamentoCarro extends Thread {
	private int idCarro;
	private Semaphore semaforo;

	public CruzamentoCarro(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		carroTravegando();
		try {
			sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			semaforo.acquire();
			passandoFarol();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	private void passandoFarol() {
		int sentido = idCarro % 4;
		switch (sentido) {
		case 0:
			System.out.println(idCarro+ " Chegou no farol.");
			System.err.println("Carro " + idCarro + " esta passando sentido norte.");
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(idCarro+ " Passou o farol.");
			break;
		case 1:
			System.out.println(idCarro+ "Chegou no farol.");
			System.out.println("Carro " + idCarro + " esta passando sentido sul.");
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(idCarro+ " Passou o farol.");
			break;
		case 2:
			System.out.println(idCarro+ " Chegou no farol.");
			System.out.println("Carro " + idCarro + " esta passando sentido oeste.");
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(idCarro+ " Passou o farol.");
			break;
		case 3:
			System.out.println(idCarro+ " Chegou no farol.");
			System.out.println("Carro " + idCarro + " esta passando sentido leste.");
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(idCarro+ " Passou o farol.");
			break;
		default:
			break;
		}
	}

	private void carroTravegando() {
		int velocidade = (int) ((Math.random() * 51) + 100);
		int distanciaPercorrida = 0;
		int disTotal = (int) ((Math.random() * 1001) + 500);
		int tempo = 1000;
		System.out.println("Carro " + idCarro + " esta indo para o semaforo");
		while (distanciaPercorrida < disTotal) {
			distanciaPercorrida += velocidade;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
