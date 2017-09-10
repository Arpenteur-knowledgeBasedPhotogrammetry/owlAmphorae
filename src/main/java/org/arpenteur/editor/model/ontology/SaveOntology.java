/**
 * Save Ontology in the same file, same name, same location
 * 
 * @author Yaaqoub Semlali, The University Of Aix-Marseille
 * @see <a href="http://www.yaaqoubsemlali.com">http://www.yaaqoubsemlali.com</a>
 */
package org.arpenteur.editor.model.ontology;

import javax.swing.JOptionPane;

import org.arpenteur.variables.GlobalVariables;
import org.protege.editor.core.ui.error.ErrorLogPanel;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

public class SaveOntology {
	
	/**
	 * Save ontology
	 * @param isDialog		if True display Save Successfully dialog 
	 * 					 	if False don't display Save Successfully dialog 
	 */
	public SaveOntology(boolean isDialog) {
		try {
			GlobalVariables.ontologyManager.saveOntology(GlobalVariables.ontology);
			if (isDialog) {
				JOptionPane.showMessageDialog(null,
				        "Your Ontology has been Saved Successfully",
				        "Save Successfully",
				        JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (OWLOntologyStorageException e) {
			ErrorLogPanel.showErrorDialog(e);
		}
	}
}
