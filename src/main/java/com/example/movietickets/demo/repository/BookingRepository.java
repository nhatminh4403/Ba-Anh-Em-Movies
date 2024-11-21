package com.example.movietickets.demo.repository;

import com.example.movietickets.demo.model.Booking;
import com.example.movietickets.demo.model.User;
import jdk.jfr.Enabled;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories(basePackageClasses = BookingRepository.class)
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("SELECT COUNT(id) AS total FROM Booking")
    Long getCountBooking();

    @Query("SELECT SUM(b.price) FROM Booking b")
    Long getTotalPrice();

    List<Booking> findByUserOrderByCreateAtDesc(User user);

    List<Booking> findAllWithComboFoodByUser(User user);

    @NotNull
    @Override
    Optional<Booking> findById(Long id);

    Optional<Booking> findByOrderId(String orderId);
}
