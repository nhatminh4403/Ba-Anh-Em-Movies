package com.example.movietickets.demo.controller.admin;

import com.example.movietickets.demo.model.ComboFood;
import com.example.movietickets.demo.model.SeatPrice;
import com.example.movietickets.demo.service.SeatPriceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class SeatPriceController {

    @Autowired
    private final SeatPriceService seatPriceService;

    @GetMapping("/admin/seatPrice")
    public String listSeatPrice(Model model) {
        List<SeatPrice> seatPrices = seatPriceService.getAllSeatPrice();
        model.addAttribute("seatprice", seatPrices );
        model.addAttribute("title", "Danh sách giá ghế ");
        return "/admin/seatprice/seatprice-list";
    }

    /*add seatprice*/
    @GetMapping("/admin/seatPrice/add")
    public String showAddForm(Model model) {
        model.addAttribute("seatprice", new SeatPrice());
        return "/admin/seatprice/seatprice-add";
    }

    @PostMapping("/admin/seatPrice/add")
    public String addSeatPrice(@Valid  @ModelAttribute SeatPrice seatprice, BindingResult result) {
        if (result.hasErrors()) {
            return "/admin/seatprice/seatprice-add";
        }

        seatPriceService.addSeatPrice(seatprice);
        return "redirect:/admin/seatPrice";
    }

    // edit seatprice
    @GetMapping("/admin/seatPrice/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        SeatPrice seatprice = seatPriceService.getSeatPriceId(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid seat price Id:" + id));
        model.addAttribute("seatprice", seatprice);
        return "/admin/seatprice/seatprice-update";
    }

    @PostMapping("/admin/seatPrice/edit/{id}")
    public String updateSeatPrice(@PathVariable("id") Long id, @Valid @ModelAttribute("seatprice") SeatPrice seatprice, BindingResult result, Model model) {
        if (result.hasErrors()) {
            seatprice.setId(id);
            return "/admin/seatprice/seatprice-edit";
        }

        SeatPrice existingSeatPrice = seatPriceService.getSeatPriceId(id).orElseThrow(() -> new IllegalArgumentException("Invalid film Id:" + id));

        existingSeatPrice.setType(seatprice.getType());
        existingSeatPrice.setPrice(seatprice.getPrice());

        seatPriceService.updateSeatPrice(seatprice);

        return "redirect:/admin/seatPrice";
    }

    // delete seatprice
    @GetMapping("/admin/seatPrice/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id, Model model) {
        SeatPrice seatPrice = seatPriceService.getSeatPriceId(id)
                .orElseThrow(() -> new IllegalArgumentException("Giá ghế Id:" + id));

        seatPriceService.deleteSeatPrice(id);
        model.addAttribute("seatprice", seatPriceService.getAllSeatPrice());
        return "redirect:/admin/seatPrice";
    }
}
