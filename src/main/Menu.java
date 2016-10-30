package main;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import shape.Img;
import shape.Shape;

public class Menu extends JMenuBar implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JMenu menuFile;
	private JMenu menuImage;
	private JMenu menuTools;
	private JMenu menuShapes;
	
	private JMenuItem itemNew;
	private JMenuItem itemOpen;
	private JMenuItem itemSave;
	private JMenuItem itemSaveAs;
	
	private JMenuItem itemCopy;
	private JMenuItem itemPaste;

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
		itemCopy = new JMenuItem("Copy");
		itemCopy.setAccelerator(KeyStroke.getKeyStroke("control C"));
		itemCopy.addActionListener(this);
		itemPaste = new JMenuItem("Paste");
		itemPaste.setAccelerator(KeyStroke.getKeyStroke("control V"));
		itemPaste.addActionListener(this);
		menuImage.add(itemCopy);
		menuImage.add(itemPaste);
		
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
		if(e.getSource().equals(itemOpen)) {
			open();
		} else if(e.getSource().equals(itemSave)) {
			save();
		} else if(e.getSource().equals(itemPaste)) {
			paste();
		}
	}
	
	private void save() {
		if(!Main.canvas.saveImage()) {
			saveAs();
		}
	}
	
	private void saveAs() {
		JFileChooser fileopen = new JFileChooser();
		fileopen.setAcceptAllFileFilterUsed(false);
		fileopen.addChoosableFileFilter(new FileNameExtensionFilter("JPEG(*.jpg, *.jpeg)", "jpg", "jpeg"));
		fileopen.addChoosableFileFilter(new FileNameExtensionFilter("PNG(*.png)", "png"));
		fileopen.addChoosableFileFilter(new FileNameExtensionFilter("GIF(*.gif)", "gif"));
		int result = fileopen.showDialog(this, null);
		if(result == JFileChooser.APPROVE_OPTION) {
			File file = fileopen.getSelectedFile();
			if(file == null)
				return;
			////
			Canvas.path = file.getPath();
			Main.canvas.saveImage();
		}
	}
	
	private void open() {
		JFileChooser fileopen = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter("Image Files (*.jpg, *.jpeg, *.png, *.gif)", "jpg", "jpeg", "png", "gif");
		fileopen.setAcceptAllFileFilterUsed(false);
		fileopen.setFileFilter(filter);
		int result = fileopen.showDialog(this, null);
		if(result == JFileChooser.APPROVE_OPTION) {
			File file = fileopen.getSelectedFile();
			if(file == null)
				return;
			try {
				Image img = ImageIO.read(file);
				Main.canvas.setSize(img.getWidth(null), img.getHeight(null));
		    	Main.canvas.addShape(new Img(img));
		    	Canvas.path = file.getPath();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void paste() {
		Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
		if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.imageFlavor)) {
			try {
				Image img = (Image)transferable.getTransferData(DataFlavor.imageFlavor);
				Main.canvas.addShape(new Img(img));
			} catch(UnsupportedFlavorException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}
		} else
			System.err.println("getImageFromClipboard: That wasn't an image!");
	}
	
}
