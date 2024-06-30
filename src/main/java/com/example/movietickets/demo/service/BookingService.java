package com.example.movietickets.demo.service;

import com.example.movietickets.demo.model.Booking;
import com.example.movietickets.demo.model.BookingDetail;
import com.example.movietickets.demo.model.Room;
import com.example.movietickets.demo.model.Seat;
import com.example.movietickets.demo.repository.BookingDetailRepository;
import com.example.movietickets.demo.repository.BookingRepository;
import com.example.movietickets.demo.repository.SeatRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
@SessionScope
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingDetailRepository bookingDetailRepository;

    @Autowired
    private SeatRepository seatRepository;

    public List<Seat> getSeatsFromSymbolsAndRoom(List<String> seatSymbols, Room room) {
        return seatRepository.findBySymbolInAndRoom(seatSymbols, room);
    }

    @Transactional
    public void saveBooking(Booking booking, List<Seat> seats) {
        bookingRepository.save(booking);
        for (Seat seat : seats) {
            BookingDetail bookingDetail = new BookingDetail();
            bookingDetail.setBooking(booking);
            bookingDetail.setSeat(seat);
            bookingDetail.setPrice(seat.getSeattype().getPrice());
            bookingDetailRepository.save(bookingDetail);
        }
        //cập nhật trạng thái ghé đã đặt
        for(Seat seat: seats){
            seat.setStatus("booked");
            seatRepository.save(seat);
        }
    }
}

