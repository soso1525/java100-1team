package java100.app.service;

import java.util.List;

import java100.app.domain.CompanyMember;
import java100.app.domain.IndividualMember;
import java100.app.domain.Member;

public interface MemberService {
	List<Member> list();
	Member get(int no);
	Member get(String id, String password);
	Member get(String email);
	int getTotalCount();
	int iAdd(Member member, IndividualMember imember);
	int cAdd(Member member, CompanyMember cmember);
	int update(Member member);
	int updateImember(Member member, IndividualMember imember);
	int updateCmember(Member member, CompanyMember cmember);
	int delete(int no);
	int deleteImember(int no);
	int deleteCmember(int no);
	public boolean isMatchMemberId(String id);
	public boolean isMatchMemberEmail(String email);
}
