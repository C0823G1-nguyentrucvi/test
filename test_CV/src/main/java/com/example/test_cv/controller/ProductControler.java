package com.example.test_cv.controller;

import com.example.test_cv.model.Product;
import com.example.test_cv.service.IProductSev;
import com.example.test_cv.service.ProductServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductControler {
    @Autowired
    private ProductServ productServ;

    @Autowired
    private IProductSev productSev;

    @GetMapping("/list")
    public ResponseEntity<Page<Product>> getAllProducts(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "2") int num,
                                                        @RequestParam (required = false) Double minPrice,
                                                        @RequestParam(required = false) Double maxPrice,
                                                        @RequestParam(required = false) String color,
                                                        @RequestParam(required = false) String size) {
        Pageable pageRequest= PageRequest.of(page,num);
        Page<Product> productList = productServ.findAll(pageRequest,minPrice,maxPrice,color,size);
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }



    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
         productSev.save(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
Product product=productSev.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }



@GetMapping("/detail/{id}")
    public ResponseEntity<Product> getProductDetail(@PathVariable Integer id) {
Product product=productSev.findById(id);
productSev.findByDetail(product);
    return new ResponseEntity<>(product, HttpStatus.OK);
}



}
