package com.zeroexcusas.zeroexcusas_app.exceptions;

import com.zeroexcusas.zeroexcusas_app.custommessages.LocalizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleAPiRequestException(ApiRequestException apiRequestException ) {

        Locale.setDefault(Locale.US);

        LocalizedException localizedException = new LocalizedException(apiRequestException.getMessage());
        String exceptionMessage = localizedException.getLocalizedMessage();

        ApiException apiException = new ApiException(exceptionMessage, apiRequestException.getStatus(), ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiException, apiRequestException.getStatus());
    }
}
