package java100.app.dao;

import java.util.List;
import java.util.Map;

import java100.app.domain.Study;
import java100.app.domain.StudyMember;

public interface StudyDao {

    int insert(Study study);
    List<Study> findAll(Map<String,Object> params);
    Study findByNo(int sno);
    int countAll();
    int update(Study study);
    int delete(int sno);
    int memberInfo(StudyMember stm);
    int findLast();
    List<Study> myStudyInfo(Map<String, Object> params);
    List<Study> studyUser(Map<String, Object> params);
    
    String chageId(int no);
    
}















