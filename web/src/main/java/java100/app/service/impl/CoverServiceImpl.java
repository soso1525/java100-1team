package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.CoverDao;
import java100.app.domain.Cover;
import java100.app.service.CoverService;

@Service
public class CoverServiceImpl implements CoverService {

    @Autowired CoverDao coverDao;
    
    @Override
    public List<Cover> list() {
        HashMap<String,Object> params = new HashMap<>();
        return coverDao.findAll(params);
    }

    @Override
    public int getTotalCount() {
        return coverDao.countAll();
    }
    
    @Override
    public int add(Cover cover) {
        
        return coverDao.insert(cover);
    }

    @Override
    public Cover get(int no) {
        return coverDao.findByNo(no);
    }

	@Override
	public int update(Cover cover) {
		return coverDao.update(cover);
	}

	@Override
	public int delete(int no) {
		return coverDao.delete(no);
	}

    
}
