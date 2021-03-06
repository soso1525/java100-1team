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

	@Autowired
	QuestionDao questionDao;

	@Override
	public List<Question> list(int no) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("lno", no);
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
	public int companyAdd(Question question) {
		for (String article : question.getArticles()) {
			question.setArticle(article);
			questionDao.companyInsert(question);
		}
		return 0;
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

	@Override
	public String getCompanyName(int no) {
		return questionDao.getCompanyName(no);
	}

	@Override
	public String getFileName(int no) {
		return questionDao.getFileName(no);
	}

}
