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

	public static String findAirportCodeByBinarySearch(String toFind, Airport[] airports) {
		String result = "Did not find city";
		int low = 0;
		int high=airports.length-1;
		int mid;
		while(high>=low) {
			mid=low + (high-low)/2;
			if(toFind.compareTo(airports[mid].getCode()) == 0) {
				return airports[mid].getCity();
			}else if(toFind.compareTo(airports[mid].getCode()) > 0) {
				low=mid+1;
			}else {
				high=mid-1;
			}
		}
		return result;
	}
	
	
}
