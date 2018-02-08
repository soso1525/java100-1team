package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.ResumeDao;
import java100.app.domain.Resume;
import java100.app.service.ResumeService;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired ResumeDao resumeDao;
    
    @Override
    public List<Resume> list() {
        HashMap<String,Object> params = new HashMap<>();
        return resumeDao.findAll(params);
    }

    @Override
    public int getTotalCount() {
        return resumeDao.countAll();
    }
    
    @Override
    public int add(Resume resume) {
        return resumeDao.insert(resume);
    }

    @Override
    public Resume get(int no) {
    	resumeDao.updateViewCount(no);
    	Resume resume = resumeDao.findByNo(no); 
        return resume;
    }

	@Override
	public int update(Resume resume) {
		return resumeDao.update(resume);
	}

	@Override
	public int delete(int no) {
		return resumeDao.delete(no);
	}
    
}
