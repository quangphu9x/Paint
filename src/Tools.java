
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Tools extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JLabel pencilTool;
	private JLabel fillTool;
	private JLabel textTool;
	private JLabel eraserTool;
	
	private JLabel lineTool;
	private JLabel ellipseTool;
	private JLabel rectangleTool;
	private JLabel roundedRectangleTool;
	private JLabel triangleTool;
	public static int shape = 0;
	public static final int LINE = 0;
	public static final int ELLIPSE = 1;
	public static final int RECTANGLE = 2;
	public static final int ROUNDEDRECTANGLE = 3;
	public static final int TRIANGLE = 4;
	
	//public 
	
	public Tools() {
		setPreferredSize(new Dimension(600, 50));
		setBackground(Color.YELLOW);
		
		JPanel panelTools = new JPanel();
		pencilTool = new JLabel();
		pencilTool.setIcon(new ImageIcon(getClass().getResource("/img/pencil.png")));
		fillTool = new JLabel();
		fillTool.setIcon(new ImageIcon(getClass().getResource("/img/bucket.png")));
		textTool = new JLabel();
		textTool.setIcon(new ImageIcon(getClass().getResource("/img/text.png")));
		eraserTool = new JLabel();
		eraserTool.setIcon(new ImageIcon(getClass().getResource("/img/eraser.png")));
		panelTools.add(pencilTool);
		panelTools.add(fillTool);
		panelTools.add(textTool);
		panelTools.add(eraserTool);
		
		JPanel panelShapes = new JPanel();
		lineTool = new JLabel();
		lineTool.setIcon(new ImageIcon(getClass().getResource("/img/line.png")));
		ellipseTool = new JLabel();
		ellipseTool.setIcon(new ImageIcon(getClass().getResource("/img/ellipse.png")));
		rectangleTool = new JLabel();
		rectangleTool.setIcon(new ImageIcon(getClass().getResource("/img/rectangle.png")));
		roundedRectangleTool = new JLabel();
		roundedRectangleTool.setIcon(new ImageIcon(getClass().getResource("/img/roundedrectangle.png")));
		triangleTool = new JLabel();
		triangleTool.setIcon(new ImageIcon(getClass().getResource("/img/triangle.png")));
		panelShapes.add(lineTool);
		panelShapes.add(ellipseTool);
		panelShapes.add(rectangleTool);
		panelShapes.add(roundedRectangleTool);
		panelShapes.add(triangleTool);
		
		JPanel panelColors = new JPanel();
		
		
		add(panelTools);
		add(panelShapes);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
