package com.zeroexcusas.zeroexcusas_app.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class NotFoundException extends BaseException {
    @Override
    public void define() {
        status = HttpStatus.NOT_FOUND;
        keyMessage = "message.not_found";
    }
}
