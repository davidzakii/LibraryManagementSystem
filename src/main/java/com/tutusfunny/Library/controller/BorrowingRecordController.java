package com.tutusfunny.Library.controller;

import com.tutusfunny.Library.entity.BorrowingRecord;
import com.tutusfunny.Library.service.BorrowingRecordService;
import com.tutusfunny.Library.service.IMPL.BorrowingRecordServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrowingRecords")
public class BorrowingRecordController {

    @Autowired
    private BorrowingRecordService borrowingRecordService;

    // Endpoint for borrowing a book
    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<BorrowingRecord> borrowBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        BorrowingRecord borrowingRecord = borrowingRecordService.borrowBook(bookId, patronId);
        return new ResponseEntity<>(borrowingRecord, HttpStatus.CREATED);
    }

    // Endpoint for returning a book
    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<BorrowingRecord> returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        BorrowingRecord borrowingRecord = borrowingRecordService.returnBook(bookId, patronId);
        if (borrowingRecord != null) {
            return new ResponseEntity<>(borrowingRecord, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
