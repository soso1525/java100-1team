package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.QuestionDao;
import java100.app.domain.Question;
import java100.app.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired QuestionDao questionDao;
    
    @Override
    public List<Question> list(int no) {
        HashMap<String,Object> params = new HashMap<>();
        return questionDao.findAll(params);
    }

    @Override
    public int getTotalCount() {
        return questionDao.countAll();
    }
    
    @Override
    public int add(Question question) {
        return questionDao.insert(question);
    }

    @Override
    public Question get(int no) {
        return questionDao.findByNo(no);
    }

	@Override
	public int update(Question question) {
		return questionDao.update(question);
	}

	@Override
	public int delete(int no) {
		return questionDao.delete(no);
	}
    
}
