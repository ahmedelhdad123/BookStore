package org.example.bookstore.dao;

import org.example.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {

    @Query("select COUNT (id) from Book  where category.id= :id")
   long findNumberOfBOOKByCategoryId(long id);

    List<Book> findBooksByNameContaining(String name);

    @Query("select count (name) from Book where name like %?1%")
    long findNumberOfBooksByName(String name);


    List<Book> findBooksByPrice(long price);
}
