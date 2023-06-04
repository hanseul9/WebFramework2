package kr.hansung.cse.hellpspringdatajpa;

import kr.hansung.cse.hellpspringdatajpa.entity.Product;
import kr.hansung.cse.hellpspringdatajpa.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest //integration test (test spring IoC Container <- beans )
@Transactional
class HellpSpringDataJpaApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("Test1: findProductById")
    public void findProductById() {
        Optional<Product> product = productRepository.findById(1L);
        System.out.println(product.get());
        assertNotNull(product.get());
    }

    @Test
    @DisplayName("Test2: findAllProducts")
    public void findAllProducts() {
        List<Product> products = productRepository.findAll();
        assertNotNull(products);
    }
    @Test
    @DisplayName("Test3: createProduct")
    public void createProduct() {
        Product product = new Product("OLED TV", "LG전자", "korea", 300.0);
        Product savedProduct = productRepository.save(product);

        Product newProduct = productRepository.findById(savedProduct.getId()).get();
        assertEquals("OLED TV", newProduct.getName());
    }

}
