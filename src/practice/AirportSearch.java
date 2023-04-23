package practice;

public class AirportSearch {
	public static void main(String[] args) {
		Airport a1 = new Airport("Bangalore", "BLR");
		Airport a2 = new Airport("Kolkata", "KOL");
		Airport a3 = new Airport("Mumbai", "MUM");
		
		Airport[] airports = new Airport[3];
		airports[0]=a1;
		airports[1]=a2;
		airports[2]=a3;
		
		System.out.println(Airport.findAirportCode("KOL", airports));
	}

}
