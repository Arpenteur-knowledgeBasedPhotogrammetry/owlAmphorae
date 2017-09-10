package org.arpenteur.test;

import javax.swing.JOptionPane;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerListener;
import org.graphstream.ui.view.ViewerPipe;

public class TestListenerGraph implements ViewerListener {
	
	protected boolean loop = true;
	
	
	public static void main(String[] args) {
		new TestListenerGraph();
	}

	
	public TestListenerGraph() {
		Graph graph = new SingleGraph("Clicks");
		graph.addNode("A" );
		graph.addNode("B" );
		graph.addNode("C" );
		graph.addEdge("AB", "A", "B");
		graph.addEdge("BC", "B", "C");
		graph.addEdge("CA", "C", "A");
		
		Viewer viewer = graph.display();
		
		viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
		
		ViewerPipe fromViewer = viewer.newViewerPipe();
		
		fromViewer.addViewerListener(this);
		//fromViewer.addSink(graph);
		
		/*while(loop) {
			fromViewer.pump();
		}*/
	}


	@Override
	public void viewClosed(String viewName) {
		loop = false;
	}


	@Override
	public void buttonPushed(String id) {
		JOptionPane.showMessageDialog(null, "Button pushed on node " + id);
	}


	@Override
	public void buttonReleased(String id) {
		JOptionPane.showMessageDialog(null, "Button released on node " + id);
	}
}
