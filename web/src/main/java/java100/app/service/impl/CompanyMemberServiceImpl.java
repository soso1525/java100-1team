package java100.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.CompanyMemberDao;
import java100.app.domain.CompanyMember;
import java100.app.service.CompanyMemberService;

@Service
public class CompanyMemberServiceImpl implements CompanyMemberService {

	@Autowired
	CompanyMemberDao cmemberDao;

	@Override
	public List<CompanyMember> list() {
		return cmemberDao.findAll();
	}

	@Override
	public CompanyMember get(int no) {
		return cmemberDao.findByNo(no);
	}

	@Override
	public int insert(CompanyMember cMember) {
		return cmemberDao.insert(cMember);
	}

	@Override
	public int update(CompanyMember cMember) {
		return cmemberDao.update(cMember);
	}

	@Override
	public int delete(int no) {
		return cmemberDao.delete(no);
	}

}
