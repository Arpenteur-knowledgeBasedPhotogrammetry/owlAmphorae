package org.arpenteur.protege.plugin.tree.view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.core.ui.util.JOptionPaneEx;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public class AddIndividual extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8708676703694351371L;
	
	private JTextField individualNameField;
		
	private JLabel iriLabel;

	
	public AddIndividual() {
		
	}

	private void addIndividualAlgo(OWLOntology ontology, OWLOntologyManager manager, String className, String individualName) {
		OWLDataFactory factory = FrameTree.modelManager.getOWLDataFactory();
		
		for (OWLClass c : ontology.getClassesInSignature()) {
			String prefix = c.getIRI().getNamespace();
			
			//i7dyiwi rbi ri7 anzayd7 class ":"
			OWLClass clsPSS = factory.getOWLClass(IRI.create(prefix + className));
			
			OWLNamedIndividual indivName = factory.getOWLNamedIndividual(IRI.create(prefix + ":" + individualName));
			
			OWLClassAssertionAxiom classAssertion = factory.getOWLClassAssertionAxiom(clsPSS, indivName);
						
			manager.addAxiom(ontology, classAssertion);
			
		}
	}
	
	public void addIndividualUI(OWLOntology ontology, OWLOntologyManager manager, String className) {
		setLayout(new BorderLayout());
		
		individualNameField = new JTextField(45);
		JPanel individualNameFieldHolder = new JPanel(new BorderLayout());
		individualNameFieldHolder.setBorder(ComponentFactory.createTitledBorder("Name"));
		individualNameFieldHolder.add(individualNameField, BorderLayout.NORTH);
		add(individualNameFieldHolder, BorderLayout.NORTH);
		
		iriLabel = new JLabel();
		iriLabel.setText(getIRI(ontology));
		JPanel iriFieldHolder = new JPanel(new BorderLayout());
		iriFieldHolder.setBorder(ComponentFactory.createTitledBorder("IRI (auto-generated)"));
		iriFieldHolder.add(iriLabel, BorderLayout.CENTER);
		add(iriFieldHolder, BorderLayout.CENTER);
		
		individualNameField.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				changeText();
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				changeText();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				changeText();
			}
			
			public void changeText() {
				iriLabel.setText(getIRI(ontology) + individualNameField.getText());
			}
			
		});
		
		JOptionPaneEx.showValidatingConfirmDialog(null,
                "Create a new OWLNamedIndividual",
                this,
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION,
                this.individualNameField);
		
		addIndividualAlgo(ontology, manager, className, individualNameField.getText());
		
		individualNameField.setText("");
		iriLabel.setText(getIRI(ontology));
	}
	
	private String getIRI(OWLOntology ontology) {
		String prefix = "";
		for (OWLClass c : ontology.getClassesInSignature()) {
			prefix = c.getIRI().getNamespace();
		}
		
		return prefix;
	}
	
}
