package com.personal.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Audited
public class Books extends AbstractEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "stock")
    private Long stock;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private Long price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "author_id")
    private Author author;
}
