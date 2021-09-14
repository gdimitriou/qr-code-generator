package com.qrcode.generator.controller;

import com.qrcode.generator.model.dto.QrCodeMessageRequestDTO;
import com.qrcode.generator.service.QrCodeGeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.awt.image.BufferedImage;

@RestController
@RequestMapping(path = "/api/v1/generate-qr")
public class Controller {

    final static Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    QrCodeGeneratorService qrCodeGeneratorService;

    @PostMapping(
            path = "/from-given-string",
            produces = MediaType.IMAGE_PNG_VALUE)
    public BufferedImage generateQRCodeImageFromString(
            @RequestBody QrCodeMessageRequestDTO qrCodeMessage) {

        String qrText = qrCodeMessage.getQrCodeMessage();

        try {
            logger.info("--> POST /api/v1/generate-qr/from-given-string"+", {"+qrText +"}");
            return qrCodeGeneratorService.generateQrCodeFromString(qrText);
        } catch (Exception e) {
            logger.info("--> POST /api/v1/generate-qr/from-given-string"+ "FAILED");
            return null;
        }
    }

    @GetMapping(
            path = "/random",
            produces = MediaType.IMAGE_PNG_VALUE)
    public BufferedImage generateRandomQRCodeImage() {

        try {
            logger.info("--> GET /api/v1/generate-qr/random");
            return qrCodeGeneratorService.generateRandomQrCode();
        } catch (Exception e) {
            logger.info("--> GET /api/v1/generate-qr/random" +" FAILED");
            return null;
        }
    }

}
