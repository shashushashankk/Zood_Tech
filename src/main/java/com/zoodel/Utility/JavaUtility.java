package com.zoodel.Utility;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JavaUtility {
    public String getTextFromQR() {
        String imagePath = "C:\\Users\\ER\\Downloads\\qr-code.png";
        String link = "";
        try {
            File imageFile = new File("C:\\Users\\ER\\Downloads\\qr-code.png");
            BufferedImage bufferedImage = ImageIO.read(imageFile);

            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            Result result = new MultiFormatReader().decode(bitmap);

            System.out.println("Scanned text: " + result.getText());
            System.out.println("Barcode format: " + result.getBarcodeFormat());
        } catch (Exception e) {
            System.err.println("Error decoding barcode: " + e.getMessage());
        }
        return link;
    }

    public String getCurrentTime(String formate) {
        return getDateAndTime(formate);
    }

    public String getCurrentDate(String formate) {
        return getDateAndTime(formate);
    }

    public String getDateAndTime(String formate) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter reqFormate = DateTimeFormatter.ofPattern(formate);
        return reqFormate.format(dateTime);
    }

    //    @Test
    void test() {
        System.out.println(getDateAndTime("dd-MM-yyyy HH:mm:ss.SSSS"));
    }
}
