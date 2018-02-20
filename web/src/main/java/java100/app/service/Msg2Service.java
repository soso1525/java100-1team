package java100.app.service;

import java.util.List;
import java.util.Map;

import java100.app.domain.Member;
import java100.app.domain.Msg2;

public interface Msg2Service {
 //   int add(Msg2 msg2);
    List<Msg2> receiveList(int pageNo, int pageSize, Map<String,Object> options, Member loginUser);
    List<Msg2> sendList(int pageNo, int pageSize, Map<String,Object> options, Member loginUser);
    Msg2 get(int mno, Member loginUser);
//    Msg2 get2(int mrecv);
    int getTotalCount();
    int delete(int mno);
    
    int msgAdd(Msg2 msg2); // Msg insert
}