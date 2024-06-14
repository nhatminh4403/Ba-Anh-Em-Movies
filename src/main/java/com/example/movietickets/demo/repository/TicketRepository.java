package com.example.movietickets.demo.repository;

import com.example.movietickets.demo.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketRepository  extends JpaRepository<Ticket, Long> {
}
