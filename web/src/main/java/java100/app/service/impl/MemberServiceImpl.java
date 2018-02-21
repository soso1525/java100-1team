package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.CompanyMemberDao;
import java100.app.dao.IndividualMemberDao;
import java100.app.dao.MemberDao;
import java100.app.domain.CompanyMember;
import java100.app.domain.IndividualMember;
import java100.app.domain.Member;
import java100.app.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;
	@Autowired
	IndividualMemberDao imemberDao;
	@Autowired
	CompanyMemberDao cmemberDao;

	@Override
	public List<Member> list() {
		return memberDao.findAll();
	}

	@Override
	public Member get(int no) {
		return memberDao.findByNo(no);
	}

	@Override
	public Member get(String id, String password) {

		HashMap<String, Object> params = new HashMap<>();
		params.put("id", id);
		params.put("password", password);
		return memberDao.findByIdAndPassword(params);
	}

	@Override
	public int getTotalCount() {
		return memberDao.countAll();
	}

	@Override
	public int iAdd(Member member, IndividualMember imember) {
		return memberDao.insert(member) + imemberDao.insert(imember);
	}

	@Override
	public int cAdd(Member member, CompanyMember cmember) {
		return memberDao.insert(member) + cmemberDao.insert(cmember);
	}

	@Override
	public int delete(int no) {
		return memberDao.delete(no);
	}

	@Override
	public int deleteImember(int no) {
		return memberDao.delete(no) + imemberDao.delete(no);
	}

	@Override
	public int deleteCmember(int no) {
		return memberDao.delete(no) + cmemberDao.delete(no);
	}

	public boolean isMatchMemberId(String id) {
		return memberDao.findById(id) == null;
	}

	public boolean isMatchMemberEmail(String email) {
		return memberDao.findByEmail(email) == null;
	}

	@Override
	public int updateImember(Member member, IndividualMember imember) {
		return memberDao.update(member) + imemberDao.update(imember);
	}

	@Override
	public int updateCmember(Member member, CompanyMember cmember) {
		return memberDao.update(member) + cmemberDao.update(cmember);
	}

	@Override
	public int update(Member member) {
		return memberDao.update(member);
	}

}
