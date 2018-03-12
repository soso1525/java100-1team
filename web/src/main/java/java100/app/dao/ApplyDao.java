package java100.app.dao;

import java.util.HashMap;
import java.util.List;

import java100.app.domain.Apply;

public interface ApplyDao {
	 public int insert(Apply apply);
	 public List<Apply> findAll(HashMap<String, Object> params);
	 public int countAll();
	 public Apply findByNo(int no);
	 public Apply findByName(String aname);
	 public int update(Apply apply);
	 public int delete(int no);
	 public Apply getState(int no);
}