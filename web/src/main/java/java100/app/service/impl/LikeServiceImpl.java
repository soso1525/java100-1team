package java100.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.LikeDao;
import java100.app.domain.Like;
import java100.app.service.LikeService;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired LikeDao likeDao;
	
	@Override
	public int add(Like like) {
		return likeDao.insert(like);
	}
}
