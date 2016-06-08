package Abstraction;

public abstract class Vehicle {
	
	public void driveToStore() {
		start();
		navigate();
		stop();
	}
	
	public abstract void start();
	
	public void navigate() {
		System.out.println("Turn Left");
		System.out.println("Turn Right");
		System.out.println("Turn Right Again");
	}
	
	public abstract void stop();
}
