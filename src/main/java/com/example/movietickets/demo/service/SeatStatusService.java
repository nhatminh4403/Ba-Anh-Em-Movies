package com.example.movietickets.demo.service;

import com.example.movietickets.demo.DTO.SeatDto;
import com.example.movietickets.demo.model.BookingDetail;
import com.example.movietickets.demo.model.Seat;
import com.example.movietickets.demo.model.SeatStatus;
import com.example.movietickets.demo.repository.BookingDetailRepository;
import com.example.movietickets.demo.repository.BookingRepository;
import com.example.movietickets.demo.repository.SeatRepository;
import com.example.movietickets.demo.repository.SeatStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SeatStatusService {
    @Autowired
    private SeatStatusRepository seatStatusRepository;
    @Autowired
    private BookingDetailRepository bookingDetailRepository;
    @Autowired
    private SeatRepository seatRepository;

    public List<SeatDto> getSeatsByRoomAndSchedule(Long roomId, Long scheduleId) {
        // Lấy danh sách ghế theo phòng
        List<Seat> seats = seatRepository.findByRoomId(roomId);
        List<BookingDetail> bookedSeats = bookingDetailRepository.findByScheduleId(scheduleId);
        // Lấy trạng thái ghế theo lịch chiếu
        List<SeatStatus> seatStatuses = seatStatusRepository.findByScheduleId(scheduleId);
        Set<Long> bookedSeatIds = bookedSeats.stream()
                .map(detail -> detail.getSeat().getId())
                .collect(Collectors.toSet());
        // Map trạng thái ghế vào danh sách ghế
        return seats.stream().map(seat -> {
            SeatDto dto = new SeatDto();
            dto.setId(seat.getId());
            dto.setSymbol(seat.getSymbol());
            dto.setSeatType(seat.getSeattype().getType());
            dto.setRoomName(seat.getRoom().getName());
            dto.setPrice(seat.getSeattype().getPrice());
            dto.setImage(seat.getImage());

            // Kiểm tra trạng thái của ghế trong lịch chiếu
            boolean isBooked = seatStatuses.stream()
                    .anyMatch(status -> status.getSeat().getId().equals(seat.getId()) && status.getIsBooked());
            dto.setStatus(bookedSeatIds.contains(seat.getId()));
            return dto;
        }).collect(Collectors.toList());
    }
}
