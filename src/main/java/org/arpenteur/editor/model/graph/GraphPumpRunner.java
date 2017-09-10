/**
 * Create a graph pump for the viewer.
 * 
 * @author Yaaqoub Semlali, The University Of Aix-Marseille
 * @see <a href="http://www.yaaqoubsemlali.com">http://www.yaaqoubsemlali.com</a>
 */
package org.arpenteur.editor.model.graph;

import org.arpenteur.editor.ui.GraphPanel;

public class GraphPumpRunner implements Runnable {

	@Override
	public void run() {
		while (true) {
			GraphPanel.fromViewer.pump();
		}
	}

}
