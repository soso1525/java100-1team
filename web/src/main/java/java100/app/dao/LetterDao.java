package java100.app.dao;

import java.util.HashMap;
import java.util.List;

import java100.app.domain.Letter;

public interface LetterDao {
	 public List<Letter> findAll(HashMap<String, Object> params); 
	 public int countAll();
	 public int insert(Letter cover);
	 public Letter findByNo(int no);
	 public int update(Letter cover);
	 public int delete(int no);
}