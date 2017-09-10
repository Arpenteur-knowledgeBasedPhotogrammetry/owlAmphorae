package org.arpenteur.protege.plugin.ui.get;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

import javax.swing.JComboBox;
import javax.swing.JToolBar;

import org.protege.editor.core.ui.error.ErrorLogPanel;
import org.protege.editor.core.ui.util.LinkLabel;


public class PluginToolBar extends JToolBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1216014663501753885L;

	private final String classesNameFieldLabel = "Classes Names:  ";
	
		
	public static final URI classes_IRI_DOCUMENTATION = URI.create("https://www.w3.org/TR/2009/REC-owl2-syntax-20091027/#Classes");
	
	
	public PluginToolBar(JComboBox<Object> comboBox) {
		this.add(new LinkLabel(classesNameFieldLabel , e -> {
        	showOntologyIRIDocumentation();
        }));
    	
		this.add(comboBox);
	}
	
	private void showOntologyIRIDocumentation() {
    	try {
            Desktop.getDesktop().browse(classes_IRI_DOCUMENTATION);
        }
        catch (IOException ex) {
            ErrorLogPanel.showErrorDialog(ex);
        }
    }
	
	
	/*private void addListener() {
		//Add_Data.addActionListener(e -> testLoad("http://protege.stanford.edu/ontologies/pizza/pizza.owl"));
	}*/
}
