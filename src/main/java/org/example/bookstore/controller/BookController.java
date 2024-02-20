package org.example.bookstore.controller;

import org.example.bookstore.entity.Book;
import org.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("findAllBook")
    public List<Book> findAll()
    {
        return bookService.findAll();
    }

    @GetMapping("findBookByID")
    public Book findByID(@RequestParam long id)
    {
        return bookService.findByID(id);
    }

    @DeleteMapping("removeBookById")
    public String removeBook(@RequestParam Long id)
    {
         bookService.removeBook(id);
         return "Done ;)";
    }

    @GetMapping("findNumberOfBOOKByCategoryId")
    public long findNumberOfBOOKByCategoryId(@RequestParam long id)
    {
        return bookService.findNumberOfBOOKByCategoryId(id);
    }

    @GetMapping("findBookByName")
    public List<Book> findBookByName(@RequestParam String name)
    {
        return bookService.findBookByName(name);
    }

    @GetMapping("findNumberOfBooksByName")
    public long findNumberOfBooksByName(@RequestParam String name)
    {
        return bookService.findNumberOfBooksByName(name);
    }

    @PostMapping("addBook")
    public Book addBook(@RequestBody Book book)
    {
        return bookService.addBook(book);
    }

    @GetMapping("sizeOfAllBook")
    public long sizeOfAllBook()
    {
        return bookService.sizeOfAllBook();
    }

    @GetMapping("findBookByPrice")
    public List<Book>  findBookByPrice(@RequestParam int price)
    {
        return bookService.findBookByPrice(price);
    }
}
