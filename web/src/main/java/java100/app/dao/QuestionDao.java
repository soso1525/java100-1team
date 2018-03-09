package java100.app.dao;

import java.util.HashMap;
import java.util.List;

import java100.app.domain.Question;

public interface QuestionDao {
	public int insert(Question question);
	public int companyInsert(Question question);
	public List<Question> findAll(HashMap<String, Object> params); 
	public int countAll();
	public Question findByNo(int no);
	public int update(Question question);
	public int delete(int no);
	public String getCompanyName(int no);
	public String getFileName(int no);
}