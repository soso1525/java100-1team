package java100.app.dao;

import java.util.List;

import java100.app.domain.IndividualMember;

public interface IndividualMemberDao {
	List<IndividualMember> findAll();
	IndividualMember findByNo(int no);
	int countAll();
	int insert(IndividualMember iMember);
	int update(IndividualMember iMember);
	int delete(int no);
    
}















