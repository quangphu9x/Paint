package shape;

public class Hexagon extends Polygon {

	public Hexagon(int x, int y, int x1, int y1) {
		int height = Math.abs(y - y1);
		xPoints = new int[] {
				x,
				x,
				(x + x1) / 2,
				x1,
				x1,
				(x + x1) / 2
		};
		yPoints = new int[] {
				Math.min(y, y1) + (3 * height) / 4,
				Math.min(y, y1) + height / 4,
				Math.min(y, y1),
				Math.min(y, y1) + height / 4,
				Math.min(y, y1) + (3 * height) / 4,
				Math.max(y, y1)
		};
	}
	
}
