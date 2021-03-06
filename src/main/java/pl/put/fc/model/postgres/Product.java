package pl.put.fc.model.postgres;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Piotr Skonieczny
 */
@Entity
@Table(name = "product")
public class Product {
    
    @Id
    private String id;
    
    @Column(length = 1023)
    private String title;
    
    private double price;
    
    @Column(length = 1023)
    private String brand;
    
    // private String description;
    
    @ManyToMany
    @JoinTable(name = "product_category")
    private List<Category> categories;
    
    @ManyToMany
    @JoinTable(name = "product_also_bought")
    private List<Product> alsoBought;
    
    @ManyToMany
    @JoinTable(name = "product_also_viewed")
    private List<Product> alsoViewed;
    
    @ManyToMany
    @JoinTable(name = "product_bought_together")
    private List<Product> boughtTogether;
    
    @ManyToMany
    @JoinTable(name = "product_buy_after_viewing")
    private List<Product> buyAfterViewing;
    
    public Product() {
    }
    
    public Product(String title, double price, String brand, List<Category> category, List<Product> alsoBought, List<Product> alsoViewed,
            List<Product> boughtTogether, List<Product> buyAfterViewing) {
        this.title = title;
        this.price = price;
        this.brand = brand;
        // this.category = category;
        this.alsoBought = alsoBought;
        this.alsoViewed = alsoViewed;
        this.boughtTogether = boughtTogether;
        this.buyAfterViewing = buyAfterViewing;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public List<Category> getCategory() {
        return categories;
    }
    
    public void setCategory(List<Category> category) {
        categories = category;
    }
    
    public List<Product> getAlsoBought() {
        return alsoBought;
    }
    
    public void setAlsoBought(List<Product> alsoBought) {
        this.alsoBought = alsoBought;
    }
    
    public List<Product> getAlsoViewed() {
        return alsoViewed;
    }
    
    public void setAlsoViewed(List<Product> alsoViewed) {
        this.alsoViewed = alsoViewed;
    }
    
    public List<Product> getBoughtTogether() {
        return boughtTogether;
    }
    
    public void setBoughtTogether(List<Product> boughtTogether) {
        this.boughtTogether = boughtTogether;
    }
    
    public List<Product> getBuyAfterViewing() {
        return buyAfterViewing;
    }
    
    public void setBuyAfterViewing(List<Product> buyAfterViewing) {
        this.buyAfterViewing = buyAfterViewing;
    }
}
