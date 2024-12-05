package com.personal.bookstore.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FetchBooksResponse {

    private Long id;
    private String name;
    private String category;
    private Long stock;
    private Long price;
}
