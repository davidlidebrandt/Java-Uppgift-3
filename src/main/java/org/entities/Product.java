package org.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Product {

    private static List<Product> allProducts = new ArrayList<>();

    private String id;
    private String name;
    private Category category;
    private int rating;
    private final Date createdAt;
    private Date lastModifiedAt;
    
    private Product(String name, Category category) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.category = category;
        this.rating = 0;
        this.createdAt = new Date();
        this.lastModifiedAt = createdAt;
        if(name == null || id == null || category == null || name.length() < 2) {
            throw new IllegalArgumentException();
        }
    }

    public static ProductCopy getProduct(String id) {
        for(Product p: allProducts) {
            if(p.id == id) {
                return new ProductCopy(true, p.id, p.name, p.category, p.rating, p.createdAt, p.lastModifiedAt);
            }
        }
        return new ProductCopy(false, "", "", Category.values()[0], 0, new Date(), new Date());
    }
    
    public static void addProduct(String id, Category category) {
        Product product = new Product(id, category);
        addToAllProducts(product);
    }
    
    public static List<ProductCopy> getAllProducts() {
        List <ProductCopy> productsCopy = new ArrayList<>();
        for(Product p: allProducts) {
            productsCopy.add(new ProductCopy(true, p.id, p.name, p.category, p.rating, p.createdAt, p.lastModifiedAt));
        }
        return productsCopy;
    }

    public static List<ProductCopy> getProductsByCategory(Category category) {
        return getAllProducts().stream().filter((p) -> {return p.category() == category;}).toList();

    }

    private static void addToAllProducts(Product product) {
        allProducts.add(product);
    }
    
   
}
