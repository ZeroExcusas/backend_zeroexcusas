package com.zeroexcusas.zeroexcusas_app.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@NoArgsConstructor
public abstract class BaseException {
    public String keyMessage = "";
    public HttpStatus status = null;

    public void define() {
        this.keyMessage = "default.message";
        this.status = HttpStatus.CONFLICT;
    }

    public RuntimeException throwIt() {
        define();
        ApiRequestException customException = new ApiRequestException(keyMessage);
        customException.setStatus(this.status);
        return customException;
        //ApiException apiException = new ApiException(keyMessage, HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z")));
    }
}
