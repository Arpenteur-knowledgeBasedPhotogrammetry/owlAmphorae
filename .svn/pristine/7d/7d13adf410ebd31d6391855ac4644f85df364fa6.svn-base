package org.arpenteur.test;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.arpenteur.variables.GlobalVariables;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.reasoner.Node;

public class GetClassesAndSubClasses extends DefaultTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5199576903388404962L;
	private String prevGroup = "";
	
	public GetClassesAndSubClasses() {
		
		this.addColumn("Classes Name");
		this.addColumn("SubClasses");
		
		Vector<String> rows = null;
		
		for (OWLClass clazz : GlobalVariables.ontology.getClassesInSignature()) {
			for (Node<OWLClass> c : GlobalVariables.reasoner.getSubClasses(clazz, false)) {
				rows = new Vector<String>();
				rows.add(clazz.getIRI().getShortForm());
				
				if (!c.iterator().next().getIRI().getShortForm().equals("Nothing"))
					rows.add(c.iterator().next().getIRI().getShortForm());
				else
					rows.add("");
					
				
				if (rows.get(0).equals(prevGroup)) {
					rows.set(0, "");
				} else {
	                prevGroup = rows.get(0);
	            }
				
				this.addRow(rows);
			}
		}
	}
	
	
}
