/**
 * This is the main Frame all component is grouped here 
 * 
 * @author Yaaqoub Semlali, The University Of Aix-Marseille
 * @see <a href="http://www.yaaqoubsemlali.com">http://www.yaaqoubsemlali.com</a>
 */
package org.arpenteur.editor.ui;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import org.arpenteur.editor.ui.dialog.ExitWarningDialog;
import org.arpenteur.variables.GlobalVariables;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5269434384045518445L;
		
	public static MainFrameTabbedPane tabbedPanes = new MainFrameTabbedPane();
	public MainFrame() {
		init();
		splitFrame();
	}
	
	/**
	 * Function for the main frame only,, any other add ones is in other functions
	 */
	private void init() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 	// Maximize the frame
		this.setSize(900, 700);							// I set the size in case the user restore down the frame
		this.setTitle(GlobalVariables.editorName);			// Title; i chose NYM Editor refering to the first project
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLayout(new BorderLayout());
		
		this.setJMenuBar(new FrameTopMenu());					// Call the class MyMenu to create Menu
		
		addListener();
	}
	
	/**
	 * Create a split pane to Organize the frame.. every Table in a split.
	 * I did this to gain more controle of the tables 
	 */
	private void splitFrame() {
		JSplitPane splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				new ClassesPanel(), new IndividualsPanel());
		
		//The main split the first split @splitPane1 in the right and combo and individuals table in the left
		JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				splitPane1, tabbedPanes);
		
		splitPane1.setDividerLocation(300);
		splitPane2.setDividerLocation(500);
		this.add(splitPane2);
	}
	
	/**
	 * Add listener to the window to know if it is closed
	 */
	private void addListener() {
		this.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent windowEvent) {
		    	if(GlobalVariables.isOntologyChanged) {
		    		new ExitWarningDialog();
		    	} else {
		    		System.exit(0);
		    	}
		    }
		});
	}
}
