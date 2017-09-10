/**
 * Create a remove object propert dialog
 * 
 * @author Yaaqoub Semlali, The University Of Aix-Marseille
 * @see <a href="http://www.yaaqoubsemlali.com">http://www.yaaqoubsemlali.com</a>
 */
package org.arpenteur.editor.ui.dialog;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.arpenteur.editor.model.RemoveObjectProperty;
import org.arpenteur.editor.ui.ObjectPropertyPanel;

public class RemoveObjectPropertyDialog extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6907790407207119117L;
	
	private Object[] options = { "Yes", "No" };
	
	/**
	 * Constract the remove dialog
	 */
	public RemoveObjectPropertyDialog() {
		int clickedButton = JOptionPane.showOptionDialog(this, "Do you want to Delete this property ?",
				"Confirm to Delete?",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, options, options[1]);
		
		if (clickedButton == 0) {
			new RemoveObjectProperty(ObjectPropertyPanel.selectedObjectProperty);
			JOptionPane.showMessageDialog(this, "Delete Property Successfully");
		}
	}
}
