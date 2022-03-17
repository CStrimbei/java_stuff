import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args){
        List<Intersection> nodeList = new ArrayList<>();
        Map<Intersection, List<Street>> cityMap = new HashMap<Intersection, List<Street>>();
        List<Street> streetList = new ArrayList<>();

        var nodeArray = IntStream.rangeClosed(0, 10)
                .mapToObj(i -> new Intersection("v" + i) )
                .toArray(Intersection[]::new);

        nodeList.addAll(Arrays.asList(nodeArray));

        var streetArray = IntStream.rangeClosed(0, 9)
                .mapToObj(i -> new Street("v" + i, "v" + (i+1),i+2))
                .toArray(Street[]::new);

        streetList.addAll(Arrays.asList(streetArray));



        for(Intersection i : nodeList){
            System.out.println(i);
        }

        for (Street s: streetList) {
            System.out.println(s);
        }

    }
}