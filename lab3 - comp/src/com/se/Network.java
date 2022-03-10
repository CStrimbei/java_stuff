package com.se;

import java.util.ArrayList;
import java.util.List;

public class Network {
    List<Node> nodeList= new ArrayList<>();

    public void addNode(Node node){
        nodeList.add(node);
    }

    @Override
    public String toString() {
        return "Network{" +
                "nodeList=" + nodeList +
                '}';
    }
}
