package shape;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class Line extends Shape {
	
	private int x, y, x1, y1;

	public Line(int x, int y, int x1, int y1) {
		this.x  = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
	}
	
	public void draw(Graphics2D g) {
		g.setStroke(new BasicStroke(size));
		g.setColor(color1);
		g.drawLine(x, y, x1, y1);
	}

}
