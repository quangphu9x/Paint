
import java.awt.FlowLayout;

import javax.swing.*;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new Main().setVisible(true);
	}
	
	public Main() {
		setTitle("Paint");
		setSize(800, 600);
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		Menu menu = new Menu();
		Canvas canvas = new Canvas();
		Tools tools = new Tools();
		setJMenuBar(menu);
		add(tools);
		add(canvas);
	}

}
