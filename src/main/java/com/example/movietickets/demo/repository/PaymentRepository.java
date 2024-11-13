package com.example.movietickets.demo.repository;

import com.example.movietickets.demo.DTO.MoMoPaymentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository  extends JpaRepository<MoMoPaymentDto,Long> {
    Optional<MoMoPaymentDto> findByOrderId(String orderId);
}
