import java.util.HashMap;
import java.util.Map;

public class Item{

    public String id;
    public String title;
    public String location;
    public String type;
    private Map<String, Object> tags = new HashMap<>();

    public Item(){

    }

    public Item(String ID, String TITLE, String LOC, String TYPE){
        this.title=TITLE;
        this.id=ID;
        this.location=LOC;
        this.type=TYPE;
    }

    public void addTag(String key, Object o){
        tags.put(key, o);
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", tags=" + tags +
                '}';
    }
}
