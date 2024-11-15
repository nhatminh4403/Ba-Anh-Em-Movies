package com.example.movietickets.demo.controller.ApiController.admin;


import com.example.movietickets.demo.model.Booking;
import com.example.movietickets.demo.service.APIService.TicketPrintingService;
import com.example.movietickets.demo.service.BookingDetailService;
import com.example.movietickets.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/admin/ticket")
public class PrintTicketController {

    @Autowired
    private TicketPrintingService ticketPrintingService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private BookingDetailService detailService;


    @GetMapping("/generate-pdfs/{bookingId}")
    public ResponseEntity<List<String>> generatePdfs(@PathVariable String bookingId)  {
        long idNumber;
        try {
            idNumber = Long.parseLong(bookingId);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body(null);
        }

        if (bookingId.isEmpty() || idNumber <= 0) {
            return ResponseEntity.badRequest().body(null);
        }

        Booking booking = bookingService.getBookingById(idNumber);
        if (booking == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        try {
            String templatePath = "src/main/resources/static/assets/admin/templates/template-ticket.pdf";
            List<String> pdfFilePaths = ticketPrintingService.generatePdfs(booking, templatePath);

            List<String> pdfUrls = pdfFilePaths.stream().map(filePath ->
                            ServletUriComponentsBuilder.fromCurrentContextPath()
                                    .path("/api/admin/ticket/download/")
                                    .path(new File(filePath).getName())
                                    .toUriString())
                    .collect(Collectors.toList());

            return new ResponseEntity<>(pdfUrls, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();  // Log the error for troubleshooting
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    // Method to download a specific PDF by filename
    @GetMapping("/view/{filename:.+}")
    public ResponseEntity<byte[]> viewPdf(@PathVariable String filename) throws IOException {

        String filePath = "src/main/resources/static/assets/admin/ticket-pdfs/"+ filename;
        File pdfFile = new File(filePath);
        if (!pdfFile.exists()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        byte[] pdfBytes = Files.readAllBytes(Paths.get(filePath));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.inline().filename(filename).build()); // View inline

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    @GetMapping("/download/{filename:.+}")
    public ResponseEntity<byte[]> downloadPdf(@PathVariable String filename) throws IOException {
        String filePath ="src/main/resources/static/assets/admin/ticket-pdfs/" + filename;
        File pdfFile = new File(filePath);
        if (!pdfFile.exists()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        byte[] pdfBytes = Files.readAllBytes(Paths.get(filePath));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.attachment().filename(filename).build()); // Trigger download

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

//        @GetMapping("/generate-pdfs/{bookingId}")
//    public ResponseEntity<byte[]> generatePdfs(@PathVariable Long bookingId) {
//        if (bookingId == null || bookingId <= 0) {
//            return ResponseEntity.badRequest().body(null); // Trả về lỗi 400 nếu bookingId không hợp lệ
//        }
//
//        Booking booking = bookingService.getBookingById(bookingId);
//        if (booking == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Trả về lỗi 404 nếu không tìm thấy booking
//        }
//
//        try {
//            String templatePath = "src/main/resources/static/assets/admin/templates/template-ticket.pdf";
//            List<byte[]> pdfs = ticketPrintingService.generatePdfs(booking, templatePath);
//
//            // Tạo một file PDF hoàn chỉnh từ danh sách byte[]
//            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//            for (byte[] pdf : pdfs) {
//                outputStream.write(pdf); // Ghi từng PDF vào stream
//            }
//            byte[] finalPdf = outputStream.toByteArray();
//
//            // Lưu PDF vào folder trong project
//            String folderPath = "src/main/resources/static/assets/admin/ticket-pdfs/";
//            String fileName = "ticket_" + bookingId + "_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".pdf";
//            File file = new File(folderPath + fileName);
//            try (FileOutputStream fos = new FileOutputStream(file)) {
//                fos.write(finalPdf); // Lưu PDF vào file
//            }
//
//            // Trả về file PDF hoàn chỉnh để mở trong tab mới
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_PDF);
//            headers.setContentDispositionFormData("inline", fileName); // Sử dụng "inline" để mở trực tiếp trong tab
//            return new ResponseEntity<>(finalPdf, headers, HttpStatus.OK);
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(null); // Trả về lỗi 500
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body(null); // Trả về lỗi 400
//        }
//    }
}