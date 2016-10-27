package shape;

public class HorizontalArrow extends Polygon {

	public HorizontalArrow(int x, int y, int x1, int y1) {
		int avgX = (x + x1) / 2;
		int height = Math.abs(y - y1);
		xPoints = new int[] {x, x, avgX, avgX, x1, avgX, avgX};
		yPoints = new int[] {
				Math.min(y, y1) + (3 * height) / 4,
				Math.min(y, y1) + height / 4,
				Math.min(y, y1) + height / 4,
				Math.min(y, y1),
				(y + y1) / 2,
				Math.max(y, y1),
				Math.min(y, y1) + (3 * height) / 4
		};
	}
	
}
