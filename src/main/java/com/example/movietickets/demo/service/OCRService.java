package com.example.movietickets.demo.service;

import com.example.movietickets.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
public class OCRService {

    private final ITesseract tesseract;

    public OCRService() {
        tesseract = new Tesseract();
//        tesseract.setDatapath("C:/Users/ADmin/AppData/Local/Programs/Tesseract-OCR/tessdata");
        tesseract.setDatapath("src/main/resources/static/assets/tessdata");
//        tesseract.setDatapath("C:/Program Files/Tesseract-OCR/tessdata");
        tesseract.setLanguage("vie+eng");
        tesseract.setTessVariable("user_defined_dpi", "300");
        tesseract.setPageSegMode(1); // Automatic page segmentation with OSD
        tesseract.setOcrEngineMode(1); // Neural nets LSTM engine
    }

    public User extractCardInfo(MultipartFile file) throws Exception {
        String extractedText = extractText(file);
        return parseUserInfo(extractedText);
    }

    private BufferedImage preprocessImage(BufferedImage image) {
        // Chuyển ảnh sang grayscale
        BufferedImage grayImage = new BufferedImage(
                image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g = grayImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();

        // Tăng độ tương phản
        RescaleOp rescaleOp = new RescaleOp(1.5f, 15, null);
        rescaleOp.filter(grayImage, grayImage);

        return grayImage;
    }

    public String extractText(MultipartFile file) throws Exception {
        File convertedFile = convertMultiPartToFile(file);
        try {
            BufferedImage image = ImageIO.read(convertedFile);
            BufferedImage processedImage = preprocessImage(image);
            return tesseract.doOCR(processedImage);
        } finally {
            convertedFile.delete();
        }
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    private User parseUserInfo(String text) {
        User info = new User();
        //line below is for testing
        info.setFullInfo(text);


        // Pattern matching để trích xuất thông tin
        Pattern mssv = Pattern.compile("(?:MSSV:|Mã SV:|Ma SV:|Student ID:|“ MãSV: - ' |)\\s*(\\d{8,12})(?=\\s|$)");
        // Sử dụng nhóm захват (capturing group) để chỉ lấy phần thông tin cần thiết
        Pattern name = Pattern.compile("(?:Họ tên:|Họ ten:|Ho ten:|Ho tên:|Ho va ten:|Họ va ten:|Ho và ten:|Ho va tên:|Họ và ten:|Họ va tên:|Ho và tên:|Họ và tên:|Ho fen:)\\s*(.+)(?=\\s|$)");
        Pattern birthday = Pattern.compile("(?:Ngày sinh:|Ngay sinh:|Ngey sinh:|Ngèy sinh:|Ngoy sinh:|Ngòy sinh:)\\s*(\\d{2}/\\d{2}/\\d{4})(?=\\s|$)"); // nhóm (\\d{2}/\\d{2}/\\d{4}) sẽ bắt ngày tháng

        Matcher mssvMatcher = mssv.matcher(text);
        Matcher nameMatcher = name.matcher(text);
        Matcher birthdayMatcher = birthday.matcher(text);

        if(mssvMatcher.find())
        {
            info.setStudentId(mssvMatcher.group(1).trim());
        }
        if (nameMatcher.find()) {
            info.setFullname(nameMatcher.group(1).trim()); // group(1) sẽ chỉ lấy phần tên
        }
//
        if (birthdayMatcher.find()) {
            info.setBirthday(birthdayMatcher.group(1).trim()); // group(1) sẽ chỉ lấy phần ngày tháng
        }

        return info;
    }
}