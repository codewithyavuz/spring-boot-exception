package com.ozmenyavuz.exception;

import lombok.Getter;

@Getter
public enum MessageType {

    NO_RECORD_EXIST("1001", "KAYIT BULUNAMADI"),
    GENERAL_EXCEPTION("9999", "GENEL BIR HATA OLUSTU");

    private String code;
    private String message;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
