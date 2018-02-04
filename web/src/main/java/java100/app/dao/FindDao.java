package java100.app.dao;

import java.util.HashMap;
import java.util.List;

import java100.app.domain.Find;

public interface FindDao {
	 public List<Find> findAll(HashMap<String, Object> params); 
	 public int insert(Find find);
	 public int delete(int no);
}