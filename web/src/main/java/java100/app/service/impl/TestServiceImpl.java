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

	@Autowired TestDao testDao;

	@Override
	public Test list(int no) {
		return testDao.list(no);
	}
	
	@Override
	public List<Test> allList(int no) {
		HashMap<String,Object> params = new HashMap<>();
        params.put("no", no);
        return testDao.findMemberAll(params);
	}

	@Override
	public int countAll() {
		return testDao.countAll();
	}

	@Override
	public int add(Test test) {
		return testDao.add(test);
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
