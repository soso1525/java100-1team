package java100.app.service;

import java.util.List;

import java100.app.domain.Question;

public interface QuestionService {
    List<Question> list();
    int getTotalCount();
    int add(Question question);
    Question get(int no);
    int update(Question apply);
    int delete(int no);
}





