package shape;

import java.awt.Graphics2D;
import java.awt.Image;

public class Img extends Shape {
	
	private Image img;
	private int x, y, width, height;
	
	public Img(Image img) {
		this.img = img;
		x = 0;
		y = 0;
		width = img.getWidth(null);
		height = img.getHeight(null);
	}
	
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void draw(Graphics2D g) {
		g.drawImage(img, x, y, width, height, null);
	}

	
	
}
