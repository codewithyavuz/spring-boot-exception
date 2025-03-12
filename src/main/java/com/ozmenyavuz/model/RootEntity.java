package com.ozmenyavuz.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RootEntity<T> {

    private boolean resultl;
    private String errorMessage;
    private T data;

    public static  <T>  RootEntity<T> ok(T data) {
        RootEntity<T>  rootEntity = new RootEntity<>();
        rootEntity.setData(data);
        rootEntity.setResultl(true);
        rootEntity.setErrorMessage(null);
        return rootEntity;
    }

    public  static <T>  RootEntity<T> error( String errorMessage ) {
        RootEntity<T>  rootEntity = new RootEntity<>();
        rootEntity.setData(null);
        rootEntity.setResultl(false);
        rootEntity.setErrorMessage(errorMessage);
        return rootEntity;
    }


}
