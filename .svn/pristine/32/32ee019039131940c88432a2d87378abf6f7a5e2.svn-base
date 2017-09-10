/**
 * Create editor tabed panes
 * 
 * @author Yaaqoub Semlali, The University Of Aix-Marseille
 * @see <a href="http://www.yaaqoubsemlali.com">http://www.yaaqoubsemlali.com</a>
 */
package org.arpenteur.editor.ui;

import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

public class MainFrameTabbedPane extends JTabbedPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5807466663888207443L;
	
	//For tabed pane test
	//private String instanceNameTab = "Instance Name";

		
	/**
	 * Constract the tabs
	 */
	public MainFrameTabbedPane() {
		//First tab , data and object property tables
		JSplitPane data_Object_Property_Split = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				new DataPropertyPanel(), new ObjectPropertyPanel());
        
        data_Object_Property_Split.setDividerLocation(300);
        
        //The data and object property tab
		this.addTab("Data & Object Property", data_Object_Property_Split);
		
		this.addTab("Ontology Graph", new GraphPanel());
		//the instance tab (this tabed pane was just a test)
		//this.addTab(instanceNameTab, instancePanel);
	}
}
