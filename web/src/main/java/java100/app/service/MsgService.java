package java100.app.service;

import java.util.List;
import java.util.Map;

import java100.app.domain.Member;
import java100.app.domain.Msg;

public interface MsgService {
 //   int add(Msg2 msg2);
    List<Msg> receiveList(int pageNo, int pageSize, Map<String,Object> options, Member loginUser);
    List<Msg> sendList(int pageNo, int pageSize, Map<String,Object> options, Member loginUser);
    Msg get(int mno, Member loginUser);
//    Msg2 get2(int mrecv);
    int getTotalCount();
    int getMrecvCount(int pno);
    int getMsendCount(int pno);
    int delete(int mno);
    
    int msgAdd(Msg msg); // Msg insert
}