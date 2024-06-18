package com.example.movietickets.demo.service;


import com.example.movietickets.demo.model.Category;
import com.example.movietickets.demo.repository.CategoryRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class CategoryService {
    private final CategoryRepository catologyRepository;

    public List<Category> getAllCatologies(){
        return catologyRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return catologyRepository.findById(id);
    }

    public void addCategory(Category category) {
        catologyRepository.save(category);
    }

    public void updateCategory(@NotNull Category category) {
        Category existingCategory = catologyRepository.findById((long)
                        category.getId())
                .orElseThrow(() -> new IllegalStateException("Category with ID " +
                        category.getId() + " does not exist."));
        existingCategory.setName(category.getName());
        catologyRepository.save(existingCategory);
    }

    public void deleteCategoryById(Long id) {
        if (!catologyRepository.existsById(id)) {
            throw new IllegalStateException("Category with ID " + id + " does not exist.");
        }
        catologyRepository.deleteById(id);
    }
}
