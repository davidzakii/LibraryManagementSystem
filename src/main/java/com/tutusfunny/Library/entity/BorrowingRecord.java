package com.tutusfunny.Library.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class BorrowingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "patron_id")
    private Patron patron;

    private LocalDate borrowDate;
    private LocalDate returnDate;

    public void setBook(Book book) {

    }

    public void setPatron(Patron patron) {

    }

    public void setBorrowDate(LocalDate now) {

    }

    public void setReturnDate(LocalDate now) {

    }
}
