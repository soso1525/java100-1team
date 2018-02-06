package java100.app.dao;

import java.util.HashMap;
import java.util.List;

import java100.app.domain.Cover;

public interface CoverDao {
	 public List<Cover> findAll(HashMap<String, Object> params); 
	 public int countAll();
	 public int insert(Cover cover);
	 public Cover findByNo(int no);
	 public int update(Cover cover);
	 public int delete(int no);
}