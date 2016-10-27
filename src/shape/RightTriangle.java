package shape;

public class RightTriangle extends Polygon {

	public RightTriangle(int x, int y, int x1, int y1) {
		xPoints = new int[] {x, x, x1};
		yPoints = new int[] {y1, y, y1};
	}
}
