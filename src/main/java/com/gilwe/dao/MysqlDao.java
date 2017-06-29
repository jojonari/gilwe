package com.gilwe.dao;

import com.gilwe.controller.MainController;
import com.gilwe.util.FormatHelper;
import com.gilwe.util.PageNavigator;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MysqlDao {
    @Autowired
    private SqlSession sqlSession;

    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    public void setSqlSessionTemplate(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    // ******************************************************************
    // 데이터 추가
    public int insertData(String id, Object value) throws Exception {
        int result = 0;

        try {
            result = sqlSession.insert(id, value);
        } catch (Exception e) {
            logger.debug(e.toString());
        } finally {
        }
        return result;
    }

    // ******************************************************************
    //데이터 수정
    public int updateData(String id) throws Exception {
        int result = 0;

        try {
            result = sqlSession.update(id);
        } catch (Exception e) {
            logger.debug(e.toString());
        }

        return result;
    }

    public int updateData(String id, Object value) throws Exception {
        int result = 0;

        try {
            result = sqlSession.update(id, value);
        } catch (Exception e) {
            logger.debug(e.toString());
        }

        return result;
    }

    public int updateData(String id, Map<String, Object> map) throws Exception {
        int result = 0;
        try {
            result = sqlSession.update(id, map);
        } catch (Exception e) {
            logger.debug(e.toString());
        }
        return result;
    }

    // ******************************************************************
    // 데이터 삭제
    public int deleteData(String id, Map<String, Object> map) throws Exception {
        int result = 0;

        try {
            result = sqlSession.delete(id, map);
        } catch (Exception e) {
            logger.debug(e.toString());
        }

        return result;
    }

    public int deleteData(String id, Object value) throws Exception {
        int result = 0;

        try {
            result = sqlSession.delete(id, value);
        } catch (Exception e) {
            logger.debug(e.toString());
        }

        return result;
    }

    public int deleteAll(String id) throws Exception {
        int result = 0;

        try {
            result = sqlSession.delete(id);
        } catch (Exception e) {
            logger.debug(e.toString());
        }

        return result;
    }

    // ******************************************************************
    // 레코드 수 / 최대값 구하기
    public int getIntValue(String id, Map<String, Object> map) throws Exception {
        int num = 0;
        num = ((Integer)sqlSession.selectOne(id, map)).intValue();
        return num;
    }

    public int getIntValue(String id, Object value) throws Exception {
        int num = 0;
        num = ((Integer)sqlSession.selectOne(id, value)).intValue();
        return num;
    }

    public int getIntValue(String id) throws Exception {
        int num = 0;
        num = ((Integer)sqlSession.selectOne(id)).intValue();
        return num;
    }

    // ******************************************************************
    // 테이블의 레코드를 리스트에 저장
    @SuppressWarnings("unchecked")
    public List<Object> getListData(String id, Map<String, Object> map) throws Exception {
        List<Object> lists = (List<Object>)sqlSession.selectList(id, map);
        return lists;
    }
    @SuppressWarnings("unchecked")
    public List<Object> getListData(String id, Object value) throws Exception {
        List<Object> lists = (List<Object>)sqlSession.selectList(id, value);
        return lists;
    }
    @SuppressWarnings("unchecked")
    public List<Object> getListData(String id) throws Exception {
        List<Object> lists = (List<Object>)sqlSession.selectList(id);
        return lists;
    }

    @SuppressWarnings("unchecked")
    public List<Object> getListData(String id, Map<String, Object> map, RowBounds rowBounds) throws Exception {
        List<Object> lists = (List<Object>)sqlSession.selectList(id, map, rowBounds);
        return lists;
    }

    // ******************************************************************
    // 해당 레코드 가져오기
    public Object getReadData(String id) throws Exception {
        return  sqlSession.selectOne(id);
    }

    public Object getReadData(String id, Object value) throws Exception {
        return  sqlSession.selectOne(id, value);
    }

    public Object getReadData(String id, Map<String, Object> map) throws Exception {
        return  sqlSession.selectOne(id, map);
    }

    // ******************************************************************
    // 페이징 처리된 리스트 레코드 가져오기
    public Map<String, Object> getPagingListData(String countQueryId,
                                                 String listQueryId, Map<String, Object> pMap) throws Exception {

        Map<String, Object> rMap = new HashMap<String, Object>();

        int totalCount = 0;

        //1. 총건수 조회
        totalCount = this.getIntValue(countQueryId, pMap);

        //2. 페이징
        String page = (String)pMap.get("page"); // 몇번째의 페이지를 요청했는지
        String rowCnt = (String)pMap.get("rows"); // 페이지 당 몇개의 행이 보여질건지

        Integer pageNo = 0;
        Integer rowPerPage = 0;

        if (FormatHelper.isNotEmpty(page)) pageNo = Integer.parseInt(page);

        if (FormatHelper.isNotEmpty(rowCnt)) rowPerPage = Integer.parseInt(rowCnt);

        //3.페이징 처리
        PageNavigator pageNavi = new PageNavigator(pageNo, rowPerPage);

        pageNavi.setPagePerGroup(rowPerPage);

        pageNavi.setTotalSize(totalCount);


        pMap.put("startRowNum", pageNavi.getStartRow());
        pMap.put("endRowNum", pageNavi.getEndRow());

        //4.리스트 조회
        rMap.put("rows", this.getListData(listQueryId, pMap));

        //5. 그리드 페이징 정보 결과리턴
        rMap.put("totalPage", pageNavi.getPageTotal());
        rMap.put("totalRecord", totalCount);
        rMap.put("currentPage", pageNavi.getCurrentPage());
        rMap.put("records", pageNavi.getRowsPerPage());

        return rMap;
    }


}
