package com.acme.viajesacme.avion.domain.service;

import java.sql.ResultSet;
import java.util.List;

public interface VerInfoService {
    public List<Integer> print(ResultSet resultSet);
}
