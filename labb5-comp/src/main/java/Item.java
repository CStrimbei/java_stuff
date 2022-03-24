import java.util.HashMap;
import java.util.Map;

public abstract class Item implements Serializable {

    public String id;
    public String title;
    public String location;

    private Map<String, Object> tags= new HashMap<String, Object>();

    public void addTag(String key, Object o){
        tags.put(key, o);
    }

    public String getId() {
        return id;
    }
}
