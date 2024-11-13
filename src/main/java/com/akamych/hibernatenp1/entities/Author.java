package com.akamych.hibernatenp1.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    subselect solutions
//    @Fetch(FetchMode.SUBSELECT)

//    batch solution
//    @BatchSize(size = 5)
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> books;
}
