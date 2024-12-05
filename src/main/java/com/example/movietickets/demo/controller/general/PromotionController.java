package com.example.movietickets.demo.controller.general;

import com.example.movietickets.demo.model.User;
import com.example.movietickets.demo.service.PromotionService;
import com.example.movietickets.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/promotions")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;
    @Autowired
    private UserService userService;


    @GetMapping
    public String promotionRedemption(Model model) {
        model.addAttribute("promotions", promotionService.getAllPromotions());
        model.addAttribute("title","Đổi khuyến mãi");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.isAuthenticated() && !"anonymousUser".equals(authentication.getPrincipal())) {
            String username = authentication.getName();
            User user = userService.getUserByUsername(username);
            model.addAttribute("user", user);
        }
            return "promotionRedemption/promotion-list";
    }
}

