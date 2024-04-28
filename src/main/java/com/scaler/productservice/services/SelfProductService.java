package com.scaler.productservice.services;

import com.scaler.productservice.dtos.FakeStoreProductDto;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.CategoryRepository;
import com.scaler.productservice.repositories.ProductRespository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService {

    private ProductRespository productRespository;
    private CategoryRepository categoryRepository;


    public SelfProductService(ProductRespository productRespository, CategoryRepository categoryRepository) {
        this.productRespository = productRespository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long id) {

        Optional<Product> optionalProduct = productRespository.findById(1L);

        if (optionalProduct.isEmpty()) {
            // throw exception
        }

        Product product = optionalProduct.get();

        return product;
    }

    @Override
    public Product addNewProduct(Product product) {

        Category category = product.getCategory();
        if (category.getId() == null) {
            Category saveCategory = categoryRepository.save(category);
            product.setCategory(saveCategory);
        }
        return productRespository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> productOptional = productRespository.findById(id);
        if (productOptional.isEmpty()) {
            //throw error
        }
        Product savedProduct = productOptional.get();

        if (product.getTitle() != null) {
            savedProduct.setTitle(product.getTitle());
        }
        if (product.getDescription() != null) {
            savedProduct.setDescription(product.getDescription());
        }
        if (product.getPrice() != null) {
            savedProduct.setPrice(product.getPrice());
        }
        if (product.getImageUrl() != null) {
            savedProduct.setImageUrl(product.getImageUrl());
        }
        return productRespository.save(savedProduct);
    }


    @Override
    public List<Product> getAllProducts() {
        return productRespository.findBy();
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        Optional<Product> productOptional = productRespository.findById(id);
        if (productOptional.isEmpty()) {
            //throw error
        }
        Product savedProduct = productOptional.get();

        savedProduct.setTitle(product.getTitle());

        savedProduct.setDescription(product.getDescription());

        savedProduct.setPrice(product.getPrice());

        savedProduct.setImageUrl(product.getImageUrl());
        Category category = product.getCategory();
        if (category.getId() == null) {
            Category saveCategory = categoryRepository.save(category);
            savedProduct.setCategory(saveCategory);
        }

        return productRespository.save(savedProduct);

    }

    @Override
    public void deleteProduct(Long id) {

        productRespository.deleteById(id);
    }

}



