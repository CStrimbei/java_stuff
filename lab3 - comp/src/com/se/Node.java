package com.se;

import java.util.HashMap;
import java.util.Map;


/**
 * The Node class.
 */


public abstract class Node implements Comparable<Node>{
    private String name;



    public void setName(String name) {
        this.name = name;
    }

    /**
     * The ovewritten method for toString()
     * @return Returns the name of the node.
     */

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    /**
     * The overwritten method for compareTo()
     * @param o Recieved node, which is compared.
     * @return Returns a value.
     */

    @Override
    public int compareTo(Node o) {
        if(name==null)
            return 0;
        return this.name.compareTo(o.name);
    }
}
