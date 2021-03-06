package java100.app.service;

import java.util.List;

import java100.app.domain.Question;

public interface QuestionService {
    List<Question> list(int no);
    int getTotalCount();
    int add(Question question);
    int companyAdd(Question question);
    Question get(int no);
    int update(Question apply);
    int delete(int no);
    String getCompanyName(int no);
    String getFileName(int no);
}





