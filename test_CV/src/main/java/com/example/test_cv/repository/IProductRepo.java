package com.example.test_cv.repository;

import com.example.test_cv.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepo extends JpaRepository<Product, Integer> {

@Query("select p.id,p.name,p.price,p.image from  Product p" +
        " join p.color c" +
        " join p.size s " + " where (:minPrice is null or p.price >= :minPrice)" +
        "and (:maxPrice is null or p.price <= :maxPrice)  " +
        "and (:color is null or c.name = :color)" +
        "and (:size is null or s.name =:size)"
        )
    Page<Product> findAll(Pageable pageRequest,@Param("minPrice") Double minPrice,@Param("maxPrice") Double maxPrice ,@Param("color") String color,@Param("size") String size);


}
