package com.example.test_cv.service;

import com.example.test_cv.model.Product;

public interface IProductSev {


    void save(Product product);

    Product findById(Integer id);

    void findByDetail(Product product);

}
