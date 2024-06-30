package com.example.movietickets.demo.service;

import com.example.movietickets.demo.model.Booking;
import com.example.movietickets.demo.model.BookingDetail;
import com.example.movietickets.demo.model.Seat;
import com.example.movietickets.demo.repository.BookingDetailRepository;
import com.example.movietickets.demo.repository.BookingRepository;
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

    @Transactional
    public Booking saveBooking(Booking booking, List<Seat> seats) {
        booking.setCreateAt(new Date());
        Booking savedBooking = bookingRepository.save(booking);

        for (Seat seat : seats) {
            BookingDetail bookingDetail = new BookingDetail();
            bookingDetail.setBooking(savedBooking);
            bookingDetail.setSeat(seat);
            bookingDetail.setPrice(booking.getPrice()); // Hoặc tính toán giá vé riêng cho mỗi ghế
            bookingDetailRepository.save(bookingDetail);
        }

        return savedBooking;
    }
}

