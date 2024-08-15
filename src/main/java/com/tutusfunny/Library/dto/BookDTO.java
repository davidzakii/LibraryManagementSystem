package com.tutusfunny.Library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private int publicationYear;
    private String isbn;
}
