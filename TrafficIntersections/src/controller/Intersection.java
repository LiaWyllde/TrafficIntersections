package controller;

import java.util.concurrent.Semaphore;

public class Intersection extends Thread{
	
	private Semaphore semaph;
	private String[] direction = {"North","South","East","West"};
	private String theCar;
	private String[] car = new String[2];
	//car[0] direction car[1] "name"
	private final int id = (int)threadId();
	
 	public Intersection(Semaphore semaph, int i) {
 		
 		this.semaph = semaph;
		theCar = Integer.toString(id);
		car[1] = theCar;
		car[0] = direction[i];
	}
 	
 	private void going() {
		
 		for (int i = 0; i < 4; i++) {
 			System.out.println("The car " + car[1] + " is arriving from the " + car[0]);
 			
 			try {
				sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
 			
 		}
 		System.out.println("The car " + car[1] + " has arrived at the intersection!");
	}
 	
 	private void crossroad() {
		
 		try {
			sleep(1500);
			System.out.println("The car " + car[1] + " crossed the intersection safely!");
		} catch (Exception e) {
			e.printStackTrace();
		}
 		
	}

	@Override
	public void run() {
		going();
		
		try {
			semaph.acquire();
			crossroad();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaph.release();
		}
	}
 	
 	
	
 	
 	
}
