package com.tutusfunny.Library.controller;

import com.tutusfunny.Library.entity.Book;
import com.tutusfunny.Library.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookRepo bookRepo;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepo.save(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        return bookRepo.findById(id)
                .map(book -> {
                    book.setTitle(bookDetails.getTitle());
                    book.setAuthor(bookDetails.getAuthor());
                    book.setPublicationYear(bookDetails.getPublicationYear());
                    book.setIsbn(bookDetails.getIsbn());
                    return ResponseEntity.ok(bookRepo.save(book));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        return bookRepo.findById(id)
                .map(book -> {
                    bookRepo.delete(book);
                    return ResponseEntity.noContent().<Void>build(); // التصريح بشكل صريح أن النوع هو Void
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
