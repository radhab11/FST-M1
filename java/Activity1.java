package activities;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car toyato = new Car();
		
		toyato.make = 2014;
		toyato.color = "Black";
		toyato.transmission = "Manual";
		
		toyato.displayCharacteristics();
		toyato.accelarate();
		toyato.brake();

	}

}
