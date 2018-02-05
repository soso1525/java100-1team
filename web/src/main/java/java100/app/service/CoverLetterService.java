package java100.app.service;

import java.util.List;

import java100.app.domain.CompanyMember;
import java100.app.domain.CoverLetter;

public interface CoverLetterService {
	
	public List<CoverLetter> findByWriter( Integer writerSeq );
	
//	public void getApplyCompany (CompanyMember company, Integer applicant, CoverLetter letter) ;
}
