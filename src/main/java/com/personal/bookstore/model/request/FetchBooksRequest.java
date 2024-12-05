package com.personal.bookstore.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FetchBooksRequest {

    private Long page;
    private Long perPage;
    private String name;
    private String author;
    private String category;
}
