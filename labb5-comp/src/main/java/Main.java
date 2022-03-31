public class Main {
    public static void main(String[] args){
        Catalog c = new Catalog("Catalog 1");
        var carte = new Item("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps", "book");
        var articol = new Item("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html", "article");
        c.add(carte);
        c.add(articol);
        System.out.println("Doar prin constructori:");
        c.save();
        System.out.println("Folosind load+save:");
        c.load();
        c.save();
        System.out.println(c);
    }
}
