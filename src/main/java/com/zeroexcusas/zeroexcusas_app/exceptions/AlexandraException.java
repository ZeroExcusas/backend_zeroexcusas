package com.zeroexcusas.zeroexcusas_app.exceptions;

import org.springframework.http.HttpStatus;

public class AlexandraException extends BaseException {

    @Override
    public void define() {
        super.define();
        keyMessage = "message.alexandra";
        status = HttpStatus.ALREADY_REPORTED;
    }
}
