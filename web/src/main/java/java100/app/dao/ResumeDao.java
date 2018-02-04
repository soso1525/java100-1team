package java100.app.dao;

import java.util.HashMap;
import java.util.List;

import java100.app.domain.Resume;

public interface ResumeDao {
	 public List<Resume> findAll(HashMap<String, Object> params); 
	 public int countAll();
	 public int insert(Resume resume);
	 public Resume findByNo(int no);
	 public int update(Resume resume);
	 public int delete(int no);
}