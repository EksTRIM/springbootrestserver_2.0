package ua.logos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.logos.domain.CategoryDTO;
import ua.logos.entity.Category;
import ua.logos.repository.CategoryRepository;
import ua.logos.service.CategoryService;
import ua.logos.service.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class CategoryServiseImpl implements CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;



    @Override
    public void saveCategory(CategoryDTO dto) {
        Category category = modelMapper.map(dto, Category.class);
        categoryRepository.save(category);
    }

    @Override
    public CategoryDTO findCategoryById(Long id) {
        Category category = categoryRepository.findById(id).get();
        CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
        return categoryDTO;
        //return modelMapper.map(categoryRepository.findById(id).get(), CategoryDTO.class);
    }

    @Override
    public List<CategoryDTO> findAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOs = modelMapper.mapAll(categories, CategoryDTO.class);
        return categoryDTOs;
    }
}
