package com.example.movietickets.demo.controller;

import com.example.movietickets.demo.model.Booking;
import com.example.movietickets.demo.model.Purchase;
import com.example.movietickets.demo.model.Room;
import com.example.movietickets.demo.model.Seat;
import com.example.movietickets.demo.repository.RoomRepository;
import com.example.movietickets.demo.repository.SeatRepository;
import com.example.movietickets.demo.service.BookingService;
import com.example.movietickets.demo.service.PurchaseService;
import com.example.movietickets.demo.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@AllArgsConstructor
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private BookingService bookingService;

    private SeatRepository seatRepository;

    private RoomRepository roomRepository;

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

            Room room = roomRepository.findByName(purchase.getRoomName());
            List<Seat> seats = seatRepository.findByRoom(room);
            //lấy ra các seat booked
            model.addAttribute("seats", seats);
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
            @RequestParam("seatSymbol") String seatSymbols,
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

        purchaseService.addToBuy(seatSymbols, filmTitle, poster, category, totalPrice, cinemaAddress, cinemaName, startTime, roomName);
        return "redirect:/purchase";
    }

    @PostMapping("/checkout")
    public String checkout(@RequestParam("payment") String payment, RedirectAttributes redirectAttributes) {
        if (purchaseService.IsExist()) {
            Purchase purchase = purchaseService.Get();
            List<String> seatSymbols = new ArrayList<>();
            for (Purchase.Seat2 seat : purchase.getSeatsList()) {
                seatSymbols.add(seat.getSymbol());
            }

            Room room = roomRepository.findByName(purchase.getRoomName());
            List<Seat> seats = bookingService.getSeatsFromSymbolsAndRoom(seatSymbols, room);

            Booking booking = new Booking();
            booking.setFilmName(purchase.getFilmTitle());
            booking.setPoster(purchase.getPoster());
            booking.setCinemaName(purchase.getCinemaName());
            booking.setCinemaAddress(purchase.getCinemaAddress());
            booking.setStartTime(parseDate(purchase.getStartTime()));
            booking.setPrice(purchase.getTotalPrice());
            booking.setSeatName(purchase.getSeats());
            booking.setRoomName(purchase.getRoomName());
            booking.setPayment(payment);
            booking.setStatus(true); // Hoặc giá trị khác tùy vào logic của bạn
            booking.setCreateAt(new Date());

            bookingService.saveBooking(booking, seats);

            redirectAttributes.addFlashAttribute("message", "Đặt vé thành công!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Không có thông tin đặt vé.");
        }
        return "redirect:/purchase"; // Chuyển hướng đến trang lịch sử mua vé
    }

    private Date parseDate(String dateStr) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dateFormat.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
