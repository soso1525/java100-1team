package java100.app.dao;

import java.util.List;
import java.util.Map;

import java100.app.domain.Msg2;

public interface Msg2Dao {

    
    List<Msg2> findAll(Map<String,Object> params);
    List<Msg2> findAll2(Map<String,Object> params);
    int updateViewCount(int mno);
    Msg2 findByNo(int mno);
//    Msg2 memberByNoAndId(int mrecv);
    int countAll();
    int countMsend();
    int countMrecv(int pno);
//    int update(Msg msg);
    int delete(int mno);
    
    int insert(Map<String,Object> params);    // Msg insert
    int chaneId(String pid2); // id를 받아 no로 변환 
}















