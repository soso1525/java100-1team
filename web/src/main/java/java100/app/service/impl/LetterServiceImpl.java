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

    @Autowired LetterDao letterDao;
    
    @Override
    public List<Letter> list(int no) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("no", no);
        return letterDao.findAll(params);
    }

    @Override
    public int getTotalCount() {
        return letterDao.countAll();
    }
    
    @Override
    public int add(Letter cover) {
        
        return letterDao.insert(cover);
    }

    @Override
    public Letter get(int no) {
        return letterDao.findByNo(no);
    }

	@Override
	public int update(Letter cover) {
		return letterDao.update(cover);
	}

	@Override
	public int delete(int no) {
		return letterDao.delete(no);
	}

    
}
