package com.ozmenyavuz.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

    // MESAJ TIPI

    private MessageType messageType;
    private String ofStatic;

    public String prepareErrorMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append(messageType.getMessage());  // messageType Enum'unun getMessage() metodunu kullanarak mesajı alır
        if (ofStatic != null && !ofStatic.trim().isEmpty()) {  // ofStatic boş veya null olmamalı
            builder.append(" : ").append(ofStatic);
        }
        return builder.toString();
    }

}
