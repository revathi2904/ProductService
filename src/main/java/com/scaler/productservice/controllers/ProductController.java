package com.scaler.productservice.controllers;

import com.scaler.productservice.dtos.FakeStoreProductDto;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
//        return new FakeStoreProductDto[0];
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id){

        return new ResponseEntity<>(
                productService.getSingleProduct(id),
                HttpStatus.OK
        );
//        System.out.println(id);
//        ResponseEntity<Product> response = new ResponseEntity<Product>(
//                productService.getSingleProduct(id), HttpStatus.FORBIDDEN);
//        return response;
    }

    @PostMapping
    public Product addNewProduct(@RequestBody Product product){

        return productService.addNewProduct(product);
    }

//    @PostMapping()
//    public FakeStoreProductDto addNewProduct(@RequestBody Product product){
//        System.out.println(product);
//        Product p = new Product();
//        Category c = new Category();
//        p.setTitle(product.getTitle());
//        p.setPrice((product.getPrice()));
//        p.setDescription(product.getDescription());
//        p.setImageUrl(product.getImageUrl());
//        c.setName(product.getCategory().getName());
//        c.setId(product.getCategory().getId());
//        p.setCategory(c);
//
//        return  productService.addNewProduct(p);
//
//    }

    // only the attributes that needs to be updated are sent here
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){

        return productService.updateProduct(id,product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){


        return productService.replaceProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") Long id){

        productService.deleteProduct(id);
        return "Deleted successfully";
    }


}
