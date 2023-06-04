package kr.hansung.cse.hellpspringdatajpa.repository;

import kr.hansung.cse.hellpspringdatajpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
