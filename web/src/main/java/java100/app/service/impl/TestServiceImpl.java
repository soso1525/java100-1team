package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.TestDao;
import java100.app.domain.Test;
import java100.app.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestDao testDao;

	@Override
	public List<Test> list(int ano) {
		HashMap<String,Object> params = new HashMap<>();
        params.put("ano", ano);
        return testDao.findAll(params);
	}
	
	@Override
	public List<Test> allList(int no) {
		HashMap<String,Object> params = new HashMap<>();
        params.put("no", no);
        return testDao.findMemberAll(params);
	}

	@Override
	public Test find(int ano) {
		return testDao.list(ano);
	}
	
	@Override
	public int countAll() {
		return testDao.countAll();
	}

	@Override
	public int insert(Test test) {
		return testDao.insert(test);
	}
	

	@Override
	public Test findByNo(int no) {
		return testDao.findByNo(no);
	}

	@Override
	public int update(Test test) {
		return testDao.update(test);
	}

	@Override
	public int delete(int no) {
		return testDao.delete(no);
	}

}
