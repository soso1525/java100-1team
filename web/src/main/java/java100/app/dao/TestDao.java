package java100.app.dao;

import java.util.HashMap;
import java.util.List;

import java100.app.domain.Letter;
import java100.app.domain.Test;

public interface TestDao {
	 public List<Test> findAll(HashMap<String, Object> params); 
	 public Test list(int ano);
	 public int countAll();
	 public int insert(Test test);
	 public Test findByNo(int no);
	 public int update(Test test);
	 public int delete(int no);
}