package java100.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.CoverLetterDao;
import java100.app.domain.CompanyMember;
import java100.app.domain.CoverLetter;
import java100.app.service.CoverLetterService;

@Service
public class CoverLetterServiceImpl implements CoverLetterService {

	@Autowired CoverLetterDao cvDao;
	
	@Override
	public List<CoverLetter> findByWriter(Integer writerSeq) {
		
		return cvDao.findByWriter ( writerSeq);
	}

/*	@Override
	public void getApplyCompany(CompanyMember company, Integer applicant, CoverLetter letter) {
		// 1. �Ի������� insert
		Integer ano = cvDao.insertIntoG_app(applicant, company.getName());
		// 2. �ڼҼ��� �� ��
		cvDao.insertIntoG_let( ano, applicant, letter);
		
	}*/
	
	
	

 
	
}
