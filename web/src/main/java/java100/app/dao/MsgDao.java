package java100.app.dao;

import java.util.List;
import java.util.Map;

import java100.app.domain.Msg;

public interface MsgDao {

    int insert(Msg msg);
    List<Msg> findAll(Map<String,Object> params);
    Msg findByNo(int mno);
    int countAll();
//    int update(Msg msg);
    int delete(int mno);
}















