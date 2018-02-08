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
    
    @Override
    public int add(Msg msg) {
        return msgDao.insert(msg);
    }
    
    @Override
    public List<Msg> list(int pageNo, int pageSize,Map<String,Object> options,
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
    public List<Msg> list2(int pageNo, int pageSize,Map<String,Object> options,
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
    public Msg get(int mno) {
        msgDao.updateViewCount(mno);
        Msg msg = msgDao.findByNo(mno);
        return msg;
    }


    @Override
    public int delete(int mno) {
        return msgDao.delete(mno);
    }

//    @Override
//    public int update(Msg msg) {
//        return msgDao.update(msg);
//    }
//    

}
