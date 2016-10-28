package shape;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class RoundedRectangularCallout extends Shape {
	
	private int x, y, x1, y1;
	
	public RoundedRectangularCallout(int x, int y, int x1, int y1) {
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
	}

	public void draw(Graphics2D g) {
		int width = Math.abs(x - x1);
		int height = Math.abs(y - y1);
		int xMin = Math.min(x, x1);
		int xMax = Math.max(x, x1);
		int yMin = Math.min(y, y1);
		int yMax = Math.max(y, y1);
		if(fill) {
			g.setColor(color2);
			g.fillRoundRect(
					xMin,
					yMin + ((y > y1) ? (height / 6) : 0),
					width, (5 * height) / 6 ,
					width / 5, height / 5
			);
			int[] xPoints, yPoints;
			xPoints = new int[]{
					xMin + width / 5,
					xMin + (2 * width) / 5,
					xMin + (3 * width) / 10
			};
			if(y < y1) { // xuoi
				yPoints = new int[]{
						yMin + (5 * height) / 6,
						yMin + (5 * height) / 6,
						y1
				};
			} else { // nguoc
				yPoints = new int[]{
						yMin + height / 6,
						yMin + height / 6,
						y1
				};
			}
			g.fillPolygon(xPoints, yPoints, 3);
		}
		
		g.setStroke(new BasicStroke(size));
		g.setColor(color1);
		if(y < y1) { // xuoi
			g.drawArc(xMin, yMin, width / 5, height / 5, 90, 90);
			g.drawArc(xMin + (4 * width) / 5, yMin, width / 5, height / 5, 0, 90);
			g.drawArc(xMin, yMin + (19 * height) / 30, width / 5, height / 5, 180, 90);
			g.drawArc(xMin + (4 * width) / 5, yMin + (19 * height) / 30, width / 5, height / 5, 270, 90);
			
			g.drawLine(xMin + width / 5, yMin + (5 * height) / 6, xMin + (3 * width) / 10, yMax);
			g.drawLine(xMin + (2 * width) / 5, yMin + (5 * height) / 6, xMin + (3 * width) / 10, yMax);
			
			g.drawLine(xMin + width / 10, yMin, xMin + (9 * width) / 10, yMin);
			g.drawLine(xMin, yMin + height / 10, xMin, yMin + (11 * height) / 15);
			g.drawLine(xMax, yMin + height / 10, xMax, yMin + (11 * height) / 15);
			g.drawLine(xMin + width / 10, yMin + (5 * height) / 6, xMin + width / 5, yMin + (5 * height) / 6); 
			g.drawLine(xMin + (2 * width) / 5, yMin + (5 * height) / 6, xMin + (9 * width) / 10, yMin + (5 * height) / 6);
		} else { // nguoc
			g.drawArc(xMin, yMin + height / 6, width / 5, height / 5, 90, 90);
			g.drawArc(xMin + (4 * width) / 5, yMin + height / 6, width / 5, height / 5, 0, 90);
			g.drawArc(xMin, yMin + (4 * height) / 5, width / 5, height / 5, 180, 90);
			g.drawArc(xMin + (4 * width) / 5, yMin + (4 * height) / 5, width / 5, height / 5, 270, 90);
			
			g.drawLine(xMin + width / 5, yMin + height / 6, xMin + (3 * width) / 10, yMin);
			g.drawLine(xMin + (2 * width) / 5, yMin + height / 6, xMin + (3 * width) / 10, yMin);
			
			g.drawLine(xMin + width / 10, yMax, xMin + (9 * width) / 10, yMax);
			g.drawLine(xMin, yMin + (4 * height) / 15, xMin, yMin + (9 * height) / 10);
			//g.drawLine(xMax - 1, yMin + height / 10, xMax - 1, yMin + (11 * height) / 15);
		}
		
	}

}
