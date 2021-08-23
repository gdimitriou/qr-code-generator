package com.qrcode.generator.model.dto;

public class QrCodeMessageRequestDTO {

    private String qrCodeMessage;

    public QrCodeMessageRequestDTO() {
    }

    public String getQrCodeMessage() {
        return qrCodeMessage;
    }

    public void setQrCodeMessage(String qrCodeMessage) {
        this.qrCodeMessage = qrCodeMessage;
    }
}
