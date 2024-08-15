package com.tutusfunny.Library.service.IMPL;

import com.tutusfunny.Library.dto.BookSaveDTO;
import com.tutusfunny.Library.entity.Book;
import com.tutusfunny.Library.repo.BookRepo;
import com.tutusfunny.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceIMPL implements BookService {
    @Autowired
    private BookRepo bookRepo;

    @Override
    public String addBook(BookSaveDTO bookSaveDTO) {
        Book book = new Book();
        book.setTitle(bookSaveDTO.getTitle());
        book.setAuthor(bookSaveDTO.getAuthor());
        book.setPublicationYear(bookSaveDTO.getPublicationYear());
        book.setIsbn(bookSaveDTO.getIsbn());
        bookRepo.save(book);
        return "Book added successfully!";
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepo.findById(id);
    }

    public Book updateBook(Long id, Book updatedBook) {
        return bookRepo.findById(id)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setPublicationYear(updatedBook.getPublicationYear());
                    book.setIsbn(updatedBook.getIsbn());
                    return bookRepo.save(book);
                })
                .orElse(null);
    }

    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }
}
