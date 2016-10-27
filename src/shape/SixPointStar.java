package shape;

public class SixPointStar extends Polygon {

	public SixPointStar(int x, int y, int x1, int y1) {
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
				xMin + (8 * width) / 25,
				avgX,
				xMin + (17 * width) / 25,
				xMax,
				xMin + (21 * width) / 25,
				xMax,
				xMin + (17 * width) / 25,
				avgX,
				xMin + (8 * width) / 25,
				xMin,
				xMin + (4 * width) / 25,
		};
		yPoints = new int[] {
				yMin + height / 4,
				yMin + height / 4,
				yMin,
				yMin + height / 4,
				yMin + height / 4,
				yMin + height / 2,
				yMin + (3 * height) / 4,
				yMin + (3 * height) / 4,
				yMax,
				yMin + (3 * height) / 4,
				yMin + (3 * height) / 4,
				yMin + height / 2
		};
	}
}
