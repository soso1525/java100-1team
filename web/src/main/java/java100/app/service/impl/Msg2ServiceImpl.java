package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.Msg2Dao;
import java100.app.domain.Member;
import java100.app.domain.Msg2;
import java100.app.service.Msg2Service;

@Service
public class Msg2ServiceImpl implements Msg2Service {
    @Autowired Msg2Dao msg2Dao;
    
    @Override
    public int add(Msg2 msg2) {
        return msg2Dao.insert(msg2);
    }
    
    @Override
    public List<Msg2> receiveList(int pageNo, int pageSize,Map<String,Object> options,
            Member loginUser){
        HashMap<String,Object> params = new HashMap<>();
        params.put("startIndex", (pageNo - 1) * pageSize);
        params.put("size", pageSize);
        params.put("writer", loginUser);
        
        if (options != null) {
            params.putAll(options);
        }
        return msg2Dao.findAll(params);
    }
    
    @Override
    public List<Msg2> sendList(int pageNo, int pageSize,Map<String,Object> options,
            Member loginUser){
        HashMap<String,Object> params = new HashMap<>();
        params.put("startIndex", (pageNo - 1) * pageSize);
        params.put("size", pageSize);
        params.put("writer", loginUser);
        
        if (options != null) {
            params.putAll(options);
        }
        return msg2Dao.findAll2(params);
    }
    
    @Override
    public int getTotalCount() {
        return msg2Dao.countAll();
    }
    
    @Override
    public Msg2 get(int mno, Member loginUser) {
        msg2Dao.updateViewCount(mno);
        Msg2 msg2 = msg2Dao.findByNo(mno);
        return msg2;
    }


    @Override
    public int delete(int mno) {
        return msg2Dao.delete(mno);
    }

//    @Override
//    public int update(Msg msg) {
//        return msgDao.update(msg);
//    }
//    

}
