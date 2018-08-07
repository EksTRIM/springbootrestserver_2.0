package ua.logos.service;

        import ua.logos.domain.CategoryDTO;

        import java.util.List;

public interface CategoryService {
    void  saveCategory(CategoryDTO dto);

    CategoryDTO findCategoryById(Long id);

    List<CategoryDTO> findAllCategories();
}
