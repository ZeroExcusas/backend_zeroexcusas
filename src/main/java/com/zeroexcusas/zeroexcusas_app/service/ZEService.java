package com.zeroexcusas.zeroexcusas_app.service;

import java.util.List;
import java.util.Optional;

public interface ZEService {

    List<?> getAllData();

    Optional<?> getOneRecord(Integer id);

    Optional<?> deleteOneRecord(Integer id);


    Optional<?> register(Object data);
}
