package com.qrcode.generator.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;
import java.util.UUID;

import java.awt.image.BufferedImage;

@Service
public class QrCodeGeneratorService {

    // better put in conf file
    final static int BARCODE_WIDTH= 300;
    final static int BARCODE_HEIGHT= 300;

    public BufferedImage generateQrCodeFromString(String qrText) throws WriterException {

        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        BitMatrix bitMatrix = qrCodeWriter
                .encode(qrText, BarcodeFormat.QR_CODE, BARCODE_WIDTH, BARCODE_HEIGHT);

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    public BufferedImage generateRandomQrCode() throws WriterException {

        String randomQrText = UUID.randomUUID().toString();
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        BitMatrix bitMatrix = qrCodeWriter
                .encode(randomQrText, BarcodeFormat.QR_CODE, BARCODE_WIDTH, BARCODE_HEIGHT);

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

}
