package java100.app.dao;

import java.util.HashMap;
import java.util.List;

import java100.app.domain.Like;

public interface LikeDao {
	List<Like> findAll(HashMap<String, Object> params);
	Like findByNo(HashMap<String, Object> params);
    int insert(Like like);
    int delete(int nno);
}















