package org.arpenteur.test;

import java.util.Set;


import org.arpenteur.variables.GlobalVariables;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.search.EntitySearcher;

public class GetImageLocation {
	
	public static String imageLocation = "http://www.bsmc.net.au/wp-content/uploads/No-image-available.jpg";
	
	
	public GetImageLocation(String individualName, String imagePropertyName) {
		
		for (OWLClass c : GlobalVariables.ontology.getClassesInSignature()) {
			NodeSet<OWLNamedIndividual> instances = GlobalVariables.reasoner.getInstances(c, false);
			
			for (OWLNamedIndividual i : instances.getFlattened()) {
				if(i.getIRI().getShortForm().equals(individualName)) {
					OWLNamedIndividual input = GlobalVariables.dataFactory.getOWLNamedIndividual(IRI.create(i.getIRI().toString()));
					Set<OWLDataPropertyAssertionAxiom> properties = GlobalVariables.ontology.getDataPropertyAssertionAxioms(input);
					
					for (OWLDataPropertyAssertionAxiom ax: properties) {
						for (OWLLiteral propertyLit :  EntitySearcher.
								getDataPropertyValues(i, ax.getProperty(), GlobalVariables.ontology)) {
							
							if(ax.getDataPropertiesInSignature().iterator().next().getIRI().getShortForm()
									.equals(imagePropertyName)){
								imageLocation = propertyLit.getLiteral();
							} else {
								imageLocation = "http://www.bsmc.net.au/wp-content/uploads/No-image-available.jpg";
							}
						}
					}
				}
			}
		}
	}
}
