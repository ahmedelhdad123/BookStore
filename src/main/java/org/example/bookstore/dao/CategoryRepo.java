package org.example.bookstore.dao;

import org.example.bookstore.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {

    List<Category> findByCategoryNameContaining(String name);

}
