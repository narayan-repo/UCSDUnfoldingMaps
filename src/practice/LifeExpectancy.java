package practice;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.providers.OpenStreetMap;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.*;

public class LifeExpectancy extends PApplet{

	private UnfoldingMap map;
	
	@Override
	public void setup() {
		size(800,600,OPENGL);
		map = new UnfoldingMap(this, 50, 50, 700, 500, new OpenStreetMap.OpenStreetMapProvider());
		
		MapUtils.createDefaultEventDispatcher(this, map);
	}
	
	@Override
	public void draw() {
		map.draw();
	}
}
