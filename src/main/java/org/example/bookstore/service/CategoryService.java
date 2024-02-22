package org.example.bookstore.service;

import org.example.bookstore.dao.CategoryRepo;
import org.example.bookstore.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private  CategoryRepo categoryRepository;

    @Autowired
    public CategoryService(CategoryRepo categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategory() {

        return categoryRepository.findAll().stream()
                .map(category -> {
                    Category categoryWithoutBooks =new Category(category.getId(),category.getCategoryName());
                    return categoryWithoutBooks;
                })
                .collect(Collectors.toList());
    }
    public Category findById(long id){
        return categoryRepository.findById(id).get();
    }
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public String deleteCategory(long id) {
        Category category = categoryRepository.findById(id).get();
        categoryRepository.delete(category);
        return "Category deleted";
    }


}
