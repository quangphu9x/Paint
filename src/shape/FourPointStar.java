package shape;

public class FourPointStar extends Polygon {

	public FourPointStar(int x, int y, int x1, int y1) {
		int avgX = (x + x1) / 2;
		int avgY = (y + y1) / 2;
		int xMin = Math.min(x, x1);
		int xMax = Math.max(x, x1);
		int yMin = Math.min(y, y1);
		int yMax = Math.max(y, y1);
		int width = Math.abs(x - x1);
		int height = Math.abs(y - y1);
		xPoints = new int[] {
				xMin,
				xMin + (3 * width) / 8,
				avgX,
				xMin + (5 * width) / 8,
				xMax,
				xMin + (5 * width) / 8,
				avgX,
				xMin + (3 * width) / 8
		};
		yPoints = new int[] {
				avgY,
				yMin + (3 * height) / 8,
				yMin,
				yMin + (3 * height) / 8,
				avgY,
				yMin + (5 * height) / 8,
				yMax,
				yMin + (5 * height) / 8,
		};
	}
	
}
