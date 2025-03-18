package com.example.movietickets.demo.controller.general;

import com.example.movietickets.demo.model.Promotion;
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

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/promotions")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;
    @Autowired
    private UserService userService;


    @GetMapping
    public String promotionRedemption(Model model) {

        List<Promotion> allPromotions = promotionService.getAllPromotions();
        Set<String> excludedCodes = Set.of("SVD20", "HSD10", "NGD18");
        // Lọc danh sách không chứa promotionCode dành cho thưởng lần đầu
        List<Promotion> filteredPromotions = allPromotions.stream()
                .filter(promotion -> excludedCodes.stream().noneMatch(promotion.getPromotionCode()::startsWith))
                .collect(Collectors.toList());;
        model.addAttribute("promotions", filteredPromotions);
        model.addAttribute("title","Đổi khuyến mãi");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.isAuthenticated() && !"anonymousUser".equals(authentication.getPrincipal())) {
            String username = authentication.getName();
            User user = userService.getUserByUsername(username);
            model.addAttribute("user", user);
        }
            return "promotion/promotion-list";
    }
}

