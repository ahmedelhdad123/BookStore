package org.example.bookstore.controller;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.entity.Category;
import org.example.bookstore.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("allCategory") //localhost:9090/api/allCategory
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories=categoryService.getAllCategory();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @GetMapping("findCategory{id}") //localhost:9090/api/findCategory
    public ResponseEntity<Category> findCategory(@PathVariable long id) {
        Category categories=categoryService.findById(id);

        return new ResponseEntity<>(categories,HttpStatus.OK);
    }
    @PostMapping("addCategory") //localhost:9090/api/addCategory
    public ResponseEntity<Category> addCategory(@Validated @RequestBody Category category){
        Category newCategory =categoryService.addCategory(category);
        return new ResponseEntity<>(newCategory,HttpStatus.CREATED);
    }

    @DeleteMapping("deleteCategory{id}") //localhost:9090/api/deleteCategory
    public ResponseEntity<String> deleteCategory(@PathVariable long id) {  //
         categoryService.deleteCategory(id);
         return ResponseEntity.ok("Category deleted");
    }

    @PutMapping("updateCategory{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable long id,@Validated @RequestBody Category updatedCategory)
    {
        Category category=categoryService.updateCategory(id,updatedCategory);

        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @GetMapping("searchCategory")
    public ResponseEntity<List<Category>> searchCategory(@RequestParam String name)
    {
        List<Category> categories=categoryService.searchCategory(name);
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

}
