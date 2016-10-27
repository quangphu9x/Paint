package shape;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public abstract class Polygon extends Shape {

	protected int[] xPoints, yPoints;
	
	public Polygon() {
		
	}
	
	public void draw(Graphics2D g) {
		if(fill) {
			g.setColor(color2);
			g.fillPolygon(xPoints, yPoints, xPoints.length);
		}
		g.setStroke(new BasicStroke(size));
		g.setColor(color1);
		g.drawPolygon(xPoints, yPoints, xPoints.length);
	}
	
}
