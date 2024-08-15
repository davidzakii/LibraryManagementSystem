package com.tutusfunny.Library.service.IMPL;

import com.tutusfunny.Library.entity.Book;
import com.tutusfunny.Library.entity.Patron;
import com.tutusfunny.Library.entity.BorrowingRecord;
import com.tutusfunny.Library.repo.BorrowingRecordRepo;
import com.tutusfunny.Library.service.BorrowingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BorrowingRecordServiceIMPL implements BorrowingRecordService {

    @Autowired
    private BorrowingRecordRepo borrowingRecordRepo;

    @Override
    public String addBorrowingRecord(BorrowingRecord borrowingRecord) {
        borrowingRecordRepo.save(borrowingRecord);
        return "Borrowing record added successfully";
    }

    public BorrowingRecord borrowBook(Long bookId, Long patronId) {
        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setBook(new Book(bookId)); // Assuming you have a constructor that accepts ID
        borrowingRecord.setPatron(new Patron(patronId)); // Assuming you have a constructor that accepts ID
        borrowingRecord.setBorrowDate(LocalDate.now());
        return borrowingRecordRepo.save(borrowingRecord);
    }

    public BorrowingRecord returnBook(Long bookId, Long patronId) {
        Optional<BorrowingRecord> borrowingRecordOptional = borrowingRecordRepo.findByBookIdAndPatronId(bookId, patronId);
        if (borrowingRecordOptional.isPresent()) {
            BorrowingRecord borrowingRecord = borrowingRecordOptional.get();
            borrowingRecord.setReturnDate(LocalDate.now());
            return borrowingRecordRepo.save(borrowingRecord);
        } else {
            return null; // Handle the case when the record is not found
        }
    }
}
