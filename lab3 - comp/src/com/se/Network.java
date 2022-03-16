package com.se;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Network {
    List<Node> nodeList= new ArrayList<>();
    Map<String, Integer> costs = new HashMap<String, Integer>();
    public void addNodes(Node node1, Node node2, int COST){
        nodeList.add(node1);
        nodeList.add(node2);
        String Edge = node1 + " -> " + node2;
        costs.put(Edge, COST);
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
