package com.gilwe.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MysqlDao {
    @Autowired
    private SqlSession sqlSession;


    public HashMap<String, Object> selectOne(String queryName, Map<String, Object> map){
        return this.sqlSession.selectOne(queryName, map);
    }

}
