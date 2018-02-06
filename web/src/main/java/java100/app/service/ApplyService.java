package java100.app.service;

import java.util.List;

import java100.app.domain.Apply;

public interface ApplyService {
    List<Apply> list();
    int getTotalCount();
    int add(Apply apply);
    Apply get(int no);
    int update(Apply apply);
    int delete(int no);
}





