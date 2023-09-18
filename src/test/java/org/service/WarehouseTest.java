package org.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.entities.Category;
import org.entities.Product;
import org.entities.ProductCopy;
import org.junit.jupiter.api.Test;

public class WarehouseTest {
    Warehouse warehouse;
    LocalDate createdAt = LocalDate.now().minusDays(20);
    LocalDate createdLater = LocalDate.now();

    @Test
    void testGetEmptyProductListBeforeAddingProducts() {
        warehouse = new Warehouse();
        assertEquals(new ArrayList<Product>(), warehouse.getAllProducts());
    }

    void testGetPopulatedProductList() {
        warehouse = new Warehouse(getPopulatedList());
        assertEquals(getPopulatedList(), warehouse.getAllProducts());
    }

    @Test
    void testAddProduct() {
        warehouse = new Warehouse();
        
        assertNotEquals("", warehouse.addProduct("Test", Category.CLOTHES));
        assertEquals("", warehouse.addProduct("", Category.SHOES));
        assertEquals(true, warehouse.getAllProducts().stream().anyMatch(p -> "Test".equals(p.name())));
        assertEquals(1, warehouse.getAllProducts().size());
    }

    @Test
    void testGetModifiedProducts() {
        warehouse = new Warehouse();
        List<ProductCopy> modifiedProducts = new ArrayList<>();
        modifiedProducts.add(
                new ProductCopy(true, "3", "Large shoes", Category.SHOES, 3, createdAt, LocalDate.now().plusDays(2)));
        modifiedProducts.add(new ProductCopy(true, "6", "Large clothes", Category.CLOTHES, 3, createdAt,
                LocalDate.now().plusDays(4)));
        
        assertEquals(modifiedProducts, warehouse.getModifiedProducts(getProductCopiesList()));
    }

    @Test
    void testGetProduct() {
        warehouse = new Warehouse(getPopulatedList());

        assertEquals(true, warehouse.getProduct("1323", warehouse.getAllProducts()).found());
        assertEquals(false, warehouse.getProduct(" ", warehouse.getAllProducts()).found());
    }

    @Test
    void testGetProductsAddedAfterGivenDate() {
        warehouse = new Warehouse();
        List<ProductCopy> products = new ArrayList<>();
        products.add(new ProductCopy(true, "1", "Small shoes", Category.SHOES, 3, createdLater, createdAt));
        products.add(
                 new ProductCopy(true, "4", "Small clothes", Category.CLOTHES, 3, createdLater, createdAt));
        
        assertEquals(products, warehouse.getProductsAddedAfterGivenDate(createdAt, getProductCopiesList()));
    }

    @Test
    void testGetProductsByCategory() {
        warehouse = new Warehouse();
        List<ProductCopy> products = new ArrayList<>();
        products.add(new ProductCopy(true, "6", "Large clothes", Category.CLOTHES, 3, createdAt,
                LocalDate.now().plusDays(4)));
        products.add(new ProductCopy(true, "5", "Medium clothes", Category.CLOTHES, 3, createdAt, createdAt));
        products.add(
                new ProductCopy(true, "4", "Small clothes", Category.CLOTHES, 3, createdLater, createdAt));
        
        assertEquals(products, warehouse.getProductsByCategory(Category.CLOTHES, getProductCopiesList()));
    }

    @Test
    void testUpdateCategory() {
        warehouse = new Warehouse(getPopulatedList());
        List<ProductCopy> productsCopy = new ArrayList<>();
        for (ProductCopy p : warehouse.getAllProducts()) {
            if(p.id() == "1323") {
                productsCopy.add(new ProductCopy(true, p.id(), p.name(), Category.CLOTHES, p.rating(),
                    p.createdAt(), p.lastModifiedAt()));
            }
            else {
                productsCopy.add(new ProductCopy(true, p.id(), p.name(), p.category(), p.rating(),
                    p.createdAt(), p.lastModifiedAt()));
            }
        }
        
        assertNotEquals(productsCopy, warehouse.getAllProducts());
        assertEquals("Successfully updated", warehouse.updateCategory("1323", Category.CLOTHES));;
        assertEquals(productsCopy, warehouse.getAllProducts());
    
    }

    @Test
    void testUpdateName() {
        warehouse = new Warehouse(getPopulatedList());
        List<ProductCopy> productsCopy = new ArrayList<>();
        for (ProductCopy p : warehouse.getAllProducts()) {
            if(p.id() == "1323") {
                productsCopy.add(new ProductCopy(true, p.id(), "A new long name", p.category(), p.rating(),
                    p.createdAt(), p.lastModifiedAt()));
            }
            else {
                productsCopy.add(new ProductCopy(true, p.id(), p.name(), p.category(), p.rating(),
                    p.createdAt(), p.lastModifiedAt()));
            }
        }
        assertNotEquals(productsCopy, warehouse.getAllProducts());
        assertEquals("Successfully updated", warehouse.updateName("1323", "A new long name"));;
        assertEquals(productsCopy, warehouse.getAllProducts());
    }

    @Test
    void testUpdateRating() {
        warehouse = new Warehouse(getPopulatedList());
        List<ProductCopy> productsCopy = new ArrayList<>();
        for (ProductCopy p : warehouse.getAllProducts()) {
            if(p.id() == "1323") {
                productsCopy.add(new ProductCopy(true, p.id(), p.name(), p.category(), 1,
                    p.createdAt(), p.lastModifiedAt()));
            }
            else {
                productsCopy.add(new ProductCopy(true, p.id(), p.name(), p.category(), p.rating(),
                    p.createdAt(), p.lastModifiedAt()));
            }
        }
        assertNotEquals(productsCopy, warehouse.getAllProducts());
        assertEquals("Successfully updated", warehouse.updateRating("1323", 1));
        assertEquals("Error updating", warehouse.updateRating("1323", 11));
        assertEquals("Error updating", warehouse.updateRating("1323", 0));
        assertEquals(productsCopy, warehouse.getAllProducts());
    }

    List<Product> getPopulatedList() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Small shoes", Category.SHOES));
        products.add(new Product("Medium shoes", Category.SHOES));
        products.add(new Product("1323", "Big shoes", Category.SHOES, 4, LocalDate.now().minusDays(3)));
        products.add(new Product("Small clothes", Category.CLOTHES));
        products.add(new Product("Medium clothes", Category.CLOTHES));
        products.add(new Product("43344", "Big clothes", Category.CLOTHES, 4, LocalDate.now().minusDays(5)));

        return products;
    }

    List<ProductCopy> getProductCopiesList() {
        List<ProductCopy> products = new ArrayList<>();
        products.add(new ProductCopy(true, "1", "Small shoes", Category.SHOES, 3, createdLater, createdAt));
        products.add(new ProductCopy(true, "2", "Medium shoes", Category.SHOES, 3, createdAt, createdAt));
        products.add(
                new ProductCopy(true, "3", "Large shoes", Category.SHOES, 3, createdAt, LocalDate.now().plusDays(2)));
        products.add(
                new ProductCopy(true, "4", "Small clothes", Category.CLOTHES, 3, createdLater, createdAt));
        products.add(new ProductCopy(true, "5", "Medium clothes", Category.CLOTHES, 3, createdAt, createdAt));
        products.add(new ProductCopy(true, "6", "Large clothes", Category.CLOTHES, 3, createdAt,
                LocalDate.now().plusDays(4)));
        
        return products;
    }
}
