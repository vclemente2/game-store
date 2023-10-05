package com.generation.gameshop.controller;

import com.generation.gameshop.dto.CategoryData;
import com.generation.gameshop.model.Category;
import com.generation.gameshop.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<Category> create(@Valid @RequestBody CategoryData categoryData){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryRepository.save(new Category(categoryData)));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAll(){
        return ResponseEntity.ok(categoryRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getOneById(@PathVariable("id") Long id) {
//        Category category = categoryRepository.findById(id).orElse(null);
//
//        if (category == null)
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada");
//
//        return ResponseEntity.ok(category);


        return categoryRepository.findById(id)
                .map((response)->ResponseEntity.ok(response))
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada."));
    }

    @GetMapping
    public ResponseEntity<List<CategoryData>> getAllWithoutId(@RequestParam(name="name", required = false) String name){
        List<Category> categories;

        if (name != null)
            categories = categoryRepository.findAllByNameContainingIgnoreCase(name);
        else
            categories = categoryRepository.findAll();

//      return ResponseEntity.ok(categories.stream().map(CategoryData::new).toList());
        return ResponseEntity.ok(categories.stream().map((response) -> new CategoryData(response)).toList());
    }


}
