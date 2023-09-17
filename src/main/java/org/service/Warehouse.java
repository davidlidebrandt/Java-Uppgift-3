package org.service;

import java.util.Date;
import java.util.List;

import org.entities.Category;
import org.entities.Product;
import org.entities.ProductCopy;

public class Warehouse {
    public String addProduct(String name, Category category) {
        try {
            Product.addProduct(name, category);
        } catch (Exception e) {
            return "An error occurred when trying to add the product";
        }
        return "Successfully added product";
    }

    public List<ProductCopy> getAllProducts() {
        return Product.getAllProducts();
    }

    public ProductCopy getProduct(String id) {
        return Product.getProduct(id);
    }

    public void getProductsByCategory(Category category) {
        Product.getProductsByCategory(category);
    }

    public void getProductsAddedAfterGivenDate(Date startDate) {

    }

    public void getModifiedProducts() {

    }

    public void updateName(String id, String newName) {

    }

    public void updateRating(String id, int newRating) {

    } 
    public void updateCategory(String id, String newCategory) {
        
    }  
    public static void main(String[] args) {
        System.out.println("Test");
    }
}
