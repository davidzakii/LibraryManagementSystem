package com.tutusfunny.Library.repo;

import com.tutusfunny.Library.entity.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorrowingRecordRepo extends JpaRepository<BorrowingRecord, Long> {

    Optional<BorrowingRecord> findByBookIdAndPatronId(Long bookId, Long patronId);
}
