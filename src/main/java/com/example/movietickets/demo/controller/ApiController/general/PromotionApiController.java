package com.example.movietickets.demo.controller.ApiController.general;

import com.example.movietickets.demo.model.Promotion;
import com.example.movietickets.demo.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/api/promotion")
public class PromotionApiController {
    @Autowired
    private PromotionService promotionService;

    @GetMapping("/validate/{code}")
    public ResponseEntity<?> validatePromotion(@PathVariable String code) {
        List<Promotion> promotions = promotionService.getAllPromotions();

        // Kiểm tra ngày hiệu lực
//        LocalDate today = LocalDate.now();
//        if (today.isBefore(promotion.getPromotionStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
//                || today.isAfter(promotion.getPromotionEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())) {
//            return ResponseEntity.badRequest().body("Mã khuyến mãi đã hết hạn!");
//        }

        return ResponseEntity.ok(promotions);
    }
}
