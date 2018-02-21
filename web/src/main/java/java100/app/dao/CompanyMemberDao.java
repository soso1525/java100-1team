package java100.app.dao;

import java.util.List;

import java100.app.domain.CompanyMember;

public interface CompanyMemberDao {
	List<CompanyMember> findAll();
	CompanyMember findByNo(int no);
	int insert(CompanyMember cmember);
	int update(CompanyMember cmember);
	int delete(int no);
	
}
