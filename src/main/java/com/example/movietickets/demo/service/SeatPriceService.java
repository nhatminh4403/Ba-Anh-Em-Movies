package com.example.movietickets.demo.service;


import com.example.movietickets.demo.model.ComboFood;
import com.example.movietickets.demo.model.SeatPrice;
import com.example.movietickets.demo.repository.ComboFoodRepository;
import com.example.movietickets.demo.repository.SeatPriceRepository;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.Optional;

@Service
@SessionScope
@AllArgsConstructor
public class SeatPriceService {
    private final SeatPriceRepository seatPriceRepository;

    public List<SeatPrice> getAllSeatPrice() {
        return seatPriceRepository.findAll();
    }

    public Optional<SeatPrice> getSeatPriceId(Long id) {
        return seatPriceRepository.findById(id);
    }

    public void addSeatPrice(SeatPrice seatPrice) {
        seatPriceRepository.save(seatPrice);
    }

    public void updateSeatPrice(@NotNull SeatPrice seatPrice) {
        SeatPrice existingSeatPrice = seatPriceRepository.findById(seatPrice.getId())
                .orElseThrow(() -> new IllegalStateException("Country with ID " + seatPrice.getId() + " does not exist."));
        existingSeatPrice.setType(seatPrice.getType());

        seatPriceRepository.save(existingSeatPrice);
    }

    public void deleteSeatPrice(Long id) {
        if (!seatPriceRepository.existsById(id)) {
            throw new IllegalStateException("SeatPrice with ID " + id + " does not exist.");
        }
        seatPriceRepository.deleteById(id);
    }
}
