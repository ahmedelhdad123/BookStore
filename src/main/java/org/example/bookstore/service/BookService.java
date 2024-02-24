package org.example.bookstore.service;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.dao.BookRepo;
import org.example.bookstore.entity.Book;
import org.example.bookstore.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BookService {


    private final BookRepo bookRepo;

    public List<Book> findAll()
    {
        return bookRepo.findAll();
    }

    public Book findByID(long id)
    {
        Optional<Book> listOfBook=bookRepo.findById(id);
        if (listOfBook.isPresent())
        {
            return listOfBook.get();
        }else
        {
            throw new ApiRequestException("Not Found");
        }

    }

    public void removeBook(Long id)
    {
         bookRepo.deleteById(id);
    }

    public long findNumberOfBOOKByCategoryId(long id)
    {
        return bookRepo.findNumberOfBOOKByCategoryId(id);
    }

    public List<Book> findBookByName(String name)
    {
        return bookRepo.findBooksByNameContaining(name);
    }

    public long findNumberOfBooksByName(String name)
    {
        return bookRepo.findNumberOfBooksByName(name);
    }

    public Book addBook(Book book)
    {
        return bookRepo.save(book);
    }

    public long sizeOfAllBook()
    {
        return bookRepo.count();
    }

    public List<Book>  findBookByPrice(int price)
    {
        List<Book> listOfBook=bookRepo.findBooksByPrice(price);
        if (listOfBook.isEmpty())
        {
            throw new ApiRequestException("Not Found");
        }
        return listOfBook;
    }



}
