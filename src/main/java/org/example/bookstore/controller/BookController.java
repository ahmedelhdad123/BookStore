package org.example.bookstore.controller;

import lombok.RequiredArgsConstructor;
import org.example.bookstore.entity.Book;
import org.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;



    @GetMapping("findAllBook")
    public ResponseEntity<List<Book>> findAll()
    {
        List<Book> books=bookService.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("findBookByID{id}")
    public ResponseEntity<Book> findByID(@PathVariable long id)
    {
        Book book=bookService.findByID(id);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @DeleteMapping("removeBookById{id}")
    public ResponseEntity<Void> removeBook(@PathVariable Long id)
    {
         bookService.removeBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("findNumberOfBOOKByCategoryId{id}")
    public ResponseEntity<Long> findNumberOfBOOKByCategoryId(@PathVariable long id)
    {
        return ResponseEntity.ok(bookService.findNumberOfBOOKByCategoryId(id));
    }

    @GetMapping("findBookByName")
    public ResponseEntity<List<Book>> findBookByName(@RequestParam String name)
    {
        return ResponseEntity.ok(bookService.findBookByName(name));
    }

    @GetMapping("findNumberOfBooksByName")
    public ResponseEntity<Long> findNumberOfBooksByName(@RequestParam String name)
    {
        return ResponseEntity.ok(bookService.findNumberOfBooksByName(name));
    }

    @PostMapping("addBook")
    public ResponseEntity<Book> addBook(@Validated @RequestBody Book book)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(book));
    }

    @GetMapping("sizeOfAllBook")
    public ResponseEntity<Long> sizeOfAllBook()
    {
        return ResponseEntity.ok(bookService.sizeOfAllBook());
    }

    @GetMapping("findBookByPrice")
    public ResponseEntity<List<Book> > findBookByPrice(@RequestParam int price)
    {
        return ResponseEntity.ok(bookService.findBookByPrice(price));
    }
}
