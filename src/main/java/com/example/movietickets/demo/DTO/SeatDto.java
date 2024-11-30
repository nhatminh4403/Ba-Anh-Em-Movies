package com.example.movietickets.demo.DTO;

import com.example.movietickets.demo.model.Room;
import com.example.movietickets.demo.model.Seat;
import com.example.movietickets.demo.model.SeatType;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class SeatDto {
    private Long id;
    private String symbol;
    private Boolean status;
    private String image; // Thêm trường hình ảnh
    private String seatType;
    private Long price;
    private String roomName;


    public SeatDto(Seat seat) {
        this.id = seat.getId();
        this.symbol = seat.getSymbol();
        this.seatType = seat.getSeattype().getType();
    }

    // Getter, Setter
}