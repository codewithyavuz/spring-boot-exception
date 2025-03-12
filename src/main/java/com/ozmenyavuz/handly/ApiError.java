package com.ozmenyavuz.handly;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError<E> {

    private Integer status;
    private CustomExceptionDetails<E> exception;

}
