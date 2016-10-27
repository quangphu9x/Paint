package shape;

public class Triangle extends Polygon {

	public Triangle(int x, int y, int x1, int y1) {
		xPoints = new int[] {x, x1, (x + x1) / 2};
		yPoints = new int[] {y1, y1, y};
	}	
	
}
