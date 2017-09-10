package org.arpenteur.protege.plugin.get.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.arpenteur.common.GetOntologyIndividuals;
import org.arpenteur.protege.plugin.model.GetOntologyClasses;
import org.arpenteur.protege.plugin.ui.get.PluginToolBar;
import org.arpenteur.variables.GlobalVariables;
import org.protege.editor.owl.model.OWLModelManager;
import org.protege.editor.owl.model.event.EventType;
import org.protege.editor.owl.model.event.OWLModelManagerListener;

public class FrameGet extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5411711042737977576L;
	    
    public static boolean isIndividualsTableClicked = false;
    
    public static String individualSelected = "";
    
    public static JTable individualsTable = new JTable(){
    	/**
		 * 
		 */
		private static final long serialVersionUID = 2667265216208579839L;
		
		@Override
		public boolean isCellEditable(int row, int column) {                
            return false;               
    	}; 
    };
    
        		
	private JComboBox<Object> classesComboBox = new JComboBox<Object>();
    
	
    private OWLModelManagerListener modelListener = event -> {
        if (event.getType() == EventType.ACTIVE_ONTOLOGY_CHANGED) {
        	fillComboBox();
        }
    };
    
	public FrameGet(OWLModelManager modelManager) {
    	GlobalVariables.modelManager = modelManager;
    	GlobalVariables.modelManager.addListener(modelListener);
    	GlobalVariables.toLoadAfterOntology();
    	
    	printIndividualsByclass();
    	fillComboBox();
    	
        setLayout(new BorderLayout());
        add(new PluginToolBar(classesComboBox), BorderLayout.NORTH);
        add(new JScrollPane(individualsTable), BorderLayout.CENTER);
        
        /*individualsTable.addMouseListener(new MouseAdapter() {
			  public void mousePressed(MouseEvent e) {
				  if (e.getClickCount() == 1) {
					  isIndividualsTableClicked = true;
				      JTable target = (JTable)e.getSource();
				      int row = target.getSelectedRow();
				      String rowValue = individualsTable.getModel().getValueAt(row, 0).toString();
				      individualSelected = rowValue;
				      
				      frameSet.printDataPropertyByIndividual(modelManager.getActiveOntology(), individualSelected);
				      frameSet.printObjectPropertyByIndividual(modelManager.getActiveOntology(), individualSelected);
				      
				      FrameSet.selectedPropertyTableRowValue = "";
				      
				   } else if (e.getButton() == MouseEvent.BUTTON3) {
				    	JOptionPane.showMessageDialog(null, "u clicked right 3");
				   }
			  }
      	});*/
    }
    
    
    
    public void dispose() {
    	GlobalVariables.modelManager.removeListener(modelListener);
    }   
    
    private void fillComboBox() {
    	if(GlobalVariables.ontology != null) {
    		classesComboBox.setModel(new GetOntologyClasses());
    	}
    }
    private void printIndividualsByclass() {
    	classesComboBox.addActionListener(new ActionListener() {
			@SuppressWarnings("rawtypes")
			public void actionPerformed(ActionEvent event) {
				JComboBox comboBox = (JComboBox) event.getSource();
				Object selected = comboBox.getSelectedItem();
				
				individualsTable.setModel(new GetOntologyIndividuals(selected.toString()));
				repaint();
		        revalidate();
			}
		});
    }
}