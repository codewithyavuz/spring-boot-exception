package com.ozmenyavuz.handly;


import com.ozmenyavuz.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Date;


//@ControllerAdvice anotasyonu, Spring Boot’un tüm Controller’larında oluşan istisnaları ele almak için kullanılır.
//Bu sınıf merkezi bir hata yönetimi sağlar, yani her Controller içinde ayrı ayrı hata yönetimi yazmamıza gerek kalmaz.
@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(value = {BaseException.class})// ile sadece BaseException türündeki hatalar yakalanı
    public ResponseEntity<ApiError> handleBaseException(BaseException exception, WebRequest request) {
        return ResponseEntity.badRequest().body(createApiError(exception.getMessage(), request));
    }


    //🔹 Generic (<E>) bir hata mesajı alarak ApiError nesnesi oluşturur.
    //🔹 message: Hata mesajını içerir.
    //🔹 request: HTTP isteği hakkında bilgi içerir.

    public <E> ApiError<E> createApiError(E message, WebRequest request) {
        ApiError<E> apiError = new ApiError<>();
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());

        CustomExceptionDetails<E> exception = new CustomExceptionDetails<>();
        exception.setCreateTime(new Date().toString()); // Hatanin olusma zamani
        exception.setHostName(getHostname()); // Hatanın hangi sunucuda gerçekleştiğini belirler.
        exception.setPath(request.getDescription(false).substring(4));
        exception.setMessage(message); //Hata mesajını nesneye kaydeder.

        apiError.setException(exception); // Oluşturulan exception nesnesini ApiError içine ekler.

        return apiError;
    }

    private String getHostname() {
        try {
            return Inet4Address.getLocalHost().getHostName(); // ✅ Değer döndürülüyor
        } catch (UnknownHostException e) {
            System.err.println("Hostname alınırken hata oluştu: " + e.getMessage());
            return "unknown-host"; // 🔥 Hata durumunda "unknown-host" döndürmek daha güvenli!
        }
    }

}
