
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Menu extends JMenuBar implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	public static JMenu menuFile;
	public static JMenu menuImage;
	public static JMenu menuTools;
	public static JMenu menuShapes;
	
	public static JMenuItem itemNew;
	public static JMenuItem itemOpen;
	public static JMenuItem itemSave;
	public static JMenuItem itemSaveAs;

	public Menu() {
		
		menuFile = new JMenu("File");
		itemNew = new JMenuItem("New");
		itemNew.setAccelerator(KeyStroke.getKeyStroke("control N"));
		itemNew.addActionListener(this);
		itemOpen = new JMenuItem("Open");
		itemOpen.setAccelerator(KeyStroke.getKeyStroke("control O"));
		itemOpen.addActionListener(this);
		itemSave = new JMenuItem("Save");
		itemSave.setAccelerator(KeyStroke.getKeyStroke("control S"));
		itemSave.addActionListener(this);
		itemSaveAs = new JMenuItem("Save As");
		itemSaveAs.setAccelerator(KeyStroke.getKeyStroke("control shift S"));
		itemSaveAs.addActionListener(this);
		menuFile.add(itemNew);
		menuFile.add(itemOpen);
		menuFile.add(itemSave);
		menuFile.add(itemSaveAs);
		
		menuImage = new JMenu("Image");
		menuImage.addActionListener(this);
		menuTools = new JMenu("Tools");
		menuTools.addActionListener(this);
		menuShapes = new JMenu("Shapes");
		menuShapes.addActionListener(this);
		
		add(menuFile);
		add(menuImage);
		add(menuTools);
		add(menuShapes);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
			System.out.println(e.getActionCommand());
		
	}
	
}
