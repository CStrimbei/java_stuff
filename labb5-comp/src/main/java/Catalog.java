import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable{
    private String name;
    private List<Item> items = new ArrayList<>();

    public Catalog(String NAME){
        this.name = NAME;
    }

    public void add(Item item){
        items.add(item);
    }
    public Item findById(String id){
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Catalog{" + '\n' +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
