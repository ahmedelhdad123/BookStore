package org.example.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@Entity
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name="Number_of_book")
    private int numberOfBook;

    @Column(name = "date_create")
    @CreationTimestamp
    private Date dateCreate;

    @Column(name = "date_update")
    @CreationTimestamp
    private Date dateUpdate;

    @Column(name = "price")
    private long price;


    @Column(name = "description" , length = 500)
    private String description;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "category_id")
    private Category category;
}
