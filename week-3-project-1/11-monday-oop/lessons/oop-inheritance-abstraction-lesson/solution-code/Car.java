package Abstraction;

public class Car extends Vehicle {

	@Override
	public void start() {
		System.out.println("Turn Key");
		System.out.println("Put Car into Drive");
		System.out.println("Press on Gas Pedal");
	}

	@Override
	public void stop() {
		System.out.println("Press on Brake");
		System.out.println("Put Car in Park");
		System.out.println("Turn Key");
	}

}
