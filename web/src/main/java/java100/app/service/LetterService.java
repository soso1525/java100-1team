package java100.app.service;

import java.util.List;

import java100.app.domain.Apply;
import java100.app.domain.Letter;

public interface LetterService {
	List<Letter> list(int no); //apply no에 대한 letter 리스트
	int getTotalCount();
	int add(Letter cover);
	int addLetter(Apply apply, Letter letter);
	Letter get(int no);
	int update(Letter cover);
	int delete(int no);
}
