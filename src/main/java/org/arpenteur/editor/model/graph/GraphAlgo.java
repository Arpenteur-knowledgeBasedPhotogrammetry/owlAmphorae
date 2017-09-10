/**
 * Extends MultiGraph class and create personal methodes
 * 
 * @author Pierre Drap, The University Of Aix-Marseille
 * @see	<a href="http://www.arpenteur.org/">http://www.arpenteur.org/</a>
 * 
 * @author Yaaqoub Semlali, The University Of Aix-Marseille
 * @see <a href="http://www.yaaqoubsemlali.com">http://www.yaaqoubsemlali.com</a>
 */
package org.arpenteur.editor.model.graph;


import java.util.Vector;


import org.graphstream.graph.*;

public class GraphAlgo {
		
	//We use public static because each edge need to have a unique ID
	public static int graphEdgeID = 0;
	
	
	public GraphAlgo() {
		
	}
	
	/**
	 * Add nodes
	 * 
	 * @param graph		Graph
	 * @param nodeStr	Nodes
	 */
	public void addNodes(Graph graph, Vector<String> nodeStr){
        for(int i=0; i< nodeStr.size(); i++){
        	Node nodeI = graph.addNode(nodeStr.get(i));
            nodeI.addAttribute("ui.label", nodeStr.get(i));
            nodeI.addAttribute("ui.class", "instance");
        }
	}

	/**
	 * Add edges -- relations
	 * 
	 * @param graph		Graph
	 * @param nodeStr	Nodes
	 */
	public void addRelations(Graph graph, Vector<String> nodeStr){
        for(int i=1; i < nodeStr.size(); i++){
        	Edge edge = graph.addEdge("" + graphEdgeID, nodeStr.get(0), nodeStr.get(i));
            edge.addAttribute("ui.size", 2);
            edge.addAttribute("ui.label", "");
            
            for (int j = 0 ; j < GetDataAndObjectPropertyForGraph.theObjectPropertyTable.length ; j++) {
            	if(nodeStr.get(i).equals(GetDataAndObjectPropertyForGraph.theObjectPropertyTable[j])) {
            		edge.addAttribute("ui.style", "fill-color: rgb(255, 0, 0);");
            	}
            }
            
        	graphEdgeID++;
        }
	}
		
	/**
	 * Add attributes
	 * 
	 * @param graph		Graph
	 */
	public void displayLabels(Graph graph){
        for (Node node : graph) {
            node.addAttribute("ui.label", node.getId());
        }
	}
}
