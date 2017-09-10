/**
 * Get Ontology sub classes ,, this class is still under development
 * 
 * @author Yaaqoub Semlali, The University Of Aix-Marseille
 * @see <a href="http://www.yaaqoubsemlali.com">http://www.yaaqoubsemlali.com</a>
 */

package org.arpenteur.test;


import org.arpenteur.editor.ui.ClassesPanel;
import org.arpenteur.variables.GlobalVariables;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.reasoner.Node;

public class GetSubClasses {
	
	public GetSubClasses() {
		//OWLClass someClass = MyVariables.dataFactory.getOWLClass(IRI.create(MyVariables.prefix() + ClassesPanel.classSelectedName));
		
		//Set<OWLClass> classes = MyVariables.reasoner.getSubClasses(someClass, false).getFlattened();
		
		
		for (OWLClass clazz : GlobalVariables.ontology.getClassesInSignature()) {
			if (clazz.getIRI().getShortForm().equals(ClassesPanel.classSelectedName)) {
				for (Node<OWLClass> c : GlobalVariables.reasoner.getSubClasses(clazz, false)) {
					System.err.println(c.iterator().next().getIRI().getShortForm());
				}
			}
		}
	}
}
