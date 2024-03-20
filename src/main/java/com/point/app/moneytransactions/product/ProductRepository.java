package com.point.app.moneytransactions.product;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

   Optional<Product> findProductById(Long id);

   @Query("SELECT o FROM Product o WHERE o.name LIKE :name")
   List<Product> getProductsByName(@Param("name") String name);
    @Query("SELECT o FROM Product o WHERE LOWER(o.name) LIKE LOWER(CONCAT('%', :name, '%')) AND o.id IN (SELECT MIN(p.id) FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')) GROUP BY p.name)")
    List<Product> findUniqueProductsByName(@Param("name") String name);

    List<Product> findProductsByCompanyId(Long id);

}
