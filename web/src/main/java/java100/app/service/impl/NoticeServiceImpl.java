package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.CompanyMemberDao;
import java100.app.dao.MemberDao;
import java100.app.dao.NoticeDao;
import java100.app.domain.Notice;
import java100.app.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired MemberDao memberDao;
    @Autowired CompanyMemberDao cMemberDao;
    @Autowired NoticeDao noticeDao;
    
    @Override
    public List<Notice> list() {
        
        HashMap<String,Object> params = new HashMap<>();
        
        return noticeDao.findAll(params);
    }
    
    @Override
    public int getTotalCount() {
        return memberDao.countAll();
    }

}
