package shape;

import java.awt.Graphics2D;

public class Heart extends Shape {
	
	private int x, y, width, height;
	
	public Heart(int x, int y, int x1, int y1) {
		this.x = Math.min(x, x1);
		this.y = Math.min(y, y1);
		width = Math.abs(x - x1);
		height = Math.abs(y - y1);
	}

	public void draw(Graphics2D g) {
		
	}
	
	

}
