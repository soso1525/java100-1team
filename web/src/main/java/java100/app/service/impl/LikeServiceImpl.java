package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.LikeDao;
import java100.app.domain.Like;
import java100.app.domain.Member;
import java100.app.domain.Notice;
import java100.app.service.LikeService;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired LikeDao likeDao;
	

	@Override
	public List<Like> list(Member loginUser) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("writer", loginUser);
		return likeDao.findAll(params);
	}
	
	@Override
	public int add(Like like) {
		return likeDao.insert(like);
	}

	@Override
	public int delete(int nno) {
		return likeDao.delete(nno);
	}
	
	
	@Override
	public Like get(int nno, Member loginUser) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("writer", loginUser);
		params.put("nno", nno);
		return likeDao.findByNo(params);
	}

	
}
