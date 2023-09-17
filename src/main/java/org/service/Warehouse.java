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
        //Returns a list of all saved products
        //Could be empty if no products have been added
        return Product.getAllProducts();
    }

    public ProductCopy getProduct(String id) {
        //Returns a ProductCopy object with field found set to true if found
        //Returns a ProductCopy object with field found set to false if not found
        return Product.getProduct(id);
    }

    public List<ProductCopy> getProductsByCategory(Category category) {
        return Product.getAllProducts().stream().filter((p) -> {return p.category() == category;}).toList();
    }

    public List<ProductCopy> getProductsAddedAfterGivenDate(Date startDate) {
        return Product.getAllProducts().stream().filter((p) -> {return p.createdAt().compareTo(startDate) > 0;}).toList();
    }

    public List<ProductCopy> getModifiedProducts() {
        return getAllProducts().stream().filter((p) -> {return p.createdAt() != p.lastModifiedAt();}).toList();
    }

    public String updateName(String id, String newName) {
        ProductCopy product = Product.getProduct(id);
        ProductCopy updatedProduct = new ProductCopy(true, product.id(), newName, product.category(), product.rating(), product.createdAt(), product.lastModifiedAt());
        return Product.updateProduct(updatedProduct);
    }

    public String updateRating(String id, int newRating) {
        ProductCopy product = Product.getProduct(id);
        ProductCopy updatedProduct = new ProductCopy(true, product.id(), product.name(), product.category(), newRating, product.createdAt(), product.lastModifiedAt());
        return Product.updateProduct(updatedProduct);
    } 

    public String updateCategory(String id, Category newCategory) {
        ProductCopy product = Product.getProduct(id);
        ProductCopy updatedProduct = new ProductCopy(true, product.id(), product.name(), newCategory, product.rating(), product.createdAt(), product.lastModifiedAt());
        return Product.updateProduct(updatedProduct);
    } 

}
