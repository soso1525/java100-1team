package java100.app.service;

import java.util.List;

import java100.app.domain.Test;

public interface TestService {
	//ano로 구하는 test리스트
	List<Test> list(int ano);
	//ino로 구하는 test리스트
	List<Test> allList(int no);
	Test find(int ano);
	int countAll();
	int insert(Test test);
	Test findByNo(int no);
	int update(Test test);
	int delete(int no);
	Object findAll(int no);
}
