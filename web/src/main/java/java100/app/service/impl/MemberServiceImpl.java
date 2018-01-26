package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.CompernyMemberDao;
import java100.app.dao.IndividualMemberDao;
import java100.app.dao.MemberDao;
import java100.app.domain.CompernyMember;
import java100.app.domain.IndividualMember;
import java100.app.domain.Member;
import java100.app.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired MemberDao memberDao;
    @Autowired IndividualMemberDao iMemberDao;
    @Autowired CompernyMemberDao cMemberDao;
    
    @Override
    public List<Member> list(int pageNo, int pageSize, Map<String, Object> options) {
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("startIndex", (pageNo - 1) * pageSize);
        params.put("size", pageSize);
        
        if (options != null) {
            params.putAll(options);
        }
        
        return memberDao.findAll(params);
    }

    @Override
    public Member get(int no) {
        return memberDao.findByNo(no);
    }
    
    @Override
    public Member get(String id, String password) {
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("id", id);
        params.put("password", password);
        return memberDao.findByIdAndPassword(params);
    }
    
    @Override
    public int getTotalCount() {
        return memberDao.countAll();
    }

    @Override
    public int iAdd(Member member, IndividualMember iMember) {
        return memberDao.insert(member) + iMemberDao.insert(iMember);
    }
    
    @Override
    public int cAdd(Member member, CompernyMember cMember) {
        return memberDao.insert(member) + cMemberDao.insert(cMember);
    }

    @Override
    public int update(Member score) {
        return memberDao.update(score);
    }

    @Override
    public int delete(int no) {
        return memberDao.delete(no);
    }

}
