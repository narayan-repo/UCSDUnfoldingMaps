package practice;

import processing.core.*;

public class HappyFace extends PApplet{
	
	@Override
	public void setup() {
		size(400,400);
		background(255,255,255);
	}
	
	@Override
	public void draw() {
		fill(255,209,0);
		ellipse(width/2,height/2,width/2,height/2);
		fill(0,0,0);
		ellipse((float) (width/2.5),(float) (height/2.5),width/10,height/10);
		ellipse((float) (width/1.67),(float) (height/2.5),width/10,height/10);
		arc(width/2,(float) (height/1.8),50,50,0,PI);
	}
}
