package shape;

public class VerticalArrow extends Polygon {

	public VerticalArrow(int x, int y, int x1, int y1) {
		int width = Math.abs(x - x1);
		int avgY = (y + y1) / 2;
		xPoints = new int[] {
				Math.min(x, x1) + (3 * width) / 4,
				Math.min(x, x1) + width / 4,
				Math.min(x, x1) + width / 4,
				Math.min(x, x1),
				(x + x1) / 2,
				Math.max(x ,  x1),
				Math.min(x, x1) + (3 * width) / 4
		};
		yPoints = new int[] {y1, y1, avgY, avgY, y, avgY, avgY};
	}
	
}
