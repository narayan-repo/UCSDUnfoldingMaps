package practice;

import processing.core.*;

public class Week3 extends PApplet{

	private String URL = "C:\\Users\\namaity\\Downloads\\image.jpg";
	private PImage backgroundImage;
	
	@Override
	public void setup() {
		size(600,400);
		backgroundImage = loadImage(URL,"jpg");
		image(backgroundImage, 0,0);
	}
	
	@Override
	public void draw() {
		backgroundImage.resize(width, height);
		
		int[] color = sunColorSec(second());
		fill(color[0],color[1],color[2]);
		
		ellipse(width/4, height/5, (float) (width/7.5), height/5);	
	}
	
	public int[] sunColorSec(float seconds) {
		int[] rgb = new int[3];
		
		float diffFrom30 = Math.abs(30-seconds);
		float ratio = diffFrom30/30;
		
		rgb[0] = (int) (255*ratio);
		rgb[1] = (int) (255*ratio);
		rgb[2] = 0;
		
		return rgb;
	}
	
}
