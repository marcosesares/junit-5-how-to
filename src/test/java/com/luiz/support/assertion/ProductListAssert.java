package com.luiz.support.assertion;

import com.luiz.domain.model.Product;
import org.assertj.core.api.AbstractAssert;

import java.math.BigDecimal;
import java.util.List;

/**
 * The type Product list assert.
 */
public class ProductListAssert extends AbstractAssert<ProductListAssert, List<Product>> {

    private List<Product> products;

    /**
     * Instantiates a new Product list assert.
     *
     * @param products the products
     */
    public ProductListAssert(List<Product> products) {
        super(products, ProductListAssert.class);
        this.products = products;
    }

    /**
     * Assert that product list assert.
     *
     * @param products the products
     * @return the product list assert
     */
    public static ProductListAssert assertThat(List<Product> products) {
        return new ProductListAssert(products);
    }

    /**
     * Has price lower than product list assert.
     *
     * @param price the price
     * @return the product list assert
     */
    public ProductListAssert hasPriceLowerThan(BigDecimal price) {
        products.forEach(product -> {
            if (product.getPrice().compareTo(price) < 0) {
                failWithMessage("The price should be lower than " + price);
            }
        });
        return this;
    }

    /**
     * Has price bigger than product list assert.
     *
     * @param price the price
     * @return the product list assert
     */
    public ProductListAssert hasPriceBiggerThan(BigDecimal price) {
        products.forEach(product -> {
            if (product.getPrice().compareTo(price) > 0) {
                failWithMessage("The price should be bigger than " + price);
            }
        });
        return this;
    }
}
