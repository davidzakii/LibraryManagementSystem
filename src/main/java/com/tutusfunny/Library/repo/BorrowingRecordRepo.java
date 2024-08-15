package com.tutusfunny.Library.repo;

import com.tutusfunny.Library.entity.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRecordRepo extends JpaRepository<BorrowingRecord, Long> {
}
