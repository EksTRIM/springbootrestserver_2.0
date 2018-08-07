package ua.logos;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import ua.logos.entity.Book;
import ua.logos.entity.Category;
import ua.logos.repository.BookRepository;
import ua.logos.repository.CategoryRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringbootrestserverApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootrestserverApplication.class, args);
        addCategories(context);
        addBooks(context);
    }

    private static void addCategories(ConfigurableApplicationContext context){
        List<String> categories = new ArrayList<>();
        categories.add("Комедія");
        categories.add("Драма");
        categories.add("Біографія");
        categories.add("Детектив");
        categories.add("Містика");
        categories.add("Фентезі");

        CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);

        if(categoryRepository.count()== 0){
            categories.forEach(c ->{
                Category category = new Category();
                category.setName(c);
                categoryRepository.save(category);
            });
        }

    }

    private static void addBooks(ConfigurableApplicationContext context) {
        BookRepository bookRepository = context.getBean(BookRepository.class);
        if (bookRepository.count() == 0) {
            for (int i = 0; i <= 500; i++) {
                Book book = new Book();
                book.setTitle("Book Tiyle #" + i);
                book.setIsbn("667678huhuhui" + i);
                book.setPrice(new BigDecimal("2" + i + ".00"));
                book.setAuthor("Autor #" + i);
                book.setImageUrl("http://image.url.com" + i);

                Category category = new Category();
                if (i % 2 == 0) {
                    category.setId(new Long(2L));
                    book.setCategory(category);
                }
                if (i % 3 == 0) {
                    category.setId(new Long(5L));
                    book.setCategory(category);
                }

                bookRepository.save(book);
            }
        }
        }

        @Bean
        public ModelMapper modelMapper () {

            return new ModelMapper();
        }

}
