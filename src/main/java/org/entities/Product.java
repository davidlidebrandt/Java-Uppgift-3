package org.entities;

import java.util.Date;

public class Product {
    enum Category {
        CLOTHES, SHOES
    }

    private String id;
    private String name;
    private Category category;
    private int rating;
    private final Date createdAt;
    private Date lastModifiedAt;
    
    public Product(String id, String name, Category category, int rating, Date createdAt) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.createdAt = createdAt;
        this.lastModifiedAt = createdAt;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public Date getLastModifiedAt() {
        return lastModifiedAt;
    }
    public void setLastModifiedAt(Date lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

}
