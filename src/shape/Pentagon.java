package shape;

public class Pentagon extends Polygon {

	public Pentagon(int x, int y, int x1, int y1) {
		int width = Math.abs(x - x1);
		int height = Math.abs(y - y1);
		xPoints = new int[] {
				Math.min(x, x1),
				(x + x1) / 2,
				Math.max(x, x1),
				Math.min(x, x1) + (13 * width) / 16,
				Math.min(x, x1) + (3 * width) / 16
		};
		yPoints = new int[] {
				Math.min(y, y1) + (3 * height) / 8,
				y,
				Math.min(y, y1) + (3 * height) / 8,
				y1,
				y1
				
		};
	}
	
}
