package java100.app.dao;

import java.util.List;

import java100.app.domain.CoverLetter;

public interface CoverLetterDao {
	List<CoverLetter> findByWriter (int writerSeq);
}
