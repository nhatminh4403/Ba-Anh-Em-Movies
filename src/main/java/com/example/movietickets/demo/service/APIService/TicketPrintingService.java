package com.example.movietickets.demo.service.APIService;


import com.example.movietickets.demo.model.Booking;
import com.example.movietickets.demo.model.BookingDetail;

import com.example.movietickets.demo.ultillity.RemoveDiacritics;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.*;
import org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.springframework.stereotype.Service;
import org.apache.pdfbox.pdmodel.font.PDFontFactory;

import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class TicketPrintingService {
    private PDDocument cloneDocument(PDDocument original) throws IOException {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            original.save(byteArrayOutputStream);
            return Loader.loadPDF(byteArrayOutputStream.toByteArray());
        }
    }
    public String capitalizeName(String name) {
        if (name == null || name.isEmpty()) {
            return name; // Return the name as is if null or empty
        }
        return name.toUpperCase(); // Convert to uppercase
    }
    public byte[] fillPDF(PDDocument template, Booking booking, BookingDetail detail) throws IOException {
        PDDocument document = cloneDocument(template);
        PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();
        PDType0Font font = PDType0Font.load(document, new File("src/main/resources/static/assets/admin/fonts/Montserrat/static/Montserrat-Regular.ttf"));


        if (acroForm != null) {
            // Điền thông tin từ Booking
            PDField filmNameField = acroForm.getField("movie_name");
            if (filmNameField != null) {
                filmNameField.setValue(capitalizeName(RemoveDiacritics.removeDiacritics(booking.getFilmName())));

            }

            PDField location1 = acroForm.getField("location1");
            PDField location2 = acroForm.getField("location2");
            if (location1 != null) {
                location1.setValue(RemoveDiacritics.removeDiacritics(booking.getCinemaName()));
            }
            if (location2 != null) {
                location2.setValue(RemoveDiacritics.removeDiacritics(booking.getCinemaName()));
            }

            PDField cinemaNameField = acroForm.getField("theathe_name");
            if (cinemaNameField != null) {
                cinemaNameField.setValue("BA ANH EM");
            }
            PDField ticketId1 = acroForm.getField("ticket_id1");
            PDField ticketId2 = acroForm.getField("ticket_id2");

            if (ticketId1 != null) {
                ticketId1.setValue(detail.getId().toString());
            }

            if (ticketId2 != null) {
                ticketId2.setValue(detail.getId().toString());
            }

            PDField startTimeField1 = acroForm.getField("date_booked1");
            PDField startTimeField2 = acroForm.getField("date_booked2");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            if (startTimeField1 != null) {
                startTimeField1.setValue(sdf.format(booking.getStartTime())); // Chuyển Date sang chuỗi
            }
            if (startTimeField2 != null) {
                startTimeField2.setValue(sdf.format(booking.getStartTime())); // Chuyển Date sang chuỗi
            }
            // Điền thông tin từ BookingDetail
            PDField seatField1 = acroForm.getField("seat_id1");
            PDField seatField2 = acroForm.getField("seat_id2");

            if (seatField1 != null) {
                seatField1.setValue(detail.getSeat().getSymbol());
            }
            if (seatField2 != null) {
                seatField2.setValue(detail.getSeat().getSymbol());
            }
        }

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            document.save(outputStream);
            return outputStream.toByteArray();
        } finally {
            document.close();
        }
    }

    public List<String> generatePdfs(Booking booking, String templatePath) throws IOException {
        List<String> pdfFilePaths = new ArrayList<>();

        try (PDDocument template = Loader.loadPDF(new File(templatePath))) {
            for (BookingDetail detail : booking.getBookingDetails()) {
                byte[] pdfBytes = fillPDF(template, booking, detail);

                // Create a unique file name for each seat
                String filePath = "src/main/resources/static/assets/admin/ticket-pdfs/ticket_"
                        + booking.getId() + "_" + detail.getSeat().getSymbol()
                        + "_" + new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date()) + ".pdf";

                // Write the byte array to a file
                try (FileOutputStream fos = new FileOutputStream(new File(filePath))) {
                    fos.write(pdfBytes);
                }

                pdfFilePaths.add(filePath);  // Store file path for each generated PDF
            }
        }
        return pdfFilePaths;
    }
}
