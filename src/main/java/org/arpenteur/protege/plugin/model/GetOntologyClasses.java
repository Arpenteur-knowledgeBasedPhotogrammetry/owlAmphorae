/**
 * Load ontology classes.
 * This class return a ComboBox model to fill combobox classes in the editor and the plugin
 */
package org.arpenteur.protege.plugin.model;

import java.util.Set;

import javax.swing.DefaultComboBoxModel;

import org.arpenteur.variables.GlobalVariables;
import org.protege.editor.core.ui.error.ErrorLogPanel;
import org.semanticweb.owlapi.model.OWLClass;


public class GetOntologyClasses extends DefaultComboBoxModel<Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7134317243726704934L;
		
	private Set<OWLClass> ontologyClassesArray = null;
	
	@SuppressWarnings("deprecation")
	public GetOntologyClasses() {
		try{
			System.out.println("======== {Start Loading classes} ========");
			
			if(GlobalVariables.ontology != null) {
				ontologyClassesArray = GlobalVariables.ontology.getClassesInSignature();
			}
	
			for (OWLClass test : ontologyClassesArray){
				this.addElement(test.getIRI().getFragment());
	    	}
			System.out.println("======== {End Loading classes} ========");
		} catch (Exception e) {
			ErrorLogPanel.showErrorDialog(e);
		}
	}
}
