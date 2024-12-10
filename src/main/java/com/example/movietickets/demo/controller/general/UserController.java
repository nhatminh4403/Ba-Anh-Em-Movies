package com.example.movietickets.demo.controller.general;

import com.example.movietickets.demo.model.Promotion;
import com.example.movietickets.demo.model.User;
import com.example.movietickets.demo.service.CategoryService;
import com.example.movietickets.demo.service.PromotionService;
import com.example.movietickets.demo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;
    @Autowired
    private final CategoryService categoryService;
    @Autowired
    private final PromotionService promotionService;


    @GetMapping("/profile")
    public String showProfile(Model model, Principal principal){
        if(principal !=null) {

            Optional<User> user = userService.findByUsername(principal.getName());
            model.addAttribute("user",user.get());
            model.addAttribute("categories",categoryService.getAllCategories());
            model.addAttribute("title","Thông tin cá nhân");
            return "user/profile";
        }
        return "redirect:/login";
    }
    @GetMapping("/profile/chinh-sua")
    public String showUpdateForm(Model model) {

        User user = userService.getCurrentUser();
        if (user.getIsStudent() == null) {
            user.setIsStudent(false); // Set giá trị mặc định nếu null
        }
        model.addAttribute("user", user);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("title", "Chỉnh sửa tài khoản");
        return "user/edit";
    }

    @PostMapping("/profile/chinh-sua")
    public String updateUserInfo(@Valid @ModelAttribute("user") User user,
                                 BindingResult result,
                                 Model model,
                                 Principal principal) {
        model.addAttribute("title", "Chỉnh sửa tài khoản");
        model.addAttribute("categories", categoryService.getAllCategories());

        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            model.addAttribute("errors", errors);
            return "user/edit";
        }

        User currentUser = userService.getCurrentUser();

        user.setId(currentUser.getId());
        user.setUsername(currentUser.getUsername());
        user.setPassword(currentUser.getPassword());
        user.setRoles(currentUser.getRoles());
        user.setProvider(currentUser.getProvider());

        if (currentUser.getPromotions() != null) {
            user.setPromotions(new HashSet<>(currentUser.getPromotions()));
        } else {
            user.setPromotions(new HashSet<>());
        }

        if (Boolean.TRUE.equals(user.getIsStudent())) {  // Sử dụng Boolean.TRUE.equals để tránh NullPointerException
            Promotion uniStudentPromotion = promotionService.getPromotionByCode("SVD20");
            if (uniStudentPromotion != null && !user.getPromotions().stream().
                    anyMatch(promotion -> Objects.equals(promotion.getId(), uniStudentPromotion.getId()))) {
                user.getPromotions().add(uniStudentPromotion);
            }
        }

        if(user.getAge() <18)  {
            Promotion highSchoolPromotion = promotionService.getPromotionByCode("HSD10");
            if (highSchoolPromotion != null && !user.getPromotions().stream().
                    anyMatch(promotion -> Objects.equals(promotion.getId(), highSchoolPromotion.getId()))) {
                user.getPromotions().add(highSchoolPromotion);
            }
        }
        if(user.getAge() >50)  {
            Promotion oldHagPromotion= promotionService.getPromotionByCode("HSD10");
            if (oldHagPromotion != null && !user.getPromotions().stream().
                    anyMatch(promotion -> Objects.equals(promotion.getId(), oldHagPromotion.getId()))) {
                user.getPromotions().add(oldHagPromotion);
            }
        }
        userService.updateUser(user);

        model.addAttribute("success", "Cập nhật thông tin thành công");
        return "redirect:/user/profile";
    }

    // Helper method for phone validation
    private boolean isValidPhoneNumber(String phone) {
        if (phone == null || phone.isEmpty()) {
            return false;
        }
        // Vietnamese phone number format
        String phoneRegex = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        return phone.matches(phoneRegex);
    }
}
