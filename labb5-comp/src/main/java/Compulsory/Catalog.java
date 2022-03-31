package Compulsory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Catalog{
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void save(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode catalogul = mapper.createObjectNode();
            for(Item obj : items){
                catalogul.put("id", obj.getId());
                catalogul.put("title", obj.getTitle());
                catalogul.put("location", obj.getLocation());
                catalogul.put("type", obj.getType());
                String jsonfile = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(catalogul);
                mapper.writeValue(Paths.get("catalog.json").toFile(), catalogul);
                System.out.println(jsonfile);
            }
        }catch (Exception no){
            no.printStackTrace();
        }
    }

    public void load(){
        try{
            ObjectMapper mapper = new ObjectMapper();

            Item obj = mapper.readValue(Paths.get("catalog1.json").toFile(), Item.class);
            this.add(obj);
        }catch (Exception nono){
            nono.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Compulsory.Catalog{" +
                "name='" + name + '\'' +
                ", items=" + '\n'+ items +
                '}';
    }
}
