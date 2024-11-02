package com.example.movietickets.demo.controller.ApiController.general;

import com.example.movietickets.demo.model.Booking;
import com.example.movietickets.demo.service.BookingService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user/history")
public class PurchaseApiController {

    @Autowired
    private BookingService bookingService;

    @GetMapping(value = "/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> generateQRCodeForBooking(@PathVariable("id") Long id) throws Exception {
        Booking booking = bookingService.getBookingById(id);

        // Sử dụng ID của booking để tạo mã QR
        String qrData = "Booking ID: " + booking.getId();
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.MARGIN, 1); // loại bỏ margin
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H); // cải thiện độ chính xác mã QR

        BitMatrix bitMatrix = qrCodeWriter.encode(qrData, BarcodeFormat.QR_CODE, 200, 200, hints);

        return new ResponseEntity<>(MatrixToImageWriter.toBufferedImage(bitMatrix), HttpStatus.OK);
    }
}
