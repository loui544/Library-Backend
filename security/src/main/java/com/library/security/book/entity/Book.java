package com.library.security.book.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //identification of the book
    private String image; //wallpaper of the book
    @NotBlank(message = "Please add the name of the book")
    private String name; // name of the book
    private String resume; // resume of the book
    private String author;//Author of the book
    @NotBlank(message = "Please add the editorial of the books")
    private String publisher; //editorial of publication
    private Date date; //date of edition
    @PositiveOrZero
    private int quantity; //quantity available of the book
}
