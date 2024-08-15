package com.tutusfunny.Library.service;

import com.tutusfunny.Library.entity.BorrowingRecord;

public interface BorrowingRecordService {
    String addBorrowingRecord(BorrowingRecord borrowingRecord);

    BorrowingRecord borrowBook(Long bookId, Long patronId);

    BorrowingRecord returnBook(Long bookId, Long patronId);
}
