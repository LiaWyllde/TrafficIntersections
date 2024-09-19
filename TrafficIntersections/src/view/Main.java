package view;

import java.util.concurrent.Semaphore;

import controller.Intersection;

public class Main {

	public static void main(String[] args) {
		
		Semaphore semaph = new Semaphore(1);
		
		for (int i = 0; i < 4; i++) {
			Intersection car = new Intersection(semaph, i);
			car.start();
		}
	}
}
