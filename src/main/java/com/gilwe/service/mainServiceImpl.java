package com.gilwe.service;

import com.gilwe.dao.MysqlDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class mainServiceImpl {
    @Autowired
    MysqlDao dao;


    public Map getMainSuggestList(Map<String, Object> pMap) {
        Map<String, Object> rMap = new HashMap<String, Object>();
        try {
            rMap.put("suggestList", dao.getListData("getMainSuggestList"));
            rMap.put("newRoadList", dao.getListData("getMainNewRoadList"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rMap;
    }

    public Map getRoadInfo(String road_id){
        Map<String, Object> rMap = new HashMap<String, Object>();
        try {
            rMap.put("getRoadInfo", dao.getReadData("getRoadInfo", road_id));
            System.out.println(rMap.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rMap;
    }
}
