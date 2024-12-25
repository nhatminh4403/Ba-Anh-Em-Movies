package com.example.movietickets.demo.repository;

import com.example.movietickets.demo.model.SeatType;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeatTypeRepository extends JpaRepository<SeatType, Long> {
    @NotNull Optional<SeatType> findById(@NotNull Long id);
    Optional <SeatType> findByType(@NotNull String type);
}
