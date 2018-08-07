package ua.logos.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private  Long id;

    private String title;

    private String description;

    private BigDecimal price;

    private String imageUrl;

    private String isbn;

    private String author;

    private CategoryDTO category;

}
