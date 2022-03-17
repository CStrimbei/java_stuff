public class Street {
    public String node1;
    public String node2;
    public double length;
    public Street(String node1, String node2, double LENGTH) {
        this.node1=node1;
        this.node2=node2;
        this.length=LENGTH;
    }

    @Override
    public String toString() {
        return "Street{" +
                "node1='" + node1 + '\'' +
                ", node2='" + node2 + '\'' +
                ", length=" + length +
                '}';
    }
}
