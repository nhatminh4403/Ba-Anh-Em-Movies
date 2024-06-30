package com.example.movietickets.demo.service;

import com.example.movietickets.demo.model.Purchase;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Setter
@Getter
@Service
@SessionScope
public class PurchaseService {
    private Purchase purchase;

    public void addToBuy(String seats, String filmTitle, String poster, String category,
                         Long totalPrice, String cinemaName, String cinemaAddress, String startTime, String roomName) {
        purchase = null;
        purchase = new Purchase(seats, filmTitle, poster, category, totalPrice, cinemaAddress, cinemaName, startTime, roomName);
    }

    public boolean IsExist() {
        return purchase != null;
    }

    public Purchase Get() {
        return purchase;
    }

    public void clearPurchase() {
        purchase = null;
    }
}
