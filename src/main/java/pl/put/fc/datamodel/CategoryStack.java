package pl.put.fc.datamodel;

import java.util.List;

public class CategoryStack {
    
    List<String> categories;
    
    public CategoryStack(List<String> categories) {
        this.categories = categories;
    }
    
    public List<String> getCategories() {
        return categories;
    }
    
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
