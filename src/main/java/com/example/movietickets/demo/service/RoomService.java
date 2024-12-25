package com.example.movietickets.demo.service;

import com.example.movietickets.demo.model.Category;
import com.example.movietickets.demo.model.Room;
import com.example.movietickets.demo.model.Seat;
import com.example.movietickets.demo.model.SeatType;
import com.example.movietickets.demo.repository.CategoryRepository;
import com.example.movietickets.demo.repository.RoomRepository;
import com.example.movietickets.demo.repository.SeatRepository;
import com.example.movietickets.demo.repository.SeatTypeRepository;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final SeatRepository seatRepository;
    private final SeatTypeRepository seatTypeRepository;
    public List<Room> getAllRooms() {
        return roomRepository.findAllByOrderById();
    }

    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }




    public void addRoom(Room room) {
        
        Room savedRoom = roomRepository.save(room);
        createSeatsForRoom(savedRoom);
    }

    private void createSeatsForRoom(Room room) {
        List<Seat> seats = new ArrayList<>();

        // Lấy các loại ghế từ database
        Map<String, SeatType> seatTypeMap = seatTypeRepository.findAll().stream()
                .collect(Collectors.toMap(SeatType::getType, seatType -> seatType));

        // Tạo ghế Regular (Hàng A-D)
        SeatType regularType = seatTypeMap.get("regular");
        if (regularType != null) {
            String[] regularRows = {"A", "B", "C", "D"};
            for (String row : regularRows) {
                for (int i = 1; i <= 12; i++) {
                    seats.add(createSeat(room, regularType, row + i, true));
                }
            }
        }

        // Tạo ghế VIP (Hàng E-H)
        SeatType vipType = seatTypeMap.get("VIP");
        if (vipType != null) {
            String[] vipRows = {"E", "F", "G", "H"};
            for (String row : vipRows) {
                for (int i = 1; i <= 12; i++) {
                    seats.add(createSeat(room, vipType, row + i, true));
                }
            }
        }

        // Tạo ghế Couple (Hàng J)
        SeatType coupleType = seatTypeMap.get("couple");
        if (coupleType != null) {
            for (int i = 1; i <= 12; i += 2) {
                // Tạo mã ghế dạng J1J2, J3J4, ...
                String seatSymbol = String.format("J%dJ%d", i, i + 1);
                seats.add(createSeat(room, coupleType, seatSymbol, true));
            }
        }

        // Lưu tất cả ghế vào database
        seatRepository.saveAll(seats);
    }

    private Seat createSeat(Room room, SeatType seatType, String symbol, Boolean status) {
        Seat seat = new Seat();
        seat.setRoom(room);
        seat.setSeattype(seatType);
        seat.setSymbol(symbol);
        seat.setStatus(status);
        // Có thể set hình ảnh mặc định theo loại ghế
        String imagePath = "";
        switch (seatType.getType().toLowerCase()) {
            case "regular":
                imagePath = "/assets/img/seat/regular.png";
                break;
            case "vip":
                imagePath = "/assets/img/seat/VIP.png";
                break;
            case "couple":
                imagePath = "/assets/img/seat/couple.png";
                break;
        }
        seat.setImage(imagePath);
        return seat;
    }

    public void updateRoom(@NotNull Room room) {
        Room existingCategory = roomRepository.findById(room.getId())
                .orElseThrow(() -> new IllegalStateException("Room with ID " + room.getId() + " does not exist."));
        existingCategory.setName(room.getName());
        roomRepository.save(existingCategory);
    }

    public void deleteRoomById(Long id) {
        if (!roomRepository.existsById(id)) {
            throw new IllegalStateException("Room with ID " + id + " does not exist.");
        }
        roomRepository.deleteById(id);
    }
}
