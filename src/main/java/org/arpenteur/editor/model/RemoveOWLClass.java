/**
 * Remove selected class of ontology 
 * This class is still under development
 * there is some bugs if you use this class
 * 
 * @author Yaaqoub Semlali, The University Of Aix-Marseille
 * @see <a href="http://www.yaaqoubsemlali.com">http://www.yaaqoubsemlali.com</a>
 */
package org.arpenteur.editor.model;

import org.arpenteur.editor.ui.ClassesPanel;
import org.arpenteur.variables.GlobalVariables;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;

public class RemoveOWLClass {
	
	/**
	 * 
	 */
	public RemoveOWLClass() {
		
		/*OWLClass clsPSS = MyVariables.dataFactory.getOWLClass(IRI.create(MyVariables.prefix() + ":" + ClassesPanel.classSelectedName));
		
		Set<OWLClassAssertionAxiom> classAssertion = MyVariables.ontology.getClassAssertionAxioms(clsPSS);
		
		MyVariables.ontologyManager.removeAxioms(MyVariables.ontology, classAssertion);*/
		/*for (OWLClass c : MyVariables.ontology.getClassesInSignature()) {
			if(ClassesPanel.classSelectedName.equals(c.getIRI().getShortForm())) {
				Set<OWLClassAssertionAxiom> classAssertion = MyVariables.ontology.getClassAssertionAxioms(c);
				MyVariables.ontologyManager.removeAxiom(MyVariables.ontology, classAssertion.iterator().next());
			}
			
		}*/
		
		
		for (OWLClass c : GlobalVariables.ontology.getClassesInSignature())  {
			if(ClassesPanel.classSelectedName.equals(c.getIRI().getShortForm())) {
				for (OWLClassAssertionAxiom clazzAx : GlobalVariables.ontology.getClassAssertionAxioms(c)) {
					GlobalVariables.ontologyManager.removeAxiom(GlobalVariables.ontology, clazzAx);
				}
			}
		}
	}
}
