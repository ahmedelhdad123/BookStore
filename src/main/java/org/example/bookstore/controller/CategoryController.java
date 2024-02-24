package org.example.bookstore.controller;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.entity.Category;
import org.example.bookstore.service.CategoryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("allCategory") //localhost:9090/api/allCategory
    public List<Category> getAllCategories() {
        return categoryService.getAllCategory();
    }
    @GetMapping("findCategory{id}") //localhost:9090/api/findCategory
    public Category findCategory(@PathVariable long id) {
        return categoryService.findById(id);
    }
    @PostMapping("addCategory") //localhost:9090/api/addCategory
    public Category addCategory(@Validated @RequestBody Category category){
        return categoryService.addCategory(category);
    }

    @DeleteMapping("deleteCategory{id}") //localhost:9090/api/deleteCategory
    public String deleteCategory(@PathVariable long id) {  //
         categoryService.deleteCategory(id);
         return "Category deleted";
    }

    @PutMapping("updateCategory{id}")
    public Category updateCategory(@PathVariable long id,@Validated @RequestBody Category updatedCategory)
    {
        return categoryService.updateCategory(id,updatedCategory);
    }

    @GetMapping("searchCategory")
    public List<Category> searchCategory(@RequestParam String name)
    {
        return categoryService.searchCategory(name);
    }

}
