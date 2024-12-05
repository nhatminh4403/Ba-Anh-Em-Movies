package com.example.movietickets.demo.service;

import com.example.movietickets.demo.model.Film;
import com.example.movietickets.demo.model.Promotion;
import com.example.movietickets.demo.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    public Promotion createPromotion(Promotion promotion) {
        if(isCodeExist(promotion.getPromotionCode()))
            throw new IllegalArgumentException("Mã không dược trùng");

        if(promotion.getPromotionEndDate().before(promotion.getPromotionStartDate())) {
            throw new IllegalArgumentException("Ngày kết thúc không được nhỏ hơn ngày bắt đầu!");
        }
        if(promotion.getPromotionDiscountRate() <=0  || promotion.getPromotionDiscountRate() >= 100) {
            throw new IllegalArgumentException("Giá trị phải trong khoảng 0 đến dưới 100");
        }

        double discountRate = promotion.getPromotionDiscountRate() / 100.0;
        promotion.setPromotionDiscountRate(discountRate);
        return promotionRepository.save(promotion);
    }

    public Promotion updatePromotion(Long id, Promotion updatedPromotion) {
        return promotionRepository.findById(id).map(existingPromotion -> {
            existingPromotion.setPromotionCode(updatedPromotion.getPromotionCode());
            existingPromotion.setPromotionDiscountRate(updatedPromotion.getPromotionDiscountRate());
            existingPromotion.setPromotionStartDate(updatedPromotion.getPromotionStartDate());
            existingPromotion.setPromotionEndDate(updatedPromotion.getPromotionEndDate());
            existingPromotion.setPromotionDescription(updatedPromotion.getPromotionDescription());
            return promotionRepository.save(existingPromotion);
        }).orElseThrow(() -> new RuntimeException("Promotion not found"));
    }

    public void deletePromotion(Long id) {
        promotionRepository.deleteById(id);
    }
    public boolean isCodeExist(String code) {
        return promotionRepository.existsPromotionByPromotionCode(code);
    }
    public Promotion getPromotionByCode(String code) {
        System.out.println("Searching for promotion with code: " + code);
        return promotionRepository.findPromotionByPromotionCode(code).orElseThrow(() -> new IllegalArgumentException("Promotion not found"));
    }
}
