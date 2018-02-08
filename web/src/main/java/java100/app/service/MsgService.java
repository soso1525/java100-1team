package java100.app.service;

import java.util.List;
import java.util.Map;

import java100.app.domain.Member;
import java100.app.domain.Msg;

public interface MsgService {
    int add(Msg msg);
    List<Msg> receiveList(int pageNo, int pageSize, Map<String,Object> options, Member loginUser);
    List<Msg> sendList(int pageNo, int pageSize, Map<String,Object> options, Member loginUser);
    Msg get(int mno);
    int getTotalCount();
    int delete(int mno);
}