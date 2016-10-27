package shape;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class RoundedRectangle extends Rectangle {
	
	private int arcWidth, arcHeight;

	public RoundedRectangle(int x, int y, int x1, int y1) {
		super(x, y, x1, y1);
		arcWidth = width / 5;
		arcHeight = height / 5;
	}
	
	public void setArc(int arcWidth, int arcHeight) {
		this.arcWidth = arcWidth;
		this.arcHeight = arcHeight;
	}
	
	public void draw(Graphics2D g) {
		if(fill) {
			g.setColor(color2);
			g.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
		}
		g.setStroke(new BasicStroke(size));
		g.setColor(color1);
		g.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
	}
}
