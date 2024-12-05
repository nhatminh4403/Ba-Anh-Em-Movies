package com.example.movietickets.demo.service;

import com.example.movietickets.demo.model.Promotion;
import com.example.movietickets.demo.repository.PromotionRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
            existingPromotion.setPointToRedeem(updatedPromotion.getPointToRedeem());
            return promotionRepository.save(existingPromotion);
        }).orElseThrow(() -> new RuntimeException("Promotion not found"));
    }

    public void editPromotion(@NotNull Promotion promotion){
        Promotion editPromotion = promotionRepository.findById(promotion.getId()).orElseThrow(() -> new RuntimeException("Promotion not found"));

        editPromotion.setPromotionDescription(promotion.getPromotionDescription());
        editPromotion.setPromotionDiscountRate(promotion.getPromotionDiscountRate());
        editPromotion.setPromotionStartDate(promotion.getPromotionStartDate());
        editPromotion.setPromotionEndDate(promotion.getPromotionEndDate());
        editPromotion.setPromotionCode(promotion.getPromotionCode());
        editPromotion.setPointToRedeem(promotion.getPointToRedeem());

        promotionRepository.save(editPromotion);
    }

    public Promotion getPromotionById(Long id) {
        return promotionRepository.findById(id).orElseThrow(() -> new RuntimeException("Promotion not found"));
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

    @Scheduled(cron = "0 0 0 * * ?") // Runs every day at midnight
    public void deleteExpiredPromotions() {
        Date currentDate = new Date(); // Get current date and time
        promotionRepository.deletePromotionByPromotionEndDateBefore(currentDate); // Delete expired promotions
    }
}
