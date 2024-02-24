package org.example.bookstore.service;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.dao.CategoryRepo;
import org.example.bookstore.entity.Category;
import org.example.bookstore.exception.ApiRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // Lombok annotation for constructor injection
public class CategoryService {

    private final CategoryRepo categoryRepository;


    public List<Category> getAllCategory() {

        return categoryRepository.findAll().stream()
                .map(category -> {
                    Category categoryWithoutBooks =new Category(category.getId(),category.getCategoryName());
                    return categoryWithoutBooks;
                })
                .collect(Collectors.toList());
    }
    public Category findById(long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElseThrow(() -> new ApiRequestException("Category not found with id: " + id));
    }
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(long id) {
        categoryRepository.findById(id).orElseThrow(() -> new ApiRequestException("Category not found with id: " + id));
        categoryRepository.deleteById(id);
    }

    public Category updateCategory(long id,Category updatedCategory)
    {
        Category existingCategory=categoryRepository.findById(id).get();
        existingCategory.setCategoryName(updatedCategory.getCategoryName());
        return categoryRepository.save(existingCategory);
    }

    public List<Category> searchCategory(String name)
    {
        return categoryRepository.findByCategoryNameContaining(name);
    }

}
