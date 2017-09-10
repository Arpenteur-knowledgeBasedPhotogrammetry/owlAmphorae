/**
 * Add a new individual to a selected class
 * 
 * @author Yaaqoub Semlali, The University Of Aix-Marseille
 * @see <a href="http://www.yaaqoubsemlali.com">http://www.yaaqoubsemlali.com</a>
 */
package org.arpenteur.editor.model;

import org.arpenteur.editor.ui.ClassesPanel;
import org.arpenteur.variables.GlobalVariables;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLNamedIndividual;

public class AddIndividual {
	
	/**
	 * Adding new individual to a selected class
	 * 
	 * @param individualName		new individual Name
	 */
	public AddIndividual(String individualName) {
		// the Trick is in ":" .. if u want to add use it
		
		OWLClass clsPSS = GlobalVariables.dataFactory.
				getOWLClass(IRI.create(GlobalVariables.prefix() + ":" + ClassesPanel.classSelectedName));
		
		OWLNamedIndividual indivName = GlobalVariables.dataFactory.
				getOWLNamedIndividual(IRI.create(GlobalVariables.prefix() + ":" + individualName));
		
		OWLClassAssertionAxiom classAssertion = GlobalVariables.dataFactory.getOWLClassAssertionAxiom(clsPSS, indivName);
		
		GlobalVariables.ontologyManager.addAxiom(GlobalVariables.ontology, classAssertion);
	}
}
