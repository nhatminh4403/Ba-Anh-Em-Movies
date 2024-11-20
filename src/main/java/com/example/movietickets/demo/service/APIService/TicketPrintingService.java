package com.example.movietickets.demo.service.APIService;


import com.example.movietickets.demo.model.Booking;
import com.example.movietickets.demo.model.BookingDetail;
import com.example.movietickets.demo.ultillity.BarcodeGenerator;
import com.example.movietickets.demo.ultillity.CheckingNumber;
import com.example.movietickets.demo.ultillity.RemoveDiacritics;
import com.google.zxing.WriterException;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDVariableText;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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

    private PDType0Font tryLoadFallbackFonts(PDDocument document) throws IOException {
        // Try different fallback fonts in order
        String[] fallbackFonts = {
                "src/main/resources/static/assets/admin/fonts/RobotoSlab/static/RobotoSlab-Regular.ttf"
        };

        for (String fontPath : fallbackFonts) {
            try (InputStream fontStream = getClass().getResourceAsStream(fontPath)) {
                if (fontStream != null) {
                    return PDType0Font.load(document, fontStream);
                }
            } catch (IOException e) {
                continue;
            }
        }
        //        "/static/assets/admin/fonts/RobotoSlab/static/RobotoSlab-Regular.ttf"
//        PDType1Font pdType1Font = new PDType1Font(Standard14Fonts.FontName.COURIER);
        // Last resort: use built-in Helvetica
        return PDType0Font.load(document,
                new File("src/main/resources/static/assets/admin/fonts/Times New Roman/times new roman.ttf"));
    }

    private void setupFontResources(PDAcroForm acroForm, PDType0Font font) {
        if (acroForm.getDefaultResources() == null) {
            acroForm.setDefaultResources(new PDResources());
        }

        String fontName = "CustomFont";
        acroForm.getDefaultResources().put(COSName.getPDFName(fontName), font);
        String defaultAppearanceString = "/" + fontName + " 12 Tf 0 g";

        for (PDField field : acroForm.getFields()) {
            if (field instanceof PDVariableText textField) {
                textField.setDefaultAppearance(defaultAppearanceString);
                field.getCOSObject().removeItem(COSName.AP);
            }
        }
    }
    public byte[] fillPDF(PDDocument template, Booking booking, BookingDetail detail) throws IOException, WriterException {
        try (PDDocument document = cloneDocument(template)) {

            PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();

            PDType0Font customFont;
            try {
                // Try loading Montserrat
                try (InputStream fontStream = getClass().getResourceAsStream("/static/assets/admin/fonts/Montserrat/Montserrat-Regular.otf")) {
                    if (fontStream != null) {
                        System.out.println("Montserrat font found");
                        customFont = PDType0Font.load(document, fontStream);
                    } else {
                        System.out.println("Montserrat font not found");
                        throw new IOException("Montserrat font not found");
                    }
                }
            } catch (IOException e) {
                // Fallback fonts in order of preference
                customFont = tryLoadFallbackFonts(document);
            }

            // Set up resources and appearance
            setupFontResources(acroForm, customFont);

            // Generate and add barcode
            BarcodeGenerator barcodeGenerator = new BarcodeGenerator();
            String barcodeText = detail.getSeat().getSymbol();
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
            fillFormFields(acroForm, booking, detail);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            document.save(outputStream);
            return outputStream.toByteArray();

        }
    }

    private String separateRoomName(String roomId) {
        String[] firstPartOfName = roomId.split("-");
        String[] getRoomNumber = firstPartOfName[0].split(" ");
        return getRoomNumber[1];
    }

    private void fillFormFields(PDAcroForm acroForm, Booking booking, BookingDetail detail) throws IOException {
        try {
            setField(acroForm, "movie_name", capitalizeName(RemoveDiacritics.removeDiacritics(booking.getFilmName())));
            setField(acroForm, "location1", capitalizeName(RemoveDiacritics.removeDiacritics(booking.getCinemaName())));
            setField(acroForm, "location2", capitalizeName(RemoveDiacritics.removeDiacritics(booking.getCinemaName())));
            setField(acroForm, "theatre_name", "BA ANH EM");
            setField(acroForm, "ticket_id1", detail.getId().toString());
            setField(acroForm, "ticket_id2", detail.getId().toString());

            String[] firstPartOfName = booking.getRoomName().split("-");
            String[] getRoomNumber = firstPartOfName[0].split(" ");

            if(getRoomNumber.length >= 2){
                for(String number : getRoomNumber){
                    if(CheckingNumber.isNumeric(number)){
                        setField(acroForm, "room1", number);
                        setField(acroForm, "room2", number);
                    }
                }
            }
            else{
                setField(acroForm, "room1", RemoveDiacritics.removeDiacritics(separateRoomName(booking.getRoomName())));
                setField(acroForm, "room2",  RemoveDiacritics.removeDiacritics(separateRoomName(booking.getRoomName())));
            }


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

    public List<String> generatePdfs(Booking booking, String templatePath) throws IOException, WriterException {
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
