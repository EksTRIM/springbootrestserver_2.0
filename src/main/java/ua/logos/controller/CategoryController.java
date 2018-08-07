package ua.logos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.logos.domain.CategoryDTO;
import ua.logos.service.CategoryService;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Void> createdCategory(@RequestBody CategoryDTO dto){
        categoryService.saveCategory(dto);
        return  new ResponseEntity<Void>(HttpStatus.CREATED);
    }


    @GetMapping
    public  ResponseEntity<List<CategoryDTO>>getCategories(){
        List<CategoryDTO> categoryDTOs = categoryService.findAllCategories();
        return new ResponseEntity<List<CategoryDTO>>(categoryDTOs, HttpStatus.OK);
    }


    /*@GetMapping
    public  List<CategoryDTO> getCategories(){
        return  categoryService.findAllCategories();
    }*/
}
