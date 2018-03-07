package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.ApplyDao;
import java100.app.domain.Apply;
import java100.app.domain.Letter;
import java100.app.domain.Member;
import java100.app.domain.Resume;
import java100.app.service.ApplyService;

@Service
public class ApplyServiceImpl implements ApplyService {

    @Autowired ApplyDao applyDao;
    
    @Override
    public List<Apply> list(Member loginUser) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("writer", loginUser);
        return applyDao.findAll(params);
    }

    @Override
    public int getTotalCount() {
        return applyDao.countAll();
    }
    
    @Override
    public int add(Apply apply) {
        return applyDao.insert(apply);
    }

    @Override
    public Apply get(int no) {
        return applyDao.findByNo(no);
    }

	@Override
	public int update(Apply apply) {
		return applyDao.update(apply);
	}

	@Override
	public int delete(int no) {
		return applyDao.delete(no);
	}
}
