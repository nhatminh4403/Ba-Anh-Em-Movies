package com.example.movietickets.demo.service;

import com.example.movietickets.demo.model.BookingDetail;
import com.example.movietickets.demo.repository.BookingDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingDetailService {
    @Autowired
    private BookingDetailRepository bookingDetailRepository;

    public List<BookingDetail> getBookingDetailsByScheduleId(Long scheduleId) {
        return bookingDetailRepository.findByScheduleId(scheduleId);
    }
}
