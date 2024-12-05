package com.personal.bookstore.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequest {

    private String name;
    private String category;
    private Long stock;
    private Long price;
    private String authorName;
}
