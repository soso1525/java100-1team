package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.LetterDao;
import java100.app.domain.Letter;
import java100.app.service.LetterService;

@Service
public class LetterServiceImpl implements LetterService {

    @Autowired LetterDao coverDao;
    
    @Override
    public List<Letter> list() {
        HashMap<String,Object> params = new HashMap<>();
        return coverDao.findAll(params);
    }

    @Override
    public int getTotalCount() {
        return coverDao.countAll();
    }
    
    @Override
    public int add(Letter cover) {
        
        return coverDao.insert(cover);
    }

    @Override
    public Letter get(int no) {
        return coverDao.findByNo(no);
    }

	@Override
	public int update(Letter cover) {
		return coverDao.update(cover);
	}

	@Override
	public int delete(int no) {
		return coverDao.delete(no);
	}

    
}
