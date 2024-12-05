package com.example.movietickets.demo.controller.ApiController.admin;


import com.example.movietickets.demo.model.Category;
import com.example.movietickets.demo.service.APIService.*;
import com.example.movietickets.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminCategoryAPIController {
    private final AdminApiService adminApiService;

    @Autowired
    private CategoryService categoryService;

    public AdminCategoryAPIController(AdminApiService adminApiService) {
        this.adminApiService= adminApiService;
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return adminApiService.getAllCategory();
    }

    @GetMapping("/categories/{id}")
    public Optional<Category> getById(@PathVariable Long id){
        return adminApiService.getCategoryById(id);
    }

    @PostMapping("/categories")
    public ResponseEntity<?> createCategory(@RequestParam("name") String name){
        if (name == null || name.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Thể loại không hợp lệ");
        }
        Category category = new Category();
        category.setName(name);
        adminApiService.addCategory(category);
        return ResponseEntity.ok(Collections.singletonMap("message", "Thêm thể loại thành công"));
    }
    @PutMapping("/categories/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestParam("name") String name){
        try{
            Optional<Category> existingCategory = adminApiService.getCategoryById(id);

            if(existingCategory.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy thể loại với id: " + id);
            }
            // Check if the name already exists in another category
            if (adminApiService.categoryNameExists(name, id)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Tên thể loại đã tồn tại");
            }
            Category categoryToUpdate = existingCategory.get();
            categoryToUpdate.setName(name);
            adminApiService.updateCategory(categoryToUpdate);
            return ResponseEntity.ok(
                    Collections.singletonMap("message", "Chỉnh sửa thể loại với id: " + id + " thành công"));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        // Kiểm tra xem thể loại có tồn tại trước khi xóa
        Optional<Category> existingCategory = categoryService.getCategoryById(id);
        if (existingCategory.isPresent()) {
            categoryService.deleteCategory(id);
            return ResponseEntity.ok(Collections.singletonMap("message", "Xóa thể loại thành công"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("message", "Không tìm thấy thể loại với id: " + id));
        }
    }


}
