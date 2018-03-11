package java100.app.service;

import java.util.List;

import java100.app.domain.Test;

public interface TestService {
	//ino로 구하는 test리스트
	List<Test> allList(int no);
	Test list(int no);
	int countAll();
	int add(Test test);
	Test findByNo(int no);
	int update(Test test);
	int delete(int no);
}
