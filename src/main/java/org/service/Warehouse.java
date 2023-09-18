package org.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.entities.Category;
import org.entities.Product;
import org.entities.ProductCopy;

public class Warehouse {
    private List<Product> allProducts;

    public Warehouse(List<Product> products) {
        this.allProducts = products;
    }

    public Warehouse() {
        this.allProducts = new ArrayList<>();
    }

    public String addProduct(String name, Category category) {

        try {
            Product newProduct = new Product(name, category);
            allProducts.add(newProduct);
            return newProduct.getId();
        } catch (Exception e) {
            return "";
        }
    }

    public List<ProductCopy> getAllProducts() {
        // Returns a list of all saved products
        // Could be empty if no products have been added
        List<ProductCopy> productsCopy = new ArrayList<>();
        for (Product p : allProducts) {
            productsCopy.add(new ProductCopy(true, p.getId(), p.getName(), p.getCategory(), p.getRating(),
                    p.getCreatedAt(), p.getLastModifiedAt()));
        }
        return productsCopy;
    }

    public ProductCopy getProduct(String id, List<Product> products) {
        // Returns a ProductCopy object with field found set to true if found
        // Returns a ProductCopy object with field found set to false if not found
        for (Product p : products) {
            if (p.getId() == id) {
                return new ProductCopy(true, p.getId(), p.getName(), p.getCategory(), p.getRating(), p.getCreatedAt(),
                        p.getLastModifiedAt());
            }
        }
        return new ProductCopy(false, "", "", Category.values()[0], 0, LocalDate.now(), LocalDate.now());
    }

    public List<ProductCopy> getProductsByCategory(Category category, List<ProductCopy> products) {
        return products.stream().filter((p) -> {
            return p.category() == category;
        }).toList();
    }

    public List<ProductCopy> getProductsAddedAfterGivenDate(LocalDate startDate, List<ProductCopy> products) {
        return products.stream().filter((p) -> {
            return p.createdAt().compareTo(startDate) > 0;
        }).toList();
    }

    public List<ProductCopy> getModifiedProducts(List<ProductCopy> products) {
        return products.stream().filter((p) -> {
            return p.createdAt() != p.lastModifiedAt() && p.createdAt().compareTo(p.lastModifiedAt()) < 0;
        }).toList();
    }

    public String updateName(String id, String newName, List<Product> products) {
        
        for (Product p : products) {
            if (p.getId() == id) {
                Product newProduct = new Product(p.getId(), newName, p.getCategory(), p.getRating(), p.getCreatedAt());
                p = newProduct;
                return "Successfully updated";
            }
        }
        return "Error updating";

    }

    public String updateRating(String id, int newRating, List<Product> products) {
        for (Product p : products) {
            if (p.getId() == id) {
                Product newProduct = new Product(p.getId(), p.getName(), p.getCategory(), newRating, p.getCreatedAt());
                p = newProduct;
                return "Successfully updated";
            }
        }
        return "Error updating";
    }

    public String updateCategory(String id, Category newCategory, List<Product> products) {
        for (Product p : products) {
            if (p.getId() == id) {
                Product newProduct = new Product(p.getId(), p.getName(), newCategory, p.getRating(), p.getCreatedAt());
                p = newProduct;
                return "Successfully updated";
            }
        }
        return "Error updating";
    }

    public static void main(String[] args) {
        Warehouse w = new Warehouse();
        System.out.println(w.getAllProducts());
        w.addProduct("Test", Category.CLOTHES);
        System.out.println(w.getAllProducts());

    }

}
