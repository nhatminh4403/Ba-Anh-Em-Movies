package com.example.movietickets.demo.controller;

import com.example.movietickets.demo.model.Purchase;
import com.example.movietickets.demo.service.PurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.NumberFormat;
import java.util.Locale;

@Controller
@AllArgsConstructor
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    public String showPurchase(Model model) {
        if (purchaseService.IsExist()) {
            Purchase purchase = purchaseService.Get();
            System.out.println("selectedSeats: " + purchase.getSeats());
            model.addAttribute("selectedSeats", purchase.getSeats());
            model.addAttribute("filmTitle", purchase.getFilmTitle());
            model.addAttribute("category", purchase.getCategory());
            model.addAttribute("cinemaName", purchase.getCinemaName());
            model.addAttribute("cinemaAddress", purchase.getCinemaAddress());
            model.addAttribute("startTime", purchase.getStartTime());
            model.addAttribute("roomName", purchase.getRoomName());
            model.addAttribute("poster", purchase.getPoster());
            //format Currency VND
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
            String formattedTotalPrice = currencyFormat.format(purchase.getTotalPrice());
            model.addAttribute("totalPrice", formattedTotalPrice);
        }
        return "/purchase/purchase";
    }

    @GetMapping("/clear")
    public String clearPurchase() {
        purchaseService.clearPurchase();
        return "redirect:/purchase";
    }

    @PostMapping("/add")
    public String addPurchase(
            @RequestParam("seatSymbol") String seatSymbol,
            @RequestParam("totalPrice") Long totalPrice,
            @RequestParam("startTime") String startTime,
            @RequestParam("filmTitle") String filmTitle,
            @RequestParam("poster") String poster,
            @RequestParam("category") String category,
            @RequestParam("cinemaName") String cinemaName,
            @RequestParam("cinemaAddress") String cinemaAddress,
            @RequestParam("roomName") String roomName,
            Model model
    ) {

        purchaseService.addToBuy(seatSymbol, filmTitle, poster, category, totalPrice, cinemaName, cinemaAddress, startTime, roomName);

        model.addAttribute("selectedSeats", seatSymbol);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("startTime", startTime);
        model.addAttribute("filmTitle", filmTitle);
        model.addAttribute("poster", poster);
        model.addAttribute("category", category);
        model.addAttribute("cinemaName", cinemaName);
        model.addAttribute("cinemaAddress", cinemaAddress);
        model.addAttribute("roomName", roomName);

        return "redirect:/purchase";
    }
}
