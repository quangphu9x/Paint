package main;

import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	public static Menu menu;
	public static Tools tools;
	public static Canvas canvas;

	public static void main(String[] args) {
		new Main().setVisible(true);
	}
	
	public Main() {
		setTitle("Paint");
		setSize(800, 600);
		setLayout(null);
		menu = new Menu();
		tools = new Tools();
		tools.setBounds(0, 0, 800, 50);
		canvas = new Canvas();
		canvas.setBounds(0, 50, 800, 400);
		setJMenuBar(menu);
		add(tools);
		add(canvas);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				System.out.println(canvas.getWidth());
				tools.setSize(getWidth(), 50);
				repaint();
			}
		});
	}

}
