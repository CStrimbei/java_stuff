package com.se;

import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node>{
    private String name;
    private Map<Node, Integer> cost = new HashMap<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Map<Node, Integer> cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        if(name==null)
            return 0;
        return this.name.compareTo(o.name);
    }
}
