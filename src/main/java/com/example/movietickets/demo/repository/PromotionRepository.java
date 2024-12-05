package com.example.movietickets.demo.repository;

import com.example.movietickets.demo.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    Optional<Promotion> findPromotionByPromotionCode(String promotionCode);
    boolean existsPromotionByPromotionCode(String promotionCode);
    void deletePromotionByPromotionEndDateBefore(Date promotionEndDate);
    List<Promotion> getPromotionByUserId(Long userid);

}
