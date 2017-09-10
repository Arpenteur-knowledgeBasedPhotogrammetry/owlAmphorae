/**
 * Create a graph Panel
 * 
 * @author Pierre Drap, The University Of Aix-Marseille
 * @see	<a href="http://www.arpenteur.org/">http://www.arpenteur.org/</a>
 * 
 * @author Yaaqoub Semlali, The University Of Aix-Marseille
 * @see <a href="http://www.yaaqoubsemlali.com">http://www.yaaqoubsemlali.com</a>
 */ 
package org.arpenteur.editor.ui;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.arpenteur.editor.model.graph.GraphLauncher;
import org.graphstream.ui.graphicGraph.GraphicNode;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerListener;
import org.graphstream.ui.view.ViewerPipe;

public class GraphPanel extends JPanel implements ViewerListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7853704429869700827L;
	
	public static Viewer viewer = null;
	
	public static ViewPanel viewPanel = null;
	
	public static  ViewerPipe fromViewer = null;
				
	/**
	 * Constract the graph panel
	 */
	public GraphPanel () {
		setLayout(new BorderLayout());
				
		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		
	    viewer = new Viewer(GraphLauncher.graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        viewer.enableAutoLayout();
        
        //Add toolbar (the one with charge graph button)
        this.add(new FramePanelsToolBars(4), BorderLayout.NORTH);
        
        fromViewer = viewer.newViewerPipe();
        fromViewer.addViewerListener(this);
		fromViewer.addSink(GraphLauncher.graph);
        //Add a view inside a scrollPane
        if (viewer != null){
        	try {
			  viewPanel = viewer.addDefaultView(false);
			  this.add(new JScrollPane(viewPanel), BorderLayout.CENTER);
			} catch (Exception e) {
				System.out.println("Graph viewer not initialized");
			}
        } else {
        	System.out.println("Graph viewer not really initialized");
        }
        
        /*if (GraphLauncher.graph != null)
	        while(loop) {
				fromViewer.pump();
			}*/
	}


	@Override
	public void viewClosed(String viewName) {
	}

	@Override
	public void buttonPushed(String id) {
		JOptionPane.showMessageDialog(this, "Button pushed on node " + id);
		//Test Test Test
		//GraphicNode n = viewer.getGraphicGraph().getNode(id);
		//int nx = (int) n.getX();
		//new GraphMenu().show();;
		
	}

	@Override
	public void buttonReleased(String id) {
	}
}