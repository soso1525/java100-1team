package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.NoticeDao;
import java100.app.domain.Member;
import java100.app.domain.Notice;
import java100.app.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired NoticeDao noticeDao;
    
    @Override
    public List<Notice> list(int pageNo, int pageSize, Map<String, Object> options) {
        
    	
    	 HashMap<String,Object> params = new HashMap<>();
         params.put("startIndex", (pageNo - 1) * pageSize);
         params.put("size", pageSize);
         if (options != null) {
             params.putAll(options);
         }
        return noticeDao.findAll(params);
    }
    
    @Override
	public List<Notice> writerList(Member loginUser) {
    	HashMap<String,Object> params = new HashMap<>();
    	params.put("writer", loginUser);
		return noticeDao.writerFindAll(params);
	}
    @Override
    public int getTotalCount() {
        return noticeDao.countAll();
    }


	@Override
	public int add(Notice notice) {
		return noticeDao.insert(notice);
	}
	
	@Override
	public Notice get(int no) {
		noticeDao.updateViewCount(no);
		return noticeDao.findByNo(no);
	}

	@Override
	public int update(Notice notice) {
		return noticeDao.update(notice);
	}

	@Override
	public int delete(int no) {
		return noticeDao.delete(no);
	}

}
