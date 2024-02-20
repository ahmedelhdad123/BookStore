package org.example.bookstore.controller;

import org.example.bookstore.entity.Category;
import org.example.bookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("api/")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("allCategory") //localhost:9090/api/allCategory
    public List<Category> getAllCategories() {
        return categoryService.getAllCategory();
    }
    @GetMapping("findCategory") //localhost:9090/api/findCategory
    public Category findCategory(@RequestParam long id) {
        return categoryService.findById(id);
    }
    @PostMapping("addCategory") //localhost:9090/api/addCategory
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    @DeleteMapping("deleteCategory") //localhost:9090/api/deleteCategory
    public String deleteCategory(@RequestParam long id) {
         categoryService.deleteCategory(id);
         return "Category deleted";
    }

}
