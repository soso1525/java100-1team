package java100.app.service;

import java.util.List;

import java100.app.domain.Like;
import java100.app.domain.Member;

public interface LikeService {
	List<Like> list(Member loginUser);
    int add(Like like);
    int delete(int nno);
    Like get(int nno, Member loginUser);
}





