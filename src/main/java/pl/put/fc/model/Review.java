package pl.put.fc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Piotr Skonieczny
 */
@Entity
@Table(name = "review")
public class Review {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "reviewer_id")
    private Reviewer reviewer;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    
    @Column(name = "voted_helpful")
    private int votedHelpful;
    
    @Column(name = "voted_not_helpful")
    private int votedNotHelpful;
    
    @Column(name = "review_text")
    private String reviewText;
    
    private double overall;
    
    private String summary;
    
    @Column(name = "review_time")
    private long reviewTime;
    
    public Review() {
    }
    
    public Review(Reviewer reviewer, Product product, int votedHelpful, int votedNotHelpful, String reviewText, double overall,
            String summary, long reviewTime) {
        this.reviewer = reviewer;
        this.product = product;
        this.votedHelpful = votedHelpful;
        this.votedNotHelpful = votedNotHelpful;
        this.reviewText = reviewText;
        this.overall = overall;
        this.summary = summary;
        this.reviewTime = reviewTime;
    }
}
