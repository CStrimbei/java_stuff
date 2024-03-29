package com.se;
/**
 * The Main class.
 */
public class Main {

    /**
     * The main function.
     * @param args
     */

    public static void main(String[] args) {
	Network n = new Network();

    Node v1 = new Computer("Computer A", "192.168.1.1", 1);
    Node v2 = new Router("Router A", "192.168.0.1", "00:00:5e:00:53:af");
    Node v3 = new Switch("Switch A", "Iasi");
    Node v4 = new Switch("Switch B", "Pascani");
    Node v5 = new Router("Router B", "192.168.6.2", "10:03:5e:00:53:af");
    Node v6 = new Computer("Computer B", "192.168.2.1", 0.5);

    n.addEdge(v1, v2, 10);
    n.addEdge(v1, v3, 50);
    n.addEdge(v2, v3, 20);
    n.addEdge(v2, v4, 20);
    n.addEdge(v2, v5, 20);
    n.addEdge(v3, v4, 10);
    n.addEdge(v4, v5, 30);
    n.addEdge(v4, v6, 10);
    n.addEdge(v5, v6, 20);
        System.out.println("The following nodes are in the system: ");

        for (Node node:n.nodeList) {
            System.out.print(node);
            if(n.isIdentifiablePC(node)){
                System.out.print(" and it's identifiable by the address ");
                System.out.print(((Computer)node).getAddress());
                System.out.println();
            }
            else if (n.isIdentifiableRouter(node)){
                System.out.print(" and it's identifiable by the address ");
                System.out.print(((Router)node).getAddress());
                System.out.println();
            }
            else System.out.println();

        }

        System.out.println("And these are the costs: ");

        System.out.println(n.costs);
    }
}
