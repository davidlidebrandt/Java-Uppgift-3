package org.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Product {

    private static List<Product> allProducts = new ArrayList<>();

    private String id;
    private String name;
    private Category category;
    private int rating;
    private final Date createdAt;
    private Date lastModifiedAt;
    
    public Product(String id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.rating = 0;
        this.createdAt = new Date();
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
    public static List<Product> getAllProducts() {
        return new ArrayList<>(allProducts);
    }
    public static void setAllProducts(List<Product> allProducts) {
        Product.allProducts = allProducts;
    }
   
    

}
