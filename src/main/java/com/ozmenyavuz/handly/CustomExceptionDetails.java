package com.ozmenyavuz.handly;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomExceptionDetails<E> {
    private String hostName;
    private String path;
    private String createTime;
    private E message;
}
