package com.se;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Network {
    List<Node> nodeList= new ArrayList<>();
    Map<String, Integer> costs = new HashMap<String, Integer>();

    public void addNode(Node node){
        nodeList.add(node);
    }

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

    @Override
    public String toString() {
        return "Network{" +
                "nodeList=" + nodeList +
                ", costs=" + costs +
                '}';
    }


    /*    @Override
    public String toString() {
        return "Network{" +
                "nodeList=" + nodeList +
                '}';
    }*/
}
