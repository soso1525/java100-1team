package java100.app.service;

import java.util.List;
import java.util.Map;

import java100.app.domain.CompanyMember;
import java100.app.domain.IndividualMember;
import java100.app.domain.Member;

public interface MemberService {
	List<Member> list();

	Member get(int no);

	Member get(String id, String password);

	int getTotalCount();

	int iAdd(Member member, IndividualMember iMember);

	int cAdd(Member member, CompanyMember cMember);

	int update(Member member);

	int delete(int no);

	public boolean isMatchMemberId(String id);

	public boolean isMatchMemberEmail(String email);
}
