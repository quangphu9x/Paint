package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Tools extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private Button[] toolsButton;
	private Button[] shapesButton;
	
	public static int shape = 0;
	public static final int LINE = 0;
	public static final int ELLIPSE = 1;
	public static final int RECTANGLE = 2;
	public static final int ROUNDEDRECTANGLE = 3;
	public static final int TRIANGLE = 4;
	public static final int RIGHTTRIANGLE = 5;
	public static final int DIAMOND = 6;
	public static final int PENTAGON = 7;
	public static final int HEXAGON = 8;
	public static final int HORIZONTALARROW = 9;
	public static final int VERTICALARROW = 10;
	public static final int FOURPOINTSTAR = 11;
	public static final int FIVEPOINTSTAR = 12;
	public static final int SIXPOINTSTAR = 13;
	
	public Tools() {
		setPreferredSize(new Dimension(800, 50));
		setBackground(Color.YELLOW);
		
		JPanel panelTools = new JPanel();
		toolsButton = new Button[4];
		String[] icons = new String[] {"pencil", "bucket", "text", "eraser"};
		for(int i = 0; i < 4; i++) {
			toolsButton[i] = new Button();
			toolsButton[i].setIcon(new ImageIcon(getClass().getResource("/img/" + icons[i] + ".png")));
			toolsButton[i].addActionListener(this);
			panelTools.add(toolsButton[i]);
		}
		panelTools.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		JPanel panelShapes = new JPanel();
		shapesButton = new Button[14];
		icons = new String[] {
				"line", "ellipse", "rectangle", "roundedrectangle", "triangle",
				"righttriangle", "diamond", "pentagon", "hexagon", "horizontalarrow",
				"verticalarrow", "fourpointstar", "fivepointstar", "sixpointstar"
		};
		for(int i = 0; i < 14; i++) {
			shapesButton[i] = new Button();
			shapesButton[i].setIcon(new ImageIcon(getClass().getResource("/img/" + icons[i] + ".png")));
			shapesButton[i].addActionListener(this);
			panelShapes.add(shapesButton[i]);
		}
		panelShapes.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		JPanel panelColors = new JPanel();
		
		
		add(panelTools);
		add(panelShapes);
	}
	
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 14; i++)
			if(e.getSource().equals(shapesButton[i])) {
				shape = i;
				break;
			}
	}

}
