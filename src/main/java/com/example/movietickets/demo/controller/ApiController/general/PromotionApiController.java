package com.example.movietickets.demo.controller.ApiController.general;

import com.example.movietickets.demo.model.Promotion;
import com.example.movietickets.demo.model.User;
import com.example.movietickets.demo.service.PromotionService;
import com.example.movietickets.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/promotion")
public class PromotionApiController {
    @Autowired
    private PromotionService promotionService;

    @Autowired
    private UserService userService;

    @PostMapping("/redeem/{id}")
    public ResponseEntity<String> redeemPromotion(@PathVariable Long id, Principal principal) {

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();

        User user = userService.getUserByUsername(principal.getName());
        User currentUser = userService.getCurrentUser();
        // Lấy Promotion theo ID
        Promotion promotion = promotionService.getPromotionById(id);
        if (promotion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Promotion không tồn tại");
        }

        // Kiểm tra điểm của user
        if (user.getPointSaving() < promotion.getPointToRedeem()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Không đủ điểm để quy đổi");
        }

        // Trừ điểm user
        user.setPointSaving(user.getPointSaving() - promotion.getPointToRedeem());
        user.getPromotions().add(promotion);
        userService.saveWithoutEncodingPassword(user);

        return ResponseEntity.ok("Quy đổi thành công");
    }
    @GetMapping("/redeemCode/{code}")
    public ResponseEntity<?> redeemPromotion(@PathVariable String code) {
        Promotion promotion = promotionService.getPromotionByCode(code);
        if (promotion != null) {
            return ResponseEntity.ok(promotion);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Code not found");
        }
    }
}
