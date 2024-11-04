package com.example.movietickets.demo.ultillity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.QRCodeWriter;

import java.awt.image.BufferedImage;

public class BarcodeGenerator {
    public BufferedImage generateBarcodeImage(String text) throws WriterException {
        Code128Writer barcodeWriter = new Code128Writer();
        BitMatrix bitMatrix = barcodeWriter.encode(text, BarcodeFormat.CODE_128, 200, 40);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}
