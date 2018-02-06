package java100.app.dao;

import java.util.List;
import java.util.Map;

import java100.app.domain.Study;

public interface StudyDao {

    int insert(Study study);
    List<Study> findAll(Map<String,Object> params);
    Study findByNo(int sno);
    int countAll();
    int update(Study study);
    int delete(int sno);
}















