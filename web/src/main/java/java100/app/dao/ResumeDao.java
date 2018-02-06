package java100.app.dao;

import java.util.HashMap;
import java.util.List;

import java100.app.domain.Resume;

public interface ResumeDao {
	int insert(Resume resume);
	 List<Resume> findAll(HashMap<String, Object> params); 
	 int countAll();
	 Resume findByNo(int no);
	 int update(Resume resume);
	 int delete(int no);
}