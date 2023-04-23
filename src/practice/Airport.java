package practice;

public class Airport {

	private String city;
	private String code;
	
	public Airport(String city, String code) {
		this.code=code;
		this.city=city;
	}

	public String getCity() {
		return city;
	}

	public String getCode() {
		return code;
	}

	public static String findAirportCode(String toFind, Airport[] airports) {
		String result = "Did not find city";
		
		for(Airport airport: airports) {
			if(airport.getCode().equals(toFind)) {
				return "Found City";
			}
		}
		
		return result;
		
	}
	
	
}
