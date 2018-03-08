package java100.app.service;

import java.util.List;

import java100.app.domain.Apply;
import java100.app.domain.Letter;
import java100.app.domain.Member;
import java100.app.domain.Resume;

public interface ApplyService {
	List<Apply> list(Member loginUser);
	int getTotalCount();
	int add(Apply apply);
	Apply get(int no);
	int update(Apply apply);
	int delete(int no);
}
