package starace.com.projectx.models;

import java.util.List;

/**
 * Created by mstarace on 1/31/18.
 */

public class SearchResult {

    private String kind;

    private List<Item> items;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
