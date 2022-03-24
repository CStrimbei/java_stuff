import java.util.ArrayList;
import java.util.List;

public class Catalog extends Item implements Serializable{
    private String name;
    private List<Item> items = new ArrayList<>();

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
    public void addDetails(String ID, String TITLE, String LOCATION) {

    }
}
