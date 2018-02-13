package java100.app.dao;

import java.util.List;
import java.util.Map;

import java100.app.domain.Msg2;

public interface Msg2Dao {

    int insert(Msg2 msg2);
    List<Msg2> findAll(Map<String,Object> params);
    List<Msg2> findAll2(Map<String,Object> params);
    int updateViewCount(int mno);
    Msg2 findByNo(int mno);
    int countAll();
//    int update(Msg msg);
    int delete(int mno);
}















