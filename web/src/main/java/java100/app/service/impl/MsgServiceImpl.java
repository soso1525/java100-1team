package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.MsgDao;
import java100.app.domain.Member;
import java100.app.domain.Msg;
import java100.app.service.MsgService;

@Service
public class MsgServiceImpl implements MsgService {
    @Autowired MsgDao msgDao;
    
//    @Override
//    public int add(msg msg) {
//        return msgDao.insert(msg);
//    }
    
    @Override
    public List<Msg> receiveList(int pageNo, int pageSize,Map<String,Object> options,
            Member loginUser){
        HashMap<String,Object> params = new HashMap<>();
        params.put("startIndex", (pageNo - 1) * pageSize);
        params.put("size", pageSize);
        params.put("writer", loginUser);
        
        if (options != null) {
            params.putAll(options);
        }
        return msgDao.findAll(params);
    }
    
    @Override
    public List<Msg> sendList(int pageNo, int pageSize,Map<String,Object> options,
            Member loginUser){
        HashMap<String,Object> params = new HashMap<>();
        params.put("startIndex", (pageNo - 1) * pageSize);
        params.put("size", pageSize);
        params.put("writer", loginUser);
        
        if (options != null) {
            params.putAll(options);
        }
        return msgDao.findAll2(params);
    }
    

    
    @Override
    public int getTotalCount() {
        return msgDao.countAll();
    }
    @Override
    public int getMrecvCount(int pno) {
        return msgDao.countMrecv(pno);
    }
    @Override
    public int getMsendCount(int pno) {
        return msgDao.countMsend(pno);
    }
    
    @Override
    public Msg get(int mno, Member loginUser) {
        msgDao.updateViewCount(mno);
        Msg msg = msgDao.findByNo(mno);
        return msg;
    }
    
//    @Override
//    public msg get2(int mrecv) {
//        msg msg = msgDao.memberByNoAndId(mrecv);
//        return msg;
//    }
    

    @Override
    public int delete(int mno) {
        return msgDao.delete(mno);
    }

    @Override
    public int msgAdd(Msg msg) {
        String pid = msg.getPid2();     // 받는 사람 id
        System.out.println("id : "+pid);
        int pno2 = msgDao.chaneId(pid); // 받는 사람 no
        System.out.println("변환한 no : "+pno2);
        Map<String, Object> params = new HashMap<String,Object>();
        
        params.put("mcont", msg.getMcont());
        params.put("writer", msg.getWriter());
        params.put("pno2", pno2);
        msgDao.insert(params); // Msg insert
        
        return 0;
    }

//    @Override
//    public int update(Msg msg) {
//        return msgDao.update(msg);
//    }
//    

}
