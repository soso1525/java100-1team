package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.FindDao;
import java100.app.domain.Find;
import java100.app.service.FindService;

@Service
public class FindServiceImpl implements FindService {

	@Autowired FindDao findDao;
	
	@Override
	public List<Find> list() {
	    HashMap<String,Object> params = new HashMap<>();
	    return findDao.findAll(params);
	}
	
	
	@Override
	public int add(Find find) {
	    return findDao.insert(find);
	}
	
	@Override
	public int addMember(Find find) {
	    return findDao.insertMember(find);
	}
	
	@Override
	public int delete(int no) {
		return findDao.delete(no);
	}

}
