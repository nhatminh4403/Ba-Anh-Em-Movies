package com.example.movietickets.demo.service;


import com.example.movietickets.demo.model.Category;
import com.example.movietickets.demo.repository.CategoryRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import java.util.List;
import java.util.Optional;


@Transactional
@Service
@RequiredArgsConstructor
//khởi tạo constructor tự động


public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAllByOrderByIdDesc();
    }

    public List<Category> findAllById(List<Long> ids) {
        return categoryRepository.findAllById(ids);
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(@NotNull Category category) {
        Category existingCategory = categoryRepository.findById(category.getId())
                .orElseThrow(() -> new IllegalStateException("Category with ID " + category.getId() + " does not exist."));
        existingCategory.setName(category.getName());
        categoryRepository.save(existingCategory);
    }

    public void deleteCategoryById(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new IllegalStateException("Category with ID " + id + " does not exist.");
        }
        categoryRepository.deleteById(id);
    }

    public List<Category> getCategoriesByIds(List<Category> categories) {
        List<Long> ids = categories.stream().map(Category::getId).toList();
        return categoryRepository.findAllById(ids);
    }


    public String getSuggestedCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            return "Hiện tại không có thể loại nào trong danh sách.";
        }

        // Tạo Random object
        Random random = new Random();

        // Chọn ngẫu nhiên số lượng thể loại (1 hoặc 2)
        int numberOfCategories = random.nextInt(2) + 1; // Random từ 1-2

        // Xáo trộn danh sách và lấy số lượng cần thiết
        Collections.shuffle(categories);
        List<Category> selectedCategories = categories.subList(0,
                Math.min(numberOfCategories, categories.size()));

        // Tạo câu trả lời
        StringBuilder response = new StringBuilder();
        if (selectedCategories.size() == 1) {
            response.append("Bạn có thể xem thể loại: ")
                    .append(selectedCategories.get(0).getName());
        } else {
            response.append("Bạn có thể xem các thể loại: ")
                    .append(selectedCategories.get(0).getName())
                    .append(" hoặc ")
                    .append(selectedCategories.get(1).getName());
        }

        return response.append(".").toString();
    }
}
