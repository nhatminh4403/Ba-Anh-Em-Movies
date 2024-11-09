package com.example.movietickets.demo.controller.general;

import com.example.movietickets.demo.model.User;
import com.example.movietickets.demo.service.CategoryService;
import com.example.movietickets.demo.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;
    @Autowired
    private final CategoryService categoryService;

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
    public String showUpdateForm( Model model, Principal principal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username =authentication.getName();
        Optional<User> user = userService.findByUsername(username);
        model.addAttribute("user", user.get());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("title", "Chỉnh sửa tài khoản");
        return "user/edit";
    }

    @PostMapping("/profile/chinh-sua")
    public String updateUserInfo(@Valid @ModelAttribute("user") User userForm,
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
        currentUser.setFullname(userForm.getFullname());
        currentUser.setPhone(userForm.getPhone());
        currentUser.setEmail(userForm.getEmail());

        userService.save(currentUser);

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
