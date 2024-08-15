package com.tutusfunny.Library.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PatronSaveDTO {
    private Long id;
    private String name;
    private String contactInfo;
}
