package com.example.movietickets.demo.service;


import com.example.movietickets.demo.model.Category;
import com.example.movietickets.demo.repository.CategoryRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


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
    public Map<String, Object> getSuggestedCategories() {
        // Lấy danh sách tất cả các thể loại từ cơ sở dữ liệu
        List<Category> getCategories = categoryRepository.findAll();

        // Kiểm tra nếu không có thể loại nào
        if (getCategories.isEmpty()) {
            Map<String, Object> response = new HashMap<>();
            response.put("fulfillmentMessages", List.of(
                    new HashMap<String, Object>() {{
                        put("text", new HashMap<String, Object>() {{
                            put("text", List.of("Hiện tại không có thể loại nào trong danh sách."));
                        }});
                    }}
            ));
            return response;
        }

        // Tạo đối tượng Random
        Random random = new Random();

        // Chọn số lượng thể loại ngẫu nhiên (1 hoặc 2)
        int numberOfCategories = random.nextInt(2) + 1; // Random từ 1-2

        // Xáo trộn danh sách thể loại và lấy số lượng cần thiết
        Collections.shuffle(getCategories);
        List<Category> selectedCategories = getCategories.subList(0, Math.min(numberOfCategories, getCategories.size()));

        // Kiểm tra nếu có thể loại đã chọn
        if (selectedCategories.isEmpty()) {
            Map<String, Object> response = new HashMap<>();
            response.put("fulfillmentMessages", List.of(
                    new HashMap<String, Object>() {{
                        put("text", new HashMap<String, Object>() {{
                            put("text", List.of("Không có thể loại phù hợp."));
                        }});
                    }}
            ));
            return response;
        }

        // Tạo JSON phản hồi cho Dialogflow Messenger
        Map<String, Object> response = new HashMap<>();
        List<Map<String, Object>> fulfillmentMessages = new ArrayList<>();

        // Thêm phần text "Bạn có thể xem thể loại:"
        fulfillmentMessages.add(new HashMap<String, Object>() {{
            put("text", new HashMap<String, Object>() {{
                put("text", Arrays.asList("Bạn có thể xem thể loại:"));
            }});
        }});

        // Tạo phần button cho các thể loại được chọn
        List<Map<String, Object>> buttons = new ArrayList<>();

        for (Category category : selectedCategories) {
            Map<String, Object> richContent = new HashMap<>();
            richContent.put("type", "button");
            richContent.put("icon", new HashMap<String, Object>() {{
                put("type", "arrow_right");
                put("color", "#ff0000");
            }});
            richContent.put("text", category.getName());
            richContent.put("link", "http://localhost:8080/films/by-category/" + category.getId()); // This link opens in the same window by default

            buttons.add(richContent);
        }

        // Thêm buttons vào fulfillmentMessages
        fulfillmentMessages.add(new HashMap<String, Object>() {{
            put("payload", new HashMap<String, Object>() {{
                put("richContent", Arrays.asList(buttons));
            }});
        }});

        response.put("fulfillmentMessages", fulfillmentMessages);

        return response;
    }


}
