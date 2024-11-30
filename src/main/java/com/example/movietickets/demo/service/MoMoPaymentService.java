package com.example.movietickets.demo.service;

import com.example.movietickets.demo.DTO.MoMoPaymentDto;
import com.example.movietickets.demo.repository.MoMoPaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MoMoPaymentService {

    private final MoMoPaymentRepository paymentRepository;

    public MoMoPaymentDto savePayment(MoMoPaymentDto moMoPaymentDto)
    {
        return paymentRepository.save(moMoPaymentDto);
    }
    public Optional<MoMoPaymentDto> getPaymentById(String orderId) {
        return paymentRepository.findByOrderId(orderId);
    }

}
