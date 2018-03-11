package java100.app.service;

import java100.app.domain.Apply;
import java100.app.domain.Test;

public interface TestService {
	Test list(int no);
	int countAll();
	int add(Test test);
	Test findByNo(int no);
	int update(Test test);
	int delete(int no);
}
