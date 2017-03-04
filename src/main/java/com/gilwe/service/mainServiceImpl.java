package com.gilwe.service;

import com.gilwe.dao.MysqlDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class mainServiceImpl {
    @Autowired
    MysqlDao dao;

    public String getTestDB(){
        Map<String, Object> pMap = new HashMap<String, Object>();

        System.out.println(dao.selectOne("gilwe.main.getString", pMap).toString());
        return "TEST1";
    }
}
