package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import shape.*;

public class Canvas extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private ArrayList<Shape> shapes;
	
	private Point startDrag, endDrag;
	private RenderingHints rh;
	public static String path = ""; // duong dan luu hinh anh
	
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
		rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	}
	
	public void addShape(Shape shape) {
		shapes.add(shape);
		repaint();
	}
	
	public boolean saveImage() {
		if(path.equals(""))
			return false;
		BufferedImage img = new BufferedImage(
				getWidth(),
				getHeight(),
				BufferedImage.TYPE_INT_ARGB
		);
		
		Graphics2D g = (Graphics2D)img.getGraphics();
		g.setRenderingHints(rh);
		for(Shape s: shapes) {
			s.draw(g);
		}
		
		g.dispose();
		RenderedImage renderedImage = img;
		File file = new File(path);
		String formatName = "png";
		if(path.matches(".\\.jpg") || path.matches(".\\.jpeg"))
			formatName = "jpg";
		else if(path.matches(".\\.gif"))
			formatName = "gif";
		
		try {
			ImageIO.write(renderedImage, formatName, file);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
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
			case Tools.RIGHTTRIANGLE:
				return new RightTriangle(x, y, x1, y1);
			case Tools.DIAMOND:
				return new Diamond(x, y, x1, y1);
			case Tools.PENTAGON:
				return new Pentagon(x, y, x1, y1);
			case Tools.HEXAGON:
				return new Hexagon(x, y, x1, y1);
			case Tools.HORIZONTALARROW:
				return new HorizontalArrow(x, y, x1, y1);
			case Tools.VERTICALARROW:
				return new VerticalArrow(x, y, x1, y1);
			case Tools.FOURPOINTSTAR:
				return new FourPointStar(x, y, x1, y1);
			case Tools.FIVEPOINTSTAR:
				return new FivePointStar(x, y, x1, y1);
			case Tools.SIXPOINTSTAR:
				return new SixPointStar(x, y, x1, y1);
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
