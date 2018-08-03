package pl.put.fc.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reviewer")
public class Reviewer {
    
    @Id
    private long id;
    private String name;
    
    public Reviewer() {
    }
    
    public Reviewer(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
