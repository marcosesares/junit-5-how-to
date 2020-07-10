package com.luiz.domain.model;

import com.luiz.support.builder.ProductTestBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * The type Product service test.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Product Service")
class ProductServiceTest {

    /**
     * The Repository.
     */
    @Mock
    ProductRepository repository;

    /**
     * The Service.
     */
    ProductService service;

    /**
     * Sets up.
     */
    @BeforeAll
    void setUp() {
        MockitoAnnotations.initMocks(this);
        when(repository.findAll()).thenReturn(ProductTestBuilder.anListOfProduct());
        service = new ProductService(repository);
    }

    /**
     * Add.
     */
    @Test
    @DisplayName("Add new product using service")
    void add() {
        final Product mouse = service.add("Mouse", BigDecimal.ONE);

        verify(repository, atLeastOnce()).add(any());
        verify(repository, atLeastOnce()).findAll();

        assertNotNull(mouse);
    }

    /**
     * Find all.
     */
    @Test
    @DisplayName("Find all products using service")
    void findAll() {
        final List<Product> products = service.findAll();
        verify(repository, atMost(1)).findAll();
        assertFalse(products.isEmpty(), "The list cannot be empty");
    }
}