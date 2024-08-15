package com.tutusfunny.Library.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class AuthorUpdateDTO {
    private int authorId;
    private String authorName;
}
