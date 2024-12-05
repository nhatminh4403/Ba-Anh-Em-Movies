package com.example.movietickets.demo.service;


import com.example.movietickets.demo.model.Category;
import com.example.movietickets.demo.model.Film;
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
    public void removeCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalStateException("Category with ID " + id + " does not exist."));

        categoryRepository.delete(category);

    }
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalStateException("Category with ID " + id + " does not exist."));

        for(Film film : category.getFilms()) {
            film.getCategories().remove(category);
        }
        categoryRepository.delete(category);
    }

    public List<Category> getCategoriesByIds(List<Category> categories) {
        List<Long> ids = categories.stream().map(Category::getId).toList();
        return categoryRepository.findAllById(ids);
    }
//    public Map<String, Object> getSuggestedCategories() {
//        // Lấy danh sách tất cả các thể loại từ cơ sở dữ liệu
//        List<Category> getCategories = categoryRepository.findAll();
//
//        // Kiểm tra nếu không có thể loại nào
//        if (getCategories.isEmpty()) {
//            Map<String, Object> response = new HashMap<>();
//            response.put("fulfillmentMessages", List.of(
//                    new HashMap<String, Object>() {{
//                        put("text", new HashMap<String, Object>() {{
//                            put("text", List.of("Hiện tại không có thể loại nào trong danh sách."));
//                        }});
//                    }}
//            ));
//            return response;
//        }
//
//        // Tạo đối tượng Random
//        Random random = new Random();
//
//        // Chọn số lượng thể loại ngẫu nhiên (1 hoặc 2)
//        int numberOfCategories = random.nextInt(2) + 1; // Random từ 1-2
//
//        // Xáo trộn danh sách thể loại và lấy số lượng cần thiết
//        Collections.shuffle(getCategories);
//        List<Category> selectedCategories = getCategories.subList(0, Math.min(numberOfCategories, getCategories.size()));
//
//        // Kiểm tra nếu có thể loại đã chọn
//        if (selectedCategories.isEmpty()) {
//            Map<String, Object> response = new HashMap<>();
//            response.put("fulfillmentMessages", List.of(
//                    new HashMap<String, Object>() {{
//                        put("text", new HashMap<String, Object>() {{
//                            put("text", List.of("Không có thể loại phù hợp."));
//                        }});
//                    }}
//            ));
//            return response;
//        }
//
//        // Tạo JSON phản hồi cho Dialogflow Messenger
//        Map<String, Object> response = new HashMap<>();
//        List<Map<String, Object>> fulfillmentMessages = new ArrayList<>();
//
//        // Thêm phần text "Bạn có thể xem thể loại:"
//        fulfillmentMessages.add(new HashMap<String, Object>() {{
//            put("text", new HashMap<String, Object>() {{
//                put("text", Arrays.asList("Bạn có thể xem thể loại:"));
//            }});
//        }});
//
//        // Tạo phần richContent cho các thể loại được chọn
//        List<List<Map<String, Object>>> richContent = new ArrayList<>();
//
//        List<Map<String, Object>> chips = new ArrayList<>();
//        for (Category category : selectedCategories) {
//            Map<String, Object> chip = new HashMap<>();
//            chip.put("text", category.getName());
//            chip.put("link", "http://localhost:8080/films/by-category/" + category.getId());
//            chips.add(chip);
//        }
//        fulfillmentMessages.add(new HashMap<String, Object>() {{
//            put("payload", new HashMap<String, Object>() {{
//                put("richContent", Arrays.asList(
//                        Arrays.asList(
//                                new HashMap<String, Object>() {{
//                                    put("type", "chips");
//                                    put("options", chips);
//                                }}
//                        )
//                ));
//            }});
//        }});
//
//        response.put("fulfillmentMessages", fulfillmentMessages);
//        return response;
//    }


/*   public Map<String, Object> getSuggestedCategories() {
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
            String link = "/films/by-category/" + category.getId();
            Map<String, Object> richContent = new HashMap<>();
            richContent.put("type", "button");
            richContent.put("icon", new HashMap<String, Object>() {{
                put("type", "arrow_right");
                put("color", "#ff0000");
            }});
            richContent.put("text", category.getName());
//            richContent.put("anchor",new HashMap<String, Object>() {{
//                put("href","/films/by-category/" + category.getId());
//                put("target","_self");
//            }});
richContent.put("link",link ); // This link opens in the same window by default
            //      richContent.put("onclick", "navigateToCategory('" + category.getId() + "')");
//            richContent.put("event","EventInput");
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
    }*/

    public Map<String, Object> getSuggestedCategories() {
        // Lấy danh sách tất cả các thể loại từ cơ sở dữ liệu
        List<Category> getCategories = categoryRepository.findAll();

        // Kiểm tra nếu không có thể loại nào
        if (getCategories.isEmpty()) {
            Map<String, Object> response = new HashMap<>();
            response.put("fulfillmentMessages", Arrays.asList(
                    new HashMap<String, Object>() {{
                        put("text", new HashMap<String, Object>() {{
                            put("text", Arrays.asList("Hiện tại không có thể loại nào trong danh sách."));
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

        // Tạo JSON phản hồi cho Dialogflow Messenger
        Map<String, Object> response = new HashMap<>();
        List<Map<String, Object>> fulfillmentMessages = new ArrayList<>();

        // Thêm text trước accordion
        fulfillmentMessages.add(new HashMap<String, Object>() {{
            put("text", new HashMap<String, Object>() {{
                put("text", Arrays.asList("Dưới đây là một số thể loại phim bạn có thể tham khảo:"));
            }});
        }});
        // Tạo accordion với nội dung
        List<Map<String, Object>> accordions = new ArrayList<>();
        for (Category category : selectedCategories) {

            String title = "<a  style='text-decoration: none; color: red; flex-grow: 1;width:150px;padding-right: 190px; height: 100%; display: block;' target='_self' href='/films/by-category/" + category.getId() + "'>"+ category.getName() + "</a>";

            String customTitle = "<div style='width: 100%; padding-right:100%; display: flex; align-items: center;'>" + "<span style='width: 72px; padding-right: 10px;'>Thể loại: </span> " + title + "</div>"; // Add a CSS class here

            Map<String, Object> accordion = new HashMap<>();
            accordion.put("type", "accordion");
            accordion.put("title", customTitle);


            // Thêm nút vào accordion text
            Map<String, Object> button = new HashMap<>();
            button.put("type", "button");
            button.put("icon", new HashMap<String, Object>() {{
                put("type", "");
                put("color", "");
            }});
            button.put("text", "Xem thể loại");
            button.put("link", title);

            accordion.put("additionalContent", Arrays.asList(button));
            accordions.add(accordion);
        }

        // Thêm accordions vào fulfillmentMessages
        fulfillmentMessages.add(new HashMap<String, Object>() {{
            put("payload", new HashMap<String, Object>() {{
                put("richContent", Arrays.asList(accordions));
            }});
        }});

        response.put("fulfillmentMessages", fulfillmentMessages);
        return response;
    }

}
