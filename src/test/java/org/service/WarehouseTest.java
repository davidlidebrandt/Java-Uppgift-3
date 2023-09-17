package org.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.entities.Category;
import org.entities.ProductCopy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WarehouseTest {
    Warehouse warehouse;
    
    @BeforeEach
    void setUp() {
        warehouse = new Warehouse();
    }

     @Test
    void testGetAllProducts() {
       
    }

    @Test
    void testAddProduct() {
        assertNotEquals("", warehouse.addProduct("Test", Category.CLOTHES));
        assertEquals("", warehouse.addProduct("", Category.SHOES));
    }
    
    @Test
    void testGetModifiedProducts() {
        List<ProductCopy> fakeProductList = new ArrayList<>();
        LocalDate now = LocalDate.now();
        LocalDate later = now.plusDays(1);
        fakeProductList.add(new ProductCopy(true, "dsdsdss2", "Big shoes", Category.SHOES, 1, now, later));
        fakeProductList.add(new ProductCopy(true, "dsdsdss2", "Small shoes", Category.SHOES, 1, now, now));
        fakeProductList.add(new ProductCopy(true, "dsdsdss2", "Medium shoes", Category.SHOES, 1, now, now));

        List<ProductCopy> modifiedProducts = new ArrayList<>();
        fakeProductList.add(new ProductCopy(true, "dsdsdss2", "Big shoes", Category.SHOES, 1, now, later));
        assertEquals(warehouse.getModifiedProducts(fakeProductList), modifiedProducts);

    }

    @Test
    void testGetProduct() {
        String id = warehouse.addProduct("Great shoe", Category.SHOES);
        ProductCopy addedProduct = warehouse.getProduct(id);
        assertEquals("Great shoe", addedProduct.name());
        assertEquals(Category.SHOES, addedProduct.category());
        assertEquals(true, addedProduct.found());
        assertEquals(false, warehouse.getProduct("").found());
    }

    @Test
    void testGetProductsAddedAfterGivenDate() {

    }

    @Test
    void testGetProductsByCategory() {

    }

    @Test
    void testUpdateCategory() {
        String id = warehouse.addProduct("New", Category.CLOTHES);
        
    }

    @Test
    void testUpdateName() {

    }

    @Test
    void testUpdateRating() {

    }
}
