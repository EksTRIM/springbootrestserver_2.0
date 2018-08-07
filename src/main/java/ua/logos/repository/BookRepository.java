package ua.logos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.logos.domain.BookDTO;
import ua.logos.entity.Book;

import java.util.List;


@Repository

public interface BookRepository extends JpaRepository<Book, Long>,
        JpaSpecificationExecutor<Book> {



  /*  @Query("SELECT b from Book b WHERE b.category.id = :categoryId")
    List<Book> findBookByCategoryId(@Param("categoryId")Long catId);*/

    List<Book> findByCategoryId(Long id);


}
