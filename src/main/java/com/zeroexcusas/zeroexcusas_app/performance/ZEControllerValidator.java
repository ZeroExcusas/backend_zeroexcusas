package com.zeroexcusas.zeroexcusas_app.performance;
import com.zeroexcusas.zeroexcusas_app.service.ZEService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class ZEControllerValidator {
    private final static int REGISTER = 1;
    private final static int GET_ONE = 2;
    private final static int GET_ALL = 3;
    private final static int DELETE = 4;
    private final static int UPDATE = 5;




    private String name;
    private Object data;

    private ResponseEntity<?> responseEntity;

    private ZEService myService;

    private int strategy;

    protected ZEControllerValidator(Object service) {
        this.myService = (ZEService) service;
    }

    public static ZEControllerValidator getInstance(Object service) {
        return new ZEControllerValidator(service);
    }

    public ZEControllerValidator getAll() {
        List<?> myData = this.myService.getAllData();
        setStrategy(ZEControllerValidator.GET_ALL);
        this.responseEntity = !myData.isEmpty() ? new ResponseEntity<>(myData, HttpStatus.OK)  : this.notFoundResponse();
        return this;
    }

    public ZEControllerValidator getOneRecord(Integer id) {
        Optional<?> record = this.myService.getOneRecord(id);
        setStrategy(ZEControllerValidator.GET_ONE);
        this.responseEntity = !record.isEmpty() ? new ResponseEntity<>(record.get(), HttpStatus.OK)  : this.notFoundResponse();
        return this;
    }

    public ZEControllerValidator register(Object data) {
        this.data = data;
        this.setStrategy(ZEControllerValidator.REGISTER);
        return this;
    }

    private ResponseEntity<?> notFoundResponse() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<?> somethingWrong() {
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }


    public ResponseEntity<?> buildReponse() {
        ResponseEntity<?> response;
        switch (getStrategy()) {
            case ZEControllerValidator.REGISTER:
                this.responseEntity = tryToRegister();
                break;
        }

        return this.responseEntity;
    }

    private ResponseEntity<?> tryToRegister() {
        ResponseEntity<?> response;
        try {
            Optional recorded = this.myService.register(this.data);
            if (recorded.isEmpty()) {
                response = somethingWrong();
            }
            else {
                response = new ResponseEntity<>(recorded, HttpStatus.OK);
            }

        } catch (Exception e) {
            response = somethingWrong();
        }
        return response;
    }

    private void setStrategy(int strategy) {
        this.strategy = strategy;
    }

    private int getStrategy() {
        return this.strategy;
    }
}