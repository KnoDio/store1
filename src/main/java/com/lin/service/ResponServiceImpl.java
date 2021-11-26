package com.lin.service;

import com.lin.dao.ResponMapper;
import com.lin.pojo.Respon;

public class ResponServiceImpl implements ResponService{
    ResponMapper responMapper;

    public ResponMapper getResponMapper() {
        return responMapper;
    }

    public void setResponMapper(ResponMapper responMapper) {
        this.responMapper = responMapper;
    }

    public int add(Respon respon) {
        return responMapper.add(respon);
    }
}
