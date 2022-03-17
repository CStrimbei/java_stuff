package com.se;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Network class.
 */


public class Network {

    List<Node> nodeList= new ArrayList<>();
    Map<String, Integer> costs = new HashMap<String, Integer>();

    /**
     * The function which adds edges, improved version of the previous addNode function.
     * @param node1 The first node of the edge.
     * @param node2 The second node of the edge.
     * @param COST The edge's cost.
     */

    public void addEdge(Node node1, Node node2, int COST){
        String Edge = node1 + " -> " + node2;
        costs.put(Edge, COST);

        if(nodeList.contains(node1))
                if(nodeList.contains(node2))
                    return;
                else {
                    nodeList.add(node2);
                }
        else {
            nodeList.add(node1);
        }
    }
    /**
     * The ovewritten method for toString()
     * @return Returns the node list and their costs.
     */
    @Override
    public String toString() {
        return "Network{" +
                "nodeList=" + nodeList +
                ", costs=" + costs +
                '}';
    }

    /**
     * This method verifies if the Node is a computer.
     * @param node The node object.
     * @return Returns a boolean value.
     */
    public boolean isIdentifiablePC(Node node){
        return node instanceof Computer;
    }

    /**
     * This method verifies if the Node is a router.
     * @param node The node object.
     * @return Returns a boolean value.
     */
    public boolean isIdentifiableRouter(Node node){
        return node instanceof Router;
    }

    /*    @Override
    public String toString() {
        return "Network{" +
                "nodeList=" + nodeList +
                '}';
    }*/
}
