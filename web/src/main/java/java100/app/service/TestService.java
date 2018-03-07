package java100.app.service;

import java.util.List;

import java100.app.domain.Test;

public interface TestService {
	List<Test> list(int no);
	Test find(int ano);
	int countAll();
	int insert(Test test);
	Test findByNo(int no);
	int update(Test test);
	int delete(int no);
}
