package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.logos.entity.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {



}


