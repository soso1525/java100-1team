package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.StudyDao;
import java100.app.domain.Study;
import java100.app.domain.StudyMember;
import java100.app.service.StudyService;

@Service
public class StudyServiceImpl implements StudyService {
    @Autowired StudyDao studyDao;
    
    @Override
    public int add(Study study) {
        
        studyDao.insert(study); // 스터디 작성
        int findLastSno = studyDao.findLast(); // 작성한 스터디 찾기
        // 작성한유저를 스터디에 추가
        // @파라미터
        StudyMember stm = new StudyMember();
        stm.setSno(findLastSno);
        stm.setIno(study.getWriter().getNo());
        // @추가
        return studyDao.memberInfo(stm);
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

	@Override
	public void applyStudy(Integer studyId, Integer userId) {
		Study study = studyDao.findByNo(studyId);
		String cur = study.getScheck(); // ["3" of 5]
		cur = (Integer.parseInt(cur) + 1) + "";
		study.setScheck(cur);
		
		StudyMember stm = new StudyMember();
		stm.setIno(userId);
		stm.setSno(studyId);
		studyDao.update(study);
		studyDao.memberInfo(stm);
	
	}

    @Override
    public List<Study> memberList(int pageNo, int pageSize, Map<String, Object> options) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startIndex", (pageNo - 1) * pageSize);
        params.put("size", pageSize);
        
        if (options != null) {
            params.putAll(options);
        }
        return studyDao.myStudyInfo(params);
    }

    @Override
    public List<Study> myStudyUserInfo(Map<String, Object> options) {
        return studyDao.studyUser(options);
    }

    @Override
    public String changId(int no) {
        
        return studyDao.chageId(no);
    }
    

}
