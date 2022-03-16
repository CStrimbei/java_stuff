package com.se;

public class Main {

    public static void main(String[] args) {
	Network n = new Network();
    n.addNodes(new Computer("Computer 1", "192.168.1.1", 1000), new Router("Router 1", "192.168.0.1", "00:00:5e:00:53:af"), 10);
    /*n.addNode(new Computer("Computer 2", "192.168.2.1";

    n.addNode());
    n.addNode(new Router("Router 2", "192.168.6.2", "10:03:5e:00:53:af"));
    n.addNode(new Switch("Switch 1", "Iasi"));
    n.addNode(new Switch("Switch 2", "Pascani"));*/


        for (Node node:n.nodeList) {
            System.out.println("I have found the node with the name: "+node);
        }
        System.out.println(n.costs);
    }
}
