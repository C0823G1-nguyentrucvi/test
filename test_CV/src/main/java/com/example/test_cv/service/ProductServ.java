package com.example.test_cv.service;

import com.example.test_cv.model.Product;
import com.example.test_cv.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServ implements IProductSev{
    @Autowired
    private IProductRepo productRepo;


    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productRepo.findById(id).get();
    }

    @Override
    public void findByDetail(Product product) {
        productRepo.findById(product.getId());
    }


    public Page<Product> findAll(Pageable pageRequest,Double minPrice,Double maxPrice,String color, String size) {
        return productRepo.findAll(pageRequest,minPrice,maxPrice,color,size);
    }
}
