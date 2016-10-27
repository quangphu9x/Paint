package shape;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class Rectangle extends Shape {

	protected int x, y, width, height;
	
	public Rectangle(int x, int y, int x1, int y1) {
		this.x = Math.min(x, x1);
		this.y = Math.min(y, y1);
		width = Math.abs(x - x1);
		height = Math.abs(y - y1);
	}
	
	public void draw(Graphics2D g) {
		if(fill) {
			g.setColor(color2);
			g.fillRect(x, y, width, height);
		}
		g.setStroke(new BasicStroke(size));
		g.setColor(color1);
		g.drawRect(x, y, width, height);
	}
	
}
