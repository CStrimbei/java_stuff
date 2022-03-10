package com.se;

public class Main {

    public static void main(String[] args) {
	Network n = new Network();
    n.addNode(new Computer("Computer 1", "192.168.1.1", 1));
    n.addNode(new Router("Router 1", "192.168.0.1", "00:00:5e:00:53:af"));
    n.addNode(new Switch("Switch 1", "Iasi"));

        for (Node node: n.nodeList) {
            System.out.println(node);
        }
    }
}
