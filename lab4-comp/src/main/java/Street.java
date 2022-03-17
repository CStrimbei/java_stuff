public class Street {
    public String name;
    public int length;
    public Street(String NAME, int LENGTH) {
        this.name =NAME;
        this.length=LENGTH;
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + length +
                '}';
    }
}
