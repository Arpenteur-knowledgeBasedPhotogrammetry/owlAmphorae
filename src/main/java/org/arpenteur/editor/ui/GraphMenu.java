package org.arpenteur.editor.ui;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class GraphMenu extends JPopupMenu {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3853448093837619934L;
	
	
	private JMenuItem rename = new JMenuItem("Rename");
	
	private JMenuItem copy = new JMenuItem("Copy");
		
	
	public GraphMenu() {
		super("Menu");
		this.add(rename);
		this.add(copy);
	}
}
