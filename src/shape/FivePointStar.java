package shape;

public class FivePointStar extends Polygon {

	public FivePointStar(int x, int y, int x1, int y1) {
		int avgX = (x + x1) / 2;
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
				xMin + (7 * width) / 10,
				xMin + (13 * width) / 16,
				avgX,
				xMin + (3 * width) / 16,
				xMin + (3 * width) / 10,
		};
		yPoints = new int[] {
				yMin + (3 * height) / 8,
				yMin + (3 * height) / 8,
				yMin,
				yMin + (3 * height) / 8,
				yMin + (3 * height) / 8,
				yMin + (5 * height) / 8,
				yMax,
				yMin + (7 * height) / 9,
				yMax,
				yMin + (5 * height) / 8,
				
		};
	}
	
}
