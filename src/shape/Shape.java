package shape;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Shape {
	
	protected boolean fill;
	protected int size; // kich thuoc duong ve
	protected Color color1; // mau vien
	protected Color color2; // mau nen
	
	public Shape() {
		fill = false;
		size = 1;
		color1 = Color.BLACK;
		color2 = Color.ORANGE;
	}
	
	public void setFill(boolean fill) {
		this.fill = fill;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public void setColor1(Color color) {
		color1 = color;
	}
	
	public void setColor2(Color color) {
		color2 = color;
	}
	public abstract void draw(Graphics2D g);
	
}
