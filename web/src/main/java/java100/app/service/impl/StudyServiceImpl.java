package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.StudyDao;
import java100.app.domain.Study;
import java100.app.service.StudyService;

@Service
public class StudyServiceImpl implements StudyService {
    @Autowired StudyDao studyDao;
    
    @Override
    public int add(Study study) {
        return studyDao.insert(study);
    }
    
    @Override
    public List<Study> list(int pageNo, int pageSize,Map<String,Object> options){
        HashMap<String,Object> params = new HashMap<>();
        params.put("startIndex", (pageNo - 1) * pageSize);
        params.put("size", pageSize);
        
        if (options != null) {
            params.putAll(options);
        }
        return studyDao.findAll(params);
    }
    
    @Override
    public int getTotalCount() {
        return studyDao.countAll();
    }
    
    @Override
    public Study get(int sno) {
        return studyDao.findByNo(sno);
    }


    @Override
    public int delete(int sno) {
        return studyDao.delete(sno);
    }

    @Override
    public int update(Study study) {
        return studyDao.update(study);
    }
    

}
