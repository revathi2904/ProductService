package com.scaler.productservice.controllers;

import com.scaler.productservice.dtos.FakeStoreCategoryDto;
import com.scaler.productservice.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping
    public String[] getAllCategories(){
        return categoryService.getAllCategories();
    }

}
