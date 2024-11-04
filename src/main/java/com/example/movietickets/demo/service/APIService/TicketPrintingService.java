package com.example.movietickets.demo.service.APIService;


import com.example.movietickets.demo.model.Booking;
import com.example.movietickets.demo.model.BookingDetail;

import com.example.movietickets.demo.ultillity.BarcodeGenerator;
import com.example.movietickets.demo.ultillity.RemoveDiacritics;
import com.google.zxing.WriterException;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.*;
import org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.springframework.stereotype.Service;
import org.apache.pdfbox.pdmodel.font.PDFontFactory;

import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
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
    private static final int BARCODE_X = 100;
    private static final int BARCODE_Y = 500;
    private static final int BARCODE_WIDTH = 200;
    private static final int BARCODE_HEIGHT = 40;
    private static final int MARGIN = 20; // Margin from the edges
    private static final float FONT_SIZE = 9;
    private static final float TEXT_MARGIN = 5;
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
    private byte[] bufferedImageToByteArray(BufferedImage image) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(image, "PNG", baos);
            return baos.toByteArray();
        }
    }
//    public byte[] fillPDF(PDDocument template, Booking booking, BookingDetail detail) throws IOException, WriterException {
//        PDDocument document = cloneDocument(template);
//        PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();
//        PDType0Font font = PDType0Font.load(document, new File("src/main/resources/static/assets/admin/fonts/Montserrat/static/Montserrat-Regular.ttf"));
//
//        BarcodeGenerator barcodeGenerator = new BarcodeGenerator();
////        BufferedImage barcodeImage = barcodeGenerator.generateBarcodeImage(detail.getSeat().getSymbol());
////
////        PDImageXObject pdImage = PDImageXObject.createFromByteArray(document, bufferedImageToByteArray(barcodeImage), "barcode");
////
////        // Get the first page or the target page
////        PDPage page = document.getPage(0);
////        try (PDPageContentStream contentStream = new PDPageContentStream(document, page,
////                PDPageContentStream.AppendMode.APPEND, true, true)) {
////            contentStream.drawImage(pdImage, 100, 500, 200, 100); // x, y, width, height
////        }
//        BufferedImage barcodeImage;
//        try {
//            barcodeImage = barcodeGenerator.generateBarcodeImage(detail.getSeat().getSymbol());
//        } catch (WriterException e) {
//            e.printStackTrace();
//            // Log the error and return a placeholder image or skip this step
//            barcodeImage = null;  // or handle as needed
//        }
//
//        if (barcodeImage != null) {
//            PDImageXObject pdImage = PDImageXObject.createFromByteArray(document, bufferedImageToByteArray(barcodeImage), "barcode");
//            PDPage page = document.getPage(0);
//            try (PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true)) {
//                contentStream.drawImage(pdImage, 100, 500, 200, 100);
//            }
//        }
//
//
//        if (acroForm != null) {
//            // Điền thông tin từ Booking
//            PDField filmNameField = acroForm.getField("movie_name");
//            if (filmNameField != null) {
//                filmNameField.setValue(capitalizeName(RemoveDiacritics.removeDiacritics(booking.getFilmName())));
//
//            }
//
//            PDField location1 = acroForm.getField("location1");
//            PDField location2 = acroForm.getField("location2");
//            if (location1 != null) {
//                location1.setValue(RemoveDiacritics.removeDiacritics(booking.getCinemaName()));
//            }
//            if (location2 != null) {
//                location2.setValue(RemoveDiacritics.removeDiacritics(booking.getCinemaName()));
//            }
//
//            PDField cinemaNameField = acroForm.getField("theathe_name");
//            if (cinemaNameField != null) {
//                cinemaNameField.setValue("BA ANH EM");
//            }
//            PDField ticketId1 = acroForm.getField("ticket_id1");
//            PDField ticketId2 = acroForm.getField("ticket_id2");
//
//            if (ticketId1 != null) {
//                ticketId1.setValue(detail.getId().toString());
//
//            }
//
//            if (ticketId2 != null) {
//                ticketId2.setValue(detail.getId().toString());
//            }
//
//            PDField startTimeField1 = acroForm.getField("date_booked1");
//            PDField startTimeField2 = acroForm.getField("date_booked2");
//            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
//            if (startTimeField1 != null) {
//                startTimeField1.setValue(sdf.format(booking.getStartTime())); // Chuyển Date sang chuỗi
//            }
//            if (startTimeField2 != null) {
//                startTimeField2.setValue(sdf.format(booking.getStartTime())); // Chuyển Date sang chuỗi
//            }
//            // Điền thông tin từ BookingDetail
//            PDField seatField1 = acroForm.getField("seat_id1");
//            PDField seatField2 = acroForm.getField("seat_id2");
//
//            if (seatField1 != null) {
//                seatField1.setValue(detail.getSeat().getSymbol());
//            }
//            if (seatField2 != null) {
//                seatField2.setValue(detail.getSeat().getSymbol());
//            }
//        }
//
//        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
//            document.save(outputStream);
//            return outputStream.toByteArray();
//        } finally {
//            document.close();
//        }
//    }
private String generateSerialNumber(String seatSymbol) {
    // Get current timestamp
    long timestamp = System.currentTimeMillis();
    // Get last 4 digits of timestamp
    String timeComponent = String.format("%04d", timestamp % 10000);

    // Remove any non-alphanumeric characters from seat symbol and take last 2 characters
    String seatComponent = seatSymbol.replaceAll("[^A-Za-z0-9]", "");
    if (seatComponent.length() > 2) {
        seatComponent = seatComponent.substring(seatComponent.length() - 2);
    } else {
        seatComponent = String.format("%2s", seatComponent).replace(' ', '0');
    }

    // Generate random component (2 digits)
    String randomComponent = String.format("%02d", new Random().nextInt(100));

    // Combine all components
    return String.format("%s-%s-%s", timeComponent, seatComponent, randomComponent);
}
public byte[] fillPDF(PDDocument template, Booking booking, BookingDetail detail) throws IOException, WriterException {
    PDDocument document = null;
    try {
        document = cloneDocument(template);
        PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();

        // Generate and add barcode
        BarcodeGenerator barcodeGenerator = new BarcodeGenerator();
        String barcodeText =detail.getSeat().getSymbol();
        String serialNumber = generateSerialNumber(barcodeText);
            BufferedImage barcodeImage = barcodeGenerator.generateBarcodeImage(barcodeText.toLowerCase());

        if (barcodeImage != null) {
            PDImageXObject pdImage = PDImageXObject.createFromByteArray(
                    document,
                    bufferedImageToByteArray(barcodeImage),
                    "barcode"
            );

            PDPage page = document.getPage(0);
            PDRectangle pageSize = page.getMediaBox();

            // Calculate position for bottom right corner
            float x = pageSize.getWidth() - BARCODE_WIDTH - MARGIN;
            float y = MARGIN; // Position from bottom

            try (PDPageContentStream contentStream = new PDPageContentStream(
                    document, page, PDPageContentStream.AppendMode.APPEND, true, true)) {
                contentStream.drawImage(pdImage, x, y + TEXT_MARGIN + FONT_SIZE, BARCODE_WIDTH, BARCODE_HEIGHT);
                // Add text below barcode
                contentStream.beginText();
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.COURIER), FONT_SIZE);

                // Center the text under the barcode
                float textWidth = new PDType1Font(Standard14Fonts.FontName.COURIER).getStringWidth(serialNumber) / 1000 * FONT_SIZE;
                float textX = x + (BARCODE_WIDTH - textWidth) / 2;

                contentStream.newLineAtOffset(textX, y);
                contentStream.showText(serialNumber);
                contentStream.endText();
            }
        }

        // Fill form fields
        if (acroForm != null) {
            fillFormFields(acroForm, booking, detail);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        document.save(outputStream);
        return outputStream.toByteArray();

    } finally {
        if (document != null) {
            document.close();
        }
    }
}


    private void fillFormFields(PDAcroForm acroForm, Booking booking, BookingDetail detail) throws IOException {
        try {
            setField(acroForm, "movie_name", capitalizeName(RemoveDiacritics.removeDiacritics(booking.getFilmName())));
            setField(acroForm, "location1", RemoveDiacritics.removeDiacritics(booking.getCinemaName()));
            setField(acroForm, "location2", RemoveDiacritics.removeDiacritics(booking.getCinemaName()));
            setField(acroForm, "theathe_name", "BA ANH EM");
            setField(acroForm, "ticket_id1", detail.getId().toString());
            setField(acroForm, "ticket_id2", detail.getId().toString());

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            String formattedDate = sdf.format(booking.getStartTime());
            setField(acroForm, "date_booked1", formattedDate);
            setField(acroForm, "date_booked2", formattedDate);

            setField(acroForm, "seat_id1", detail.getSeat().getSymbol());
            setField(acroForm, "seat_id2", detail.getSeat().getSymbol());
        } catch (IOException e) {
            throw new IOException("Error filling form fields", e);
        }
    }

    private void setField(PDAcroForm acroForm, String fieldName, String value) throws IOException {
        PDField field = acroForm.getField(fieldName);
        if (field != null) {
            try {
                field.setValue(value);
            } catch (IOException e) {
                throw new IOException("Error setting field " + fieldName, e);
            }
        }
    }

    public List<String> generatePdfs(Booking booking, String templatePath) throws IOException,WriterException {
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
