package com.se;

import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node>{
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Node o) {
        if(name==null)
            return 0;
        return this.name.compareTo(o.name);
    }
}
