package com.example.movietickets.demo.model;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@Data
@Getter
@Setter
public class Purchase {
    public class Seat2 {
        public int id;
        public String symbol;
        public int price;

        //constructor
        public Seat2(String id, String symbol, int price) {
            this.id = Integer.parseInt(id);
            this.symbol = symbol;
            this.price = price;
        }
    }

    private Long totalPrice;
    private String filmTitle;
    private String category;
    private String poster;
    private String cinemaName;
    private String cinemaAddress;
    private String roomName;
    private String startTime;
    private List<Seat2> seats;
    private Date exp;

    public Purchase(String seats, String filmTitle, String poster, String category, Long totalPrice, String cinemaAddress, String cinemaName, String startTime, String roomName) {
//
        this.seats = new ArrayList<>();
        JSONArray jsonSeats = new JSONArray(seats);
        for (int i = 0; i < jsonSeats.length(); i++) {
            System.out.println("test: " + jsonSeats.get(i).toString());
            JSONObject jsonSeat = new JSONObject(jsonSeats.get(i).toString());
            this.seats.add(new Seat2(jsonSeat.getString("id"),
                    jsonSeat.getString("symbol"),
                    jsonSeat.getInt("price")));
        }

        this.filmTitle = filmTitle;
        this.poster = poster;
        this.category = category;
        this.cinemaName = cinemaName;
        this.cinemaAddress = cinemaAddress;
        this.roomName = roomName;
        this.totalPrice = totalPrice;
        this.startTime = startTime;
        exp = new Date(Calendar.getInstance().getTimeInMillis() + 1000 * 60 * 5);
    }

    public String getSeats() {
        StringBuilder str = new StringBuilder();
        for (Seat2 seat : seats) {
            str.append(seat.symbol).append(",");
        }
        str.deleteCharAt(str.length() - 1);
        return str.toString();
    }
}
