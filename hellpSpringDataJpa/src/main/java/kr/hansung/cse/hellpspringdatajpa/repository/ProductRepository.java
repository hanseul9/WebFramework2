package kr.hansung.cse.hellpspringdatajpa.repository;

import kr.hansung.cse.hellpspringdatajpa.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);
    List<Product> findByNameContaining(String searchKeyword, Pageable paging);

    // used to retrieve records from the Product entity
    // where the name attribute contains a specific substring
    @Query("select p from Product p where p.name like %?1%")
    List<Product> searchByName(String name);

}
