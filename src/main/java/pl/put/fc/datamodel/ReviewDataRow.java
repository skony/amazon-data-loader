package pl.put.fc.datamodel;

public class ReviewDataRow {
    
    private String reviewerId;
    private String productId;;
    private String reviewerName;
    private String helpful;
    private String reviewText;
    private double overall;
    private String summary;
    private long unixReviewTime;
    
    public ReviewDataRow(String reviewerId, String productId, String reviewerName, String helpful, String reviewText, double overall,
            String summary, long unixReviewTime) {
        this.reviewerId = reviewerId;
        this.productId = productId;
        this.reviewerName = reviewerName;
        this.helpful = helpful;
        this.reviewText = reviewText;
        this.overall = overall;
        this.summary = summary;
        this.unixReviewTime = unixReviewTime;
    }
    
    public String getReviewerId() {
        return reviewerId;
    }
    
    public void setReviewerId(String reviewerId) {
        this.reviewerId = reviewerId;
    }
    
    public String getProductId() {
        return productId;
    }
    
    public void setProductId(String productId) {
        this.productId = productId;
    }
    
    public String getReviewerName() {
        return reviewerName;
    }
    
    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }
    
    public String getHelpful() {
        return helpful;
    }
    
    public void setHelpful(String helpful) {
        this.helpful = helpful;
    }
    
    public String getReviewText() {
        return reviewText;
    }
    
    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
    
    public double getOverall() {
        return overall;
    }
    
    public void setOverall(double overall) {
        this.overall = overall;
    }
    
    public String getSummary() {
        return summary;
    }
    
    public void setSummary(String summary) {
        this.summary = summary;
    }
    
    public long getUnixReviewTime() {
        return unixReviewTime;
    }
    
    public void setUnixReviewTime(long unixReviewTime) {
        this.unixReviewTime = unixReviewTime;
    }
}
