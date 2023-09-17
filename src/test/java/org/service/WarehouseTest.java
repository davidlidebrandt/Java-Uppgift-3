package org.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.entities.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WarehouseTest {
    Warehouse warehouse;
    
    @BeforeEach
    void setUp() {
        warehouse = new Warehouse();
    }

    @Test
    void testAddProduct() {
        assertEquals("Successfully added product", warehouse.addProduct("Test", Category.CLOTHES));
        assertEquals("An error occurred when trying to add the product", warehouse.addProduct("", Category.SHOES));
    }

    @Test
    void testGetAllProducts() {

    }

    @Test
    void testGetModifiedProducts() {

    }

    @Test
    void testGetProduct() {

    }

    @Test
    void testGetProductsAddedAfterGivenDate() {

    }

    @Test
    void testGetProductsByCategory() {

    }

    @Test
    void testUpdateCategory() {

    }

    @Test
    void testUpdateName() {

    }

    @Test
    void testUpdateRating() {

    }
}
