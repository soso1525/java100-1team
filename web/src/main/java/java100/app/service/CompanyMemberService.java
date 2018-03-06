package java100.app.service;

import java.util.List;

import java100.app.domain.CompanyMember;

public interface CompanyMemberService {
	List<CompanyMember> list();
	CompanyMember get(int no);
	int insert(CompanyMember cMember);
	int update(CompanyMember cMember);
	int delete(int no);
}
