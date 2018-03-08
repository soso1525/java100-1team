package java100.app.service;

import java.util.List;
import java.util.Map;

import java100.app.domain.Study;

public interface StudyService {
    int add(Study study);
    List<Study> list(int pageNo, int pageSize, Map<String,Object> options);
    Study get(int sno);
    int getTotalCount();
    int update(Study study);
    int delete(int sno);
	void applyStudy(Integer studyId, Integer userId);
    
}





