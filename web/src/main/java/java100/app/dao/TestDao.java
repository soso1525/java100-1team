package java100.app.dao;

import java.util.HashMap;
import java.util.List;

import java100.app.domain.Test;

public interface TestDao {
	 public List<Test> findMemberAll(HashMap<String, Object> params);
	 public List<Test> findAll(int no); 
	 public Test list(int ano);
	 public int countAll();
	 public int add(Test test);
	 public Test findByNo(int no);
	 public int update(Test test);
	 public int delete(int no);
}