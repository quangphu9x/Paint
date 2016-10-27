package shape;

public class Diamond extends Polygon {

	public Diamond(int x, int y, int x1, int y1) {
		int avgX = (x + x1) / 2;
		int avgY = (y + y1) / 2;
		xPoints = new int[] {x, avgX, x1, avgX};
		yPoints = new int[] {avgY, y, avgY, y1};
	}

}
