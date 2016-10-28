
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.*;

import shape.*;

public class Canvas extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	public static ArrayList<Shape> shapes;
	
	private Point startDrag, endDrag;
	
	public Canvas() {
		setPreferredSize(new Dimension(800, 400));
		setBackground(Color.WHITE);
		setFocusable(true);
		shapes = new ArrayList<Shape>();
		addMouseListener(this);
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				endDrag = e.getPoint();
				repaint();
			}
		});
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHints(rh);
		for(Shape s: shapes) {
			s.draw(g2);
		}
		
		if(startDrag != null && endDrag != null) {
			makeShape(startDrag.x, startDrag.y, endDrag.x, endDrag.y).draw(g2);
		}
	}
	
	private Shape makeShape(int x, int y, int x1, int y1) {
		switch(Tools.shape) {
			case Tools.LINE:
				return new Line(x, y, x1, y1);
			case Tools.ELLIPSE:
				return new Ellipse(x, y, x1, y1);
			case Tools.RECTANGLE:
				return new Rectangle(x, y, x1, y1);
			case Tools.ROUNDEDRECTANGLE:
				return new RoundedRectangle(x, y, x1, y1);
			case Tools.TRIANGLE:
				return new Triangle(x, y, x1, y1);
		}
		return null;
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		startDrag = endDrag = e.getPoint();
		repaint();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		shapes.add(makeShape(startDrag.x, startDrag.y, e.getX(), e.getY()));
		startDrag = endDrag = null;
		repaint();
	}

}
