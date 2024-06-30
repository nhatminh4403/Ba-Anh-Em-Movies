package com.example.movietickets.demo.repository;

import com.example.movietickets.demo.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository  extends JpaRepository<Room, Long> {
    Room findByName(String name);
}
