package com.tutusfunny.Library.dto;

import com.tutusfunny.Library.entity.Patron;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorrowingRecordSaveDTO {
    private Patron patron;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
