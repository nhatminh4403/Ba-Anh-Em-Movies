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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        Long qrData = booking.getId();
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H); // Higher error correction
        hints.put(EncodeHintType.MARGIN, 2); // Slightly larger margin for better scanning
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        // Make the QR code larger
        int width = 300;  // Increased size
        int height = 300; // Increased size

        BitMatrix bitMatrix = qrCodeWriter.encode(
                String.format("BOOKING-%d", qrData), // Add a prefix to ensure consistent format
                BarcodeFormat.QR_CODE,
                width,
                height,
                hints
        );

        BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

        // Optionally enhance the contrast
        BufferedImage enhancedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                enhancedImage.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }

        return new ResponseEntity<>(enhancedImage, HttpStatus.OK);
    }
}
