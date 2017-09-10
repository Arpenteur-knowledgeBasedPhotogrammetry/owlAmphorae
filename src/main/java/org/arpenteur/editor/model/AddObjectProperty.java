/**
 * Add a new Object property to a selected individual
 * 
 * @author Yaaqoub Semlali, The University Of Aix-Marseille
 * @see <a href="http://www.yaaqoubsemlali.com">http://www.yaaqoubsemlali.com</a>
 */
package org.arpenteur.editor.model;

import org.arpenteur.editor.ui.IndividualsPanel;
import org.arpenteur.variables.GlobalVariables;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;

public class AddObjectProperty {
	
	/**
	 * Constract a new Object property
	 * 
	 * @param objectPropertyName	The name of the object property
	 * @param objectPropertyValue	The value of the object property
	 */
	public AddObjectProperty(String objectPropertyName, String objectPropertyValue) {
		for (OWLClass c : GlobalVariables.ontology.getClassesInSignature()) {
			String prefix = c.getIRI().getNamespace();
			
			OWLNamedIndividual classIndName = GlobalVariables.dataFactory.getOWLNamedIndividual(IRI.create(prefix + objectPropertyValue));
			OWLNamedIndividual originIndName = GlobalVariables.dataFactory.getOWLNamedIndividual(IRI.create(prefix + IndividualsPanel.individualName));
			OWLObjectProperty objectName = GlobalVariables.dataFactory.getOWLObjectProperty(IRI.create(prefix + objectPropertyName));
			
			OWLAxiom axiom = GlobalVariables.dataFactory.getOWLObjectPropertyAssertionAxiom(objectName, originIndName, classIndName);
			
			AddAxiom addAxiom = new AddAxiom(GlobalVariables.ontology, axiom);
			GlobalVariables.ontologyManager.applyChange(addAxiom);
		}
	}
}
