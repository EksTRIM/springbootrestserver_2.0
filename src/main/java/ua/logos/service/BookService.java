package ua.logos.service;


import org.springframework.data.domain.Pageable;
import ua.logos.domain.BookDTO;
import ua.logos.domain.filter.SimpleFilter;
import ua.logos.entity.Book;


import java.util.List;

public interface BookService {

    void  saveBook(BookDTO bookDTO);

    BookDTO findById(Long id);

    List<BookDTO> findAllBooks();

    void deleteBook(Long id);

    List<BookDTO> findBookByCategoryId(long id);

    List<BookDTO> findAllBooksByPages(Pageable pageable);

    List<BookDTO> findByAllBooksSpecification(SimpleFilter filter);
}
