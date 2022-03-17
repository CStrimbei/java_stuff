import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args){
        List<Intersection> nodeList = new ArrayList<>();
        var nodes = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Intersection("v" + i) )
                .toArray(Intersection[]::new);

    }
}
