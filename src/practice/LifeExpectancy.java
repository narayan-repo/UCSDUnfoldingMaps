package practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.OpenStreetMap;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.*;

public class LifeExpectancy extends PApplet{

	private UnfoldingMap map;
	private Map<String, Float> lifeExpByCountry;
	
	private List<Feature> countries;
	private List<Marker> countryMarkers;
	
	@Override
	public void setup() {
		size(800,600,OPENGL);
		map = new UnfoldingMap(this, 50, 50, 700, 500, new OpenStreetMap.OpenStreetMapProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
		
		lifeExpByCountry = loadLifeExpectancyFromCSV("LifeExpectancyWorldBankModule3.csv");
		
		countries = GeoJSONReader.loadData(this, "countries.geo.json");
		countryMarkers = MapUtils.createSimpleMarkers(countries);
		
		map.addMarkers(countryMarkers);
		
		
		shadeCountries();
		
	}
	
	private void shadeCountries() {

		for(Marker marker: countryMarkers) {
			String countryId = marker.getId();
			
			if(lifeExpByCountry.containsKey(countryId)) {
				float lifeExp = lifeExpByCountry.get(countryId);
				int colorLevel = (int) map(lifeExp, 40, 90, 10, 255);
				marker.setColor(color(255-colorLevel, 100, colorLevel));
			}else {
				marker.setColor(color(150,150,150));
			}
		}
		
	}

	private Map<String, Float> loadLifeExpectancyFromCSV(String fileName) {
		Map<String, Float> lifeExpMap = new HashMap<String, Float>();
		
		String[] rows = loadStrings(fileName);
		for(String row: rows) {
			String[] columns = row.split(",");
			if(columns.length == 6 && !columns[5].equals("..")) { 
				//this if omits the first header row in the CSV file as well as all the empty lifeExp records
				Float lifeExp = Float.parseFloat(columns[5]);
				lifeExpMap.put(columns[4], lifeExp); //column[4] is the country name
			}
		}
		
		return lifeExpMap;
	}

	@Override
	public void draw() {
		map.draw();
	}
}
