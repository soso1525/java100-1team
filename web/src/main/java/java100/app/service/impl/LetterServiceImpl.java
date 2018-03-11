package java100.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.ApplyDao;
import java100.app.dao.LetterDao;
import java100.app.dao.QuestionDao;
import java100.app.domain.Apply;
import java100.app.domain.Letter;
import java100.app.service.LetterService;

@Service
public class LetterServiceImpl implements LetterService {

	@Autowired
	ApplyDao applyDao;
	@Autowired
	LetterDao letterDao;
	@Autowired
	QuestionDao questionDao;

	@Override
	public List<Letter> findAll(int no) {
		return letterDao.findAll(no);
	}

	@Override
	public List<Letter> list(int ano) {
		// HashMap<String,Object> params = new HashMap<>();
		// params.put("ano", no);
		// return letterDao.findAll(params);
		return letterDao.list(ano);
	}

	@Override
	public int getTotalCount() {
		return letterDao.countAll();
	}

	@Override
	public int add(Letter letter) {
		return letterDao.insert2(letter);
	}

	@Override
	public int addLetter(Apply apply, Letter letter) {
		return applyDao.insert(apply) + letterDao.insert(letter);
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
		return questionDao.delete(no) + letterDao.delete(no);
	}

	@Override
	public int getAno(int lno) {
		return letterDao.getAno(lno);
	}

}
