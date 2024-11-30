package com.example.movietickets.demo.service;

import com.example.movietickets.demo.DTO.SeatDto;
import com.example.movietickets.demo.model.BookingDetail;
import com.example.movietickets.demo.model.Room;
import com.example.movietickets.demo.model.Seat;
import com.example.movietickets.demo.model.SeatType;
import com.example.movietickets.demo.repository.BookingDetailRepository;
import com.example.movietickets.demo.repository.ScheduleRepository;
import com.example.movietickets.demo.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SeatService {


    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private BookingDetailRepository bookingDetailRepository;
    @Autowired
    private SeatTypeService seatTypeService;

    public List<Seat> getSeatsByRoomId(Long roomId) {
        return seatRepository.findByRoomId(roomId);
    }

    // SeatService.java
    public List<Seat> getSeatsByRoomIdDistinct(Long roomId) {
        // Assuming your repository query or method fetches distinct seats based on roomId
        return seatRepository.findDistinctSeatsByRoomId(roomId);
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Optional<Seat> getSeatById(Long seatId) {
        return seatRepository.findById(seatId);
    }

    public void addSeat(Seat seat) {
        seatRepository.save(seat);
    }

    public Seat updateSeat(Seat seat){
        if (seat.getId() == null) {
            throw new IllegalArgumentException("Seat ID cannot be null for update");
        }
        return seatRepository.save(seat);
    }
    public Seat saveSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public void deleteSeat(Long seatId) {
        if (!seatRepository.existsById(seatId)) {
            throw new IllegalStateException("Seat with ID " + seatId + " does not exist.");
        }
        seatRepository.deleteById(seatId);
    }

    public List<Seat> getSeatListByRoomId(Long roomId) {
        return seatRepository.findByRoomId(roomId);
    }


    public List<SeatDto> getSeatsByScheduleAndRoom(Long roomId, Long scheduleId) {
        List<Seat> seats = seatRepository.findSeatsByRoomAndSchedule(roomId, scheduleId);
//        List<SeatType> seatTypes= seatTypeService.

        return seats.stream()
                .map(this::mapToDto) // Chuyển đổi sang SeatDto
                .collect(Collectors.toList());
    }

    public SeatDto mapToDto(Seat seat) {
        SeatDto seatDto = new SeatDto();
        seatDto.setId(seat.getId());
        seatDto.setSymbol(seat.getSymbol());
        seatDto.setSeatType(seat.getSeattype().getType()); // Lấy tên loại ghế
        seatDto.setPrice(seat.getSeattype().getPrice());
        seatDto.setImage(seat.getImage());
        seatDto.setStatus(seat.getStatus());
        return seatDto;
    }
}

