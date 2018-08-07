package ua.logos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "book", indexes = @Index(columnList = "title, isbn"))
public class Book extends BaseEntity{

    @Column(name = "title")
    private String title;

    private String description;

    private BigDecimal price;

    private String imageUrl;

    private String isbn;

    private String author;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
