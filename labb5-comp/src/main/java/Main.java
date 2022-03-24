public class Main {
    public static void main(String[] args){
        Item b1 = new Book("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps");
        Item m1 = new Magazine("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html");
        Catalog c = new Catalog("Catalog 1");
        c.add(b1);
        c.add((m1));
        System.out.println(c);
    }
}
