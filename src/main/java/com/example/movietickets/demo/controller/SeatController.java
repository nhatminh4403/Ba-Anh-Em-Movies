package com.example.movietickets.demo.controller;

import com.example.movietickets.demo.model.Schedule;
import com.example.movietickets.demo.model.SeatReservation;
import com.example.movietickets.demo.service.RoomService;
import com.example.movietickets.demo.service.ScheduleService;
import com.example.movietickets.demo.service.ScheduleServiceImpl;
import  org.springframework.ui.Model;

import com.example.movietickets.demo.model.Seat;
import com.example.movietickets.demo.model.Room;
import com.example.movietickets.demo.service.SeatService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
@RequestMapping("/seats")
public class SeatController {

    @Autowired
    private SeatService seatService;
    @Autowired
    private RoomService roomService;

    @Autowired
    private ScheduleServiceImpl scheduleService;

    @GetMapping("/room/{roomId}")
    public String getSeatsByRoomId(@PathVariable("roomId") Long roomId, Model model) {
        List<Seat> seats = seatService.getSeatsByRoomId(roomId);
        model.addAttribute("seats", seats);
        return "seat/seat-list";
    }

    @GetMapping("/schedules/{scheduleId}")
    public String getSeatsByScheduleId(@PathVariable("scheduleId") Long scheduleId, Model model) {
        Optional<Schedule> optionalSchedule = scheduleService.getScheduleById(scheduleId);

        if (optionalSchedule.isPresent()) {
            Schedule schedule = optionalSchedule.get();
            List<Seat> seats = seatService.getSeatsByRoomId(schedule.getRoom().getId());
            List<SeatReservation> seatReservations = seatService.getSeatReservationsByScheduleId(scheduleId);

            model.addAttribute("seats", seats);
            model.addAttribute("seatReservations", seatReservations);
            model.addAttribute("schedule", schedule);
            return "seat/seat-list";
        } else {
            // Handle the case where the schedule is not found, e.g., redirect to an error page or show a message
            return "redirect:/error";
        }
    }

    @PostMapping("/reserve")
    public String reserveSeat(@RequestParam("seatId") Long seatId, @RequestParam("scheduleId") Long scheduleId) {
        seatService.reserveSeat(scheduleId, seatId);
        return "redirect:/seats/schedules/" + scheduleId;
    }

    @GetMapping("/add")
    public String showAddSeatForm(Model model) {
        model.addAttribute("seat", new Seat());
        return "seat/seat-form";
    }

    @PostMapping("/add")
    public String addSeat(@ModelAttribute("seat") Seat seat) {
        seatService.saveSeat(seat);
        return "redirect:/seats/room/" + seat.getRoom().getId();
    }

    @GetMapping("/edit/{seatId}")
    public String showEditSeatForm(@PathVariable("seatId") Long seatId, Model model) {
        Seat seat = seatService.getSeatById(seatId);
        model.addAttribute("seat", seat);
        return "seat/seat-form";
    }

    @PostMapping("/edit/{seatId}")
    public String editSeat(@PathVariable("seatId") Long seatId, @ModelAttribute("seat") Seat seat) {
        seat.setId(seatId);
        seatService.saveSeat(seat);
        return "redirect:/seats/room/" + seat.getRoom().getId();
    }

    @GetMapping("/delete/{seatId}")
    public String deleteSeat(@PathVariable("seatId") Long seatId) {
        Seat seat = seatService.getSeatById(seatId);
        if (seat != null) {
            seatService.deleteSeat(seatId);
            return "redirect:/seats/room/" + seat.getRoom().getId();
        }
        return "redirect:/seats";
    }
}