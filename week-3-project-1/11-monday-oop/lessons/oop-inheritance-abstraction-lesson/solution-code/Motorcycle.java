package Abstraction;

public class Motorcycle extends Vehicle {

	@Override
	public void start() {
		System.out.println("Put on Helmet");
		System.out.println("Kick Start");
		System.out.println("Turn Hand Throttle");
	}

	@Override
	public void stop() {
		System.out.println("Turn Hand Brake");
		System.out.println("Put Down Kickstand");
		System.out.println("Take off helmet");
		
	}

}
